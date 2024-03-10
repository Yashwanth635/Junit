package com.example.LibraryManagement.repository;

import com.example.LibraryManagement.controller.BookController;
import com.example.LibraryManagement.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class BookRepositoryTest {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    BookRepository bookRepository = new BookRepositoryImpl();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddBook()
    {
        Book bookToAdd = new Book();
        when(restTemplate.postForObject(anyString(), eq(bookToAdd), eq(Book.class))).thenReturn(bookToAdd);
        BookRepository mockRepository = Mockito.mock(BookRepository.class);
        Mockito.when(mockRepository.addBook(Mockito.any(Book.class))).thenReturn(bookToAdd);
        Book addedBook = bookRepository.addBook(bookToAdd);
        assertEquals(bookToAdd, addedBook);
    }

    @Test
    public void getBookDetails_PositiveTest()
    {
        int validId = 1;
        Book expectedBook = new Book();
        when(restTemplate.getForObject(anyString(), eq(Book.class))).thenReturn(expectedBook);
        //BookRepository mockRepository = Mockito.mock(BookRepository.class);
        //Mockito.when(mockRepository.getBookDetailsRepository(Mockito.anyInt())).thenReturn(expectedBook);
        Book actualBook = bookRepository.getBookDetailsRepository(validId);
        assertEquals(expectedBook, actualBook);
    }
    @Test
    public void getBookDetails_NegativeTest()
    {
        int BookId = 999;
        when(restTemplate.getForObject(anyString(), eq(Book.class))).thenReturn(null);
        //BookRepository mockRepository = Mockito.mock(BookRepository.class);
        //Mockito.when(mockRepository.getBookDetailsRepository(Mockito.anyInt())).thenReturn(null);
        Book actualBook = bookRepository.getBookDetailsRepository(BookId);
        assertNull(actualBook);
    }
}
