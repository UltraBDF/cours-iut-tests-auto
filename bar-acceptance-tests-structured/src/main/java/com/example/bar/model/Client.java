package com.example.bar.model;

public class Client {
    private final String name;
    private int consumedDrinks = 0;
    private final Bill bill = new Bill();

    public Client(String name) {
        this.name = name;
    }

    public void consume() {
        this.consumedDrinks++;
    }

    public Bill getBill() {
        return bill;
    }

    public String getName() {
        return name;
    }

    public Mood getMood() {
        if (consumedDrinks > 1) {
            return Mood.SAD;
        }
        if (consumedDrinks == 1) {
            return Mood.HAPPY;
        }
        return Mood.NEUTRAL;
    }
}