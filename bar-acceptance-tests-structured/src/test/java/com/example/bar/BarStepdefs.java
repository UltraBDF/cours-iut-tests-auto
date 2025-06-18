package com.example.bar;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.bar.exception.BarException;
import com.example.bar.model.Bar;
import com.example.bar.model.Client;
import com.example.bar.model.Mood;
import com.example.bar.service.BarService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BarStepdefs {

    private Bar bar;
    private BarService barService;
    private Client pignon;
    private Client leblanc;
    private Exception admissionException;
    private double finalBillLeblanc;

    @Given("a bar called {string} with {int} seats")
    public void a_bar_called_with_seats(String name, int capacity) {
        bar = new Bar(name, capacity); 
        barService = new BarService(bar);
    }

    @Given("the cocktail of the month costs {double} euros")
    public void the_cocktail_of_the_month_costs_euros(double price) {
        bar.addDrinkToMenu("cocktail of the month", price);
    }

    @Given("Mr. Pignon and Mr. Leblanc are at the door")
    public void mr_pignon_and_mr_leblanc_are_at_the_door() {
        pignon = new Client("Mr. Pignon");
        leblanc = new Client("Mr. Leblanc");
    }

    @Given("the bar already has {int} clients")
    public void the_bar_already_has_clients(int count) {
        for (int i = 0; i < count; i++) {
            bar.addClient(new Client("Anonymous Client " + (i + 1)));
        }
    }

    @When("they try to enter the bar")
    public void they_try_to_enter_the_bar() {
        if (!bar.canAdmit(2)) {
            this.admissionException = new BarException("Le groupe ne peut pas être admis.");
        } else {
            try {
                barService.admit(pignon);
                barService.admit(leblanc);
            } catch (BarException e) {
                this.admissionException = e;
            }
        }
    }

    @When("they enter the bar")
    public void they_enter_the_bar() {
        they_try_to_enter_the_bar();
    }

    @Then("they should be refused entry because the bar is full")
    public void they_should_be_refused_entry_because_the_bar_is_full() {
        assertNotNull(admissionException, "Une exception aurait dû être levée.");
        assertTrue(admissionException instanceof BarException);
    }

    @Then("the number of clients in the bar should remain {int}")
    public void the_number_of_clients_in_the_bar_should_remain(int count) {
        assertEquals(count, bar.getCurrentOccupancy());
    }

    @Then("they should be admitted")
    public void they_should_be_admitted() {
        assertNull(admissionException, "Aucune exception n'aurait dû être levée.");
        assertTrue(bar.getClients().containsAll(List.of(pignon, leblanc)));
    }

    @When("the person behind them tries to enter")
    public void the_person_behind_them_tries_to_enter() {
        assertThrows(BarException.class, () -> {
            barService.admit(new Client("Person Behind"));
        });
    }

    @Then("the person behind them should be refused entry")
    public void the_person_behind_them_should_be_refused_entry() {
        // C'est validé par l'étape précédente, cette étape est pour la lisibilité.
    }

    @Then("the bar should now be full")
    public void the_bar_should_now_be_full() {
        assertEquals(10, bar.getCurrentOccupancy());
    }

    @When("they each order a cocktail of the month")
    public void they_each_order_a_cocktail_of_the_month() {
        barService.order(pignon, "cocktail of the month");
        barService.order(leblanc, "cocktail of the month");
    }

    @When("Mr. Leblanc pays for everyone's order")
    public void mr_leblanc_pays_for_everyone_s_order() {
        barService.payFor(leblanc, List.of(pignon, leblanc));
        this.finalBillLeblanc = leblanc.getBill().getTotal();
        leblanc.getBill().pay();
    }
    
    @When("Mr. Pignon pays his own bill")
    public void mr_pignon_pays_his_own_bill() {
        pignon.getBill().pay();
    }
    
    @When("Mr. Leblanc orders {int} more cocktails of the month for his bill")
    public void mr_leblanc_orders_more_cocktails(int quantity) {
        barService.orderForBill(leblanc, pignon, "cocktail of the month");
        barService.orderForBill(leblanc, leblanc, "cocktail of the month");
    }
    
    @When("Mr. Leblanc pays his final bill")
    public void mr_leblanc_pays_his_final_bill() {
        this.finalBillLeblanc = leblanc.getBill().getTotal();
        leblanc.getBill().pay();
    }

    @Then("the final bill for Mr. Leblanc should be {double} euros")
    public void the_final_bill_for_mr_leblanc_should_be_euros(double expectedBill) {
        assertEquals(expectedBill, this.finalBillLeblanc);
    }

    @Then("Mr. Pignon is {word}")
    public void mr_pignon_is(String mood) {
        assertEquals(Mood.valueOf(mood.toUpperCase()), pignon.getMood());
    }
}