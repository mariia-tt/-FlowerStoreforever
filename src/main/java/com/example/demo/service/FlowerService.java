package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Flower;
import com.example.demo.repository.FlowerRepository;

@Service
public class FlowerService {

    @Autowired
    private final FlowerRepository flowerRepository;

    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<Flower> getAllFlowers() {
        return flowerRepository.findAll();
    }

    public Flower saveFlower(Flower flower) {
        return flowerRepository.save(flower);
    }

    public Flower getFlowerById(Long id) {
        return flowerRepository.findById(id).orElse(null);
    }

    public void deleteFlower(Long id) {
        flowerRepository.deleteById(id);
    }
}
