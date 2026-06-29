package com.exercise2.service;

import com.exercise2.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Default No-Arg Constructor (Required for Setter Injection)
    public BookService() {
        System.out.println("[BookService] Initializing BookService instance...");
    }

    // Setter Method for Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("[BookService] Injecting BookRepository dependency via setter method...");
        this.bookRepository = bookRepository;
    }

    public void saveBook() {
        if (bookRepository == null) {
            throw new IllegalStateException("BookRepository dependency has not been injected!");
        }
        System.out.println("[BookService] Business logic processing...");
        bookRepository.saveData();
    }
}