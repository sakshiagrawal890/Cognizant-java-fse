import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    private static class Book {
        String title;
        String author;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }

    private final List<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    public void searchByTitle(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + book.title + " by " + book.author);
                return;
            }
        }
        System.out.println("No book found with title: " + title);
    }

    public void searchByAuthor(String author) {
        System.out.println("Books by " + author + ":");
        for (Book book : books) {
            if (book.author.equalsIgnoreCase(author)) {
                System.out.println("- " + book.title);
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        library.addBook("Java Basics", "Alice");
        library.addBook("Data Structures", "Bob");
        library.addBook("Advanced Java", "Alice");

        library.searchByTitle("Java Basics");
        library.searchByAuthor("Alice");
    }
}
