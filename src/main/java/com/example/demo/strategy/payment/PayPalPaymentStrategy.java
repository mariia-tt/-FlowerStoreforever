package com.example.demo.strategy.payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PayPalPaymentStrategy implements Payment {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    @Override
    public void collectPaymentDetails() {
        try {
            while (!signedIn) {
                System.out.print("Enter the user's email: ");
                email = reader.readLine();
                System.out.print("Enter the password: ");
                password = reader.readLine();
                if (verify()) {
                    System.out.println(
                        "Data verification has been successful.");
                } else {
                    System.out.println("Wrong email or password!");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean verify() {
        updateSignedInStatus(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            System.out.println("Paying " + paymentAmount + " using PayPal.");
            return true;
        } else {
            return false;
        }
    }

    private void updateSignedInStatus(boolean status) {
        this.signedIn = status;
    }
}
