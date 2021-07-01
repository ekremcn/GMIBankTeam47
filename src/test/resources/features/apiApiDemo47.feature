@apiApi
Feature: Api Demo 47

  Background:Api country Token
    Given User access to api end point

  Scenario: Read all countries
    Then apiUser read all countries from api using "country_api_endpoint"
    And apiUser creates a new country from api using "country_api_endpoint"
    Then apiUser validates that country is created
    And apiUser update created country using api end point "country_api_endpoint"
    Then apiUser validates that country is updated
    And apiUser delete created country using api end point "country_api_endpoint"
    Then apiUser validates that country is deleted
