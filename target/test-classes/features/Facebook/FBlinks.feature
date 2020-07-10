Feature: Login feature


  Scenario: Verify Terms link takes goes to correct web page
    Given I am on facebook landing page
    When I click on Terms link
    Then I verify user is on 'Terms of Service' page title
    And I verify facebook landing page is open
    And I close all facebook window

  Scenario: Verify Data Policy link takes goes to correct web page
    Given I am on facebook landing page
    When I click on Data Policy link
    Then I verify user is on 'Data Policy' page title
    And I verify facebook landing page is open
    And I close all facebook window

  Scenario: Verify Cookie Policy link takes goes to correct web page
    Given I am on facebook landing page
    When I click on Cookie Policy link
    Then I verify user is on 'Cookies Policy' page title
    And I verify facebook landing page is open
    And I close all facebook window