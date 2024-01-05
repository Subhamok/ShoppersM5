package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddress 
{
public WebDriver driver;
	
	public MyAddress(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='Add Address']")
	private WebElement addressformButton;

	public WebElement getAddressformButton() 
	{
		return addressformButton;
	}
	
	@FindBy(xpath="//div[@class='addressListContainer']//h3")
	private WebElement addedAddress;
	
	public WebElement getaddedAddress() 
	{
		return addedAddress;
	}
	
}
