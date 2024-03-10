package com.example.LibraryManagement.repository;

import com.example.LibraryManagement.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Value("${downstream.servicepost.url}")
    private String downstreamServiceUrl;

    @Value("${downstream.serviceget.url}")
    private String downstreamUrl;

    @Autowired
    private RestTemplate restTemplate;

    public Book getBookDetailsRepository(int id) {
        String url = downstreamUrl + "/" + id;
        try{
            Book book = restTemplate.getForObject(url,Book.class);
//            System.out.println(book);
            return book;
        }catch (HttpClientErrorException.NotFound ex)
        {
            System.out.println("Book with requested ID is not present: " + id);
            return null;
        }

    }
    @Override
    public Book addBook(Book book) {
        String url = downstreamServiceUrl + "/books";
        return restTemplate.postForObject(url, book, Book.class);
    }

}
