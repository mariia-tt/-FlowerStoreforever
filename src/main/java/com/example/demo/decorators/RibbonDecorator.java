package com.example.demo.decorators;

import com.example.demo.model.Item;

public class RibbonDecorator extends ItemDecorator {
    private static final double RIBBON_PRICE = 40.0;

    public RibbonDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + RIBBON_PRICE;
    }

    public String getDescription() {
        return "Decorated with a ribbon";
    }
}