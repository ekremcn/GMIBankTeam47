@apiUI
  Feature: Api Presentation

    Scenario: Create a customer on UI and Validate with Api
      Given User is on main page for access
      And User access to applicant registration page
      And User provides correct information for registration
      Then Authorized user access the api endpoint for read the customer info "applicantsEndPoint"
      And Validate the customer of applicants endpoint
      Then Admin activate to applicant
      Then Employee create two new account for the customer
      And Employee integrate account for the customer
      Then Authorized user access the api endpoint for read the customer info "customer_api_endpoint"
      And Validate the customer

    Scenario: Read, Create, Update and Delete Countries
      Given User access to api end point
      Then apiUser read all countries from api using "country_api_endpoint"
      And apiUser creates a new country from api using "country_api_endpoint"
      Then apiUser validates that country is created
      And User is on main page for access
      Then User sign in to an Employee Account
      Then apiUser validates that country is created on UI
      And apiUser update created country using api end point "country_api_endpoint"
      Then apiUser validates that country is updated
      Then apiUser validates that country is update on UI
      And apiUser delete created country using api end point "country_api_endpoint"
      Then apiUser validates that country is deleted
      Then apiUser validates that country is delete on UI
# calistirmadan once AdminMainPage gidip userin activet olabilmesi icin editButton locatorunu duzeltmelisin

