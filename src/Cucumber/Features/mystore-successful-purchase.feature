@my-store
Feature: Performing successful/unsuccessful purchase

  Background:
    I have an active account

  @successful-purchase
  Scenario Outline: Successful purchase

    Given I am on the main page
    Then I log into my account with email: <email> and password: <password>
    When I search for the product: <productName>
    And I verify the product: <productName> is displayed on the screen
    Then I navigate to the product page, check if the discount is displayed and equals: <discount>
    And I choose the desired size: <size> and quantity: <quantity>
    Then I verify the material composition of the product: <material>
    And I verify that there are more than <stock> items available in stock
    Then I add the product to the cart
    Then I proceed to checkout
    And verify the price <price> for the <quantity> products matches the total price


    Examples:
      |email               | password| productName                |discount|size |quantity| material| stock| price |
      |corruptedmind@die.net| Modulo | Hummingbird Printed Sweater| 20%     | M   | 5     | Cotton  | 1000 | 28.72 |
#      |rabarbea@whatfor.com| Whatfor| Hummingbird Printed Sweater| 20%     | XL | 20     |         |      |       |                |