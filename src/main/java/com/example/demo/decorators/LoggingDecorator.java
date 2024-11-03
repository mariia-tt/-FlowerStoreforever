package com.example.demo.decorators;

import com.example.demo.model.Flower;
import com.example.demo.service.FlowerService;

import java.util.List;

public class LoggingDecorator extends AbstractDecorator {

    public LoggingDecorator(FlowerService flowerService) {
        super(flowerService);
    }

    @Override
    public List<Flower> getAllFlowers() {
        System.out.println("Fetching all flowers...");
        List<Flower> flowers = super.getAllFlowers();
        System.out.println("Retrieved " + flowers.size() + " flowers.");
        return flowers;
    }
}
