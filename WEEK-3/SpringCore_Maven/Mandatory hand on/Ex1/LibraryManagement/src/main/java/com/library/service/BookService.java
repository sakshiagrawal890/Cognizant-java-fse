package com.library.service;

public class BookService {

    public BookService() {
        System.out.println("BookService bean created by Spring.");
    }

    public void manageBooks() {
        System.out.println("Managing books via BookService.");
    }
}
