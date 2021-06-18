Feature: US001 System should allow any user to register with valid credentials validating the success message

  Background: User navigates to Registration page of GMI bank application
    Given User goes to the Homepage
    And User navigates to registration page

  Scenario: User should register to the GMI Bank Application successfully mit valid inputs
    When User clicks on SSN textbox and provide a valid SSN
    Then User should not see the error message

