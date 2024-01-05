package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PomClasses.AccountSettingPage;
import PomClasses.HomePage;
import PomClasses.LoginPage;
import PomClasses.WelcomePage;






public class BaseClass 
{
	public static WebDriver driver;
	public DataUtility data = new DataUtility();
	public WebDriverUtility wu=new WebDriverUtility();
	public DropDownUtility drpU=new DropDownUtility();
	
	@BeforeClass
	public void launchingBrowser() throws Throwable
	{
		System.out.println("-----------------Launching the Browser--------------------");
		String BROWSER = data.dataFromProperties("browser");
		
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		String URL=data.dataFromProperties("url");
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@BeforeMethod
	public void loginToApplication() throws Throwable
	{
		System.out.println("-------------------Login to the Application--------------------");
		WelcomePage WLpage = new WelcomePage(driver);
		WLpage.getMainLoginButton().click();
		
		LoginPage Lpage = new LoginPage(driver);
		String emailID = data.dataFromProperties("email");
		Lpage.getEmailTextField().sendKeys(emailID);
		String Password = data.dataFromProperties("password");
		Lpage.getPasswordTextField().sendKeys(Password);
		Lpage.getLoginButton().click();	
	}
	
	@AfterMethod
	public void logoutFromApplication() throws Throwable
	{
		System.out.println("-----------------------Logout to the Application-----------------------");
		Thread.sleep(5000);
		HomePage Hpage=new HomePage(driver);
		Thread.sleep(3000);
		Hpage.getAccountSettingIcon().click();
		
		AccountSettingPage APage=new AccountSettingPage(driver);
	    Thread.sleep(3000);
		APage.getLogoutIcon().click();
	}
	
	@AfterClass
	public void quitBrowser()
	{
		System.out.println("------------------------------Quit the Browser-------------------------");
		driver.quit();
	}
}
