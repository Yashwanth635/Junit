package com.example.LibraryManagement.service;

import com.example.LibraryManagement.entity.Book;

public interface BookService {
    Book getBookDetailsService(int id);
    Book addBook(Book book);
}
