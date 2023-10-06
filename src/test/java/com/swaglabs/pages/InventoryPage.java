package com.swaglabs.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.*;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.swaglabs.base.SetUp;

import io.cucumber.java.en_old.Ac;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class InventoryPage extends PageObject {

	@FindBy(xpath = "//div[@class='header_label']//div")
	public WebElementFacade inverntorypageheaders;

	@FindBy(xpath = "//div[@class='header_secondary_container']//span[text()='Products']")
	public WebElementFacade secondaryheaderininventorypage;

	@FindBy(xpath = "//span[text()='Name (A to Z)']")
	public WebElementFacade filtertext;

	@FindBy(xpath = "//div[@class='inventory_item_label']//a//div")
	public List<WebElementFacade> productnamesininverntorypage;

	@FindBy(xpath = "//div[@class='footer_copy']")
	public WebElementFacade footer;

	@FindBy(xpath = "//div[@class='inventory_item_price']")
	public List<WebElementFacade> productprices;

	@FindBy(xpath = "//select[@class='product_sort_container']")
	public WebElementFacade filterdropdown;

	@FindBy(xpath = "//select[@class='product_sort_container']")
	public List<WebElementFacade> filterdropdowns;

	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
	
//	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']")
	public WebElementFacade addtocartbuttonforproductone;

//	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	public WebElementFacade addtocartbuttonforproducttwo;

	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")

//	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
	public WebElementFacade addtocartbuttonforproductthree;

	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	public WebElementFacade shopingcartbadge;

	@FindBy(xpath = "//div[@id='shopping_cart_container']")
	public WebElementFacade shoppingcart;

	@FindBy(linkText = "LinkedIn")
	public WebElementFacade linkedIn;
	
	@FindBy(xpath = "//a[text()='Twitter']")
	public WebElementFacade X;
	
	@FindBy(xpath = "//ul[@class='social']//li")
	public List<WebElementFacade> links;
	
	
	@FindBy(linkText = "Facebook")
	public WebElementFacade facebook;
	
	@FindBy(xpath = "//title[text()='Sauce Labs (@saucelabs) / X']")
	public WebElementFacade xtitle;

	@FindBy(id = "react-burger-menu-btn")
	public List<WebElementFacade> menuitems;

	@Override
	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return super.getDriver();
	}

	
	// validate the header
	public void validateHeader(String header) {
		String inventorypageheader = inverntorypageheaders.getText();
		if (inventorypageheader.equals(header)) {
			System.out.println("inverntory page header validated");
		} else {
			System.out.println("inventory page header not validated");
		}

	}
	
