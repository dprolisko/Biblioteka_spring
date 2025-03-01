package com.example.biblioteka.controller;

import com.example.biblioteka.entity.Book;
import com.example.biblioteka.exception.BookNotFoundException;
import com.example.biblioteka.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor

public class BookController {
    private BookService bookService;

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("create/{bookId}")
    public Optional<Book> createBook(Book book) {
        return bookService.createBook(book);
    }

    @DeleteMapping("delete/{bookId}")
    public void deleteBook(Long id) throws BookNotFoundException {
        bookService.deleteBook(id);
    }

    @GetMapping("getBook/{bookId}")
    public Book getBookById(Long id) throws BookNotFoundException {
        return bookService.getBookById(id);
    }

    @GetMapping("findByTitle/{bookTitle}")
    public Optional<Book> findByTitle(String title){
        return bookService.findByTitle(title);
    }

    @GetMapping("findByTitleContainingIgnoreCase/{titlePart}")
    public List<Book> findByTitleContainingIgnoreCase(String titlePart){
        return bookService.findByTitleContainingIgnoreCase(titlePart);
    }

    @GetMapping("findBookByAuthorId/{authorId}")
    public List<Book> findBooksByAuthorId(@Param("authorId") Long authorId){
        return bookService.findBooksByAuthorId(authorId);
    }

    @GetMapping("findBooksByAuthorName/{authorName}")
    public  List<Book> findBooksByAuthorName(@Param("authorName") String authorName){
        return bookService.findBooksByAuthorName(authorName);
    }

    @GetMapping("findAllPageable")
    public Page<Book> findAll(Pageable pageable){
        return bookService.findAll(pageable);
    }

}
