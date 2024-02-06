package com.example.demo.repo;

import com.example.demo.model.Book;
import com.example.demo.model.Readers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepo extends JpaRepository<Readers,Integer> {
}
