package crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import crm.utilities.TestUtil;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	
	/*
	 * 
	 * new  thing
	 */
	public TestBase()  {                  //Construtcor of base class
		
		try {
		FileInputStream f = new FileInputStream("C:\\testing\\prop.properties");
        Properties prop = new Properties();
        prop.load(f);
		} catch(IOException f){
			f.printStackTrace();
		}
	}
		public static void initialization(){
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
		}else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_Wait, TimeUnit.SECONDS);
		
		
		driver.get(prop.getProperty("url"));  //launch browser
		
	}
	 
}
