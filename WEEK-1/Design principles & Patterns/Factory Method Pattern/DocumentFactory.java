/**
 * Abstract Factory Class - DocumentFactory
 * 
 * Defines the factory method createDocument() that
 * concrete factory subclasses must implement.
 */
public abstract class DocumentFactory {

    // Factory method to be implemented by concrete factories
    public abstract Document createDocument();
}
