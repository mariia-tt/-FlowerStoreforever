package com.example.demo.model;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flowers")
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String color;
    private BigDecimal price;
    private Boolean available;

    public Flower(String flowerName, String flowerColor, BigDecimal flowerPrice, Boolean flowerAvailable) {
        this.name = flowerName;
        this.color = flowerColor;
        this.price = flowerPrice;
        this.available = flowerAvailable;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
