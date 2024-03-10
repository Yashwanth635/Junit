package com.example.LibraryManagement.service;

import com.example.LibraryManagement.entity.Book;
import com.example.LibraryManagement.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    private BookService bookService = new BookServiceImpl();;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addBookTest()
    {
        Book bookToAdd = new Book();
        bookToAdd.setBookid(1);
        bookToAdd.setBookname("THIS");
        bookToAdd.setBookauthor("Torry");
        bookToAdd.setDescription("Torry Harries Integration Solution");
        bookToAdd.setRating(5.0);
        Mockito.when(bookRepository.addBook(bookToAdd)).thenReturn(bookToAdd);
        BookService mockService = Mockito.mock(BookService.class);
        Mockito.when(mockService.addBook(Mockito.any(Book.class))).thenReturn(bookToAdd);
        Book addedBook = bookService.addBook(bookToAdd);
        assertEquals(bookToAdd,addedBook);
    }
    @Test
    public void getBookDetails_PositiveTest()
    {
        Book expectedBook = new Book();
        expectedBook.setBookid(1);
        expectedBook.setBookname("THIS");
        expectedBook.setBookauthor("Torry");
        expectedBook.setDescription("Torry Harries Integration Solution");
        expectedBook.setRating(5.0);
        Mockito.when(bookRepository.getBookDetailsRepository(1)).thenReturn(expectedBook);
        //BookService mockService = Mockito.mock(BookService.class);
        //Mockito.when(mockService.getBookDetailsService(Mockito.anyInt())).thenReturn(expectedBook);
        Book actualBook = bookService.getBookDetailsService(1);
        assertEquals(expectedBook,actualBook);
    }

    @Test
    public void getBookDetails_NegativeTest()
    {
        int bookId=3;
        Mockito.when(bookRepository.getBookDetailsRepository(bookId)).thenReturn(null);
        //BookService mockService = Mockito.mock(BookService.class);
        //Mockito.when(mockService.addBook(Mockito.any(Book.class))).thenReturn(null);
        Book actualBook = bookService.getBookDetailsService(bookId);
        assertNull(actualBook);
    }
}
