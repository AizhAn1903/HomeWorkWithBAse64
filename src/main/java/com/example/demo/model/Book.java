package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;
@Entity
@Table
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String bookName;
    private String authorName;
    private Date publishedDate;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] bookPhoto;



}
