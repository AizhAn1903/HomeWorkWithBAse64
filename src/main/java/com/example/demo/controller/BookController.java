package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {


  private final BookService bookService;
@PostMapping
    public ResponseEntity<String> saveBook (@RequestBody Book book) {
    bookService.saveBook(book);
    return ResponseEntity.ok("Успешно загружено") ;
}
}
