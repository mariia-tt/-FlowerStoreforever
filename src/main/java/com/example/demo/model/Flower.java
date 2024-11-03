package com.example.demo.model;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flowers")
public class Flower implements Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String color;
    private BigDecimal price;
    private boolean available;

    protected Flower() {
    }

    public Flower(String name, String color, BigDecimal price, boolean available) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.available = available;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }

    public BigDecimal getPriceAsBigDecimal() {
        return price;
    }

    public void setPrice(BigDecimal newPrice) {
        this.price = newPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean newAvailable) {
        this.available = newAvailable;
    }

    @Override
    public double getPrice() {
        return price.doubleValue();
    }
}
