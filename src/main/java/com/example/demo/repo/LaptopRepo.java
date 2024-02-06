package com.example.demo.repo;

import com.example.demo.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LaptopRepo extends JpaRepository<Laptop,Long> {
    public Laptop getLaptopById(int id);

    Optional<Laptop> findById(Integer id);

    void deleteById(Integer laptopId);
}

