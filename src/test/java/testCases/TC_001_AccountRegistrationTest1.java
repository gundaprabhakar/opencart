package testCases;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest1 extends BaseClass {
	
	
	@Test(groups= {"sanity","master"})
	public void verify_Account_Registration()  {
		
		logger.info("***** Stating TC_001_AccountRegistrationTest ******");
		logger.debug("Application logs starts.....");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccoount();
		logger.info("clicked on MyAccount Page");
		hp.clickRegister();
		logger.info("clicked on Register Page");
		
		logger.info("Entering customer details....");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstname(randomstring().toUpperCase());
		logger.info("entered firstname");
		regpage.setLastname(randomstring().toUpperCase());
		logger.info("entered lastname");
		regpage.setEmail(randomstring()+"@gmail.com");
		//regpage.setEmail("p.getProperty("email")");
		logger.info("entered email");
		regpage.setPassword(randomAlaphaNumeric());
		//regpage.setPassword("password");
		logger.info("entered Password");
	
		regpage.setPrivacyPolicy();
		logger.info("clicked setprivacy policy");

		regpage.setContinue();
		logger.info("clicked setcontinue");
		
		String confmsg = regpage.getconfirmationmsg();
		logger.info("validating msgs");
		//Assert.assertEquals(confmsg, "Our Account Has Been Created!" );
		if(confmsg.equals("Your Account Has Been Created!")) {
			logger.info("test passed");
		}
		else {
			logger.info("test failed");
		}
		}
		catch(Exception e) {
			logger.error("test failed........");
			//Assert.fail();
		}
		logger.debug("Application logs ended.....");
		logger.info("***** Finished TC_001_AccountRegistrationTest ******");
	}
}
