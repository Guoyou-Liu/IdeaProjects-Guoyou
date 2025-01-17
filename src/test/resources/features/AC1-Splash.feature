@regression@AC1
Feature: VerifyAppSplash

  Scenario: AppSplash
    Given user on the Storellet introduction page
    When user clicks the close button in the prompt box if exists
    And user scrolls the Storellet introduction page and clicks the close button on the last page
    Then user navigates to the home page and guide appears
    When user skips the home guide on the home page
    Then explore guide appears on the home page
    When user skips the explore guide on the home page
    Then wallet guide appears on the home page
    When user skips the wallet guide on the home page
    Then account guide appears on the home page
    When user skips the account guide on the home page
    Then scanner guide appears on the home page
    When user skips the scanner guide on the home page
    Then notice guide appears on the home page
    When user skips the notice guide on the home page
    Then show home page content
    And user restart the app


