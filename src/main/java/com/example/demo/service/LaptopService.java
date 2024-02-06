package com.example.demo.service;

import com.example.demo.model.Laptop;
import com.example.demo.repo.LaptopRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {
    private final LaptopRepo repo;

    @Autowired
    public LaptopService(LaptopRepo repo) {
        this.repo = repo;
    }

    public void saveLaptop(Laptop laptopRequest) {

        Laptop laptop = new Laptop();

        laptop.setPrice(laptopRequest.getPrice());
        laptop.setBrand(laptopRequest.getBrand());
        laptop.setModel(laptopRequest.getModel());
        laptop.setLaptopPhoto(laptopRequest.getLaptopPhoto());

        repo.save(laptop);
    }

    public List<Laptop> getAllLaptops() {
        return repo.findAll();
    }

    public Laptop getLaptopById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Laptop updateLaptop(Laptop updateLaptop) {
        Optional<Laptop> menuOptional = repo.findById(updateLaptop.getId());
        if (menuOptional.isPresent()) {
            Laptop existingLaptop = menuOptional.get();
            existingLaptop.setBrand(updateLaptop.getBrand());
            existingLaptop.setLaptopPhoto(existingLaptop.getLaptopPhoto());
            existingLaptop.setModel(existingLaptop.getModel());
            existingLaptop.setPrice(existingLaptop.getPrice());
            return repo.save(existingLaptop);
        } else {
            throw new RuntimeException("Laptop not found");
        }


    }

    public void deleteLaptop(Integer laptopId) {
        repo.deleteById(laptopId);
    }
}

