package com.example.demo.strategy.delivery;

public interface Delivery {
    String deliver();

    double calculateDeliveryCost(double total);
}
