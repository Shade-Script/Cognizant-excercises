package com.exercise1.service;

import com.exercise1.repository.BookRepository;

public class BookService {
    private final BookRepository bookRepository;

    // Constructor Injection for Spring container wiring
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook() {
        System.out.println("[BookService] Processing book business logic...");
        bookRepository.saveData();
    }
}