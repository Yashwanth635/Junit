package com.example.LibraryManagement.entity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookEntityTest  {

    @Test
    public void testGettersAndSetters()
    {
        Book book = new Book();

        book.setBookid(1);
        book.setBookname("THIS");
        book.setBookauthor("Torry");
        book.setDescription("Torry Harries Integration Solution");
        book.setRating(4.5);

        assertEquals(1, book.getBookid());
        assertEquals("THIS", book.getBookname());
        assertEquals("Torry", book.getBookauthor());
        assertEquals("Torry Harries Integration Solution", book.getDescription());
        assertEquals(4.5, book.getRating());
    }
}

