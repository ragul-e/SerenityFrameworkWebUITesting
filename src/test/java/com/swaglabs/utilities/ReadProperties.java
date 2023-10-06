package com.swaglabs.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public Properties property;
	File file;
	FileInputStream fileinput;

	public ReadProperties() {
		file = new File(
				"C:\\Users\\RA20312005\\Documents\\22-23 Poc\\swaglabs\\src\\test\\resources\\configuration\\config.properties");
		try {
			fileinput = new FileInputStream(file);
			property = new Properties();
			property.load(fileinput);
		} catch (IOException e) {
			System.out.println("Exception:" + e.getMessage());
		}

	}

	public String getProperty(String key) {
		return property.getProperty(key);
	}

	public String usernnameOne() {

		return getProperty("username1");

	}

	public String usernnameTwo() {

		return getProperty("username2");

	}

	public String usernnameThree() {

		return getProperty("username3");

	}

	public String usernnameFour() {

		return getProperty("username4");

	}

	public String pssword() {

		return getProperty("password");

	}

	public String headerText() {

		return getProperty("headertext");

	}

	public String footerText() {

		return getProperty("footertext");

	}

	public String filePath() {

		return getProperty("filepath");

	}

	public String loginError() {

		return getProperty("loginerrorforlockeduser");

	}

	public String validateQtyOne() {

		return getProperty("validateQtyone");
	}

	public String validateQtyThree() {

		return getProperty("validateQtythree");
	}

	public String checkoutSecondaryHeader() {

		return getProperty("checkoutsecondaryheader");
	}

	public String checkoutFirstName() {

		return getProperty("chekoutfirstname");
	}

	public String checkoutLastName() {

		return getProperty("checkoutlastname");
	}

	public String checkoutZip() {

		return getProperty("checkoutZip");
	}

	public String firstProductName() {

		return getProperty("FirstProductname");
	}

	public String secondProductName() {

		return getProperty("secondProductname");
	}

	public String thirdProductName() {

		return getProperty("thirdProductname");
	}

	public String fourthProductName() {

		return getProperty("fourthProductname");
	}

	public String fifthProductName() {

		return getProperty("fifthProductname");
	}

	public String sixProductName() {

		return getProperty("sixProductname");
	}

	public String firstProductPrice() {
		return getProperty("firstproductprice");
	}

	public String secondProductPrice() {
		return getProperty("secondproductprice");
	}

	public String thirdProductPrice() {
		return getProperty("thirdproductprice");
	}

	public String fourthProductPrice() {
		return getProperty("fourthproductprice");
	}

	public String fifthProductPrice() {
		return getProperty("fifthproductprice");
	}

	public String sixProductPrice() {
		return getProperty("sixproductprice");
	}

	public String filterAtoZ() {

		return getProperty("aToz");
	}

	public String filterZtoA() {

		return getProperty("zToa");
	}

	public String filterLowtoHigh() {

		return getProperty("lowToHigh");
	}

	public String filterHighToLow() {

		return getProperty("HighTolow");
	}

	public String linkedInTitleName() {

		return getProperty("linkedInpagetitle");
	}

	public String getUsernmaeplaceholder() {

		return getProperty("usenameplaceholder");
	}

	public String getPasswordplaceholder() {

		return getProperty("passwordplaceholder");
	}
	
	public String getFooterusername() {

		return getProperty("footerusername");
	}
	public String getFooterUsernameOne() {

		return getProperty("footerusernameone");
	}
	public String getFooterUsernameTwo() {

		return getProperty("footerusernametwo");
	}
	public String getFooterUsernameThree() {

		return getProperty("footerusernamethree");
	}
	
	public String getFacebookTitle() {
		return getProperty("facebooktitle");
	}
	
	public String getFooterUsernameFour() {

		return getProperty("footerusernamefour");
	}
}
