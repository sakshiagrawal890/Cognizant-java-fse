package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n--- Testing Constructor Injection ---");
        BookService constructorService = (BookService) context.getBean("bookServiceConstructor");
        constructorService.manageBooks();

        System.out.println("\n--- Testing Setter Injection ---");
        BookService setterService = (BookService) context.getBean("bookServiceSetter");
        setterService.manageBooks();
    }
}
