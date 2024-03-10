package com.example.LibraryManagement.service;

import com.example.LibraryManagement.entity.Book;
import com.example.LibraryManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book getBookDetailsService(int id) {
        return bookRepository.getBookDetailsRepository(id);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.addBook(book);
    }
}
