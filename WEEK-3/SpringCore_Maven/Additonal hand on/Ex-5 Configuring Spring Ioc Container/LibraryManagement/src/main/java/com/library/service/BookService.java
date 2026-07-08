package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public BookService() {
        System.out.println("BookService bean created (Ex 5).");
    }

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository injected into BookService via setter (Ex 5).");
    }

    public void manageBooks() {
        System.out.println("BookService (Ex 5): Managing books...");
        if (bookRepository != null) {
            bookRepository.findAllBooks();
        } else {
            System.out.println("BookRepository dependency is not injected!");
        }
    }
}
