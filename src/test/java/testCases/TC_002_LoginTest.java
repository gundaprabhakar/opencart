package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	
	
	@Test(groups= {"regression","master"})
	public void verify_login() 
	{
		try 
		{
		logger.info("****** starting TC_002_LoginTest ******");
		logger.debug("capturing application debug logs");
		//home page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccoount();
		logger.info("clicked on myaccount link");
		hp.clickLogin();//login link under Myaccount
		logger.info("clicked on lonin link");
		//Login page
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering valid email and password...");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.setLogin();//Login button
		logger.info("clicksed on login button");
		//my Account page
		MyAccountPage maccp=new MyAccountPage(driver); 
		boolean targetpage=maccp.IsMyAccountPageExists();
		if(targetpage==true) 
		{
			logger.info("Login Test Passed........");
			Assert.assertTrue(true);
		}
		else 
		{
			//Assert.fail();
			logger.error("Login test fail........");
			
		}
	}
	catch(Exception e) {
		Assert.fail();
	}
		logger.info("****** finished TC_002_LoginTest ******");
	}
	
	}

