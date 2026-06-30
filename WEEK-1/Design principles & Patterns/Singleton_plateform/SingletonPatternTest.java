/**
 * Exercise 1: Singleton Pattern - Test Class
 * 
 * This class verifies that only one instance of Logger
 * is created and used across the application.
 */
public class SingletonPatternTest {

    public static void main(String[] args) {

        // Get the first instance of Logger
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        // Get the second instance of Logger
        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

        // Verify both references point to the same instance
        System.out.println("\n--- Singleton Verification ---");
        System.out.println("logger1 hashCode: " + logger1.hashCode());
        System.out.println("logger2 hashCode: " + logger2.hashCode());

        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the SAME instance. Singleton works!");
        } else {
            System.out.println("logger1 and logger2 are DIFFERENT instances. Singleton failed!");
        }
    }
}
