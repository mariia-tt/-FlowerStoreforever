package com.example.demo;

import com.example.demo.decorators.LoggingDecorator;
import com.example.demo.decorators.AvailabilityFilterDecorator;
import com.example.demo.model.Flower;
import com.example.demo.service.FlowerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecoratorTests {

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
            new Flower("Rose", "Red", BigDecimal.valueOf(10.0), true),
            new Flower("Tulip", "Yellow", BigDecimal.valueOf(5.0), false)
        );

        Mockito.when(flowerService.getAllFlowers()).thenReturn(mockFlowers);
        List<Flower> flowers = loggingDecorator.getAllFlowers();

        assertEquals(2, flowers.size());
    }

    @Test
    public void testAvailabilityFilterDecorator() {
        List<Flower> mockFlowers = Arrays.asList(
            new Flower("Rose", "Red", BigDecimal.valueOf(10.0), true),
            new Flower("Tulip", "Yellow", BigDecimal.valueOf(5.0), false)
        );

        Mockito.when(flowerService.getAllFlowers()).thenReturn(mockFlowers);
        List<Flower> flowers = availabilityDecorator.getAllFlowers();

        assertEquals(1, flowers.size());
        assertEquals("Rose", flowers.get(0).getName());
    }
}
