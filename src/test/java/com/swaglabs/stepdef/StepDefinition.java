package com.swaglabs.stepdef;

import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.CheckoutPage;
import com.swaglabs.pages.InventoryPage;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.steps.CartPageSteps;
import com.swaglabs.steps.CheckoutPageSteps;
import com.swaglabs.steps.InventoryPageSteps;
import com.swaglabs.steps.LoginPageSteps;
import com.swaglabs.utilities.ReadProperties;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class StepDefinition {

	@Steps
	public LoginPageSteps loginPagesteps;

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

	ReadProperties read = new ReadProperties();

	@Given("launch browser")
	public void launch_browser() {
		loginPagesteps.launchBrowser();

	}

	@Given("validate header")
	public void validate_header() {
		loginPagesteps.validateHeadersInloginPage("Swag Labs");
	}

	@Given("validate body")
	public void validate_body() {
		loginPagesteps.validateUsernamePlaceholderInFormInLoginPage("Username");
		loginPagesteps.validatePasswordPlaceholderInformInLoginPage("Password");
	}

	@Then("validate footers")
	public void validate_footers() {
		loginPagesteps.validateUsernameFooters("Accepted usernames are:", "standard_user", "locked_out_user", "problem_user",
				"performance_glitch_user");
		loginPagesteps.validatePasswordFootersInLoginPage("Password for all users:", "secret_sauce");

		loginPagesteps.validateLoginButton();
	}

	@Given("login with all user {string},{string}")
	public void login_with_all_user(String username, String password) {
		loginPagesteps.logWithWithAllUsers(username, password);
	}

//	
	@Given("do login {string}, {string}")
	public void do_login(String username, String password) {
		loginPagesteps.logWithWithAllUsers(username, password);
		loginPagesteps.clickLoginBtn();
	}

	@Given("validate inventory page header")
	public void validate_inventory_page_header() {
		inventorypagesteps.validateHeader(read.headerText());
		inventorypagesteps.validateSecondaryHeader("Products");
		inventorypagesteps.validateMenuBars("All Items", "About", "Logout", "Reset App State");
		inventorypagesteps.validateFilter("aToz", "zToa", "lowToHigh", "HighTolow");
	}

	@Given("validate inventory page body")
	public void validate_inventory_page_body() {
		inventorypagesteps.validateAllProductsLabel(read.firstProductName(), "Sauce Labs Bike Light",
				"Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie",
				"Test.allTheThings() T-Shirt (Red)");
		inventorypagesteps.validateProductsPrices("$29.99", " $9.99", "$15.99", "$49.99", "$7.99", "$15.99");
	}

	@Then("validate inventory pag footers")
	public void validate_inventory_pag_footers() {
		inventorypagesteps.validateFooter(read.footerText());
		inventorypagesteps.validateSocialMediaLink(read.linkedInTitleName());
	}

	@When("user login {string}, {string}")
	public void user_login(String username, String password) {
		loginPagesteps.logWithWithAllUsers(username, password);
		loginPagesteps.clickLoginBtn();
	}

	@Then("validate the sorting logic for name and price")
	public void validate_the_sorting_logic_for_name_and_price() {
		inventorypagesteps.validateFilterProductAToZ(read.firstProductName(), read.secondProductName(),
				read.thirdProductName(), read.fourthProductName(), read.fifthProductName(), read.sixProductName());

		inventorypagesteps.chooseFilterZtoA();

		inventorypagesteps.validateFilterProductZToA(read.sixProductName(), read.fifthProductName(),
				read.fourthProductName(), read.thirdProductName(), read.secondProductName(), read.firstProductName());

		inventorypagesteps.chooseFilterLowToHigh();

		inventorypagesteps.validateProductsPricesLowToHigh(read.firstProductPrice(), read.secondProductPrice(),
				read.thirdProductPrice(), read.fourthProductPrice(), read.fifthProductPrice(), read.sixProductPrice());

		inventorypagesteps.chooseFilterHighToLow();

		inventorypagesteps.validateProductsPricesHighToLow(read.sixProductPrice(), read.fifthProductPrice(),
				read.fourthProductName(), read.thirdProductPrice(), read.secondProductPrice(),
				read.firstProductPrice());

	}

	@Given("user add the product to the cart")
	public void user_add_the_product_to_the_cart() {
		inventorypage.addtocartbuttonforproductone.waitUntilClickable().click();
	}

	@Given("user validate the count {string} is showing near shopping cart")
	public void validateCountIsShowingNearShoppingCart(String actualcount) {
//		inventorypage.addtocartbuttonforproductone.waitUntilEnabled().click();
		inventorypage.addtocartbuttonforproductone.waitUntilClickable().click();
//		inventorypage.addProductToTheCart();
		
//		System.out.println("click the product");
//		inventorypage.validateCountofProductIsShowingNearShoppingCart(actualcount);
	}

	@Then("Add two more product to the cart and Validate the {string}")
	public void addTwoMoreProductvalidateTotalProductCountInTheCartIs(String actualcount) {
		inventorypagesteps.addTwoMoreProductToTheCart(actualcount);
	}

	@And("Add two more product")
	public void addTwoMoreProduct() {
//		user_add_the_product_to_the_cart();
		inventorypagesteps.addTwoMoreProductToTheCart();
	}

	@Then("validate the user interface headers  and footers")
	public void validate_the_user_interface_headers_and_footers() {

		inventorypagesteps.clickShoppingCart();
		cartpagesteps.validateHeaders(read.headerText());
		cartpagesteps.valiedateFooters(read.footerText());
		cartpagesteps.verifyTheContinueShoppingBtn();
		cartpagesteps.verifyTheCheckoutBtn();
		cartpagesteps.verifyQunatity();
		cartpagesteps.verifyDescription();
		cartpagesteps.continueShopping();

	}

	@And("user removes one product")
	public void removeOneProduct() {

		user_add_the_product_to_the_cart();
		cartpagesteps.removeProduct();

	}

	@And("Add product details to the excel")
	public void addProductDetailsToExcel() {
//		user_add_the_product_to_the_cart();
		addTwoMoreProduct();
		removeOneProduct();

	}

//	cartpage.checkoutbtn.click();
//	checkoutpage.validateHeader(header);
//	checkoutpage.validateSecHeader(secheader);
//	checkoutpage.verifyShoppingCart();
//	checkoutpage.validateFirstname(firstname);
//	checkoutpage.validateLastname(lastname);
//	checkoutpage.validateZip(zip);
//	checkoutpage.verifyCancelBtn();
//	checkoutpage.verifyCheckoutBtn();
//	checkoutpage.validateFooter(footer);

	

	
	
	@Then("validate headers in checkoutpage {string}, {string}")
	public void validate_headers_in_checkoutpage(String header, String secheader) {
		
		
		inventorypagesteps.clickShoppingCart();
		cartpagesteps.clickCheckoutButton();
//		cartpage.checkoutbtn.click();
		
		checkoutpagesteps.validateHeaderInCartPage(header);
		checkoutpagesteps.validateSecHeaderInCartPage(secheader);
		checkoutpagesteps.verifyShoppingCartInCartPage();
		
		
		
	}

	@Then("Validate body in checkout page {string},{string},{string}")
	public void validate_body_in_checkoutpage(String firstname, String lastname, String zip) {
		checkoutpagesteps.validateFirstname(firstname);
		checkoutpagesteps.validateLastname(lastname);
		checkoutpagesteps.validateZip(zip);
		checkoutpagesteps.verifyCheckoutBtn();
		checkoutpagesteps.verifyCancelBtn();
		checkoutpagesteps.verifyCheckoutBtn();
	}
	
	@Then("validate footers in checkoutpage")
	public void validate_footers_In_checkoutpage() {
		
		checkoutpagesteps.validateFooter(read.footerText());
	}

}
