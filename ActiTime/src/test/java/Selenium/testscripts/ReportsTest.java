package Selenium.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Selenium.genericLib.BaseClass;

public class ReportsTest extends BaseClass{
	@Test
	public void staffperformance()
	{
		driver.findElement(By.id("container_reports")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Performance Report')]")).click();
		System.out.println(driver.getTitle());
	}

}
