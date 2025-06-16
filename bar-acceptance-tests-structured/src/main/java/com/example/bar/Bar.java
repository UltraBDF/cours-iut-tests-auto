package com.example.bar;

import java.util.ArrayList;
import java.util.List;

public class Bar {
    private final int capacity = 10;
    private final List<Person> people = new ArrayList<>();
    private int revenue = 0;

    public boolean canEnter(int groupSize) {
        return people.size() + groupSize <= capacity;
    }

    public void enter(Person... group) {
        for (Person p : group) {
            people.add(p);
        }
    }

    public void serve(Person person, Cocktail cocktail) {
        person.order(cocktail);
        revenue += cocktail.getPrice();
    }

    public int getTotalRevenue() {
        return revenue;
    }

    public void reset() {
        people.clear();
        revenue = 0;
    }

    public int getPeopleCount() {
        return people.size();
    }
}