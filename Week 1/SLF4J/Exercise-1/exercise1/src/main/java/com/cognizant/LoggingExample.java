package com.cognizant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.debug("This is a debug message - detailed information for developers");
        logger.info("This is an info message - general informational message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");

        logger.info("Starting application...");

        try {
            performDivision(10, 0);
        } catch (ArithmeticException e) {
            logger.error("An error occurred during division", e);
        }

        logger.info("Application completed");
    }

    private static void performDivision(int a, int b) {
        logger.debug("Attempting to divide {} by {}", a, b);
        int result = a / b;
        logger.info("Division result: {}", result);
    }
}