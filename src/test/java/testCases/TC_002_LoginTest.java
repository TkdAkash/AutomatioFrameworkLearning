package testCases;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	
	@Test
	public void verify_Login() throws InterruptedException {
		
		logger.info("***** Starting TC_002_LoginTest *****");
		logger.debug("capturing application debug");
		
		Thread.sleep(5000);
//		HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickLogin();
		logger.info("Clicked on Login Link");
		
		
//		LohinPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		logger.info("Emial entered successfully");
		lp.setPassword(p.getProperty("pass"));
		logger.info("Password eneterd successfully");
		lp.clickLogin();
		logger.info("Clicked on Login");
		
		
//		My Account Page
		MyAccountPage macc = new MyAccountPage(driver);
		boolean target = macc.isMyAccountPageExists();
		if(target) {
			logger.info("Login test case passed");
			Assert.assertTrue(true);
		}
		else {
			logger.error("Login test failed");
			Assert.fail();
		}
		
		logger.info("***** End TC_002_LoginTest *****");
		
	}
	
}
