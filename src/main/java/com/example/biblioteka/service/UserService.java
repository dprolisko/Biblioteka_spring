package com.example.biblioteka.service;

import com.example.biblioteka.entity.Book;
import com.example.biblioteka.entity.User;
import com.example.biblioteka.exception.UserNotFoundException;
import com.example.biblioteka.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
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

    public User getUserById(Long id) throws UserNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    public void deleteUser(Long id) throws UserNotFoundException {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("Cannot delete, user not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    public Optional<User> findByFullName(String full_name) {
        return userRepository.findByFullName(full_name);
    }

    public List<User> findByFullNameContainingIgnoreCase(String full_namePart){
        return userRepository.findByFullNameContainingIgnoreCase(full_namePart);
    }
}
