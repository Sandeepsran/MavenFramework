package crm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.base.TestBase;
import crm.pages.HomePage;
import crm.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage  homePage;
	
	
	//constructor of class
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
	String title= 	loginPage.veriTitlePage();  // this is non-static..so thatswhy use contructor of page class
	Assert.assertEquals(title, "Sign in | Scotiabank");
	}
    
	@Test(priority=2)
	public void logintest() {
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
}
