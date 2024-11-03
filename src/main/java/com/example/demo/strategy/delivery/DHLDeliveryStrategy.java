package com.example.demo.strategy.delivery;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api/delivery")
public class DHLDeliveryStrategy implements Delivery {
    @Override
    @GetMapping("/dhl")
    public String deliver() {
        return ("Delivering by DHL");
    }

    @Override
    public double calculateDeliveryCost(double total) {
        throw new UnsupportedOperationException(
            "Unimplemented method 'calculateDeliveryCost'");
    }
}
