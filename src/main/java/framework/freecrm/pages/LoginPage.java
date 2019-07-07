package framework.freecrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

	// webelements and actions(methods) -- features

	// pagefactory pattern: for WebElements:

	@FindBy(name = "email")
	WebElement username;

	//WebElement username1 =driver.findElement(By.name("Email);

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//*[contains(text(),'Login')]")
	WebElement loginBtn;

	//WebElement loginbtn =driver.findElement(By.xpath("//*[contains(text(),'Login')]"));

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String userName, String pwd) {
		username.sendKeys(userName);
		password.sendKeys(pwd);
		loginBtn.click();
		//JavascriptExecutor js = ((JavascriptExecutor) driver);
		//js.executeScript("arguments[0].click();", loginBtn);

		return new HomePage(driver);


	}



	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}




				}