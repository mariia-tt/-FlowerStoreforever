package com.example.demo.decorators;

import com.example.demo.model.Item;

public class PaperDecorator extends ItemDecorator {
    private static final double PAPER_PRICE = 13.0;

    public PaperDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PAPER_PRICE;
    }

    public String getDescription() {
        return "Wrapped in decorative paper";
    }
}