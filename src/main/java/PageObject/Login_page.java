package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login_page {
	WebDriver driver;
	public Login_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	@FindBy(name="username")
	WebElement usern;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="loginButton")
	WebElement lbutton;

	public void sertusername(String uname)
	{
		usern.sendKeys(uname);
	}
	public void sertpassword(String passw)
	{
		password.sendKeys(passw);
	}
	public void lclick()
	{
		usern.click();
	}
}
