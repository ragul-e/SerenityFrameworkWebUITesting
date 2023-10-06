package com.swaglabs.steps;

import org.junit.Assert;

import com.swaglabs.base.SetUp;
import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.CheckoutPage;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class CheckoutPageSteps {

	CheckoutPage checkoutpage;
	CartPage cartpage;
	
	
	public void validateHeaderInCartPage(String Expheader) {
		String Actualtext = checkoutpage.checkoutheadertext.getText();
		if(Expheader.equals(Actualtext)) {
			SetUp.logger.info("header validation passed");
			 Serenity.reportThat(Expheader+"validated", 
		                () -> Assert.assertEquals(Expheader,Actualtext));
		}
		else {
			SetUp.logger.info("header vlaidation failed");
		}
		
		
	}
	
	public void validateSecHeaderInCartPage(String secheader) {
		String Actualheader = checkoutpage.checkoutpageyourinfotext.getText();
		if(Actualheader.equals(secheader)) {
			System.out.println("secondary header vallidation passed");
		}else {
			System.out.println("secondary header vallidation failed");
		}
	}
	
	public void verifyShoppingCartInCartPage() {
		if (checkoutpage.checkoutpageshoppingcart.isDisplayed()) {
			SetUp.logger.info("shopping cart validation passed");
		}
		else {
			SetUp.logger.info("shopping cart verificaiton failed ");
		}
	}
	
	public void validateFirstname(String firstname) {
		String Actualfirstname  = checkoutpage.checkoutpagefirstname.getText();
		if (Actualfirstname.equals(firstname)) {
			System.out.println("firstname validation passed");
		}
		else {
			System.out.println("firstname validation failed");
		}
	}
	
	public void validateLastname(String lastname) {
		String ActualLastname  = checkoutpage.checkoutpagelastname.getText();
		if (ActualLastname.equals(lastname)) {
			System.out.println("lastname validation passed");
		}
		else {
			System.out.println("lastname validation failed");
		}
	}
	
	public void validateZip(String zip) {
		if (checkoutpage.checkoutpagezip.isDisplayed()) {
			SetUp.logger.info("zip button verification passed");
		}else {
			SetUp.logger.info("zip button verification failed");
		}
	}
	
	public void verifyCancelBtn() {
		if (checkoutpage.checkoutcancelbtn.isDisplayed()) {
			SetUp.logger.info("cancel button verification passed");
		}else {
			SetUp.logger.info("cancel button verification failed");
		}
	}
	
	public void verifyCheckoutBtn() {
		if (checkoutpage.checkoutcontinuebtn.isDisplayed()) {
			SetUp.logger.info("checkout button verification passed");
		}else {
			System.out.println("checkout button verification failed");
		}
	}
	
	public void validateFooter(String footer) {
		String Actualfootertext = checkoutpage.footertext.getText();
		if (Actualfootertext.equals(footer)) {
			SetUp.logger.info("footertext validation passed");
		}
		else {
			SetUp.logger.info("footertet validation failed");
		}
	}


	
	
	@Step("test12_checkoutAndValidateUserInterfaceHeaderAndFooters")
	public void test12_checkoutAndValidateUserInterfaceHeaderAndFooters(String header, String secheader, String firstname, String lastname, String zip, String footer) {
		cartpage.checkoutbtn.click();
		validateHeaderInCartPage(header);
	    validateSecHeaderInCartPage(secheader);
	    verifyShoppingCartInCartPage();
		validateFirstname(firstname);
	validateLastname(lastname);
		validateZip(zip);
		verifyCancelBtn();
	   verifyCheckoutBtn();
		validateFooter(footer);
	}

}
