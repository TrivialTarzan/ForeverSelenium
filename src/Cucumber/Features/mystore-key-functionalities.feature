@my-store
Feature: Testing key functionalities of the MyStore website

  Background:
    User has already created an account.

  @user-registration
  Scenario Outline: Creating a new address

    Given I'm on the main page
    And I'm logged into my account with email: <email> and password: <password>
    Then Then I verify that the name <full name> is displayed on the screen

    Then I close the browser

    Examples:
      | email                 | password | full name            |
      | rabarbea@whatfor.com  | Whatfor  | Rabarbeata Gibberish |