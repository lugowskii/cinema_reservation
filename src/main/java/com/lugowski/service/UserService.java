package com.lugowski.service;

import com.lugowski.dao.UserRepository;
import com.lugowski.entities.User;
import com.lugowski.entities.UserCreateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(long id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    public Collection<User> getAllUsers() {
        return userRepository.findAll(new Sort("email"));
    }

    public User create(UserCreateForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        return userRepository.save(user);
    }
}
