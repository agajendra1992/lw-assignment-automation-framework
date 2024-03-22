package com.ui.automationassignment.validations;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ui.automationassignment.pom.AddCartPageObjects;
import com.ui.automationassignment.pom.ProductPageObjects;
import com.ui.automationassignment.utils.Constant;

public class ProductPageValidation {
	private static Logger logger = LogManager.getLogger(HomePageValidation.class);
	private ProductPageObjects productPageObjects = new ProductPageObjects();
	private AddCartPageObjects addCartPageObjects = new AddCartPageObjects();
	
	public void validateProductIsDisplayed() {
		assertTrue(productPageObjects.productPageIsDisplayed(), "Product page is not displayed");
	
	}
	
	public void validateSubTotalPriceIsMatching(String productPrice) {
		String actualPrice = addCartPageObjects.getSubTotalPrice();
		DecimalFormat decimalFormat = new DecimalFormat("#,##,###");
		String atualformattedValue = decimalFormat.format(Double.parseDouble(actualPrice.replace(",", "")));
		atualformattedValue = atualformattedValue.replace(",", "");
		String expectedPrice = Constant.getSavedValues(productPrice).replace(",", "");
		assertEquals(atualformattedValue, expectedPrice, "ProductPage Price and SubTotal Price is not matching");
	}	
	
	public void validateTwoSumProductIsMatchingSubTotalPrice(String productPrice) {
		List<String> expectedPriceKey = Arrays.asList(productPrice.split(","));
		double expectecSubTotal = 0;
		for (int i = 0; i < expectedPriceKey.size(); i++) {
			String value = Constant.getSavedValues(expectedPriceKey.get(i)).replace(",", "");
			expectecSubTotal += Double.parseDouble(value);
		}
		double actualSubTotal = Double.valueOf(addCartPageObjects.getSubTotalPrice().replace(",", ""));
		assertEquals(actualSubTotal, expectecSubTotal, "Sum of Two Product Price and SubTotal Price is not matching");

	}	
	
//	public void validateCartPagePriceIsMatching(String productPrice) {
//		String actualPrice  = addCartPageObjects.getCartPagePrice().trim();
//		 DecimalFormat decimalFormat = new DecimalFormat("#,##,###");
//		String atualformattedValue = decimalFormat.format(Double.parseDouble(actualPrice.replace(",","")));
//		atualformattedValue= atualformattedValue.replace(",", "");
//		String expectedPrice = Constant.getSavedValues(productPrice).replace(",", "");
//		assertEquals(atualformattedValue, expectedPrice, "ProductPage Price and Cart Page Price is not matching");
//	}
	
	public void validateCartPagePriceIsMatching(String productPrice) {
		List<String> expectedPriceKeyList = Arrays.asList(productPrice.split(","));
		List<String> actualCartPriceList =  new ArrayList<String>();
		List<String> expectedPriceList = new ArrayList<String>();
		for (int i = 0; i < expectedPriceKeyList.size(); i++) {
			DecimalFormat decimalFormat = new DecimalFormat("#,##,###");
			String atualformattedValue = decimalFormat.format(Double.parseDouble(addCartPageObjects.getCartPriceList().get(i).replace(",","")));
			actualCartPriceList.add(atualformattedValue.replace(",", ""));
			expectedPriceList.add(Constant.getSavedValues(expectedPriceKeyList.get(i)).replace(",", ""));
		}
		assertEquals(actualCartPriceList, expectedPriceList, "ProductPage Price and Cart Page Price is not matching");
//		String actualPrice  = addCartPageObjects.getCartPagePrice().trim();
//		 DecimalFormat decimalFormat = new DecimalFormat("#,##,###");
//		String atualformattedValue = decimalFormat.format(Double.parseDouble(actualPrice.replace(",","")));
//		atualformattedValue= atualformattedValue.replace(",", "");
//		String expectedPrice = Constant.getSavedValues(productPrice).replace(",", "");
//		assertEquals(atualformattedValue, expectedPrice, "ProductPage Price and Cart Page Price is not matching");
	}



}
