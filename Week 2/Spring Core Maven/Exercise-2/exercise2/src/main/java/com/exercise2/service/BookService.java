package com.exercise2.service;

import com.exercise2.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void showService() {

        System.out.println("Book Service Running");

        bookRepository.display();

    }

}