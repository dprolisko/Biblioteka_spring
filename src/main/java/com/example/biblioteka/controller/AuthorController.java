package com.example.biblioteka.controller;

import com.example.biblioteka.entity.Author;
import com.example.biblioteka.exception.AuthorNotFoundException;
import com.example.biblioteka.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("author")
@RequiredArgsConstructor

public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("getAuthor/{id}")
    public Author getAuthorById(Long id) throws AuthorNotFoundException {
        return authorService.getAuthorById(id);
    }

    @GetMapping("getAuthor/{name}")
    public Optional<Author> getAuthorByName(String name) {
        return authorService.getAuthorByName(name);
    }

    @PostMapping("create/{authorId}")
    public Optional <Author> createAuthor(Author author) {
        return authorService.createAuthor(author);
    }

    @DeleteMapping("{authorId}")
    public void deleteAuthor(Long id) throws AuthorNotFoundException {
        authorService.deleteAuthor(id);
    }

    @GetMapping("searchAuthor/{name}")
    public List<Author> searchAuthorsByName(String namePart) {
        return authorService.findByNameContainingIgnoreCase(namePart);
    }

    @GetMapping("findAuthor/{bookId}")
    public List<Author> findAuthorsByBookId(@Param("bookId") Long bookId){
        return authorService.findAuthorsByBookId(bookId);
    }
}

