package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.List;

import com.example.demo.strategy.delivery.Delivery;
import com.example.demo.strategy.payment.Payment;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @OneToMany
    private List<Item> orderItems;

    @Transient
    private Payment payment;

    @Transient
    private Delivery delivery;

    public Order() {
    }

    public Order(List<Item> items) {
        this.orderItems = items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long id) {
        this.orderId = id;
    }

    public List<Item> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Item> items) {
        this.orderItems = items;
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
        double total = orderItems.stream()
        .mapToDouble(Item::getPrice).sum();
        if (delivery != null) {
            total += delivery.calculateDeliveryCost(total);
        }
        return total;
    }
}