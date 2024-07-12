package com.example.crmsystem.controllers;

import com.example.crmsystem.models.Sales;
import com.example.crmsystem.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesRepository salesRepository;

    @GetMapping
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sales> getSalesById(@PathVariable Long id) {
        Optional<Sales> sales = salesRepository.findById(id);
        return sales.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sales> createSales(@RequestBody Sales sales) {
        Sales savedSales = salesRepository.save(sales);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSales);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sales> updateSales(@PathVariable Long id, @RequestBody Sales salesDetails) {
        Optional<Sales> sales = salesRepository.findById(id);
        if (sales.isPresent()) {
            Sales existingSales = sales.get();
            existingSales.setDescription(salesDetails.getDescription());
            existingSales.setStage(salesDetails.getStage());
            Sales updatedSales = salesRepository.save(existingSales);
            return ResponseEntity.ok(updatedSales);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSales(@PathVariable Long id) {
        if (salesRepository.existsById(id)) {
            salesRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
