package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {

	
	@Test
	public void verify_Account_Registration() throws InterruptedException {
		
		logger.info("*************** starting AccountRegistration ****************");
		
		logger.debug(" All application log");
		
		Thread.sleep(4000);
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount");
		hp.clickRegister();
		logger.info("Clicked on Registration");
//		
		
		logger.info("Entering user details");
		AccountRegistration accRegis = new AccountRegistration(driver);
		accRegis.setFirstName(randomeString().toUpperCase());
		accRegis.setLastName(randomeString().toUpperCase());
		accRegis.setEmail(randomeString()+"@gmail.com");
//		accRegis.setTelephone(randomeNumber());
		
		String pass = randomeAlphaNumberic();
		accRegis.setPassword(pass);
//		accRegis.setConfirmPassword(pass);
		
		accRegis.setPrivacyPolicy();
		accRegis.clickContinue();
		logger.info("Clicked on continue");
		
//		String confirmMsg = accRegis.getConfirmationMsg();
//		Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
		
		logger.info("***** Finished AccountRegistration ******");
		
	}
	
	
	
	
}
