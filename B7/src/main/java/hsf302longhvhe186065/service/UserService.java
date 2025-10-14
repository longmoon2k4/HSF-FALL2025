package hsf302longhvhe186065.service;

import hsf302longhvhe186065.pojo.User;
import hsf302longhvhe186065.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public Page<User> listAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    public User add(User user) {
        return userRepository.save(user);
    }

    public boolean update(String email, User updated) {
        return findByEmail(email).map(existing -> {
            existing.setFirstName(updated.getFirstName());
            existing.setLastName(updated.getLastName());
            existing.setGender(updated.getGender());
            existing.setHobbies(updated.getHobbies());
            existing.setProvince(updated.getProvince());
            existing.setBirthday(updated.getBirthday());
            existing.setPassword(updated.getPassword());
            existing.setEmail(updated.getEmail());
            userRepository.save(existing);
            return true;
        }).orElse(false);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public boolean updateById(Long id, User updated) {
        return findById(id).map(existing -> {
            existing.setFirstName(updated.getFirstName());
            existing.setLastName(updated.getLastName());
            existing.setGender(updated.getGender());
            existing.setHobbies(updated.getHobbies());
            existing.setProvince(updated.getProvince());
            existing.setBirthday(updated.getBirthday());
            existing.setPassword(updated.getPassword());
            existing.setEmail(updated.getEmail());
            userRepository.save(existing);
            return true;
        }).orElse(false);
    }

    public boolean deleteById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean deleteByEmail(String email) {
        if (findByEmail(email).isPresent()) {
            userRepository.deleteByEmail(email);
            return true;
        }
        return false;
    }
}