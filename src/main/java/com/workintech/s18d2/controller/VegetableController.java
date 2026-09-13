package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vegetable")
public class VegetableController {

    private final VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public ResponseEntity<List<Vegetable>> getVegetables() {
        return ResponseEntity.ok(vegetableService.getByPriceAsc());
    }

    @GetMapping("/desc")
    public ResponseEntity<List<Vegetable>> getVegetablesDesc() {
        return ResponseEntity.ok(vegetableService.getByPriceDesc());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Vegetable>> getVegetablesByName(@PathVariable String name) {
        return ResponseEntity.ok(vegetableService.searchByName(name));
    }

    @PostMapping
    public ResponseEntity<Vegetable> saveVegetable(@RequestBody Vegetable vegetable) {
        return ResponseEntity.ok(vegetableService.save(vegetable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vegetable> getVegetableById(@PathVariable long id) {
        return ResponseEntity.ok(vegetableService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vegetable> deleteVegetable(@PathVariable long id) {
        return ResponseEntity.ok(vegetableService.delete(id));
    }
}