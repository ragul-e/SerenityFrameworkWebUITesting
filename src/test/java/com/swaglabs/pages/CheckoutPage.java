package com.swaglabs.pages;

import org.openqa.selenium.WebElement;

import com.swaglabs.base.SetUp;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CheckoutPage  extends PageObject{

	@FindBy(xpath = "//div[@class='app_logo']")
	public WebElementFacade checkoutheadertext;
	
	@FindBy(xpath = "//div[@class='footer_copy']")
	public WebElementFacade checkoutpagefooter;
	
	@FindBy(xpath = "//div[@class='header_secondary_container']//span")
	public WebElementFacade checkoutpageyourinfotext;
	
//	@FindBy(xpath = "//div[@class='shopping_cart_container']//span")
	@FindBy(xpath = "//div[@class='shopping_cart_container']")
	public WebElementFacade checkoutpageshoppingcart;
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	public WebElementFacade checkoutpagefirstname;
	
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	public WebElementFacade checkoutpagelastname;
	
	
	@FindBy(xpath = "//input[@placeholder='Zip/Postal Code']")
	public WebElementFacade checkoutpagezip;
	
	@FindBy(xpath = "//button[@id='cancel']")
	public WebElementFacade checkoutcancelbtn;
	
	@FindBy(xpath = "//input[@id='continue']")
	public WebElementFacade checkoutcontinuebtn;
	
	@FindBy(xpath = "//div[@class='footer_copy']")
	public WebElementFacade footertext;

	
	//validate header
	

	
	

	
	//validate zip code
	

	
	//verify checkout button
	

	//validate footer
	
	
	
	
	
	
	
}
