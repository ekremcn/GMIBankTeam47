@US002
Feature:US002 System should not allow anyone to register with invalid credentials

  Background: User navigates to register page of gmi bank application
    Given User on the registration page


  Scenario: TC_001 Any blank field on the registration page should give the error
    When User clicks on Register button without filling blanks
    Then User should see all error message


  Scenario:TC_002 Any field on the registration page should not be left blank
    When User fill in the blanks with valid credentials
    Then User should not see any feedback error

  Scenario Outline: TC_003, TC_004, TC_005 Mobile phone number cannot be of any chars nor spec chars except "-"
    When User fill in the Mobile Phone Number textbox with "<invalid_mpns>"
    Then User should see the Mobile Phone Number error feedback message
    Examples:Invalid mobile phone numbers
      | invalid_mpns   |
      | (1)345-54-3478 |
      | 865.12.887     |
      | 643 22 6754    |

  Scenario Outline: TC_006, TC_007, TC_008, TC_009, TC_010, TC_011, TC_012 Email cannot be created without "@" sign and "." extensions
    When User fill in the E-Mail textbox with "<invalid_mails>"
    Then User should see the E-Mail error feedback message
    Examples:Invalid mobile phone numbers
      | invalid_mails       |
      | 1@mailcom           |
      | 2@mailcom.          |
      | 3.mail@com          |
      | 4@.mailcom          |
      | @mail.com           |
      | 5@mail.com@mail.com |
      | 6 @mail.com         |

  Scenario Outline: TC_013, TC_014, TC_015, TC_016, TC_017 SSN number cannot be of any chars nor spec chars except "-"
    When User fill in the SSN textbox with "<invalid_ssns>"
    Then User should see the SSN error feedback message
    Examples:Invalid mobile phone numbers
      | invalid_ssns |
      | 111 22 3333  |
      | 000.11.1234  |
      | 999-34-5476  |
      | 342,76,1368  |
      | 000-42-8463  |
