Feature: Le Juste Bar customer stories

  Background:
    Given a bar called "Le Juste" with 10 seats
    And the cocktail of the month costs 10.0 euros
    And Mr. Pignon and Mr. Leblanc are at the door

  Scenario: Entry is refused when the bar is almost full
    Given the bar already has 9 clients
    When they try to enter the bar
    Then they should be refused entry because the bar is full
    And the number of clients in the bar should remain 9

  Scenario: Two friends enter a nearly full bar and one pays for the round
    Given the bar already has 8 clients
    When they enter the bar
    And the person behind them tries to enter
    Then they should be admitted
    And the person behind them should be refused entry
    And the bar should now be full
    When they each order a cocktail of the month
    And Mr. Leblanc pays for everyone's order
    Then the final bill for Mr. Leblanc should be 20.0 euros
    And Mr. Pignon is happy

  Scenario: Two friends have multiple drinks and one gets sad
    Given the bar already has 3 clients
    When they enter the bar
    Then they should be admitted
    When they each order a cocktail of the month
    And Mr. Pignon pays his own bill
    And Mr. Leblanc orders 2 more cocktails of the month for his bill
    And Mr. Leblanc pays his final bill
    Then the final bill for Mr. Leblanc should be 30.0 euros
    And Mr. Pignon is sad