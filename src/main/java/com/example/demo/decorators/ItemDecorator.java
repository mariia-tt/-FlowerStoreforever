package com.example.demo.decorators;

import com.example.demo.model.Item;

public abstract class ItemDecorator implements Item {
    private Item item;

    public ItemDecorator(Item newItem) {
        this.item = newItem;
    }

    @Override
    public double getPrice() {
        return item.getPrice();
    }

    public Item getItem() {
        return item;
    }
}
