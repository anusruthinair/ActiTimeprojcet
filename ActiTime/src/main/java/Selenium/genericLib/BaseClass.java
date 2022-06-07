package Selenium.genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Selenium.elementRepository.LoginLocatos;

public class BaseClass {
	public WebDriver driver;
	public static  WebDriver listenerdriver;
	public DataUtility du=new DataUtility();
	
	@BeforeClass(alwaysRun=true)
	public void launchBrowser()
	{
		
			
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		driver=new ChromeDriver();
		listenerdriver=driver;
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void login() throws IOException
	{
		driver.get(du.getDatafromProperties("Url"));
		LoginLocatos ll=new LoginLocatos(driver);
		ll.loginApp(du.getDatafromProperties("Username"),du.getDatafromProperties("Password"));
	}
	@AfterMethod(alwaysRun=true)
	public void logout()
	{
		driver.findElement(By.id("logoutLink")).click();
	}
	@AfterClass(alwaysRun=true)
	public void closeBrowser()
	{
		driver.close();
	}
}
