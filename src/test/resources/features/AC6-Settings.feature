@regression@AC6

Feature:VerifyAccountSetting
  @AC6.1
  Scenario: Settings page
    Given user on the Storellet home page
    When user clicks the close button in the prompt box if exists
    And user clicks the my account button on the Storellet home page
    Then account information appear on the home page
    And setting button is displayed on the account information
    When user clicks the setting button on the account information
    Then user should navigate to the settings page
    And push notification are displayed on the settings page
    And push notification checkbox is not checked on the settings page
    And account management entry are displayed on the settings page
    And update information entry are displayed on the settings page
    And change password entry are displayed on the settings page
    And logout button are displayed on the settings page
    And language setting entry are displayed on the settings page
    And language setting entry displayed is traditional chinese on the settings page
    And contact us entry are displayed on the settings page
    And about button are displayed on the settings page
    And re-enable guide button are displayed on the settings page
    And user restart the app

  @AC6.2
  Scenario Outline: Verify push notifications checkbox are on or off and language setting
    Given user on the Storellet home page
    When user clicks the close button in the prompt box if exists
    And user clicks the my account button on the Storellet home page
    Then account information appear on the home page
    And setting button is displayed on the account information
    When user clicks the setting button on the account information
    Then user should navigate to the settings page
    When user clicks the push notification checkbox on the settings page
    Then push notification checkbox is <checkbox> on the settings page
    When user clicks the language setting button on the settings page
    Then language selections appears on the settings page
    And <beforeSetting> option is displayed on the language selections
    And <afterSetting> option is displayed on the language selections
    And <beforeSetting> option is selected on the language selections
    And <afterSetting> option is not selected on the language selections
    When user clicks the cancel button on the language selections
    Then user should navigate to the settings page
    And language setting entry displayed is <beforeSetting> on the settings page
    When user clicks the language setting button on the settings page
    And user select the <afterSetting> option on the language selections
    Then <afterSetting> option is selected on the language selections
    And <beforeSetting> option is not selected on the language selections
    When user clicks the confirm button on the language selections
    Then user should navigate to the home page
    And app is displayed <afterSetting> language
    When user clicks the my account button on the Storellet home page
    Then account information appear on the home page
    When user clicks the setting button on the account information
    And user should navigate to the settings page
    Then language setting entry displayed is <afterSetting> on the settings page
    And user restart the app

    Examples:
      | beforeSetting       | afterSetting        | checkbox    |
      | traditional chinese | english             | checked     |
      | english             | traditional chinese | not checked |

  @AC6.3
  Scenario: Verify logout function
    Given user on the Storellet home page
    When user clicks the close button in the prompt box if exists
    And user clicks the my account button on the Storellet home page
    Then account information appear on the home page
    And setting button is displayed on the account information
    When user clicks the setting button on the account information
    Then user should navigate to the settings page
    When user clicks the logout button on the settings page
    Then user should see the logout prompt box displayed on the settings page
    When user clicks the cancel button on the logout prompt box
    Then user should navigate to the settings page
    When user clicks the logout button on the settings page
    And user clicks the logout button on the logout prompt box
    Then user should navigate to the home page
    When user clicks the my account button on the Storellet home page
    Then user should navigate to the login page
    And user restart the app


