package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "flower_buckets")
public class FlowerBucket implements Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<Flower> flowers;

    @Transient
    private double price;

    public FlowerBucket() {
        this.flowers = new ArrayList<>();
        this.price = 0.0;
    }

    public void addFlower(Flower flower) {
        if (flower != null && flower.isAvailable()) {
            flowers.add(flower);
            updatePrice();
        }
    }

    private void updatePrice() {
        this.price = flowers.stream()
                .mapToDouble(Flower::getPrice)
                .sum();
    }

    public void removeFlower(Flower flower) {
        flowers.remove(flower);
        updatePrice();
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }

    public List<Flower> getFlowers() {
        return new ArrayList<>(flowers);
    }

    public void setFlowers(List<Flower> newFlowers) {
        this.flowers = new ArrayList<>(newFlowers);
        updatePrice();
    }

    public int getFlowerCount() {
        return flowers.size();
    }

    public boolean isEmpty() {
        return flowers.isEmpty();
    }

    public void clear() {
        flowers.clear();
        price = 0.0;
    }

    public boolean containsFlower(String flowerName) {
        return flowers.stream()
                .anyMatch(flower -> flower.getName()
                .equalsIgnoreCase(flowerName));
    }

    @Override
    public String toString() {
        return "FlowerBucket{" 
        + "id=" + id
         + ", flowerCount=" + flowers.size()
          + ", totalPrice=" + price
           + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } 
        if (!(o instanceof FlowerBucket)) { 
            return false;
        }
        FlowerBucket that = (FlowerBucket) o;
        return id != null && id.equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
