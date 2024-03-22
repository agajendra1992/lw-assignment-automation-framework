package stepdefinitions;

import com.ui.automationassignment.actions.AddCartPageAction;
import com.ui.automationassignment.actions.HomePageAction;
import com.ui.automationassignment.actions.ProductPageAction;
import com.ui.automationassignment.validations.HomePageValidation;
import com.ui.automationassignment.validations.ProductPageValidation;

import io.cucumber.java8.En;

public class AddCartStepDefinition implements En {

	HomePageAction homePageAction = new HomePageAction();
	ProductPageAction productPageAction = new ProductPageAction();
	AddCartPageAction addCartPageAction = new AddCartPageAction();
	HomePageValidation homePageValidation = new HomePageValidation();
	ProductPageValidation productPageValidation = new ProductPageValidation();

	public AddCartStepDefinition() {

		Given("I Search for an item {string} and clicked on search icon", (String product) -> {
			homePageAction.setProductInSearchBoxAndClicked(product);
		});

		And("verify the product list is displayed", () -> {
			homePageValidation.validateProductsListIsDiplayed();
		});

		When("I Select the {int} item from the product result page", (Integer item) -> {
			homePageAction.clickOnSearchedProduct(item);
		});

		And("I landed on product page and saved the {string}", (String productPrice) -> {
			//productPageValidation.validateProductIsDisplayed();
			productPageAction.saveProductPrice(productPrice);
		});

		And("I add the item to cart by clicking on Add to Cart button", () -> {
			addCartPageAction.clickOnAddToCart();
		});

		And("I landed on open cart page by clicking the top-right cart icon", () -> {
			addCartPageAction.NavigateToOpenCart();
		});
		
		Then("verify the subtotal price on cart page is same as {string}", (String productPrice) -> {
			productPageValidation.validateSubTotalPriceIsMatching(productPrice);
			
		});
		
		Then("verify the subtotal price on the cart page matches the product sum {string}", (String productPrice) -> {
			productPageValidation.validateTwoSumProductIsMatchingSubTotalPrice(productPrice);
			
		});
		
		Then("verify the cart page price is same as {string}", (String productPrice) -> {
			productPageValidation.validateCartPagePriceIsMatching(productPrice);
		});
		
		And("I navgate to home page and verify the home page is displayed", () -> {
			homePageValidation.HomePageIsDisplayed();
		});
		
		And("I cleared the cart and navigate to home page", () -> {
			addCartPageAction.clickOnDeleteProduct();
		}); 

	}
}
