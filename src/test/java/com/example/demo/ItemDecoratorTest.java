package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.decorators.BasketDecorator;
import com.example.demo.decorators.PaperDecorator;
import com.example.demo.decorators.RibbonDecorator;
import com.example.demo.model.Flower;
import com.example.demo.model.FlowerBucket;
import com.example.demo.model.Item;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
class ItemDecoratorTest {
    private static final double PAPER_DECORATOR_PRICE = 63.0;
    private static final double BASKET_DECORATOR_PRICE = 74.0;
    private static final double RIBBON_DECORATOR_PRICE = 90.0;
    private static final double EMPTY_BUCKET_PRICE = 13.0;
    private static final double MULTIPLE_DECORATORS_PRICE = 127.0;
    private static final double DELTA = 0.01;

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
        Assertions.assertEquals(PAPER_DECORATOR_PRICE, decoratedItem
        .getPrice(), DELTA);

        PaperDecorator paperDecorator = (PaperDecorator) decoratedItem;
        Assertions.assertEquals("Wrapped in decorative paper",
         paperDecorator.getDescription());
    }

    @Test
    void testBasketDecorator() {
        Item decoratedItem = new BasketDecorator(flowerBucket);
        Assertions.assertEquals(BASKET_DECORATOR_PRICE, decoratedItem
        .getPrice(), DELTA);

        BasketDecorator basketDecorator = (BasketDecorator) decoratedItem;
        Assertions.assertEquals("Placed in a decorative basket",
         basketDecorator.getDescription());
    }

    @Test
    void testRibbonDecorator() {
        Item decoratedItem = new RibbonDecorator(flowerBucket);
        Assertions.assertEquals(RIBBON_DECORATOR_PRICE, decoratedItem
        .getPrice(), DELTA);

        RibbonDecorator ribbonDecorator = (RibbonDecorator) decoratedItem;
        Assertions.assertEquals("Decorated with a ribbon",
         ribbonDecorator.getDescription());
    }

    @Test
    void testMultipleDecorators() {
        Item decoratedItem = new RibbonDecorator(
            new BasketDecorator(
                new PaperDecorator(flowerBucket)
            )
        );

        Assertions.assertEquals(MULTIPLE_DECORATORS_PRICE, decoratedItem
        .getPrice(), DELTA);
    }

    @Test
    void testDecoratorWithEmptyBucket() {
        FlowerBucket emptyBucket = new FlowerBucket();
        Item decoratedItem = new PaperDecorator(emptyBucket);

        Assertions.assertEquals(EMPTY_BUCKET_PRICE, decoratedItem
        .getPrice(), DELTA);
    }

    @Test
    void testNestedDecoratorsOrder() {
        Item basketWithRibbon = new BasketDecorator(new RibbonDecorator
        (flowerBucket));
        Item ribbonWithBasket = new RibbonDecorator(new BasketDecorator
        (flowerBucket));

        Assertions.assertEquals(basketWithRibbon.getPrice(),
         ribbonWithBasket.getPrice(), DELTA);
    }
}
