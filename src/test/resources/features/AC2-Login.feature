@regression@AC2
Feature: Verify login function

  @AC2.1
  Scenario Outline: Login failure
    Given user on the Storellet home page
    When user clicks the close button in the prompt box if exists
    And user clicks the wallet button on the Storellet home page
    Then user should navigate to the login page
    When user clicks the phone number code button on the login page
    Then phone number code selection appears on the login page
    When user select the phone number code <numberCode> on the phone number code selection
    Then phone number code button shows <numberCode> on the login page
    When user input the phone number <number> and password <password> on the login page
    And user clicks the login button on the login page
    Then app prompts that the phone number or password is incorrect
    And user clicks the confirm error button in the error message prompt box
    And user restart the app

    Examples:
      | numberCode | number      | password    |
      | 852        | 99998000    | Testing123  |
      | 853        | 99998001    | Testing111  |
      | 86         | 13495093745 | Testing1234 |

  @AC2.2
  Scenario:Login success
    Given user on the Storellet home page
    When user clicks the close button in the prompt box if exists
    And user clicks the wallet button on the Storellet home page
    Then user should navigate to the login page
    When user clicks the phone number code button on the login page
    Then phone number code selection appears on the login page
    When user select the phone number code 852 on the phone number code selection
    Then phone number code button shows 852 on the login page
    When user input the phone number 99998039 and password Testing!234 on the login page
    And user clicks the login button on the login page
    Then user successfully logs in and goes to the My Wallet page
    When user clicks the my account button on the My Wallet page
    Then account information appear on the My Wallet page
    And account id is displayed on the account information
    And user restart the app

