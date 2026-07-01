package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    // Dependency on BookRepository (injected by Spring via setter)
    private BookRepository bookRepository;

    public BookService() {
        System.out.println("BookService bean created by Spring.");
    }

    // Setter method for Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository injected into BookService via setter.");
    }

    public void manageBooks() {
        System.out.println("Managing books via BookService.");
        bookRepository.findAllBooks();
    }
}
