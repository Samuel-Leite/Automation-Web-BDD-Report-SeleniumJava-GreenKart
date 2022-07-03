Feature: Search and Order items successfully

  @orderItems
  Scenario Outline: Search the products on the homepage and place the product order successfully

    Given user is on GreenKart page
    When user searches "<productOne>" and adds "3" from product to cart
    And user searches "<productTwo>" and adds "6" from product to cart
    And user checkout products "<productOne> <productTwo>" and check if user can enter promo code and order products
    Then order of the products and validate the order message successfully

    Examples:
    | productOne    | productTwo     |
    | Strawberry    | Grapes         |
    | Potato        | Apple          |
