package com.swaglabs.steps;

import com.swaglabs.base.SetUp;
import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.InventoryPage;
import com.swaglabs.utilities.ExcelUitls;
import com.swaglabs.utilities.ReadProperties;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;

public class CartPageSteps {
	
	
	CartPage cartpage;
	InventoryPage inventoryPage;
	InventoryPageSteps inventorypagesteps;

	//validate headers
	@Step("validate headers")
	public void validateHeaders(String header) {
		
		Assert.assertEquals(cartpage.cartpageheader.getText(),header);
		
		
		if (cartpage.cartpageheader.getText().equals(header)) {
			System.out.println("header validation passed");
		}
		else {
			System.out.println("header validation failed");
		}
		
	}
	
//	validate footers
	@Step("validate footers")
	public void valiedateFooters(String footer) {
		
		String expected =  cartpage.cartpagefooter.getText();
		String Actual = footer;
		
		Assert.assertEquals(expected, Actual);
		if(expected.equals(Actual)) {
			System.out.println("footer validation passed");
		}
		else {
			System.out.println("footer validation failed");
		}
		
	}

//	verify continue shopping button is exist
	@Step("verify continue shopping button is exist")
	public void verifyTheContinueShoppingBtn() {
		cartpage.continuebtn.isDisplayed();
		Assert.assertTrue(cartpage.continuebtn.isDisplayed());
	}

	//veify continue checkout button is existt
	@Step("verify continue checkout button is exist")
	public  void verifyTheCheckoutBtn() {
		cartpage.checkoutbtn.isDisplayed();
		Assert.assertTrue(cartpage.checkoutbtn.isDisplayed());
	}

	//verify quantity is exist 
	@Step("verify quantity  is exist")
	public void verifyQunatity() {
		cartpage.qtylabel.isDisplayed();
		Assert.assertTrue(cartpage.qtylabel.isDisplayed());
	}

	//veify desciption is exist
	@Step("verify description  is exist")
	public void verifyDescription() {
		cartpage.descriptiontext.isDisplayed();
		Assert.assertTrue(cartpage.descriptiontext.isDisplayed());
	}
	
	//click continuew shopping button
	@Step("click continues shopping button")
	public void continueShopping() {
		cartpage.continuebtn.click();
	}
	
	//click shopping cart
	@Step("click shopping cart")
	public void clickShoppingCart() {
		cartpage.clickshoppingcart.click();
	}
	
	//test case 8
	@Step("test8_validateUserInterfaceFootersAndHeaders")
	public void test8_validateUserInterfaceFootersAndHeadersInInventoryPage() {
//		readProperties.headerText(),
//		readProperties.footerText()
		ReadProperties readProperties = new ReadProperties();
		inventoryPage.shoppingcart.click();
//		inventorypagesteps.clickShoppingCart();
		 validateHeaders(readProperties.headerText());
		valiedateFooters(readProperties.footerText());
		verifyTheContinueShoppingBtn();
		verifyTheCheckoutBtn();
		verifyQunatity();
		verifyDescription();
		continueShopping();
		
	}
	
	public void clickCheckoutButton() {
		cartpage.checkoutbtn.waitUntilClickable().click();
	}
	
	//remove product from the cart
	@Step("remove product from the cart")
	public void removeProduct() {
	
		cartpage.removefirstProductincart.click();
	}
	

	@Step("test10_tryToRemoveOneProductFromTheCart")
	public void test10_tryToRemoveOneProductFromTheCart() {
		removeProduct();
		SetUp.logger.info("one product removed from the cart");
	}
	
	
	public void addProductToTheExcel(String filepath) {

		cartpage.clickshoppingcart.click();
//		CommonMethods.doClick(clickshoppingcart);
		System.out.println("printingproductdescription");
	 List<WebElementFacade>  firstproductname=	cartpage.allproductincarts;
	 System.out.println("firstproductname"+firstproductname.get(0).getText());
	 System.out.println("firstproductname"+firstproductname.get(1).getText());
	 
	 List<String> productOne = new ArrayList<String>();
	 for (int i = 0; i < firstproductname.size(); i++) {
		 
		 productOne.add(firstproductname.get(i).getText());
		 
	}
	 
	 SetUp.logger.info("product details has been stored in excel sheet");
	 
//	 for (int i = 2; i < productOne.size(); i++) {
//		 if(i%2==0) {
//			 productOne.remove(i);
//		 }
//	 }
//	 
//	 Arrays.asList(productOne);
	 
//	 for(int j=0;j<productOne.size();j++) {
//		 if(j%3==0) {
//			 productOne.remove(j);
//		 }
//	 }
	 
	 ExcelUitls.putValueIntoExcel(filepath, productOne);
	 
	 
	
	}
	
	@Step("test11_StoreProductInExcel")
	public void test11_StoreProductInExcel(String filepath) {
		
		addProductToTheExcel(filepath);
		
		
//		clickShoppingCart();
//		
//		System.out.println("printingproductdescription");
//	 List<WebElementFacade>  firstproductname=	cartpage.allproductincarts;
//	 System.out.println("firstproductname"+firstproductname.get(0).getText());
//	 System.out.println("firstproductname"+firstproductname.get(1).getText());
//	 
//	 List<String> productOne = new ArrayList<String>();
//	 for (int i = 0; i < firstproductname.size(); i++) {
//		 
//		 productOne.add(firstproductname.get(i).getText());
//		 
//	}
//	 
//	 SetUp.logger.info("product details has been stored in excel sheet");
//	 
//	 
//	 ExcelUitls.putValueIntoExcel(filepath, productOne);
	 
	 
	}
	

	
	

}
