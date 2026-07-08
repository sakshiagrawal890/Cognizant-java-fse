package com.library;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            repository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"));
            repository.save(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"));
            repository.save(new Book("1984", "George Orwell", "9780451524935"));
            System.out.println("\n--- Mock database initialized with sample books ---");
        };
    }
}
