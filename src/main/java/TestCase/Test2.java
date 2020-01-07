package TestCase;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import PageObject.Login_page;

public class Test2 extends BaseClass{
	@Test
	public void loginTest()
	{
		//test = extent.createTest("passTest","My new desc.");
		test.log(Status.INFO, "Just testing");
		driver.get(url);
		Login_page lp=new Login_page(driver);
		lp.sertusername(username);
		logger1.info("entered username");
		logger1.debug("entered username");
		lp.sertpassword(password);
		logger1.info("entered password");
		lp.lclick();		
	}
}
