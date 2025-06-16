Feature: Bar Entry and Ordering at "le Juste"

  Background: Bar Setup
    Given the bar "le Juste" has a maximum capacity of 10 seats [cite: 28]

  Scenario: Turned away due to full capacity (Story 1) [cite: 29]
    Given there are 9 people already in the bar
    When Mr. Pignon and Mr. Leblanc arrive at the bar
    Then they should be refused entry
    And the bar should still have 9 occupants

  Scenario: Successful entry, bar becomes full, Leblanc pays for all (Story 2) [cite: 30, 31, 32, 33, 34]
    Given there are 8 people already in the bar
    And Mr. Pignon should only consume one drink to remain happy
    When Mr. Pignon and Mr. Leblanc arrive at the bar
    And they are allowed entry
    And another person arrives after them
    Then this other person should be refused entry because the bar is full
    And the bar should now have 10 occupants (8 existing + Pignon + Leblanc)
    When Mr. Pignon orders one "cocktail of the month" at 10 euros
    And Mr. Leblanc orders one "cocktail of the month" at 10 euros
    And Mr. Leblanc states he will pay for the entire order
    When they finish their drinks
    And the bill for their order is checked
    Then the total bill should be 20 euros
    And Mr. Leblanc pays the 20 euros bill [cite: 33]
    Then Mr. Pignon should be happy because he consumed only one drink [cite: 34]

  Scenario: Successful entry, individual orders, Leblanc orders more, Pignon unhappy (Story 3) [cite: 36, 37, 38, 39, 40]
    Given there are 3 people already in the bar
    And Mr. Pignon will be sad if he consumes more than one drink
    When Mr. Pignon and Mr. Leblanc arrive at the bar
    And they are allowed entry
    Then the bar should now have 5 occupants (3 existing + Pignon + Leblanc)
    When Mr. Pignon orders and consumes one "cocktail of the month" at 10 euros
    And Mr. Leblanc orders and consumes one "cocktail of the month" at 10 euros
    And Mr. Pignon pays for his own drink, amounting to 10 euros [cite: 37]
    # Leblanc's first drink is still on his tab.
    And Mr. Leblanc then decides to order more drinks
    And Mr. Leblanc orders two more "cocktail of the month" at 10 euros each, one for Mr. Pignon and one for himself, adding them to his own bill [cite: 38]
    And Mr. Pignon consumes his second "cocktail of the month"
    And Mr. Leblanc consumes his second "cocktail of the month"
    When Mr. Leblanc checks his total bill
    Then his total bill should be 30 euros (10 for his first + 10 for Pignon's second + 10 for his second) [cite: 39]
    And Mr. Leblanc pays his total bill [cite: 39]
    Then Mr. Pignon should be sad because he consumed more than one drink [cite: 40]