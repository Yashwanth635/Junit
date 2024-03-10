package com.example.LibraryManagement.repository;

import com.example.LibraryManagement.entity.Book;

public interface BookRepository {
    Book getBookDetailsRepository(int id);
    Book addBook(Book book);
}
