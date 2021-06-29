
Feature: US023 System should allow to read all Applicants using api end point "https://gmibank.com/api/tp-account-registrations"

  Scenario: TC_01 Read All Applicants and Validate
    Given Authorized user goes to api end point "https://gmibank.com/api/tp-account-registrations"
    And Authorized user validate data

    Scenario: TC_02 Created New Applicant and Validate
      And Create a new applicant using to api end point "https://gmibank.com/api/tp-account-registrations"
      And Validate the Created Applicant

