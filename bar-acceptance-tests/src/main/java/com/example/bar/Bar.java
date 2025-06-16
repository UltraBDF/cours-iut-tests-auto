package com.example.bar;

import java.util.ArrayList;
import java.util.List;

public class Bar {
    private String name;
    private int capacity;
    private List<Customer> occupants;
    // You'll need more fields for managing orders, bills, etc.
    // private HashMap<Customer, List<Drink>> customerOrders;
    // private HashMap<Customer, Bill> customerBills;


    public Bar(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.occupants = new ArrayList<>();
        // Initialize other collections
    }

    public boolean canEnter() {
        return occupants.size() < capacity;
    }

    public boolean tryEnter(Customer customer) {
        if (occupants.size() < capacity) {
            occupants.add(customer);
            return true;
        }
        return false;
    }
    
    public boolean tryEnter(Customer customer1, Customer customer2) {
        if (occupants.size() + 2 <= capacity) {
            occupants.add(customer1);
            occupants.add(customer2);
            return true;
        }
        return false;
    }


    public int getCurrentOccupancy() {
        return occupants.size();
    }
    
    public boolean isFull() {
        return occupants.size() >= capacity;
    }

    // Add methods for:
    // - Adding customers
    // - Taking orders
    // - Calculating bills
    // - Processing payments
    // - Checking if full
    // - etc.

    public String getName() {
        return name;
    }
}