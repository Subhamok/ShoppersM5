package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	    public WebDriver driver;
	
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//*[name()='svg' and @data-testid='SettingsIcon']")//(xpath=//button[@aria-label='Account settings']")
		private WebElement accountSettingIcon;
		
		public WebElement getAccountSettingIcon()
		{
			return accountSettingIcon;
		}
		
		@FindBy(xpath="//a[@href='/men' and @id='men']")
		private WebElement menMenuLink;
		
		public WebElement getmenMenuLink()
		{
			return menMenuLink;
		}
		
		@FindBy(xpath="//a[text()='T-shirts']")
		private WebElement TshirtpopupLink;
		
		public WebElement getTshirtpopupLink()
		{
			return TshirtpopupLink;
		}
		
		@FindBy(xpath="//a[@id='cart']")
		private WebElement addToCartLink;

		public WebElement getAddToCartLink() 
		{
			return addToCartLink;
		}
		
//		public void javascriptClick(WebDriver driver)
//		{
//			WebElement ele=driver.findElement(By.xpath(""));
//			JavascriptExecutor jse=(JavascriptExecutor)driver;
//			jse.executeScript("arguments[0].click();", ele);
//		}
}
