package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethod 
{
		public WebDriver driver;
		
		public PaymentMethod(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//span[text()='Cash On Delivery (COD)']/preceding-sibling::span/input")
		private WebElement cashondeliveryRadioButton;
		
		public WebElement getNetbankingbuttonpayment() {
			return netbankingbuttonpayment;
		}

		@FindBy(xpath="//button[text()='Proceed']")
		private WebElement proceedButtonpayment;
		
		@FindBy(xpath="//input[@value='Net Banking']")
		private WebElement netbankingbuttonpayment;

		public WebElement getCashondeliveryRadioButton() {
			return cashondeliveryRadioButton;
		}

		public WebElement getProceedButtonpayment() {
			return proceedButtonpayment;
		}
}
