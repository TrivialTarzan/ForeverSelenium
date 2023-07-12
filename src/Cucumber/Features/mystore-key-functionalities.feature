@my-store
Feature: Testing key functionalities of the MyStore website

  Background:
    User has already created an account.

  @creating-new-address
  Scenario Outline: Creating a new address

    Given I'm on the main page
    And I'm logged into my account with email: <email> and password: <password>
    Then I verify that the name: <full name> is displayed on the screen
    And I navigate to 'Address' tab and click on 'Create new address' button
    When I fill out the form with following credentials: <alias>, <company>, <address>, <city>, <zip code>, <phone>
    And save the changes
    Then I verify if the added address contains the correct credentials


    Then I close the browser

    Examples:
      | email                | password| full name           | alias   | company | address  | city | zip code| phone   |
      | rabarbea@whatfor.com | Whatfor | Rabarbeata Gibberish| Rabarbea| GerTrans| Hoan Kiem| Hanoi| 00120   | +84 666 |