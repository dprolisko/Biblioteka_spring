package com.example.biblioteka.service;

import com.example.biblioteka.entity.Author;
import com.example.biblioteka.exception.AuthorNotFoundException;
import com.example.biblioteka.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) throws AuthorNotFoundException {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: " + id));
    }

    public Optional<Author> getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    public Optional <Author> createAuthor(Author author) {
        return Optional.of(authorRepository.save(author));
    }

    public void deleteAuthor(Long id) throws AuthorNotFoundException {
        if (!authorRepository.existsById(id)) {
            throw new AuthorNotFoundException("Cannot delete, author not found with id: " + id);
        }
        authorRepository.deleteById(id);
    }

    public List<Author> searchAuthorsByName(String namePart) {
        return authorRepository.findByNameContainingIgnoreCase(namePart);
    }

    public List<Author> findAuthorsByBookId(@Param("bookId") Long bookId){
        return authorRepository.findAuthorsByBookId(bookId);
    }

    public List<Author> findByNameContainingIgnoreCase(String namePart) {
        return authorRepository.findByNameContainingIgnoreCase(namePart);
    }
}
