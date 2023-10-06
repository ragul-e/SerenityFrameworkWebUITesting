package com.swaglabs.utilities;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.waits.WithTimeout;

public class CommonMethods extends PageObject {
	
	public static void doClick(WebElementFacade element) {
		element.waitUntilClickable();
	}
	
	public static void selectByVisibleText(WebElementFacade element, String text) {
		element.selectByVisibleText(text);
	}
	
	public static void selectByIndex(WebElementFacade element, int index) {
		element.selectByIndex(index);
	}
	
	public static void selectByOption(WebElementFacade element, String text) {
		element.selectByValue(text);
	}
	
	

}
