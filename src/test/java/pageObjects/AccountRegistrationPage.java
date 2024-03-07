package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement txtpolicy;
	
	@FindBy(xpath="//button[@type='submit']")
	 private WebElement btncontinue;
	
	/*
	 * WebDriverWait wait = new WebDriverWait(driver, 10); WebElement txtsubmit =
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "//input[@name='agree']")));
	 */
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirmation;
	
	public void setFirstname(String fname) {
		txtfirstname.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		txtlastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy() {
		txtpolicy.click();
	}
	
	public void setContinue() {
		//btncontinue.sendKeys(Keys.RETURN);
		//btncontinue.submit();
		//btncontinue.click();
		/*
		 * JavascriptExecutor js=(JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].click();", btncontinue);
		 */
		/*
		 * Actions act=new Actions(driver);
		 * act.moveToElement(btncontinue).click().perform();
		 */
		WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(btncontinue)).click();
		
	}
	
	public String getconfirmationmsg() {
		try {
			return(msgconfirmation.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}
	
	

}
