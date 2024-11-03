// Updated Order.java
package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

import com.example.demo.strategy.delivery.Delivery;
import com.example.demo.strategy.payment.Payment;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Item> items;

    @Transient
    private Payment payment;

    @Transient
    private Delivery delivery;

    public Order() {
    }

    public Order(List<Item> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment paymentMethod) {
        this.payment = paymentMethod;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery deliveryMethod) {
        this.delivery = deliveryMethod;
    }

    public double calculateTotalPrice() {
        double total = items.stream().mapToDouble(Item::getPrice).sum();
        if (delivery != null) {
            total += delivery.calculateDeliveryCost(total);
        }
        return total;
    }
}