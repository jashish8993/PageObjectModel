package TestCase;

//import org.apache.log4j.BasicConfigurator;
//import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utilities.ReadConfig;

public class BaseClass {
	ReadConfig readf=new ReadConfig();
	public  String username= readf.getUsername();
	public  String password= readf.Password();
	public  String url=readf.getApplicationUrl();
	public  WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	public ExtentHtmlReporter htmlreporter;
	public Logger logger1;
	@Parameters("Browser")
	@BeforeClass
	public void setup(String br)
	{
		//extent = new ExtentReporter (System.getProperty("user.dir") +"/test-output2/My_Report", true);

		//loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output2/My_Report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		htmlreporter.config().setTheme(Theme.DARK);
		test=extent.createTest("Test1");
		test=extent.createTest("Test2");
		logger1=Logger.getLogger(Test1.class);
		logger1=Logger.getLogger(Test2.class);
		//BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","Driver\\geckodriver.exe");
			driver=new FirefoxDriver();
			logger1.fatal("fatal error");
		}
		else if(br.equals("chrome"))
		{ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		System.setProperty("webdriver.chrome.driver","Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else
		{
			System.out.println("You have selected a invalid browser");
		}
	}

	@AfterClass
	public void teardown()
	{
		extent.flush();
		driver.quit();	
		
	}
}
