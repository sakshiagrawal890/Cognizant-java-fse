/**
 * Exercise 1: Singleton Pattern - Logger Class
 * 
 * This class ensures only one instance of Logger exists
 * throughout the application lifecycle for consistent logging.
 */
public class Logger {
// Step 1: Private static instance of itself
    private static Logger instance;

    // Step 2: Private constructor to prevent external instantiation
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Step 3: Public static method to get the single instance (Thread-safe)
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Logging method to log messages
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }

    public static void setInstance(Logger instance) {
        Logger.instance = instance;
    }
}
