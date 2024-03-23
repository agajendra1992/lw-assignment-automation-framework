package stepdefinitions;


import com.ui.automationassignment.actions.AddCartPageAction;
import io.cucumber.java.After;


public class Hooks{

	@After(order = 0)
	public void clearCart() {
		AddCartPageAction addCartPageAction = new AddCartPageAction();
		addCartPageAction.clickOnDeleteProduct();
	}
}
