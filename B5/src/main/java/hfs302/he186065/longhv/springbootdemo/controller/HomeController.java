package hfs302.he186065.longhv.springbootdemo.controller;

import hfs302.he186065.longhv.springbootdemo.pojo.Student;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private List<Student> studentList;

    public HomeController() {
        studentList = new ArrayList<>();
        Student student = new Student(1, "lamnhungoc@gmail.com", "password", "Ngoc", "Lam", 10);
        studentList.add(student);
    }

    @GetMapping("/")
    public ModelAndView showStudent(HttpServletResponse response) {
        ModelAndView model = new ModelAndView("home");
        model.addObject("studentList", studentList);
        return model;
    }

    @PostMapping("/create")
    public String createOrUpdateStudent(HttpServletRequest request) {
        String type = request.getParameter("btnManageStudent");
        int studentID = Integer.parseInt(request.getParameter("txtID"));
        String email = request.getParameter("txtEmail");
        String password = request.getParameter("txtPassword");
        String firstName = request.getParameter("txtFirstName");
        String lastName = request.getParameter("txtLastName");
        int mark = Integer.parseInt(request.getParameter("txtMark"));
        switch (type) {
            case "add":
                Student student = new Student(studentID, email, password, firstName, lastName, mark);
                studentList.add(student);
                break;
            case "update":
                for (Student s : studentList) {
                    if (s.getId() == studentID) {
                        s.setEmail(email);
                        s.setPassword(password);
                        s.setFirstName(firstName);
                        s.setLastName(lastName);
                        s.setMarks(mark);
                        break;
                    }
                }
                break;
            case "cancel":
                return "redirect:/";
        }
        return "redirect:/";
    }
    @GetMapping("/update")
    public ModelAndView showUpdateForm(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student found = null;
        for (Student s : studentList) {
            if (s.getId() == id) {
                found = s;
                break;
            }
        }
        ModelAndView model = new ModelAndView("create");
        model.addObject("student", found);
        model.addObject("isUpdate", true);
        return model;
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "create"; // Trả về view create.jsp
    }
}
