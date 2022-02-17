package crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.base.TestBase;

public class LoginPage extends TestBase{

	//PageFactory -OR to avoid the driver issue...as our webelements are globally declared and driver is coming null
	
	@FindBy(name="usernameInput")
	public WebElement emailBox;    //for single element
	
	@FindBy(name="password")
	public WebElement passwordBox;
	
	@FindBy(id= "signIn")
	public WebElement loginButton;
	
	
	//Initializating the PAGE OBJECTS
	//declare public constructor of this class, and create method
	public LoginPage() {
		PageFactory.initElements(driver, this);  // all above webelememnt declare with this driver...this emaning this preset class
		
	}
		//ACTIONS
		public String veriTitlePage() {
			return driver.getTitle();        
		}
//			public void login(String un, String pwd) {
//				emailBox.sendKeys(un);
//				passwordBox.sendKeys(pwd);
//				loginButton.click();
//			}
		
		public HomePage login(String un, String pwd) {
			emailBox.sendKeys(un);
			passwordBox.sendKeys(pwd);
			loginButton.click();
			return new HomePage();
			
			
			
		}
}
