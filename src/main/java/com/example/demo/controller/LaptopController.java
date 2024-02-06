package com.example.demo.controller;

import com.example.demo.dao.LaptopDao;
import com.example.demo.model.Laptop;
import com.example.demo.service.LaptopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/laptops")
public class LaptopController {
    private final LaptopService service;


    @GetMapping("getAllLaptops")
    public List<Laptop> getAllLaptops() {
        return service.getAllLaptops();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laptop> getLaptopById(@PathVariable int id) {
        Laptop laptop = service.getLaptopById(id);
        return ResponseEntity.ok(laptop);
    }

    @PostMapping
    public ResponseEntity<String> saveLaptop(@RequestBody Laptop laptopRequest) {
        service.saveLaptop(laptopRequest);
        return ResponseEntity.ok("laptop saved successfully!");
    }

    @PutMapping("updateLaptop")
    public void updateLaptop( @RequestBody Laptop laptop) {
        service.updateLaptop(laptop);

    }

    @DeleteMapping("deleteLaptop/{laptopId}")
    public void deleteLaptop(@PathVariable Integer laptopId) {
        service.deleteLaptop(laptopId);
    }
}