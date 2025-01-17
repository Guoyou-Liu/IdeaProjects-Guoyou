@regression@AC5
Feature: Verify wallet function

  @AC5.1
  Scenario Outline: Verify the redemption coupon
    Given user on the Storellet home page
    When user clicks the close button in the prompt box if exists
    And user clicks the wallet button on the Storellet home page
    Then user should navigate to the my wallet page
    When user clicks the show all button on the my wallet page
    And user scrolls my wallet page and clicks <restaurants> restaurant
    And user clicks the 暫時不用 button on the Email Verification if exists
    Then user should then navigate to the <restaurants> restaurant details page
    When user clicks the 可兌換 on the restaurant page
    And user skips coupons guide on the restaurant details page if exists
    Then user should the navigates to the 可兌換 selection
    And user should see the restaurant unredeemed coupons on the 可兌換 selection page
    When user clicks the restaurant unredeemed coupons on the 可兌換 selection page
    Then user should see coupons details displayed on the restaurant page
    When user clicks the 兌換 button on the coupons details page
    Then users should see a "你沒有足夠的積分兌換此項目" prompt box on the coupon details page
    When user clicks the confirm button on the prompt box
    And user clicks the close button on the coupons details page
    Then user should then navigate to the <restaurants> restaurant details page
    And user restart the app
    Examples:
      | restaurants   |  |
      | SKY BIG GROUP |  |
      | 亞泰            |  |

  @AC5.2
  Scenario Outline:Verify coupon expiration date
    Given user on the Storellet home page
    When user clicks the close button in the prompt box if exists
    And user clicks the wallet button on the Storellet home page
    Then user should navigate to the my wallet page
    When the user scrolls the my wallet page to display the <restaurants> restaurant coupon
    And user clicks the <restaurants> restaurant on the my wallet page
    Then user should then navigate to the <restaurants> restaurant details page
    When user clicks the 我的錢包 on the restaurant page
    Then user should see the restaurant already redeemed coupons on the 我的錢包 selection page
    And user should see the coupon and coupon expiry date on the 我的錢包 selection page
    When user clicks the coupon on the 我的錢包 selection page
    Then user should navigate to the coupon detail page
    And user should see the coupon validity period on the coupon details page
    And the number of days in the coupon expiry date should be the same as the number of days in the my wallet page coupon expiry date
    When user clicks the close button on the coupon detail page
    Then user should then navigate to the <restaurants> restaurant details page
    When user clicks the back button on the restaurant details page
    Then user should back to the my wallet page and display the <restaurants> restaurant coupon
    When the user clicks the coupon in the <restaurants> restaurant section to view the coupons
    Then user should navigate to the coupon detail page
    And user should see the coupon validity period on the coupon details page
    And the number of days in the coupon expiry date should be the same as the number of days in the my wallet page coupon expiry date
    When user clicks the close button on the coupon detail page
    Then user should back to the my wallet page and display the <restaurants> restaurant coupon
    And user restart the app

    Examples:
      | restaurants |  |
      | 翠華餐廳        |  |
      | 牛牛日式火鍋放題    |  |

  @AC5.3
  Scenario: Verify image
      Given user on the Storellet home page
      When user clicks the close button in the prompt box if exists
      And user clicks the wallet button on the Storellet home page
      Then user should navigate to the my wallet page
      When user views 4口 restaurant images and saves them
      Then 4口 restaurant images are not empty
      And the user should see the same image of the 4口 restaurant as the saved image
      And the user should see that the image of the Monkey Cafe restaurant is inconsistent with the image of the save 4口 restaurant
      And user restart the app


