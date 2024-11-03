package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.strategy.delivery.Delivery;
import com.example.demo.strategy.payment.Payment;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order setDeliveryStrategy(Long id, Delivery deliveryStrategy) {
        Order order = getOrderById(id);
        if (order != null) {
            order.setDelivery(deliveryStrategy);
            return orderRepository.save(order);
        }
        return null;
    }

    public Order setPaymentStrategy(Long id, Payment paymentStrategy) {
        Order order = getOrderById(id);
        if (order != null) {
            order.setPayment(paymentStrategy);
            return orderRepository.save(order);
        }
        return null;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public double calculateOrderTotal(Long id) {
        Order order = getOrderById(id);
        if (order != null) {
            return order.calculateTotalPrice();
        } else {
            return 0.0;
        }
    }
}