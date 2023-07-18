@my-store
Feature: Performing successful/unsuccessful purchase

  Background:
    1. I have an active account.
    2. I'm on the main page

  @successful-purchase
  Scenario Outline: Successful purchase

    Given I am on the main page
    Then I log into my account with email: <email> and password: <password>
    And I search for the product: <productName>
    And I verify the product: <productName> is displayed on the screen
    Then I navigate to the product page, check if the discount is displayed and equals: <discount>
    And I choose the desired size: <size> and quantity: <quantity>
    Then I check if the material composition of the product is: <material>
    And I verify that there are more than <stock> items available in stock



    And I close the browser

    Examples:
      |email               | password| productName                |discount|size |quantity| material| stock|
      |corruptedmind@die.net| Modulo | Hummingbird Printed Sweater| 20%     | M   | 5     | cotton  | 1000 |
#      |rabarbea@whatfor.com| Whatfor| Hummingbird Printed Sweater| 20%     | XL | 20     |         |  |