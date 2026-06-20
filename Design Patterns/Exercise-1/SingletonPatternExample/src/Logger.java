import java.time.LocalDateTime;

public class Logger {

    // The single instance, volatile so changes are visible across threads
    private static volatile Logger instance;

    // Private constructor prevents instantiation from outside
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Thread-safe accessor using double-checked locking
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

    public void log(String message) {
        System.out.println("[" + LocalDateTime.now() + "] " + message);
    }
}