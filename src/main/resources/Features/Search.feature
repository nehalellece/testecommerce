@regression
Feature: search

  Scenario: user can search by name with result
    Given user click in  search field
    When user write "Apple" to search
    And user click search button
    Then current URl changed
    And list of results appear

  Scenario: user can search by name no result
    Given user click in  search field
    When user write "Nehal" to search
    And user click search button
    Then current URl changed
    And result list size equal zero
    And message no_result appear

  Scenario: user can search by serial with result
    Given user click in  search field
    When user write "AP_MBP_13" to search
    And user click search button
    Then current URl changed
    And list of results appear

  Scenario: user can search by serial without result
    Given user click in  search field
    When user write "AP_MBP_13" to search
    And user click search button
    Then current URl changed
    And result list size equal zero
    And list of results appear
