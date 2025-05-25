Feature: SauceDemo Login and Shopping

  Scenario: User logs in, adds product to cart, and logs out
    Given User is on login page
    When User logs in with valid credentials
    Then User should be redirected to products page
    When User adds a product to the cart
    Then Product should be visible in cart
    