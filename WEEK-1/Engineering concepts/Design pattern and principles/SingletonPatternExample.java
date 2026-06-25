public class SingletonPatternExample {
    static class Logger {
        private static Logger instance;
        private Logger() {}
        public static synchronized Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }
        public void log(String message) {
            System.out.println("[LOG] " + message);
        }
    }

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First message.");
        logger2.log("Second message.");

        System.out.println("Same instance: " + (logger1 == logger2));
    }
}