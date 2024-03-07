package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email,String password,String exp) {
		
        logger.info("*****Starting TC_003_LoginDDT ***** ");
    
        try {
	
        HomePage hp=new HomePage(driver);
		hp.clickMyAccoount();
		logger.info("clicked on myaccount link");
		hp.clickLogin();//login link under Myaccount
		logger.info("clicked on login link");
		
		//Login page
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering valid email and password...");
		lp.setEmail(email);
		lp.setPassword(password);
		lp.setLogin();//Login button
		logger.info("clicksed on login button");
		
		
		//my Account page
		MyAccountPage maccp=new MyAccountPage(driver); 
		boolean targetpage=maccp.IsMyAccountPageExists();
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetpage==true) {
				maccp.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
			if(exp.equalsIgnoreCase("InValid")) {
				if(targetpage==true) {
					maccp.clickLogout();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
		}
		
        }
        catch(Exception e) {
        	Assert.fail();
        }
        logger.info("*****Finished TC_003_LoginDDT ***** ");
	}
	
}
