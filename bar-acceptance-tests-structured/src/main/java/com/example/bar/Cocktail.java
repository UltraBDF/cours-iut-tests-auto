package com.example.bar;

public class Cocktail {
    private final String name;
    private final int price;

    public Cocktail(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}