package com.example.bar;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Drink> drinks;
    private Customer payer;
    private double totalAmount;
    private boolean isPaid;

    public Bill() {
        this.drinks = new ArrayList<>();
        this.totalAmount = 0.0;
        this.isPaid = false;
    }

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
        this.totalAmount += drink.getPrice();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setPayer(Customer payer) {
        this.payer = payer;
    }

    public Customer getPayer() {
        return payer;
    }

    public void markAsPaid() {
        this.isPaid = true;
    }

    public boolean isPaid() {
        return isPaid;
    }
}