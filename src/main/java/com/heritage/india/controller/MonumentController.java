package com.heritage.india.controller;

import com.heritage.india.entity.Monument;
import com.heritage.india.repository.MonumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // Import this
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monuments")
@CrossOrigin(origins = "http://localhost:5173") 
public class MonumentController {

    @Autowired
    private MonumentRepository monumentRepository;

    @GetMapping
    public List<Monument> getAllMonuments() {
        return monumentRepository.findAll();
    }

    // --- NEW METHOD FOR INDIVIDUAL DETAILS ---
    @GetMapping("/{id}")
    public ResponseEntity<Monument> getMonumentById(@PathVariable Long id) {
        return monumentRepository.findById(id)
                .map(monument -> ResponseEntity.ok().body(monument))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Monument addMonument(@RequestBody Monument monument) {
        return monumentRepository.save(monument);
    }
}