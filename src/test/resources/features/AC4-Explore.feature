@regression@AC4
Feature: Verify explore function

  @AC4.1
  Scenario: Explore view new arrivals restaurants
    Given user on the Storellet home page
    When user clicks the close button in the prompt box if exists
    And user clicks the explore button on the Storellet home page
    Then user should navigate to the explore page
    And user should see the search box displayed on the explore page
    And user should see the 最新上架 displayed on the explore page
    And user should see the 全部餐廳 displayed on the explore page
    When the user scrolls the 最新上架 on the explore page to show the The Wall Street Bar & Lounge restaurant
    And user clicks the The Wall Street Bar & Lounge restaurant on the explore page
    And user clicks the 暫時不用 button on the Email Verification if exists
    And user skips coupons guide on the restaurant details page if exists
    Then user should then navigate to the The Wall Street Bar & Lounge restaurant details page
    And user should see that the membership validity period has not expired
    When the user scrolls down the restaurant details page to display the 查看所有分店 button
    And user clicks the 查看所有分店 button on the restaurant details page
    Then user then navigates to the view all stores page view branches
    When user clicks the Back button on the view all stores page
    Then user should then back to the The Wall Street Bar & Lounge restaurant details page
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
    Then user should navigate to the explore page
    And user restart the app


  @AC4.2
  Scenario Outline:Change email verification
    Given user on the Storellet home page
    When user clicks the close button in the prompt box if exists
    And user clicks the explore button on the Storellet home page
    Then user should navigate to the explore page
    When the user scrolls the 全部餐廳 on the explore page to show the <restaurants> restaurant
    And user clicks the <restaurants> restaurant on the explore page
    And user clicks the 更改電郵 button on the Email Verification if exists
    Then user should navigate to the email change page
    And the update button is disable on the email change page
    When user enters email <email> in the email field
    Then the update button is enable on the email change page
    When user clicks the update button on the email change page
    Then the user should see the 電郵已發送 prompt box appear
    When user clicks the 完成 button on the prompt box
    And user skips coupons guide on the restaurant details page if exists
    Then user should then navigate to the <restaurants> restaurant details page
    And user restart the app

    Examples:
      | email                | restaurants           |
      | testing1@gtomato.com | Plato Cafe Bistro     |
      | testing2@gtomato.com | The Farmhouse Deli 餅店 |


  @AC4.3
  Scenario:Complete restaurants Email Verification
    Given user on the Storellet home page
    When user clicks the close button in the prompt box if exists
    And user clicks the explore button on the Storellet home page
    Then user should navigate to the explore page
    When user clicks the search box on the explore page
    And user enters MR in the search box
    Then user should see the MR.MAKI on the search result
    When user clicks the search result on the explore page
    And user clicks the 發送驗證 button on the Email Verification if exists
    Then the user should see the 電郵已發送 prompt box appear
    When user clicks the 完成 button on the prompt box
    And user skips coupons guide on the restaurant details page if exists
    Then user should then navigate to the MR.MAKI restaurant details page
    And user should see that the membership validity period has not expired
    When user clicks the back button on the restaurant details page
    Then user should navigate to the search page and search box displayed
    And the search content MR in the search box will still be displayed
    And user should see the MR.MAKI on the search result
    When user clicks clear button on the search box
    Then the search content in the search box will be cleared
    And user restart the app

  @AC4.4
  Scenario: Verify to join the membership
    Given user on the Storellet home page
    When user clicks the close button in the prompt box if exists
    And user clicks the explore button on the Storellet home page
    Then user should navigate to the explore page
    When the user scrolls the 全部餐廳 on the explore page to show the 成為會員 restaurant
    And user clicks the 成為會員 button the explore page
    Then user should navigate to the restaurant details page
    When user clicks the 成為會員 button on the restaurant details page
    Then user should see membership details displayed on the restaurant page
    And user should see the agree button is disabled on the membership details
    When user clicks the disagree button on the membership details
    Then user back to restaurant page and 成為會員 is displayed
    When user clicks the 成為會員 button on the restaurant details page
    And the user scrolls to view the member details until the bottom
    Then user should see the agree button is enabled on the membership details
    When user clicks the agree button on the membership details
    Then user back to restaurant page and 會籍有效期 is displayed
    And user restart the app







