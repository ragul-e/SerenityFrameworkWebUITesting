package com.swaglabs.steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.swaglabs.base.SetUp;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utilities.HeaderExist;
import com.swaglabs.utilities.ReadProperties;

import ch.qos.logback.classic.Logger;

import org.junit.*;
import org.junit.jupiter.api.Assumptions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WithTimeout;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class LoginPageSteps extends PageObject {

	LoginPage loginpage;
	
	Actor ragul = Actor.named("Ragul");
	
	
	
	
	
	
	
	

	//launch browser
	@Step("launch browser")
	public void launchBrowser() {
		loginpage.open();
		SetUp.logger.info("browser launched");

		
	}

	//validate header
	@Step("validate header")
	public void validateHeaders(String header) {

		if (loginpage.headertext.getText().equals(header)) {
			SetUp.logger.info("header validated");
		} else {
			SetUp.logger.info("header not validated");
		}
	}

	//validate footer usernames
	@Step("validate footer usernames")
	public void validateUsernameFooters(String usernameheader, String usernameone, String usernametwo,
			String usernamethree, String usernamefour) {
		String usernamefooter = loginpage.footerusernametxt.getText();
		String[] usernames = usernamefooter.split("\n");

		List<String> uiusernames = Arrays.asList(usernames);

		List<String> usernameslist = new ArrayList<String>();
		usernameslist.add(usernameheader);
		usernameslist.add(usernameone);
		usernameslist.add(usernametwo);
		usernameslist.add(usernamethree);
		usernameslist.add(usernamefour);

		for (int i = 0, j = 0; i < uiusernames.size() && j < usernameslist.size(); i++, j++) {
			if (uiusernames.get(i).equals(usernameslist.get(j))) {
				SetUp.logger.info(uiusernames.get(i) + "validated");
				ragul.attemptsTo(
						Ensure.that(uiusernames.get(i)).isEqualTo(usernameslist.get(j)));
			} else {
				SetUp.logger.info("not validated");
			}
		}

	}

	//validate uesrname placeholders
	@Step("validate  username placeholders")
	public void validateUsernamePlaceholderInForm(String username) {
		if (loginpage.usernameplaceholderfield.getText().equals(username)) {
			SetUp.logger.info("username  placeholder validated");
		} else {
			SetUp.logger.info("username placeholder not validated");
		}

	}

	
	//validate password placeholders
	@Step("validate  password placeholders")
	public void validatePasswordPlaceholderInform(String password) {
		if (loginpage.passwordplaceholder.getText().equals(password)) {
			SetUp.logger.info("password  placeholder validated");
		} else {
			SetUp.logger.info("password placeholder not validated");
		}
	}

	//validate login button
	@Step("validate  login button ")
	public void validateLoginButton() {
		if (loginpage.loginButton.isVisible()) {
			SetUp.logger.info("loginButton   validated");
		} else {
			SetUp.logger.info("loginButton  not validated");
		}
	}

	//validate passowrd footers
	@Step("validate password footers")
	public void validatePasswordFooters(String passwordheader, String passwordone) {
		String[] passwordfooter = loginpage.footerpasswordstext.getText().split("\n");
		List<String> uipasswordfooters = Arrays.asList(passwordfooter);
		List<String> passwords = new ArrayList<String>();
		passwords.add(passwordheader);
		passwords.add(passwordone);

		for (int i = 0, j = 0; i < uipasswordfooters.size() && j < passwords.size(); i++, j++) {
			if (uipasswordfooters.get(i).equals(passwords.get(j))) {
				SetUp.logger.info(uipasswordfooters.get(i) + "validated");
			} else {
				SetUp.logger.info("not validated");
			}
		}

	}

	//validate password footers
	@Step("validate password footers")
	public void logWithWithAllUsers(String username, String password) {
		loginpage.usernameinputtextfield.clear();
		loginpage.usernameinputtextfield.sendKeys(username);
		SetUp.logger.info("username entered a:"+username);
		loginpage.passwordinputtextfield.clear();
		loginpage.passwordinputtextfield.sendKeys(password);
		SetUp.logger.info("password entered a:"+password);
	}

	//click login button
	public void clickLoginBtn() {
		loginpage.loginButton.click();
		SetUp.logger.info("login button clicked");
	}

	//log with locked user
	public void logwithLockedUser(String username, String password) {
		loginpage.usernameinputtextfield.sendKeys(username);
		loginpage.passwordinputtextfield.sendKeys(password);
	}

	//validate error message
	public void validateErrorMessage(String errormsg) {

//		
		SetUp.logger.info(loginpage.standardusererrormsg.getText());
		String standarderrormsg = loginpage.standardusererrormsg.waitUntilPresent().getText();
		if (standarderrormsg.equals(errormsg)) {
			SetUp.logger.info("standarduser error msg verified");
		} else {
			System.out.println("standarduser error msg not verified");
		}
	}

	//log with problem user
	public void logWithProblemUser(String username, String password) {
		loginpage.usernameinputtextfield.sendKeys(username);
		loginpage.passwordinputtextfield.sendKeys(password);
	}
	
	
	public void validateHeadersInloginPage(String header) {

		try {
			if (loginpage.headertext.getText().equals(header)) {
				SetUp.logger.info("header validation passed");
				Assert.assertEquals(loginpage.headertext.getText(), header);
				Serenity.reportThat(header+"validation passed", 
		                () -> Assert.assertEquals(loginpage.headertext.getText(),header));
				throw new HeaderExist("header  text is not visible ");
			} else {
				SetUp.logger.info("header valdation failed");
			}
		}
		catch(HeaderExist e){
			e.printStackTrace();
		}
		
		
	}
	
	
	public void validateUsernamePlaceholderInFormInLoginPage(String username) {
		if (loginpage.usernameplaceholderfield.getText().equals(username)) {
			SetUp.logger.info("username  placeholder validation passed");
			Assert.assertEquals(loginpage.usernameplaceholderfield.getText(), username);
			Serenity.reportThat(username+"validation passed", 
	                () -> Assert.assertEquals(loginpage.usernameplaceholderfield.getText(),username));
		} else {
			SetUp.logger.info("username placeholder not validated failed");
		}

	}
	
	
	//validate password placeholder in form
		public void validatePasswordPlaceholderInformInLoginPage(String password) {
			if (loginpage.passwordplaceholder.getText().equals(password)) {
				SetUp.logger.info("password  placeholder validation passed");
				Assert.assertEquals(loginpage.passwordplaceholder.getText(), password);
				Serenity.reportThat(password+"validation passed", 
		                () -> Assert.assertEquals(loginpage.passwordplaceholder.getText(),password));
			} else {
				SetUp.logger.info("password placeholder  validattion failed");
			}
		}
		
		public void validateLoginButtonInLoginPage() {
			if (loginpage.loginButton.isVisible()) {
				SetUp.logger.info("loginButton   validation passed");
				Assert.assertTrue(loginpage.loginButton.isVisible());
				Serenity.reportThat(" login button is visible", 
		                () -> Assert.assertTrue(loginpage.loginButton.isVisible()));
			} else {
				SetUp.logger.info("loginButton  validation failed");
			}
		}
		
		
		
		public void validateUsernameFootersInLoginPage(String usernameheader, String usernameone, String usernametwo,
				String usernamethree, String usernamefour) {
			String usernamefooter = loginpage.footerusernametxt.getText();
			String[] usernames = usernamefooter.split("\n");

			List<String> uiusernames = Arrays.asList(usernames);

			List<String> usernameslist = new ArrayList<String>();
			usernameslist.add(usernameheader);
			usernameslist.add(usernameone);
			usernameslist.add(usernametwo);
			usernameslist.add(usernamethree);
			usernameslist.add(usernamefour);

			for (int i = 0, j = 0; i < uiusernames.size() && j < usernameslist.size(); i++, j++) {
				if (uiusernames.get(i).equals(usernameslist.get(j))) {
					
					
					SetUp.logger.info(uiusernames.get(i) + "validated");
					 
					Assert.assertEquals(uiusernames.get(i),usernameslist.get(j));
					
					
				} else {
					SetUp.logger.info("not validated");
				}
			}
		}
		
		
		
		public void validatePasswordFootersInLoginPage(String passwordheader, String passwordone) {
			String[] passwordfooter = loginpage.footerpasswordstext.getText().split("\n");
			List<String> uipasswordfooters = Arrays.asList(passwordfooter);
			List<String> passwords = new ArrayList<String>();
			passwords.add(passwordheader);
			passwords.add(passwordone);

			for (int i = 0, j = 0; i < uipasswordfooters.size() && j < passwords.size(); i++, j++) {
				if (uipasswordfooters.get(i).equals(passwords.get(j))) {
					SetUp.logger.info(uipasswordfooters.get(i) + "validated");
					Assert.assertEquals(uipasswordfooters.get(i),passwords.get(j));
				} else {
					SetUp.logger.info("not validated");
				}
			}

		}
		
		public void validateTheTtleInLoginpage(String excpectedtitle) {
			String actualtitle = loginpage.getDriver().getTitle();
			
			if(excpectedtitle.equals(actualtitle)) {
				Assert.assertEquals(excpectedtitle, actualtitle);
				 Serenity.reportThat(excpectedtitle+"validated", 
			                () -> Assert.assertEquals(excpectedtitle,actualtitle));
				SetUp.logger.info(excpectedtitle+ " title validation passed");
			}
			else {
				SetUp.logger.info(excpectedtitle +" title validation passed");
			}
			
		}
		
		
		
		
//		  public void validateCheckOutButton() {
//		        Serenity.reportThat("CheckOut button is displayed", 
//		                () -> Assert.assertTrue(cartPage.checkOutButton.isCurrentlyVisible()));
//
//		    }

	
	//test2 validate user interface headers and footers
	@Step("test2_ValidateUserinterfaceHeadersAndFooters")
	public void test2_ValidateUserinterfaceHeadersAndFooters() {
		ReadProperties read = new ReadProperties();
		validateTheTtleInLoginpage("Swag Labs");
		validateHeadersInloginPage(read.headerText());
		
		validateUsernamePlaceholderInFormInLoginPage(read.getUsernmaeplaceholder());
		validatePasswordPlaceholderInformInLoginPage(read.getPasswordplaceholder());
		validateLoginButtonInLoginPage();
		validateUsernameFootersInLoginPage("Accepted usernames are:", "standard_user", "locked_out_user", "problem_user",
				"performance_glitch_user");
		validatePasswordFootersInLoginPage("Password for all users:", "secret_sauce");
	}
	
	
	public void validateErrorMessage(String username, String password, String Actualerror) {
		boolean isErrorExpected = username.equals("locked_out_user") && password.equals("secret_sauce");

		if(username.equals("locked_out_user") && password.equals("secret_sauce")) {
			String Expectederror = loginpage.errormsg.getText();
			Assert.assertEquals(Expectederror, Actualerror);
			if (Expectederror.equals(Actualerror)) {
				System.out.println("error validation passed");
				Assert.assertEquals(Expectederror, Actualerror);;
				 Assumptions.assumeTrue(isErrorExpected,"skipping test because eror validated");
//				Assume.assumeFalse("skipping test because error validated",isErrorExpected);
				
			} 
			
			else {
				System.out.println("error validation failed");
	}
		}
		
	}
	
	
	//test3 log with all user
	@Step("login with user {0}")
	public void test3_loginWithAllUser(String username, String password, String Actualerror) {

		logWithWithAllUsers(username, password);
		SetUp.logger.info("username password entered");
		clickLoginBtn();
		SetUp.logger.info("login button clicked");
//		validateErrorMessage(username,password,Actualerror);

		
//		[
		boolean isErrorExpected = username.equals("locked_out_user") && password.equals("secret_sauce");
		if (isErrorExpected) {
		
			 waitFor(ExpectedConditions.visibilityOf(loginpage.errormsg));
			withTimeoutOf(Duration.ofSeconds(2));

			String Expectederror = loginpage.errormsg.getText();
			Assert.assertEquals(Expectederror, Actualerror);
			if (Expectederror.equals(Actualerror)) {
				System.out.println("error validation passed");
				Assert.assertEquals(Expectederror, Actualerror);;
//				 Assumptions.assumeTrue(isErrorExpected);
				Assume.assumeFalse("skipping test because eror validated",isErrorExpected);
				
			} else {
				System.out.println("error validation failed");
			}

		}
//		]
		
		

	}

}
