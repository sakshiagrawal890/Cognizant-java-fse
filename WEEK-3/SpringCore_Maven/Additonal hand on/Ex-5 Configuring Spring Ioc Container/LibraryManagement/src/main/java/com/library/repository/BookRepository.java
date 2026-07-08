package com.library.repository;

public class BookRepository {

    public BookRepository() {
        System.out.println("BookRepository bean created (Ex 5).");
    }

    public void findAllBooks() {
        System.out.println("BookRepository (Ex 5): Retrieving all books from the database.");
    }
}
