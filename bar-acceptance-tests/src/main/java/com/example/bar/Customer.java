package com.example.bar;

public class Customer {
    private String name;
    private int drinksConsumed;
    private double moneyPaid;
    // private List<Drink> currentOrder;

    public Customer(String name) {
        this.name = name;
        this.drinksConsumed = 0;
        this.moneyPaid = 0.0;
        // this.currentOrder = new ArrayList<>();
    }

    public void orderDrink(Drink drink) {
        // Add to order list
        // this.currentOrder.add(drink);
    }
    
    public void consumeDrink() {
        this.drinksConsumed++;
    }

    public int getDrinksConsumed() {
        return drinksConsumed;
    }

    public String getName() {
        return name;
    }
    
    public void pay(double amount) {
        this.moneyPaid += amount;
        // Further logic for bill settlement
    }
    
    public double getMoneyPaid() {
        return moneyPaid;
    }

    // Logic for happiness/sadness based on drinksConsumed
    public boolean isHappy() {
        // Based on TP: Happy if 1 drink (for Story 2)
        return drinksConsumed == 1; // This needs to be flexible based on scenario context
    }

    public boolean isSad() {
        // Based on TP: Sad if >1 drink (for Story 3)
        return drinksConsumed > 1; // This needs to be flexible based on scenario context
    }
}