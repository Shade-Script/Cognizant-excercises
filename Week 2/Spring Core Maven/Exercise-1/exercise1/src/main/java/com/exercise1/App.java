package com.exercise1;

// 1. Import the Spring classes
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 2. Import your custom service class from the other package
import com.exercise1.service.BookService;

public class App {
    public static void main(String[] args) {
        // Load the XML application context configuration
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the configured BookService bean
        BookService bookService = context.getBean("bookService", BookService.class);

        // Test the setup
        bookService.saveBook();
        
        // Close the context context gracefully
        context.close();
    }
}