package com.example.bar;

public class Bill {
    private int total = 0;

    public void add(int amount) {
        total += amount;
    }

    public int getTotal() {
        return total;
    }
}