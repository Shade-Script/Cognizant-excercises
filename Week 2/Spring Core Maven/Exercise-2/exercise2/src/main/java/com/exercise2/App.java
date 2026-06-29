package com.exercise2;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.exercise2.service.BookService;

public class App {
    public static void main(String[] args) {
        System.out.println("--- Starting Spring Container ---");
        
        // 1. Bootstrapping the container via XML configuration
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("--- Container Initialized Successfully ---");

        // 2. Fetch the wired BookService bean
        BookService bookService = context.getBean("bookService", BookService.class);

        // 3. Test execution
        bookService.saveBook();
        
        // 4. Clean up resources
        context.close();
    }
}