package com.example.biblioteka.controller;

import com.example.biblioteka.entity.User;
import com.example.biblioteka.exception.UserNotFoundException;
import com.example.biblioteka.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAllBooks() {
        return userService.getAllBooks();
    }

    @PostMapping("create/{userId}")
    public Optional<User> createUser(User user) {
        return userService.createUser(user);
    }

    @GetMapping("getUser/{userId}")
    public User getUserById(Long id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(Long id) throws UserNotFoundException {
        userService.deleteUser(id);
    }

    @GetMapping("findByFullName/{full_name}")
    public Optional<User> findByFullName(String full_name) {
        return userService.findByFullName(full_name);
    }

    @GetMapping("findByFullNameContainingIgnoreCase")
    public List<User> findByFullNameContainingIgnoreCase(String full_namePart){
        return userService.findByFullNameContainingIgnoreCase(full_namePart);
    }
}
