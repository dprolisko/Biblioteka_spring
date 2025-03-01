package com.example.biblioteka.service;

import com.example.biblioteka.entity.User;
import com.example.biblioteka.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllBooks() {
        return userRepository.findAll();
    }

    public Optional<User> createUser(User user) {
        return Optional.of(userRepository.save(user));
    }


}
