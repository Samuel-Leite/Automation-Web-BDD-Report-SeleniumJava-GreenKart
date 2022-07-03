Feature: Place the order for products

  @placeOrder
  Scenario Outline: Search experience for products search in home and offers page

    Given user is on GreenKart page
    When user searched with shortname <name> and extracted actual name of product
    And add "3" items of the selected product to cart
    Then user proceeds to checkout and validate the "<name>" items in checkout page
    And verify user has ability to enter promo code and place the order

    Examples:
    | name    |
    | Tom     |
