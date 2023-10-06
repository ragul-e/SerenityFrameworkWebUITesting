package com.swaglabs.pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.swaglabs.base.SetUp;
import com.swaglabs.utilities.CommonMethods;
import com.swaglabs.utilities.ExcelUitls;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CartPage extends PageObject {
	
	

	@FindBy(xpath = "//div[@class='header_label']//div")
	public WebElementFacade cartpageheader;

	@FindBy(xpath = "//div[@class='footer_copy']")
	public WebElementFacade cartpagefooter;

	@FindBy(id = "continue-shopping")
	public WebElementFacade continuebtn;

	@FindBy(xpath = "//button[text()='Checkout']")
	public WebElementFacade checkoutbtn;

	@FindBy(xpath = "//div[@class='cart_quantity_label']")
	public WebElementFacade qtylabel;

	@FindBy(xpath = "//div[@class='cart_desc_label']")
	public WebElementFacade descriptiontext;

	@FindBy(xpath = "continue-shopping")
	public WebElementFacade continueShopping;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	public WebElementFacade clickshoppingcart;

	@FindBy(xpath = "(//button[text()='Remove'])[1]")
	public WebElementFacade removefirstProductincart;

	@FindBy(xpath = "//div[@class='cart_item_label']//div")
	public List<WebElementFacade> allproductincarts;

	
	
	//click checkout button
	
}
