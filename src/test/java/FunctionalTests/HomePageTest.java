package FunctionalTests;

import java.util.Properties;

import framework.freecrm.pages.ContactInformationPage;
import framework.freecrm.pages.HomePage;
import framework.freecrm.util.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import framework.freecrm.pages.LoginPage;
import framework.freecrm.pages.TestBase;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class HomePageTest  {
	
	public WebDriver driver;
	public TestBase testBase;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactInformationPage contactInformationPage;
	
	@BeforeMethod
	public void setUp(){
		testBase = new TestBase();
		driver = testBase.init();
		prop = testBase.initProperty();
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));

		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
driver.manage().window().maximize();
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is: "+ title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);

	}
	
	@Test(priority=2)
	public void verifyContactInformationPageTest(){
		homePage.clickContactsTab();
		homePage.clickOnNewContact();
		String title = homePage.getHomePageTitle();
		System.out.println("Contacts page title is: "+ title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
