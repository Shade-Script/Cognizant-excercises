package com.example;

import java.time.LocalDateTime;

public class Logger {

    // Single instance, volatile so changes are visible across threads
    private static volatile Logger instance;

    // Private constructor to prevent instantiation from outside
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Thread-safe accessor
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