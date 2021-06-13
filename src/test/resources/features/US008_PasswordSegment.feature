Feature: Password segment on Homepage should be editable

  Background: User logs in system
    Given User logs in the system as "<user_type>"


  Scenario Outline: TC_001 The old password should not be used
    When User navigate to Password page
    And User write "<current_password>"
    And User write "<new_password>"
    Then User should not get "<alert>"
    Examples:
      | user_type    | current_password | new_password     | alert             |
      | TestAdmin    | Testadmin47,     | Testadmin47,     | Password changed! |
      | TestCustomer | Testcustomer47,  | Testcustomer47,  | Password changed! |
      | TestManager  | Testmanager47,   | Testmanager47,   | Password changed! |
      | TestEmployee | Testemployee47,  | Testemployeee47, | Password changed! |
