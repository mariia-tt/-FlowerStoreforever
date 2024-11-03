package com.example.demo.decorators;

import com.example.demo.model.Flower;
import com.example.demo.service.FlowerService;

import java.util.List;
import java.util.stream.Collectors;

public class AvailabilityFilterDecorator extends AbstractDecorator {

    public AvailabilityFilterDecorator(FlowerService flowerService) {
        super(flowerService);
    }

    @Override
    public List<Flower> getAllFlowers() {
        List<Flower> allFlowers = super.getAllFlowers();
        List<Flower> availableFlowers = allFlowers.stream()
                .filter(Flower::getAvailable)
                .collect(Collectors.toList());
        System.out.println("Filtered available flowers: "
         + availableFlowers.size());
        return availableFlowers;
    }
}
