package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {
        // Load Spring application context from XML configuration
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("Spring Context loaded successfully!");

        // Retrieve BookService bean from context
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.manageBooks();

        // Close context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
