Feature: Bar with structured domain
  As clients of the bar
  I want the bar to manage entry, orders, and bills with objects

  Scenario: Enter and order cocktails
    Given the bar is open and has room for 2
    When Mr. Pignon and Mr. Leblanc enter
    And they both order a cocktail of the month at 10 euros
    Then the total revenue should be 20 euros