@regression
Feature: category


  Scenario: guest user could select digital category
#   Given user open browser
    When user click on digital category
    Then browser go to page category

  Scenario: guest user could select jewelry category
#   Given user open browser
    When user click on jewelry category
    Then browser go to page category

  Scenario: guest user could select desktop sub category
#   Given user open browser
    When user click on desktop sub category
    Then browser go to page category

  Scenario: guest user could select GiftCard category
#   Given user open browser
    When user click on gift category
    Then browser go to page category

  Scenario: guest user could select subcategory
#   Given user open browser
    When click on sub category
    Then browser go to page category