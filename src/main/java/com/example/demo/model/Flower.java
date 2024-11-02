package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "flowers")
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String color;
    private double price;
    private boolean available;

    // No-arg constructor required by JPA
    public Flower() {}

    public Flower(String name, String color, double price, boolean available) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.available = available;
    }
}
