package Selenium.testscripts;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Selenium.genericLib.BaseClass;
import Selenium.genericLib.DataUtility;
@Listeners(Selenium.genericLib.ListenerImplementation.class)
public class CreateCustomerTest extends BaseClass{
	@Test
	public void customerCreation() throws EncryptedDocumentException, IOException
	{
		
		Random r=new Random();
		int num=r.nextInt(10000);
		String expcustomername=du.getDatafromExcelSheet("Sheet1",0,1);
		expcustomername=expcustomername+num;
		driver.findElement(By.id("container_tasks")).click();
		driver.findElement(By.cssSelector(".title.ellipsis")).click();
		driver.findElement(By.className("createNewCustomer")).click();
		driver.findElement(By.className("newNameField")).sendKeys(expcustomername);
		driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']"))
		                                  .sendKeys("done");
		driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated
			(By.cssSelector(".titleEditButtonContainer>div.title"),expcustomername));
		
		String actualcustomername=driver.findElement
				(By.cssSelector(".titleEditButtonContainer>div.title")).getText();
		if(actualcustomername.equals(expcustomername))
		{
			System.out.println("customer creation passed");
		}
		else
		{
			System.out.println("customer creation failed");
		}
		
		
	}

}
