@Sandbox @Test
Feature: test of list

  Scenario: As a Test Engineer, I want to validate thar a text is present inside the list.
    Given I navigate to the list page
    When I search the list
    Then I can find the test in te list