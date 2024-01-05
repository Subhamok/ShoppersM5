package Utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtility 
{
	public void selectDropdownByVisibleText(String textofOption,WebElement selectTagOfDropdown)
	{
		Select select=new Select(selectTagOfDropdown);
		select.selectByVisibleText(textofOption);
	}
	
	public void selectDropdownByValueofValueAttribute(WebElement selectTagOfDropdown,String valueAttributevalue)
	{
		Select select=new Select(selectTagOfDropdown);
		select.selectByValue(valueAttributevalue);
	}
	
	public void selectDropdownByIndex(WebElement selectTagOfDropdown,int index)
	{
		Select select=new Select(selectTagOfDropdown);
		select.selectByIndex(index);
	}
	
	public void deselectDropdownByText(WebElement selectTagOfDropdown,String Textvalue)
	{
		Select select=new Select(selectTagOfDropdown);
		select.deselectByVisibleText(Textvalue);
	}
	
	public void deselectDropdownByvalueofValueAttribute(WebElement selectTagOfDropdown,String valueAttributevalue)
	{
		Select select=new Select(selectTagOfDropdown);
		select.deselectByValue(valueAttributevalue);
	}
	
	public void deselectDropdownByIndex(WebElement selectTagOfDropdown,int index)
	{
		Select select=new Select(selectTagOfDropdown);
		select.deselectByIndex(index);
	}
	
	public ArrayList ToGetAllOptionsText(WebElement selectTagOfDropdown)
	{
		Select select = new Select(selectTagOfDropdown);
		List<WebElement> allOptions = select.getOptions();
		ArrayList<String> allOptionsTexts = new ArrayList<String>();
		for(WebElement ele:allOptions)
		{
			allOptionsTexts.add(ele.getText());
		}
		return allOptionsTexts;
	}
	
	public WebElement ToGetParticularOptionIndex(WebElement selectTagOfDropdown,int indexOfOption)
	{
		Select select=new Select(selectTagOfDropdown);
		List<WebElement> allOptions = select.getOptions();
		WebElement particularOptionWebElement=allOptions.get(indexOfOption);
		return particularOptionWebElement;
	}
}
