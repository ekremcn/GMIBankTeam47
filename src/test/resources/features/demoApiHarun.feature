
  Feature: Api Presentation
    Scenario: Create a customer on UI and Validate with Api
      Given User is on main page for access
#      And User access to applicant registration page
#      And User provides correct information for registration
#      Then Admin activate to applicant
#      Then Employee create two new account for the customer
#      And Employee integrate account for the customer
      Then Authorized user access the api endpoint for read the customer info "customer_api_endpoint"
      And Validate the customer
# calistirmadan once AdminMainPage gidip userin activet olabilmesi icin editButton locatorunu duzeltmelisin