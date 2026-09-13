package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/fruit")
public class FruitController {

    private final FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public ResponseEntity<List<Fruit>> getFruits() {
        return ResponseEntity.ok(fruitService.getByPriceAsc());
    }

    @GetMapping("/desc")
    public ResponseEntity<List<Fruit>> getFruitsDesc() {
        return ResponseEntity.ok(fruitService.getByPriceDesc());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Fruit>> getFruitsByName(@PathVariable String name) {
        return ResponseEntity.ok(fruitService.searchByName(name));
    }

    @PostMapping
    public ResponseEntity<Fruit> saveFruit(@RequestBody Fruit fruit) {
        return ResponseEntity.ok(fruitService.save(fruit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable long id) {
        return ResponseEntity.ok(fruitService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Fruit> deleteFruit(@PathVariable long id) {
        return ResponseEntity.ok(fruitService.delete(id));
    }
}