package com.swaglabs.base;

import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.CheckoutPage;
import com.swaglabs.pages.InventoryPage;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.steps.CartPageSteps;
import com.swaglabs.steps.CheckoutPageSteps;
import com.swaglabs.steps.InventoryPageSteps;
import com.swaglabs.steps.LoginPageSteps;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

public class SetUp {
	
	
	@Managed
	WebDriver driver;
	
	@Steps
	public  LoginPageSteps loginPagesteps;
	
	@Steps
	public InventoryPageSteps inventorypagesteps;
	
	@Steps
	public CartPageSteps cartpagesteps;
	
	@Steps
	public CheckoutPageSteps checkoutpagesteps;
	
	
	
	public LoginPage loginpage;
	public InventoryPage inventorypage;
	public CartPage cartpage;
	public CheckoutPage checkoutpage;
	
	public static  Logger logger = (Logger) LogManager.getLogger(SetUp.class);
	
	@Before
	public   void launchBrowser() {
//		logger = (Logger) LogManager.getLogger(SetUp.class);

		loginPagesteps.launchBrowser();
		
	}

}
