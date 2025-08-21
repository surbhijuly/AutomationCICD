Feature: Submit Order

  Scenario: Purchase a product successfully
    Given I launch the application
    When I register a user with email "jane@example.com" and password "Secret@123"
    And I login with email "jane@example.com" and password "Secret@123"
    And I add product "ZARA COAT 3" to the cart
    And I checkout and select country "India"
    And I submit the order
    Then I should see the confirmation message "THANKYOU FOR THE ORDER."
    And The product "ZARA COAT 3" should be present in Order History


