package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private  String brand;
    private String model;
    private Double price;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] laptopPhoto;
}
