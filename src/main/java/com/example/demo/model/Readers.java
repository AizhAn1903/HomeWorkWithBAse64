package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table
@Data
public class Readers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String birthday;


}
