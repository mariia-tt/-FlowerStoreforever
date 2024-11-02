package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Flower;
import com.example.demo.repository.FlowerRepository;

@Service
public class FlowerService {

    private FlowerRepository flowerRepository;

    @Autowired
    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<Flower> getFlowers() {
        List<Flower> flowers = flowerRepository.findAll();
        System.out.println("Flowers: " + flowers);
        return flowers;
    }

    public Flower createFlower(Flower flower) {
        return flowerRepository.save(flower);
    }
}
