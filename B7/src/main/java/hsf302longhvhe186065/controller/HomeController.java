package hsf302longhvhe186065.controller;

import hsf302longhvhe186065.pojo.User;
import hsf302longhvhe186065.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

@Controller
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String home(Model model, @org.springframework.web.bind.annotation.RequestParam(value = "page", defaultValue = "0") int page,
                       @org.springframework.web.bind.annotation.RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> userPage = userService.listAll(pageable);
        model.addAttribute("userPage", userPage);
        model.addAttribute("users", userPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("newUser", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.add(user);
        return "redirect:/register-success";
    }

    @GetMapping("/register-success")
    public String showSuccessPage() {
        return "register-success";
    }

    @GetMapping("/users/{id}/edit")
    public String editFormById(@org.springframework.web.bind.annotation.PathVariable("id") Long id, Model model) {
        return userService.findById(id)
                .map(u -> { model.addAttribute("user", u); return "edit"; })
                .orElse("redirect:/");
    }

    @PostMapping("/users/email/edit")
    public String editSubmit(@Valid @ModelAttribute("user") User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        // use id from bound user to update
        userService.updateById(user.getId(), user);
        return "redirect:/";
    }

    @GetMapping("/users/{id}/delete")
    public String deleteById(@org.springframework.web.bind.annotation.PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/";
    }
}
