package com.example.bar.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.bar.exception.BarException;
import com.example.bar.model.Bar;
import com.example.bar.model.Client;
import com.example.bar.model.Drink;

public class BarService {
    private final Bar bar;

    public BarService(Bar bar) {
        this.bar = bar;
    }

    /**
     * Admits a single client if there is capacity.
     */
    public void admit(Client client) {
        if (!bar.canAdmit(1)) {
            throw new BarException("The bar is full.");
        }
        bar.addClient(client);
    }

    /**
     * A client places an order for themselves.
     */
    public void order(Client client, String drinkName) {
        Drink drink = bar.getDrink(drinkName)
            .orElseThrow(() -> new NoSuchElementException("Drink not on menu: " + drinkName));
        
        client.consume();
        client.getBill().add(drink.getPrice());
    }

    /**
     * A client pays the bill for a list of clients (including potentially themselves).
     */
    public void payFor(Client payer, List<Client> clientsToCover) {
        double totalToPay = 0;
        for (Client client : clientsToCover) {
            totalToPay += client.getBill().getTotal();
            client.getBill().pay();
        }
        payer.getBill().add(totalToPay);
    }
    
    /**
     * A client (payer) orders a drink for another client (consumer),
     * but the cost is added to the payer's bill.
     */
    public void orderForBill(Client payer, Client consumer, String drinkName) {
        Drink drink = bar.getDrink(drinkName)
            .orElseThrow(() -> new NoSuchElementException("Drink not on menu: " + drinkName));
        
        consumer.consume(); 
        payer.getBill().add(drink.getPrice()); 
    }
}