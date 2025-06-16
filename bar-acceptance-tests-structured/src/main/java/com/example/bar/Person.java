package com.example.bar;

public class Person {
    private final String name;
    private final Bill bill = new Bill();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Bill getBill() {
        return bill;
    }

    public void order(Cocktail cocktail) {
        bill.add(cocktail.getPrice());
    }
}