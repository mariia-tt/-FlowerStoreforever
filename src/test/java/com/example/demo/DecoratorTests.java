package com.example.demo;

import com.example.demo.decorators.LoggingDecorator;
import com.example.demo.decorators.AvailabilityFilterDecorator;
import com.example.demo.model.Flower;
import com.example.demo.service.FlowerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DecoratorTests {

    private static final BigDecimal TEN = BigDecimal.valueOf(10.0);
    private static final BigDecimal FIVE = BigDecimal.valueOf(5.0);

    private FlowerService flowerService;
    private LoggingDecorator loggingDecorator;
    private AvailabilityFilterDecorator availabilityDecorator;

    @BeforeEach
    public void setUp() {
        flowerService = Mockito.mock(FlowerService.class);
        loggingDecorator = new LoggingDecorator(flowerService);
        availabilityDecorator = new AvailabilityFilterDecorator(flowerService);
    }

    @Test
    public void testLoggingDecorator() {
        List<Flower> mockFlowers = Arrays.asList(
            new Flower("Rose", "Red", TEN, true),
            new Flower("Tulip", "Yellow", FIVE, false)
        );

        Mockito.when(flowerService.getAllFlowers()).thenReturn(mockFlowers);
        List<Flower> flowers = loggingDecorator.getAllFlowers();

        assertEquals(2, flowers.size());
    }

    @Test
    public void testAvailabilityFilterDecorator() {
        List<Flower> mockFlowers = Arrays.asList(
            new Flower("Rose", "Red", TEN, true),
            new Flower("Tulip", "Yellow", FIVE, false)
        );

        Mockito.when(flowerService.getAllFlowers()).thenReturn(mockFlowers);
        List<Flower> flowers = availabilityDecorator.getAllFlowers();

        assertEquals(1, flowers.size());
        assertEquals("Rose", flowers.get(0).getName());
    }
}
