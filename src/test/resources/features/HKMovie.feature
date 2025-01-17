@HKMovie
Feature: Verify HKMovie app

  Scenario:Verify app launch
    Given user on HKMovie startup page
    When the user clicks the Skip button on the HKMovie startup page
    Then the user should navigate to the select location selection
    When the user clicks the Completed button on the select location selection
    And the user clicks the close button in the prompt box if it exists
    Then the user should navigate to the HKMovie 上映回数順 ▾ page
    And user restart the app


  Scenario Outline:Verify login
    Given user on HKMovie 上映回数順 ▾ page
    When user clicks the my page button
    Then the user should navigate to the HKMovie マイページ page
    And User should see the New Register and Login button displayed on HKMovie my page
    When the user clicks the New Register and Login button on the HKMovie my page
    Then the user should navigate to the HKMovie ログイン page
    When the user enters the <emailAccount> and <password> on the HKMovie login page
    And user clicks the login button on the HKMovie login page
    Then the user logs in successfully and should see user id <userIdNumber> on the HKMovie my page
    And user restart the app
    Examples:
      | emailAccount        | password | userIdNumber |
      | testing@gtomato.com | 123456   | 467398       |
