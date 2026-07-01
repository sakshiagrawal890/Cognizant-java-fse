package com.library.repository;

public class BookRepository {

    public BookRepository() {
        System.out.println("BookRepository bean created by Spring.");
    }

    public void findAllBooks() {
        System.out.println("Fetching all books from the repository.");
    }
}
