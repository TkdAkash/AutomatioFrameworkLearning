package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;


public class TC_003_LoginDDT extends BaseClass {

	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProvider.class)
	public void verify_Login(String email,String password,String exp) {
		//Home page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin(); //Login link under MyAccount
			
		//Login page
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin(); //Login button
			
		//My Account Page
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		
		if(exp.equalsIgnoreCase("valid")) {
			if(targetPage==true) {
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.fail();
			}
		}
		if(exp.equalsIgnoreCase("invalid")) {
			if(targetPage == true) {
				macc.clickLogout();
				Assert.fail();
			}
			else {
				Assert.assertTrue(true);
			}
		}
	}
	
}
