/**
 * Exercise 2: Factory Method Pattern - Document Interface
 * 
 * This interface defines the contract for all document types
 * in the document management system.
 */
public interface Document {
    void open();
    void save();
    void close();
}
