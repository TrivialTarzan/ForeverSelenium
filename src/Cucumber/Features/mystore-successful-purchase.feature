@my-store
Feature: Performing successful/unsuccessful purchase

  Background:
    1. I have an active account.
    2. I'm on the main page

  @successful-purchase
  Scenario Outline: Successful purchase

    Given I log into my account with email: <email> and password: <password>
    And I verify that my name: <fullName> is displayed on the screen
    Then I search for the product: <productName>


    And I close the browser

    Examples:
      |email               | password| fullName           | productName                 |discount |size |quantity|
      |corruptedmind@die.net| Modulo | Kristian Vikernes   | Hummingbird Printed Sweater| 20%     | M   | 5      |
#      |rabarbea@whatfor.com| Whatfor | Rabarbeata Gibberish| Hummingbird Printed Sweater| 20%     | M   | 5      |