//	add two more product to the cart
	public void addTwoMoreProductToTheCart(String totalcount) {


		addtocartbuttonforproducttwo.waitUntilEnabled().click();
		SetUp.logger.info("second product has been added");
		addtocartbuttonforproductthree.waitUntilEnabled().click();
		SetUp.logger.info("third product has been added");
		Assert.assertEquals(shopingcartbadge.getText(), totalcount);
		SetUp.logger.info("added two more products and verified");
//	Assert.assertEquals(inventorypage.shopingcartbadge.getText(),totalcount);
		

	}
	
	//add prodcut to the cart
	public void addProductToTheCart() {
		waitFor(ExpectedConditions.elementToBeClickable(addtocartbuttonforproductone)).click();
		
	}
	
	//add two more product to the cart
	public void addTwoMoreProductToTheCart() {


		addtocartbuttonforproducttwo.waitUntilEnabled().click();
		SetUp.logger.info("second product has been added");
		addtocartbuttonforproductthree.waitUntilEnabled().click();
		SetUp.logger.info("third product has been added");
		SetUp.logger.info("added two more products and verified");
//	Assert.assertEquals(inventorypage.shopingcartbadge.getText(),totalcount);
		

	}
	
	

	//validate secondary header
	public void validateSecondaryHeader(String secondaryheader) {
		String secondaryheaderinventorypage = secondaryheaderininventorypage.getText();
		if (secondaryheaderinventorypage.equals(secondaryheader)) {
			System.out.println("secondary header  validation passed");
		} else {
			System.out.println("scondary header is validation failed");
		}
	}

	//validatefilter
	public void validateFilter(String optionone, String optiontwo, String optionthree, String optionfour) {

		List<String> Actualfilters = new ArrayList<String>();
		Actualfilters.add(optionone);
		Actualfilters.add(optiontwo);
		Actualfilters.add(optionthree);
		Actualfilters.add(optionfour);

		List<WebElementFacade> expectionfilteroptions =filterdropdowns;

		for (int i = 0, j = 0; i < Actualfilters.size() && j < expectionfilteroptions.size(); i++, j++) {
			if (Actualfilters.get(i).equals(expectionfilteroptions.get(j).getText())) {
				System.out.println(Actualfilters.get(i) + "validated");
			} else {
				System.out.println(Actualfilters.get(i) + "not validated");
			}
		}

	}
	
	//validate click shopping cart
	public  void clickShoppingCart() {
		shoppingcart.click();
	}
	
	
	//validate count of product is showig near shopping cart
	
	
	//validate all product lables
	public void validateAllProductsLabel(String firstprodname, String secprodname, String thirdprodname,
			String fourthprodname, String fifthprodname, String sixthprodname) {
		List<String> productnames = new ArrayList<String>();
		productnames.add(firstprodname);
		productnames.add(secprodname);
		productnames.add(thirdprodname);
		productnames.add(fourthprodname);
		productnames.add(fifthprodname);
		productnames.add(sixthprodname);

		List<WebElementFacade> uiproductnames = productnamesininverntorypage;

		for (int i = 0, j = 0; i < productnames.size() && j < uiproductnames.size(); i++, j++) {
			if (productnames.get(i).equals(uiproductnames.get(j).getText())) {
				System.out.println(uiproductnames.get(i) + "validated");
			} else {
				System.out.println("not validated");
			}
		}

	}
	
	// validate products pricess
	@Step("validate product prices")
	public void validateProductsPrices(String priceone, String pricetwo, String pricethree, String pricefour,
			String pricefive, String pricesix) {
		List<WebElementFacade> uiproductsprices = productprices;

		List<String> productprice = new ArrayList<String>();
		productprice.add(priceone);
		productprice.add(pricetwo);
		productprice.add(pricethree);
		productprice.add(pricefour);
		productprice.add(pricefive);
		productprice.add(pricesix);

		for (int i = 0, j = 0; i < uiproductsprices.size() && j < productprice.size(); i++, j++) {

			if (uiproductsprices.get(i).getText().equals(productprice.get(i))) {
				System.out.println(productprice.get(i) + " validated Passed");
			} else {
				System.out.println(productprice.get(i) + " validated Failed");
			}
		}

	}
	
	
	//validate footer
	public void validateFooter(String Expectedtext) {

		String expectedtext = "";
		String Actualtext = footer.getText();

		System.out.println(footer.getText());
		System.out.println(Actualtext);

		if (Expectedtext.equals(Actualtext)) {
			System.out.println("footer validation is pass");
		} else {
			System.out.println("footer validation is failded");
		}

	}
	
	//validate linkedin
	public void validateLinkedIn(String ActualTitle) {
		linkedIn.click();
		String currentwindow = getDriver().getWindowHandle();
		Set<String> win  =  getDriver().getWindowHandles();
		
		win.remove(currentwindow);
		
		getDriver().switchTo().window(win.iterator().next());
//		String expectedtitle =  getDriver().getTitle();
		String expectedtitle =xtitle.getText();
		System.out.println(expectedtitle);
		if(ActualTitle.equals(expectedtitle)) {
			System.out.println("title validation passed");
		}else {
			System.out.println("title validation failed");
		}
		
		getDriver().switchTo().window(currentwindow);
	}
	
	
	public void validateXsocialmedia(String ActualTitle) {

		X.click();
		String currentwindow = getDriver().getWindowHandle();
		Set<String> win = getDriver().getWindowHandles();

		win.remove(currentwindow);

		getDriver().switchTo().window(win.iterator().next());
		String expectedtitle = getDriver().getTitle();
		
		
		System.out.println("------------title----------------");
		
		System.out.println(expectedtitle);
		
		
		
		System.out.println("------------title----------------");
		if (ActualTitle.equals(expectedtitle)) {
			SetUp.logger.info("title validation passed");
		} else {
			SetUp.logger.info("title validation failed");
		}
		
		Assert.assertEquals(expectedtitle, ActualTitle);
		getDriver().close();
		getDriver().switchTo().window(currentwindow);
		
		System.out.println("expected title for x:" +expectedtitle);
	
	}
	
	
	public void validateFacebook(String Actualtitle) {

		facebook.click();
		String currentwindow = getDriver().getWindowHandle();
		Set<String> win = getDriver().getWindowHandles();

		win.remove(currentwindow);

		getDriver().switchTo().window(win.iterator().next());
		String expectedtitle = getDriver().getTitle();
		System.out.println("title:"+expectedtitle);
		Assert.assertEquals(expectedtitle, Actualtitle);
		if (Actualtitle.equals(expectedtitle)) {
			SetUp.logger.info("title validation passed");
		} else {
			SetUp.logger.info("title validation failed");
		}
		getDriver().close();
		getDriver().switchTo().window(currentwindow);
	
	}
	
	//validate filter product Atoz
	public void validateFilterProductAToZ(String prodone, String prodtwo, String prodthree, String prodfour,
			String prodfive, String prodsix) {

		List<String> productnamesAtoZ = new ArrayList<String>();
		productnamesAtoZ.add(prodone);
		productnamesAtoZ.add(prodtwo);
		productnamesAtoZ.add(prodthree);
		productnamesAtoZ.add(prodfour);
		productnamesAtoZ.add(prodfive);
		productnamesAtoZ.add(prodsix);

		List<WebElementFacade> uiproductnames = productnamesininverntorypage;

		for (int i = 0, j = 0; i < uiproductnames.size() && j < productnamesAtoZ.size(); i++, j++) {

			if (uiproductnames.get(i).getText().equals(productnamesAtoZ.get(i))) {
				System.out.println(productnamesAtoZ.get(i) + " validated Passed");
			} else {
				System.out.println(productnamesAtoZ.get(i) + " validated Failed");
			}
		}

	}
	
	
	//chooose filtter z to A
	public void chooseFilterZtoA() {
		filterdropdown.selectByIndex(1);
	}
	
	//validate filter product z to A
	public void validateFilterProductZToA(String productone, String producttwo, String productthree, String productfour,
			String productfive, String productsix) {

		List<String> productnamesZtoA = new ArrayList<String>();
		productnamesZtoA.add(productone);
		productnamesZtoA.add(producttwo);
		productnamesZtoA.add(productthree);
		productnamesZtoA.add(productfour);
		productnamesZtoA.add(productfive);
		productnamesZtoA.add(productsix);

		List<WebElementFacade> uiproductnames = productnamesininverntorypage;

		for (int i = 0, j = 0; i < uiproductnames.size() && j < productnamesZtoA.size(); i++, j++) {

			if (uiproductnames.get(i).getText().equals(productnamesZtoA.get(i))) {
				System.out.println(productnamesZtoA.get(i) + " validated Passed");
			} else {
				System.out.println(productnamesZtoA.get(i) + " validated Failed");
			}
		}

	}
	
	//choose filter low to high
	public void chooseFilterLowToHigh() {
		filterdropdown.selectByIndex(2);
	}
	
	
	//validate products price low to high
	public void validateProductsPricesLowToHigh(String priceone, String pricetwo, String pricethree, String pricefour,
			String pricefive, String pricesix) {

		List<String> price = new ArrayList<String>();
		price.add(priceone);
		price.add(pricetwo);
		price.add(pricethree);
		price.add(pricefour);
		price.add(pricefive);
		price.add(pricesix);

		List<WebElementFacade> pricelowTohigh = productprices;

		for (int i = 0, j = 0; i < pricelowTohigh.size() && j < pricelowTohigh.size(); i++, j++) {

			if (pricelowTohigh.get(i).getText().equals(price.get(i))) {
				System.out.println(pricelowTohigh.get(i) + "price validation passed");
			} else {
				System.out.println(pricelowTohigh.get(i) + "price validation failed");
			}
		}

	}
	
	//choose filter high to low
	public void chooseFilterHighToLow() {
		filterdropdown.selectByIndex(3);
	}
	
	//vlaidate products prices high to low
	public void validateProductsPricesHighToLow(String priceone, String pricetwo, String pricethree, String pricefour,
			String pricefive, String pricesix) {

		List<String> price = new ArrayList<String>();
		price.add(priceone);
		price.add(pricetwo);
		price.add(pricethree);
		price.add(pricefour);
		price.add(pricefive);
		price.add(pricesix);

		List<WebElementFacade> priceHighToLow = productprices;

		for (int i = 0, j = 0; i < priceHighToLow.size() && j < price.size(); i++, j++) {

			if (priceHighToLow.get(i).getText().equals(price.get(i))) {
				System.out.println(priceHighToLow.get(i) + "price validation passed");
			} else {
				System.out.println(priceHighToLow.get(i) + "price validation failed");
			}
		}

	}


	public void validateSocialMediaLinks( String facebooktitle, String linkedIntitle) {
		List<String> actualtitle = new ArrayList<String>();
		actualtitle.add(facebooktitle);
		actualtitle.add(linkedIntitle);
		
		for (int i = 1,j=0; i < links.size()-1 && j<actualtitle.size()-1; i++,j++) {
			links.get(i).click();
			String currentwindow = getDriver().getWindowHandle();
			Set<String> win = getDriver().getWindowHandles();
			win.remove(currentwindow);
			getDriver().switchTo().window(win.iterator().next());
			String expectedtitle = getDriver().getTitle();
			Assert.assertEquals(expectedtitle, actualtitle.get(j));
			System.out.println(expectedtitle);
			if (actualtitle.get(j).equals(expectedtitle)) {
				SetUp.logger.info("title validation passed");
			} else {
				SetUp.logger.info("title validation failed");
			}
		
			getDriver().close();

			getDriver().switchTo().window(currentwindow);
		}
		
			
		}
		

}
