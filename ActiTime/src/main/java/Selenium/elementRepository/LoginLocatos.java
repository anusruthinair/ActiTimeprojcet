package Selenium.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLocatos {
	
	public LoginLocatos(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="username")
	private WebElement usernameTB;
	
	@FindBy(name="pwd")
	private WebElement passwordTB;
	
	@FindBy(id="loginButton")
	private WebElement loginButton;

	
	public  WebElement getusernameTB()
	{
		return usernameTB;
	}
	
	public WebElement getpasswordTB()
	{
	return 	passwordTB;
	}
	
	public WebElement getloginButton()
	{
		return loginButton;
	}
	
	public void loginApp(String username,String password)
	{
		getusernameTB().sendKeys(username);
		getpasswordTB().sendKeys(password);
		getloginButton().click();
	}
	
}








