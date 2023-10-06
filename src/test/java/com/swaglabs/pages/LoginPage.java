package com.swaglabs.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Assume;
import org.openqa.selenium.WebDriver;

import com.swaglabs.base.SetUp;
import com.swaglabs.utilities.HeaderExist;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.saucedemo.com/")
//@DefaultUrl("page:webdriver.app1.url")
public class LoginPage extends PageObject {

	@FindBy(xpath = "//div[@class='login_logo']")
	public WebElementFacade headertext;

	@FindBy(xpath = "//div[@id='login_credentials']//h4")
	public WebElementFacade footeronetext;

	@FindBy(xpath = "//div[@class='login_password']//h4")
	public WebElementFacade footertwotext;
	
	
	@FindBy(xpath = "//div[@id='login_credentials']")
	public WebElementFacade footerusernametxt;
	
	@FindBy(xpath = "//div[@class='login_password']")
	public  WebElementFacade footerpasswordstext;
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	public WebElementFacade usernameplaceholderfield;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElementFacade passwordplaceholder;
	
	@FindBy(id = "login-button")
	public WebElementFacade loginButton;
	
	@FindBy(id = "user-name")
	public WebElementFacade usernameinputtextfield;
	
	@FindBy(id = "password")
	public WebElementFacade passwordinputtextfield;
	
	@FindBy(xpath = "//div[@class='error-message-container error']//h3")
	public WebElementFacade standardusererrormsg;
	
	@FindBy(xpath = "//div[@class='pricebar']//div")
	public WebElementFacade productprice;
	
	
	@FindBy(xpath = "//h3[text()='Epic sadface: Sorry, this user has been locked out.']")
	public WebElementFacade errormsg;
	
	
	@Override
	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return super.getDriver();
	}
	
	
}
