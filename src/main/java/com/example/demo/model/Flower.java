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

    public Flower(String flowerName, String flowerColor, BigDecimal flowerPrice,
     Boolean flowerAvailable) {
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

    public void setId(Integer newId) {
        this.id = newId;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }

    public void setPrice(BigDecimal newPrice) {
        this.price = newPrice;
    }

    public void setAvailable(Boolean newAvailable) {
        this.available = newAvailable;
    }
}
