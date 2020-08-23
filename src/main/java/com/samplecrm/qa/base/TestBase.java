package com.samplecrm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.samplecrm.qa.util.TestUtil;


public class TestBase {

	
	public  static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream input= new FileInputStream("C:\\Users\\Yatan\\eclipse-workspace\\SamplePOMTest\\src\\main\\java\\com\\samplecrm\\qa\\config\\config.properties");
			prop.load(input);
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.contentEquals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.contentEquals("firefox")){
			
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWait,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeout, TimeUnit.SECONDS);	
		
		driver.get(prop.getProperty("url"));
	}
	
}
