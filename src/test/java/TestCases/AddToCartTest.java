package TestCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PomClasses.AccountSettingPage;
import PomClasses.AddressFormPage;
import PomClasses.HomePage;
import PomClasses.MyAddress;
import PomClasses.MyProfilePage;
import PomClasses.NetBankingPage;
import PomClasses.OrderConfirm;
import PomClasses.PaymentMethod;
import PomClasses.TshirtPage;
import PomClasses.addToCartPage;
import PomClasses.addressPage;
import Utilities.BaseClass;


@Listeners(Utilities.ListenersUtility.class)
public class AddToCartTest extends BaseClass
{
	@Test(dataProvider="dataProviderAddresss")
	public void Tc_AddAddress_001_Test(String name, String house_Office, String street, String Landmark, String Country, String State,
			String City, String Pin_code, String Phone_number) throws InterruptedException
	{
		System.out.println("Add Address");
		Thread.sleep(3000);
		HomePage hp=new HomePage(driver);
		hp.getAccountSettingIcon().click();
//		hp.javascriptClick(driver);when we remove the comment we should remove getaccountsettingsIcon above this line and call it from 
//		homepage javascript method.
		
		AccountSettingPage as=new AccountSettingPage(driver);
		as.getmyProfileLink().click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.shoppersstack.com/my-profile/my-profile-info");
		System.out.println("The my profile page is opened");
		MyProfilePage mp=new MyProfilePage(driver);
		mp.getmyAddressLink().click();
		
		MyAddress ma=new MyAddress(driver);
		ma.getAddressformButton().click();
		
		AddressFormPage afp= new AddressFormPage(driver);
		afp.getNameTextField().sendKeys(name);
		afp.getHouseOfficeInformationTextField().sendKeys(house_Office);
		afp.getStreetInformationTextField().sendKeys(street);
		afp.getLandmarkTextField().sendKeys(Landmark);
		WebElement countryDropdown = afp.getCountryDropDown();
		drpU.selectDropdownByVisibleText(Country,countryDropdown);
		WebElement StateDropdown= afp.getStateDropDown();
		drpU.selectDropdownByVisibleText(State, StateDropdown);
		WebElement CityDropdown= afp.getCityDropDown();
		drpU.selectDropdownByVisibleText(City, CityDropdown);
		afp.getPincodeTextField().sendKeys(Pin_code);
		afp.getPhoneNumberTextField().sendKeys(Phone_number);
		afp.getAddAddressButton().click();
	}
	
	@DataProvider
	public Object[][] dataProviderAddresss() throws Throwable
	{
		return data.accessAllAddress();
	}
	
//	@DataProvider
//	public Object[][] dataProviderAddress()
//	{
//		Object[][] ref=new Object[1][9];
//		ref[0][0]="LoveBirds";
//		ref[0][1]="ambani building, 2nd Floor";
//		ref[0][2]="ambani street";
//		ref[0][3]="ambani point";
//		ref[0][4]="India";
//		ref[0][5]="Karnataka";
//		ref[0][6]="Bengaluru";
//		ref[0][7]="560010";
//		ref[0][8]="9476219263";
//		
//		return ref;
//	}
	
	@Test(dependsOnMethods ="Tc_AddAddress_001_Test")
	public void Tc_AddToCart_001_Test() throws Throwable
	{	
		Thread.sleep(5000);
		System.out.println("the first test case");
		String titleHomePage = driver.getTitle();
		Assert.assertEquals(titleHomePage, "ShoppersStack | Home");
		
		HomePage Hp=new HomePage(driver);
		Thread.sleep(5000);
		WebElement menLink = Hp.getmenMenuLink();
		
		wu.mouseOverAction(driver, menLink);
		
		Hp.getTshirtpopupLink().click();
		
		TshirtPage tsp=new TshirtPage(driver);
		String currentUrl=driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://www.shoppersstack.com/sub-category/men-tshirt");
		wu.mouseOverAction(driver, tsp.gettshirtTopLink());
		
		tsp.getlevismensregularfitproduct_AddToCartButton().click();
		Hp.getAddToCartLink().click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.shoppersstack.com/cart");
		System.out.println("The cart has been opened");
		
		addToCartPage ac = new addToCartPage(driver);
		String levisProductTest=ac.getLevisProduct().getText();
		Assert.assertEquals(levisProductTest, "Levis Mens Regular Fit Tee");
		System.out.println("The product is added to the cart");
		ac.getBuyNowButtonInAddToCartPage().click();
		String addressPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(addressPageUrl, "https://www.shoppersstack.com/selectaddress");
		System.out.println("The address page is displayed");
		
		addressPage ap= new addressPage(driver);
		ap.getLovebirdAddress().click();
		ap.getProceedButton().click();
		
		PaymentMethod pm=new PaymentMethod(driver);
		pm.getCashondeliveryRadioButton().click();
		pm.getProceedButtonpayment().click();
		
		OrderConfirm oc=new OrderConfirm(driver);
		
		Assert.assertEquals(oc.getOrderConfirmed().getText(), "Order Confirmed");
		System.out.println("The order got confirmed in cash on delivery");
	}
	
	@Test(priority = 1, dependsOnMethods ="Tc_AddAddress_001_Test")
	public void EndtoEndNetBanking() throws Throwable
	{
		Thread.sleep(5000);
		System.out.println("the first test case");
		String titleHomePage = driver.getTitle();
		Assert.assertEquals(titleHomePage, "ShoppersStack | Home");
		
		HomePage Hp=new HomePage(driver);
		Thread.sleep(5000);
		WebElement menLink = Hp.getmenMenuLink();
		
		wu.mouseOverAction(driver, menLink);
		
		Hp.getTshirtpopupLink().click();
		
		TshirtPage tsp=new TshirtPage(driver);
		String currentUrl=driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://www.shoppersstack.com/sub-category/men-tshirt");
		wu.mouseOverAction(driver, tsp.gettshirtTopLink());
		
		tsp.getlevismensregularfitproduct_AddToCartButton().click();
		Hp.getAddToCartLink().click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.shoppersstack.com/cart");
		System.out.println("The cart has been opened");
		
		addToCartPage ac = new addToCartPage(driver);
		String levisProductTest=ac.getLevisProduct().getText();
		Assert.assertEquals(levisProductTest, "Levis Mens Regular Fit Tee");
		System.out.println("The product is added to the cart");
		ac.getBuyNowButtonInAddToCartPage().click();
		String addressPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(addressPageUrl, "https://www.shoppersstack.com/selectaddress");
		System.out.println("The address page is displayed");
		
		addressPage ap= new addressPage(driver);
		ap.getLovebirdAddress().click();
		ap.getProceedButton().click();
		
		PaymentMethod pm=new PaymentMethod(driver);
		pm.getNetbankingbuttonpayment().click();
		pm.getProceedButtonpayment().click();
		
		NetBankingPage nb= new NetBankingPage(driver);
		driver.switchTo().frame(nb.getNetBankingFrameTag());
		
		nb.getIDHC_radioButton().click();
		nb.getSubmitbutton().click();
		
//		nb.getNetbankingId().sendKeys("kunka.rocks33@gmail.com");
//		nb.getNetbankingPassword().sendKeys("Q7uID1B");
//		nb.getSubmitbutton().click();
//		nb.getPaynowbutton().click();
		
	}
	
//	@Test
//	public void Tc_AddToCart_002_Test() throws Throwable
//	{
//		System.out.println("the second test case");
//	}
//	

}
