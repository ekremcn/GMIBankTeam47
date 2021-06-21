Feature:Registration page should restrict password usage to a secure and high level passcode
Background:
  When User is on main page
  Given User clicks on Register button without filling blanks
  Scenario Outline:US003-TC01,TC02,TC03,TC04
  There should be at least 1 uppercase or 1 digit or 1 lowercase or 1 special character
   ,and the level chart changes accordingly

    When User provides "<password>" with six-character
    And The level chart shows only one red bar
    When User enters "<character>"
    Then The level chart changes into two bars
    Examples:
      | password | character |
      | aaaaaa   | A         |
      | aaaaaa   | ?         |
      | aaaaaa   | 1         |

  Scenario Outline:There should be at least 1 lowercase char for stronger password and
  see the level chart change accordingly
    When User provides "<password>" with six-character
    And User enters "<character>"
    Then the level chart changes accordingly
    Examples:
      | password | character |
      | aaaaaa   | A?        |

  Scenario Outline: Thee should be at least 7 characters in a password including all necessary character
    When User provides "<password>" with six-character
    And User enters "<character>"
    Then the level chart shows all bars green
    Examples:
      | password | character |
      | aaaaaa   | A?1       |

