package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.decorators.BasketDecorator;
import com.example.demo.decorators.PaperDecorator;
import com.example.demo.decorators.RibbonDecorator;
import com.example.demo.model.Flower;
import com.example.demo.model.FlowerBucket;
import com.example.demo.model.Item;

import java.math.BigDecimal;

class ItemDecoratorTest {
    private Item flowerBucket;
    private Flower flower;

    @BeforeEach
    void setUp() {
        flower = new Flower("Rose", "Red", new BigDecimal("50.0"), true);
        FlowerBucket bucket = new FlowerBucket();
        bucket.addFlower(flower);
        flowerBucket = bucket;
    }

    @Test
    void testPaperDecorator() {
        Item decoratedItem = new PaperDecorator(flowerBucket);
        assertEquals(63.0, decoratedItem.getPrice(), 0.01);
        
        PaperDecorator paperDecorator = (PaperDecorator) decoratedItem;
        assertEquals("Wrapped in decorative paper", paperDecorator
        .getDescription());
    }

    @Test
    void testBasketDecorator() {
        Item decoratedItem = new BasketDecorator(flowerBucket);
        assertEquals(74.0, decoratedItem.getPrice(), 0.01);
        
        BasketDecorator basketDecorator = (BasketDecorator) decoratedItem;
        assertEquals("Placed in a decorative basket", basketDecorator
        .getDescription());
    }

    @Test
    void testRibbonDecorator() {
        Item decoratedItem = new RibbonDecorator(flowerBucket);
        assertEquals(90.0, decoratedItem.getPrice(), 0.01);
        
        RibbonDecorator ribbonDecorator = (RibbonDecorator) decoratedItem;
        assertEquals("Decorated with a ribbon", ribbonDecorator
        .getDescription());
    }

    @Test
    void testMultipleDecorators() {
        Item decoratedItem = new RibbonDecorator(
            new BasketDecorator(
                new PaperDecorator(flowerBucket)
            )
        );
        
        assertEquals(127.0, decoratedItem.getPrice(), 0.01);
    }

    @Test
    void testDecoratorWithEmptyBucket() {
        FlowerBucket emptyBucket = new FlowerBucket();
        Item decoratedItem = new PaperDecorator(emptyBucket);
        
        assertEquals(13.0, decoratedItem.getPrice(), 0.01);
    }

    @Test
    void testNestedDecoratorsOrder() {
        Item order1 = new BasketDecorator(new RibbonDecorator(flowerBucket));
        Item order2 = new RibbonDecorator(new BasketDecorator(flowerBucket));
        
        assertEquals(order1.getPrice(), order2.getPrice(), 0.01);
    }
}