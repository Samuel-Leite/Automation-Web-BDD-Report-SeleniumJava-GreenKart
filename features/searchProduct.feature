Feature: Search and place the order for products

  @offersPage
  Scenario Outline: Search experience for products search in home and offers page

    Given user is on GreenKart page
    When user searched with shortname <name> and extracted actual name of product
    Then user searched for <name> shortname in offers page to check if product exist
    And validate product name in offer page matches with landing page

    Examples:
    | name    |
    | Tom     |
    | Beet     |
