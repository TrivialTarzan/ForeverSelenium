@my-store
Feature: Adding and deleting an address from the account

  Background:
    1. I have an active account.
    2. I have one address already added to my account.

  @add-and-delete-address
  Scenario Outline: Adding and deleting a new address

    Given I'm on the main page
    And I'm logged into my account with email: <email> and password: <password>
    Then I verify that the name: <full name> is displayed on the screen
    And I navigate to 'Address' tab and click on 'Create new address' button
    When I fill out the form with following credentials: <alias>, <company>, <address>, <city>, <zip code>, <phone>
    And save the changes
    Then I verify if the added address contains the correct credentials: <alias>, <company>, <address>, <city>, <zip code>, <phone>
    Then I delete the address and verify it was successfully deleted

    Examples:
      | email                | password| full name           | alias   | company | address     | city  | zip code| phone      |
      | rabarbea@whatfor.com | Whatfor | Rabarbeata Gibberish| Rabarbea| GerTrans| Hoan Kiem   | Hanoi | 00120   | +84 666    |
      | corruptedmind@die.net| Modulo  | Kristian Vikernes   | Varg    | Burzum  | Hordaland 51| Bergen| 5003    | +47 265 356|