package com.example.demo.decorators;

import com.example.demo.model.Item;

public class BasketDecorator extends ItemDecorator {
    private static final double BASKET_PRICE = 24.0;

    public BasketDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + BASKET_PRICE;
    }

    public String getDescription() {
        return "Placed in a decorative basket";
    }
}