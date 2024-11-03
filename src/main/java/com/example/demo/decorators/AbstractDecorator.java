package com.example.demo.decorators;

import com.example.demo.model.Flower;
import com.example.demo.service.FlowerService;

import java.util.List;

public abstract class AbstractDecorator {
    private final FlowerService flowerService;

    public AbstractDecorator(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    public List<Flower> getAllFlowers() {
        return flowerService.getAllFlowers();
    }

    public Flower saveFlower(Flower flower) {
        return flowerService.saveFlower(flower);
    }

    public Flower getFlowerById(Long id) {
        return flowerService.getFlowerById(id);
    }

    public void deleteFlower(Long id) {
        flowerService.deleteFlower(id);
    }
}
