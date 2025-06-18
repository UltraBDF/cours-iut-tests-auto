package com.example.bar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Bar {

    private final String name; 
    private final int capacity;
    private final List<Client> clients = new ArrayList<>();
    private final Map<String, Drink> menu = new HashMap<>();
    
    public Bar(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void addDrinkToMenu(String name, double price) {
        this.menu.put(name, new Drink(name, price));
    }

    public boolean canAdmit(int numberOfPeople) {
        return clients.size() + numberOfPeople <= capacity;
    }

    public int getCurrentOccupancy() {
        return clients.size();
    }

    public void addClient(Client client) {
        clients.add(client);
    }
    
    public List<Client> getClients() {
        return clients;
    }

    public Optional<Drink> getDrink(String name) {
        return Optional.ofNullable(menu.get(name));
    }
}