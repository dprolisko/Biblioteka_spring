package com.example.biblioteka.service;

import com.example.biblioteka.entity.Author;
import com.example.biblioteka.entity.Book;
import com.example.biblioteka.exception.AuthorNotFoundException;
import com.example.biblioteka.exception.BookNotFoundException;
import com.example.biblioteka.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional

public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> createBook(Book book) {
        return Optional.of(bookRepository.save(book));
    }

    public void deleteBook(Long id) throws BookNotFoundException {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Cannot delete, book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    public Book getBookById(Long id) throws BookNotFoundException {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Author not found with id: " + id));
    }
    public Optional<Book> findByTitle(String title){
        return bookRepository.findByTitle(title);
    }
    public List<Book> findByTitleContainingIgnoreCase(String titlePart){
        return bookRepository.findByTitleContainingIgnoreCase(titlePart);
    }
    public List<Book> findBooksByAuthorId(@Param("authorId") Long authorId){
        return bookRepository.findBooksByAuthorId(authorId);
    }
    public  List<Book> findBooksByAuthorName(@Param("authorName") String authorName){
        return bookRepository.findBooksByAuthorName(authorName);
    }
    public Page<Book> findAll(Pageable pageable){
        return bookRepository.findAll(pageable);
    }
}
