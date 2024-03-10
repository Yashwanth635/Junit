package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.entity.Book;
import com.example.LibraryManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/{id}")
    public Book getBookDetailsController(@PathVariable int id) {
        return bookService.getBookDetailsService(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

}
