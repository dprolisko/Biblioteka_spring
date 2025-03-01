package com.example.biblioteka.repository;

import com.example.biblioteka.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByFullName(String username);

    List<User> findByFullNameContainingIgnoreCase(String fullNamePart);
}
