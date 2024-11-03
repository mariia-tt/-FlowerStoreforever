package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Flower;
import com.example.demo.service.FlowerService;

@RestController
@RequestMapping("/api/v1/flower")
public class FlowerController {

    private final FlowerService flowerService;

    @Autowired
    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping
    public List<Flower> getAllFlowers() {
        return flowerService.getAllFlowers();
    }

    @PostMapping
    public Flower addFlower(@RequestBody Flower flower) {
        return flowerService.saveFlower(flower);
    }

    @GetMapping("/{id}")
    public Flower getFlowerById(@PathVariable Long id) {
        return flowerService.getFlowerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFlower(@PathVariable Long id) {
        flowerService.deleteFlower(id);
    }
}