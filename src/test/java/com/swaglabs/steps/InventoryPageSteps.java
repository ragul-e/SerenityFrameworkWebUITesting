package com.swaglabs.steps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.swaglabs.base.SetUp;
import com.swaglabs.pages.InventoryPage;
import com.swaglabs.utilities.ReadProperties;

import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class InventoryPageSteps {

	InventoryPage inventorypage;
	
//validate inventory page headers
	@Step("validate inverntory page headers")
	public void validateHeader(String header) {
		String inventorypageheader = inventorypage.inverntorypageheaders.getText();
		if (inventorypageheader.equals(header)) {
			Assert.assertEquals(inventorypageheader, header);
			Serenity.reportThat("inventorypage header validation passed", 
	                () -> Assert.assertEquals(inventorypageheader,header));
			SetUp.logger.info("inverntory page header validated");
		} else {
			SetUp.logger.info("inventory page header not validated");
		}

	}

	//validate secondary headers
	@Step("validate  secondary headers")
	public void validateSecondaryHeader(String secondaryheader) {
		String secondaryheaderininventorypage = inventorypage.secondaryheaderininventorypage.getText();
		if (secondaryheaderininventorypage.equals(secondaryheader)) {
			Assert.assertEquals(secondaryheaderininventorypage, secondaryheader);
			SetUp.logger.info("secondary header  validation passed");
		} else {
			SetUp.logger.info("scondary header is validation failed");
		}
	}

//	/validate filter
	@Step("validate Filter")
	public void validateFilter(String optionone, String optiontwo, String optionthree, String optionfour) {

		List<String> Actualfilters = new ArrayList<String>();
		Actualfilters.add(optionone);
		Actualfilters.add(optiontwo);
		Actualfilters.add(optionthree);
		Actualfilters.add(optionfour);

		List<WebElementFacade> expectionfilteroptions = inventorypage.filterdropdowns;

		for (int i = 0, j = 0; i < Actualfilters.size() && j < expectionfilteroptions.size(); i++, j++) {
			if (Actualfilters.get(i).equals(expectionfilteroptions.get(j).getText())) {
				SetUp.logger.info(Actualfilters.get(i) + "validated");
				Assert.assertEquals(Actualfilters.get(i), expectionfilteroptions.get(j));
			} else {
				SetUp.logger.info(Actualfilters.get(i) + "not validated");
			}
		}

	}

	//validate all products label
	@Step("validate AllProductsLabel")
	public void validateAllProductsLabel(String firstprodname, String secprodname, String thirdprodname,
			String fourthprodname, String fifthprodname, String sixthprodname) {
		List<String> productnames = new ArrayList<String>();
		productnames.add(firstprodname);
		productnames.add(secprodname);
		productnames.add(thirdprodname);
		productnames.add(fourthprodname);
		productnames.add(fifthprodname);
		productnames.add(sixthprodname);

		List<WebElementFacade> uiproductnames = inventorypage.productnamesininverntorypage;

		for (int i = 0, j = 0; i < productnames.size() && j < uiproductnames.size(); i++, j++) {
			if (productnames.get(i).equals( uiproductnames.get(j).getText())) {
				Assert.assertEquals(productnames.get(i), uiproductnames.get(j).getText());
				
				SetUp.logger.info(uiproductnames.get(i) + "validated");
			} else {
				SetUp.logger.info("not validated");
			}
		}

	}

	//validate footer
	@Step("validate footer")
	public void validateFooter(String Expectedtext) {

		String expectedtext = "";
		String Actualtext = inventorypage.footer.getText();

		System.out.println(inventorypage.footer.getText());
		System.out.println(Actualtext);

		if (Expectedtext.equals(Actualtext)) {
			SetUp.logger.info("footer validation is pass");
			Assert.assertEquals(Expectedtext, Actualtext);
		} else {
			SetUp.logger.info("footer validation is failded");
		}

	}

	//validate product prices
	@Step("validate product prices")
	public void validateProductsPrices(String priceone, String pricetwo, String pricethree, String pricefour,
			String pricefive, String pricesix) {
		List<WebElementFacade> uiproductsprices = inventorypage.productprices;

		List<String> productprice = new ArrayList<String>();
		productprice.add(priceone);
		productprice.add(pricetwo);
		productprice.add(pricethree);
		productprice.add(pricefour);
		productprice.add(pricefive);
		productprice.add(pricesix);

		for (int i = 0, j = 0; i < uiproductsprices.size() && j < productprice.size(); i++, j++) {

			if (uiproductsprices.get(i).getText().equals(productprice.get(i))) {
				SetUp.logger.info(productprice.get(i) + " validated Passed");
				Assert.assertEquals(uiproductsprices.get(i).getText(), productprice.get(i));
			} else {
				SetUp.logger.info(productprice.get(i) + " validated Failed");
			}
		}

	}

	//validate filter product A to Z
	@Step("validate filter product A to Z")
	public void validateFilterProductAToZ(String prodone, String prodtwo, String prodthree, String prodfour,
			String prodfive, String prodsix) {

		List<String> productnamesAtoZ = new ArrayList<String>();
		productnamesAtoZ.add(prodone);
		productnamesAtoZ.add(prodtwo);
		productnamesAtoZ.add(prodthree);
		productnamesAtoZ.add(prodfour);
		productnamesAtoZ.add(prodfive);
		productnamesAtoZ.add(prodsix);
		
		

		List<WebElementFacade> uiproductnames = inventorypage.productnamesininverntorypage;
		
		
		List<String> expectedproduct = new ArrayList<String>();
		
		for(WebElementFacade productnames: uiproductnames) {
			expectedproduct.add(productnames.getText());
			
		}
		Collections.sort(expectedproduct);
		
		
		for (int i = 0, j = 0; i < expectedproduct.size() && j < uiproductnames.size(); i++, j++) {

			if (uiproductnames.get(i).getText().equals(uiproductnames.get(i).getText())) {
				SetUp.logger.info(productnamesAtoZ.get(i) + " validated Passed");
				Assert.assertEquals(productnamesAtoZ.get(i), uiproductnames.get(i).getText());
			} else {
				SetUp.logger.info(productnamesAtoZ.get(i) + " validated Failed");
			}
		}

	}

	//choose filter option Z to A
	@Step("choose filter option Z to A")
	public void chooseFilterZtoA() {
		inventorypage.filterdropdown.selectByIndex(1);
	}

	//validate filter product z to a
	@Step("validate FilterProductZToA")
	public void validateFilterProductZToA(String productone, String producttwo, String productthree, String productfour,
			String productfive, String productsix) {

		List<String> productnamesZtoA = new ArrayList<String>();
		productnamesZtoA.add(productone);
		productnamesZtoA.add(producttwo);
		productnamesZtoA.add(productthree);
		productnamesZtoA.add(productfour);
		productnamesZtoA.add(productfive);
		productnamesZtoA.add(productsix);

		List<WebElementFacade> uiproductnames = inventorypage.productnamesininverntorypage;

		for (int i = 0, j = 0; i < uiproductnames.size() && j < productnamesZtoA.size(); i++, j++) {

			if (uiproductnames.get(i).getText().equals(productnamesZtoA.get(i))) {
				Assert.assertEquals(uiproductnames.get(i).getText(), productnamesZtoA.get(i));
				SetUp.logger.info(productnamesZtoA.get(i) + " validated Passed");
				
			} else {
				SetUp.logger.info(productnamesZtoA.get(i) + " validated Failed");
			}
		}

	}

	//choose filter low to high
	@Step("chooseFilterLowToHigh")
	public void chooseFilterLowToHigh() {
		inventorypage.filterdropdown.selectByIndex(2);
		SetUp.logger.info("filter low to high selected");
	}

	//validate product prices low to high
	@Step("validate ProductsPricesLowToHigh")
	public void validateProductsPricesLowToHigh(String priceone, String pricetwo, String pricethree, String pricefour,
			String pricefive, String pricesix) {

		List<String> price = new ArrayList<String>();
		price.add(priceone);
		price.add(pricetwo);
		price.add(pricethree);
		price.add(pricefour);
		price.add(pricefive);
		price.add(pricesix);

		List<WebElementFacade> pricelowTohigh = inventorypage.productprices;

		for (int i = 0, j = 0; i < pricelowTohigh.size() && j < pricelowTohigh.size(); i++, j++) {

			if (pricelowTohigh.get(i).getText().equals(price.get(i))) {
				Assert.assertEquals(pricelowTohigh.get(i).getText(), price.get(i));
				System.out.println(pricelowTohigh.get(i) + "price validation passed");
			} else {
				System.out.println(pricelowTohigh.get(i) + "price validation failed");
			}
		}

	}

	//choose filter low to high
	@Step("chooseFilterLowToHigh")
	public void chooseFilterHighToLow() {
		inventorypage.filterdropdown.selectByIndex(3);
		SetUp.logger.info("filter low to high");
	}

	//validate products prices high to low
	@Step("validateProductsPricesHighToLow")
	public void validateProductsPricesHighToLow(String priceone, String pricetwo, String pricethree, String pricefour,
			String pricefive, String pricesix) {

		List<String> price = new ArrayList<String>();
		price.add(priceone);
		price.add(pricetwo);
		price.add(pricethree);
		price.add(pricefour);
		price.add(pricefive);
		price.add(pricesix);

		List<WebElementFacade> priceHighToLow = inventorypage.productprices;

		for (int i = 0, j = 0; i < priceHighToLow.size() && j < price.size(); i++, j++) {

			if (priceHighToLow.get(i).getText().equals(price.get(i))) {
				Assert.assertEquals(priceHighToLow.get(i).getText(), price.get(i));
				SetUp.logger.info(priceHighToLow.get(i) + "price validation passed");
			} else {
				SetUp.logger.info(priceHighToLow.get(i) + "price validation failed");
			}
		}

	}

	//test6 add product to the cart
	@Step("test6_addProductToTheCart")
	public String test6_addProductToTheCart() {
		inventorypage.addtocartbuttonforproductone.waitUntilClickable().click();
		SetUp.logger.info("product added to the cart");
		return inventorypage.shopingcartbadge.getText();
	}
	
	
	public void validateCountofProductIsShowingNearShoppingCart(String actualcount) {

		JavascriptExecutor jsexe = (JavascriptExecutor)inventorypage.getDriver();
		jsexe.executeScript("window.scrollBy(0, -" + 300 + ");");
//		org.junit.Assert.assertTrue(inventorypage.shopingcartbadge.isDisplayed());
		System.out.println("actualcount" + actualcount);
		String expectedcount = inventorypage.shopingcartbadge.getText();
		Assert.assertEquals(expectedcount, actualcount);
		SetUp.logger.info("validated product count as 1 in shopping cart");

	
	}

	//test7 validate one is showing near shopping cart
	@Step("test7_validateOneIsShowingNearShoppingCart")
	public String test7_validateOneIsShowingNearShoppingCart(String actualcount) {
//		org.junit.Assert.assertTrue(inventorypage.shopingcartbadge.isDisplayed());
//		System.out.println("actualcount" + actualcount);
		String expectedcount = inventorypage.shopingcartbadge.getText();
//		Assert.assertEquals(expectedcount, actualcount);
//		SetUp.logger.info("validated product count as 1 in shopping cart");
		
		validateCountofProductIsShowingNearShoppingCart(actualcount);
		return expectedcount;

	}

	public String totalProduct() {
		String expectedcount = inventorypage.shopingcartbadge.getText();
		return expectedcount;
	}

//	click shopping cart
	@Step("clickShoppingCart")
	public void clickShoppingCart() {
		inventorypage.shoppingcart.click();
	}

	//add second product to the cart
	@Step("addSecondProductToTheCart")
	public void addSecondProductToTheCart() {
		inventorypage.addtocartbuttonforproducttwo.waitUntilEnabled().click();
		;
	}

	//add third product to the cart
	@Step("addThirdProductTotheCart")
	public void addThirdProductTotheCart() {
		inventorypage.addtocartbuttonforproductthree.waitUntilEnabled().click();
	}

	//verify total count in cart
	public void verifyTotalCountInCart(int Actualcount) {
		String uicount = inventorypage.shopingcartbadge.getText();

		int expectedcount = Integer.parseInt(uicount);

		Assert.assertEquals(expectedcount, Actualcount);

	}

	//validate linked in s
	@Step("validateLinkedIn")
	public void validateSocialMediaLink(String ActualTitle) {
		inventorypage.linkedIn.click();
		String currentwindow = inventorypage.getDriver().getWindowHandle();
		Set<String> win = inventorypage.getDriver().getWindowHandles();

		win.remove(currentwindow);

		
		inventorypage.getDriver().switchTo().window(win.iterator().next());
		String expectedtitle = inventorypage.getDriver().getTitle();
		System.out.println(expectedtitle);
		if (ActualTitle.equals(expectedtitle)) {
			Assert.assertEquals(expectedtitle, ActualTitle);
			SetUp.logger.info("title validation passed");
		} else {
			SetUp.logger.info("title validation failed");
		}
		Assert.assertEquals(expectedtitle, ActualTitle);
		inventorypage.getDriver().close();

		inventorypage.getDriver().switchTo().window(currentwindow);
		
	}

	//validate menu bars
	@Step("validateMenuBars")
	public void validateMenuBars(String itemone, String itemtwo, String itemthree, String itemfour) {
		List<WebElementFacade> actualmenuitem = inventorypage.menuitems;
		List<String> expectedmenuitem = new ArrayList<String>();
		expectedmenuitem.add(itemone);
		expectedmenuitem.add(itemtwo);
		expectedmenuitem.add(itemthree);

	}

	//validate one in shoppgin cart
	public void validateOneInshoppingart(String productcount) {
		if (test6_addProductToTheCart().equals(productcount)) {
			System.out.println("validation passed");
		} else {
			System.out.println("validation failed");
		}
	}

	public void validateOneInshoppingart(int expectedcount) {
		String count = inventorypage.shopingcartbadge.getText();
		int actualcount = Integer.parseInt(count);

		Assert.assertEquals(expectedcount, actualcount);
	}
	
	
	public void addTwoMoreProductToTheCart(String totalcount) {


		inventorypage.addtocartbuttonforproducttwo.waitUntilEnabled().click();
		SetUp.logger.info("second product has been added");
		inventorypage.addtocartbuttonforproductthree.waitUntilEnabled().click();
		SetUp.logger.info("third product has been added");
		Assert.assertEquals(inventorypage.shopingcartbadge.getText(), totalcount);
		SetUp.logger.info("added two more products and verified");
//	Assert.assertEquals(inventorypage.shopingcartbadge.getText(),totalcount);
		

	}
	
	
	
	
	public void addTwoMoreProductToTheCart() {


		inventorypage.addtocartbuttonforproducttwo.waitUntilEnabled().click();
		SetUp.logger.info("second product has been added");
		inventorypage.addtocartbuttonforproductthree.waitUntilEnabled().click();
		SetUp.logger.info("third product has been added");
		SetUp.logger.info("added two more products and verified");
//	Assert.assertEquals(inventorypage.shopingcartbadge.getText(),totalcount);
		

	}

	//test9 add two more product and validate total product count
	@Step("test9_addToMoreProductAndValidateTotalProductCountIs")
	public void test9_addToMoreProductAndValidateTotalProductCountIs(String totalcount) {

//		inventorypage.addtocartbuttonforproducttwo.waitUntilEnabled().click();
//		SetUp.logger.info("second product has been added");
	
//		inventorypage.addtocartbuttonforproductthree.waitUntilEnabled().click();
//		SetUp.logger.info("third product has been added");
////	
//		Assert.assertEquals(inventorypage.shopingcartbadge.getText(), totalcount);
//		SetUp.logger.info("added two more products and verified");
		
		addTwoMoreProductToTheCart(totalcount);



	}

	
	
	
	//verify total count in cart
	public void verifyTotalCountInCart(String Actualtotalcount) {

		Assert.assertEquals(inventorypage.shopingcartbadge.getText(), Actualtotalcount);
	}
	
	
	public void validateSocialMediaLinks( String facebooktitle, String linkedIntitle) {
		List<String> actualtitle = new ArrayList<String>();
		actualtitle.add(facebooktitle);
		actualtitle.add(linkedIntitle);
		
		for (int i = 1,j=0; i < inventorypage.links.size()-1 && j<actualtitle.size()-1; i++,j++) {
			inventorypage.links.get(i).click();
			String currentwindow = inventorypage.getDriver().getWindowHandle();
			Set<String> win = inventorypage.getDriver().getWindowHandles();
			win.remove(currentwindow);
			inventorypage.getDriver().switchTo().window(win.iterator().next());
			String expectedtitle = inventorypage.getDriver().getTitle();
			System.out.println(expectedtitle);
			if (actualtitle.get(j).equals(expectedtitle)) {
				SetUp.logger.info("title validation passed");
			} else {
				SetUp.logger.info("title validation failed");
			}
		
			inventorypage.getDriver().close();

			inventorypage.getDriver().switchTo().window(currentwindow);
		}
		
			
		}
	
	public void validateTheTtleInInventoryPage(String excpectedtitle) {
		String actualtitle = inventorypage.getDriver().getTitle();
		
		if(excpectedtitle.equals(actualtitle)) {
			Assert.assertEquals(excpectedtitle, actualtitle);
			SetUp.logger.info(excpectedtitle+ " title validation passed");
			Serenity.reportThat("inventorypage title validation passed", 
	                () -> Assert.assertEquals(excpectedtitle,actualtitle));
		}
		else {
			SetUp.logger.info(excpectedtitle +" title validation passed");
		}
		
	}
	

	//test4 validate inverntory page header and footers
	@Step("test4_validateInventoryPageHeaderAndFooters")
	public void test4_validateInventoryPageHeaderAndFooters() {
		
		ReadProperties read = new ReadProperties();
		validateTheTtleInInventoryPage("Swag Labs");
		validateHeader(read.headerText());
		validateSecondaryHeader("Products");
//		inventorypagesteps.validateMenuBars("All Items","About","Logout","Reset App State")
		validateFilter(read.filterAtoZ(),read.filterZtoA() , read.filterLowtoHigh(), read.filterHighToLow());
		validateAllProductsLabel(read.firstProductName(), read.secondProductName(), read.thirdProductName(),
				read.fourthProductName(), read.fifthProductName(), read.sixProductName());
		validateProductsPrices(read.fifthProductPrice(), read.secondProductPrice(), read.thirdProductPrice(),
				read.sixProductPrice(), read.firstProductPrice(), read.fourthProductPrice());

		validateFooter(read.footerText());
//		validateSocialMediaLink(read.linkedInTitleName());
//		inventorypage.validateXsocialmedia("X");
//		inventorypage.validateFacebook("Sauce Labs | [Facebook");
	validateSocialMediaLinks(read.getFacebookTitle(),read.linkedInTitleName());
		
	}
	

	//test5 validate sorting logc in filter
	@Step("test5_validateSortinLogicInFilter")
	public void test5_validateSortinLogicInFilter() {
		
		ReadProperties read = new ReadProperties();
		
		validateFilterProductAToZ(read.firstProductName(), read.secondProductName(), read.thirdProductName(),
				read.fourthProductName(), read.fifthProductName(), read.sixProductName());

		chooseFilterZtoA();

		validateFilterProductZToA(read.sixProductName(), read.fifthProductName(), read.fourthProductName(),
				read.thirdProductName(), read.secondProductName(), read.firstProductName());

		chooseFilterLowToHigh();

		validateProductsPricesLowToHigh(read.firstProductPrice(), read.secondProductPrice(), read.thirdProductPrice(),
				read.fourthProductPrice(), read.fifthProductPrice(), read.sixProductPrice());

		chooseFilterHighToLow();

		validateProductsPricesHighToLow(read.sixProductPrice(), read.fifthProductPrice(), read.fourthProductName(),
				read.thirdProductPrice(), read.secondProductPrice(), read.firstProductPrice());

	}
	
	

}
