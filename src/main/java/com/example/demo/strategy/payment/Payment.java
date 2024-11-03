package com.example.demo.strategy.payment;

public interface Payment {
    void collectPaymentDetails();
    boolean pay(int paymentAmount); 
}
