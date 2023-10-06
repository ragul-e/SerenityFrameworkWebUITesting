package com.swaglabs.testcases;

import java.util.Arrays;



import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.swaglabs.base.SetUp;
import com.swaglabs.pages.CheckoutPage;
import com.swaglabs.utilities.ReadProperties;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.junit.annotations.TestData;

@RunWith(SerenityParameterizedRunner.class)
public class Tests extends SetUp {

	String username;
	String password;
	
	
	/*
	 * constructor
	 */
	public Tests(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		
	}
	
//	@Rule
//    public RetryRule retryRule = new RetryRule(3); // Retry up to 3 times
	
	

	/*
	 * data provider method
	 */
	@TestData
	public static Collection<Object[]> userDetail() {
		ReadProperties	readProperties = new ReadProperties();
		return Arrays.asList(

				new Object[][] {
					{readProperties.usernnameOne(),readProperties.pssword()},
					            {readProperties.usernnameTwo(),readProperties.pssword()},
						{ readProperties.usernnameThree(), readProperties.pssword() }, 
						{ readProperties.usernnameFour(), readProperties.pssword()},

				});

	}

	@Test
	public void testCases() {
		
			ReadProperties	readProperties = new ReadProperties();
			loginPagesteps.test2_ValidateUserinterfaceHeadersAndFooters();
		 loginPagesteps.test3_loginWithAllUser(username, password,
					readProperties.loginError());
			
				inventorypagesteps.test4_validateInventoryPageHeaderAndFooters();
				inventorypagesteps.test5_validateSortinLogicInFilter();
				inventorypagesteps.test6_addProductToTheCart();
				inventorypagesteps.test7_validateOneIsShowingNearShoppingCart(readProperties.validateQtyOne());
				cartpagesteps.test8_validateUserInterfaceFootersAndHeadersInInventoryPage();
				inventorypagesteps.test9_addToMoreProductAndValidateTotalProductCountIs(readProperties.validateQtyThree());
				cartpagesteps.test10_tryToRemoveOneProductFromTheCart();
				cartpagesteps.test11_StoreProductInExcel(readProperties.filePath());
	//
				checkoutpagesteps.test12_checkoutAndValidateUserInterfaceHeaderAndFooters(readProperties.headerText(),
						readProperties.checkoutSecondaryHeader(), readProperties.checkoutFirstName(), readProperties.checkoutLastName(), readProperties.checkoutZip(),readProperties.footerText()
						);
			
		}
		
			
			
		}
		
		


		
		
		

	


        