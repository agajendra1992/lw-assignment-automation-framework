Feature: Verifying Products subtotal
 This Scenario is verify the product price and cart subtotal is matching for single and multiple items
  
  Scenario Outline: Adding a "<product_name>" item to the cart and verifying sub total
    Given I Search for an item "<product_name>" and clicked on search icon
    And verify the product list is displayed
    When I Select the <item> item from the product result page
    And I landed on product page and saved the "<price>"
    And I add the item to cart by clicking on Add to Cart button
    And I landed on open cart page by clicking the top-right cart icon
    Then verify the cart page price is same as "<price>"
    And verify the subtotal price on cart page is same as "<price>"

    Examples: 
      | product_name | item | price        |
      | Monitor      |    1 | MonitorPrice |
      | Laptop       |    2 | LaptopPrice  |

  Scenario: Adding a multiple items to the cart and verifying sub total
    Given I Search for an item "Headphone" and clicked on search icon
    And verify the product list is displayed
    When I Select the 1 item from the product result page
    And I landed on product page and saved the "HeadphonePrice"
    And I add the item to cart by clicking on Add to Cart button
    And I landed on open cart page by clicking the top-right cart icon
    And I navgate to home page and verify the home page is displayed
    And I Search for an item "Keyboard" and clicked on search icon
    And verify the product list is displayed
    And I Select the 1 item from the product result page
    And I landed on product page and saved the "KeyboardPrice"
    And I add the item to cart by clicking on Add to Cart button
    And I landed on open cart page by clicking the top-right cart icon
    Then verify the cart page price is same as "KeyboardPrice,HeadphonePrice"
    And verify the subtotal price on the cart page matches the product sum "HeadphonePrice,KeyboardPrice"
