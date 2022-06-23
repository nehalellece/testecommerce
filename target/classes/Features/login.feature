@account
Feature: user login


  Background: open login tab
    Given user open login Page

  Scenario: guest user could Login with valid credentials.
#    Given user open login Page
    When user enter "test2@mail.com" and "as123sa54"
    And user click on LOG IN Button
    Then browser go to "https://demo.nopcommerce.com/"
    And "My account" tab is displayed

  Scenario: guest user could not Login with invalid credentials
#    Given user open login Page
    When user enter "test2@mail.com" and "as1a54"
    And user click on LOG IN Button
    Then Error Msg Displayed "Login was unsuccessful. Please correct the errors and try again."
    And Error Msg in red color