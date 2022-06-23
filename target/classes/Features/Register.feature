@account
Feature: user can Register in the system

  Scenario: guest user could register with valid data successfully

#    Given
  #    user open Browser
#    And
    Given user open Register Page
    When user select Gender
    And user enter valid Data
#    And user enter valid Data
#    And user enter valid last name
#    And user enter birthdate day , month , year
#    And user enter email
#    And user enter Company
#    And user enter password
#    And user enter the same password in confirm password
    And user click on register button
    Then Browser displayes "Your registration completed" Msg
  #    user registeration succefully
#    And
    And "Your registration completed" Msg in Green color
