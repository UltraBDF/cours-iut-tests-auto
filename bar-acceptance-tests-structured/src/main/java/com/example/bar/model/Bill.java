package com.example.bar.model;

public class Bill {
    private double total = 0.0;

    public void add(double amount) {
        this.total += amount;
    }

    public double getTotal() {
        return total;
    }

    public void pay() {
        this.total = 0.0;
    }
}