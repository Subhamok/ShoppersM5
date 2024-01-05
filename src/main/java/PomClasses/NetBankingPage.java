package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NetBankingPage 
{
	public WebDriver driver;
	public NetBankingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//iframe[@title='Netbanking']")
	private WebElement netBankingFrameTag;
	
	public WebElement getNetBankingFrameTag() {
		return netBankingFrameTag;
	}
	
	@FindBy(xpath="//input[@value='IDHC']")
	private WebElement IDHC_radioButton;
	
	public WebElement getIDHC_radioButton() {
		return IDHC_radioButton;
	}
	
//	public WebElement getNetbankingId() {
//		return netbankingId;
//	}
//
//	public WebElement getNetbankingPassword() {
//		return netbankingPassword;
//	}

	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitbutton;
	
	public WebElement getSubmitbutton() {
		return submitbutton;
	}
	
//	@FindBy(xpath="//input[@id='User ID']")
//	private WebElement netbankingId;
//	
//	@FindBy(xpath="//input[@id='Password']")
//	private WebElement netbankingPassword;
//	
//	@FindBy(xpath="//button[@id='Submit']")
//	private WebElement netbankingloginsubmit;
//	
//	public WebElement getNetbankingloginsubmit() {
//		return netbankingloginsubmit;
//	}
//	
//	@FindBy(xpath="//button[text()='Pay Now']")
//	private WebElement paynowbutton;
//	
//	public WebElement getPaynowbutton() {
//		return paynowbutton;
//	}
//	
//	@FindBy(xpath="//input[@id='Transaction Message']")
//	private WebElement transactionmessage;
//	
//	public WebElement getTransactionmessage() {
//		return transactionmessage;
//	}
	
	
	
}
