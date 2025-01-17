@regression@AC3
Feature: Verify Home function

  @AC3.1
  Scenario: View popular restaurants
    Given user on the Storellet home page
    When user clicks the close button in the prompt box if exists
    And user scrolls the home page to view Causeway Bay popular recommendations
    And user clicks the Causeway Bay popular recommendations on the Storellet home page
    Then user should navigate to the Causeway Bay page
    And user should see the $25 現金券 displayed in the popular restaurant recommendations in Causeway Bay
    When user clicks on the $25 現金券 in the popular restaurant recommendation in Causeway Bay
    And user skips coupons guide on the restaurant details page if exists
    Then user should then navigate to the Patisserie Tony Wong restaurant details page
    And user should see that the membership validity period has not expired
    And user should see the 概要 selection displayed on the restaurant details page
    And user should see the 概要 selection is selected on the restaurant details page
    And user should see the 我的錢包 selection displayed on the restaurant details page
    And user should see the 我的錢包 selection is not selected on the restaurant details page
    And user should see the 可兌換 selection displayed on the restaurant details page
    And user should see the 可兌換 selection is not selected on the restaurant details page
    When user clicks the 條款與細則 button on the restaurant details page
    Then user should see the rules details prompt box appear on the restaurant details page
    When user clicks the confirm button on the rules details prompt box
    Then user should then navigate to the Patisserie Tony Wong restaurant details page
    When the user scrolls down the restaurant details page to display the 最新消息 button
    Then user should see the 最新消息 button is turned on
    When user clicks the 最新消息 button on the restaurant details page
    Then user should see the 最新消息 button is off
    When user clicks the 查看所有分店 button on the restaurant details page
    Then user then navigates to the view all stores page view branches
    When user clicks the Back button on the view all stores page
    Then user should then back to the Patisserie Tony Wong restaurant details page
    When user clicks the 最新消息 button on the restaurant details page
    Then user should see the 最新消息 button is turned on
    When user clicks the 我的錢包 on the restaurant page
    Then user should the navigates to the 我的錢包 selection
    And user should see the 我的錢包 selection is selected on the restaurant details page
    And user should see the 概要 selection is not selected on the restaurant details page
    When user on the restaurant 我的錢包 selection page
    Then user should see the restaurant already redeemed coupons on the 我的錢包 selection page
    When user clicks the 可兌換 on the restaurant page
    And user skips coupons guide on the restaurant details page if exists
    Then user should the navigates to the 可兌換 selection
    And user should see the 可兌換 selection is selected on the restaurant details page
    And user should see the 我的錢包 selection is not selected on the restaurant details page
    When user on the restaurant 可兌換 selection page
    Then user should see the restaurant unredeemed coupons on the 可兌換 selection page
    When user scrolls the restaurant page to clicks the back button
    Then user should navigate to the Causeway Bay page
    When user clicks the close button on the Causeway Bay page
    Then users should return to the home page Causeway Bay Hot Recommendations section
    And user restart the app

  @AC3.2
  Scenario: Search for restaurants on the home page
    Given user on the Storellet home page
    When user clicks the close button in the prompt box if exists
    And user clicks the search button on the Storellet home page
    Then user should navigate to the search page and search box displayed
    When user clicks the search box on the search page
    And user enters rico in the search box
    Then user should see the Rico Rico on the search result
    When user clicks the search result on the search page
    And user skips coupons guide on the restaurant details page if exists
    Then user should then navigate to the Rico Rico restaurant details page
    And user should see that the membership validity period has not expired
    When user clicks the back button on the restaurant details page
    Then user should navigate to the search page and search box displayed
    And the search content rico in the search box will still be displayed
    And user should see the Rico Rico on the search result
    When user clicks clear button on the search box
    Then the search content in the search box will be cleared
    And user restart the app






