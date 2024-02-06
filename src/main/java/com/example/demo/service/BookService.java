package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepo bookRepo;
    public void saveBook (Book bookRequest) {
        Book book = new Book();
        book.setBookName(bookRequest.getBookName());
        book.setAuthorName(bookRequest.getAuthorName());
        book.setPublishedDate(new Date());
        book.setBookPhoto(bookRequest.getBookPhoto());


    }

}
