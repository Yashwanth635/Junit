package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.entity.Book;
import com.example.LibraryManagement.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BookControllerTest {

    @Mock
    BookService bookService;

    @InjectMocks
    BookController bookController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addBookTest_positive()
    {
        Book bookToAdd = new Book();
        bookToAdd.setBookid(1);
        bookToAdd.setBookname("THIS");
        bookToAdd.setBookauthor("Torry");
        bookToAdd.setDescription("Torry Harries Integration Solution");
        bookToAdd.setRating(5.0);
        Mockito.when(bookService.addBook(bookToAdd)).thenReturn(bookToAdd);
        Book addedbook = bookController.addBook(bookToAdd);
        assertEquals(bookToAdd,addedbook);
    }


    @Test
    public void getBookDetails_positiveTest()
    {
        Book expectedBook = new Book();
        expectedBook.setBookid(1);
        expectedBook.setBookname("THIS");
        expectedBook.setBookauthor("Torry");
        expectedBook.setDescription("Torry Harries Integration Solution");
        expectedBook.setRating(5.0);
        Mockito.when(bookService.getBookDetailsService(1)).thenReturn(expectedBook);
        Book actualBook = bookController.getBookDetailsController(1);
        assertEquals(expectedBook,actualBook);
    }

    @Test
    public void getBookDetails_negativeTest()
    {
        int bookid = 3;
        Mockito.when(bookService.getBookDetailsService(bookid)).thenReturn(null);
        Book actualBook = bookController.getBookDetailsController(bookid);
        assertNull(actualBook);
    }

}
