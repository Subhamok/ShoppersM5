package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersUtility extends BaseClass implements ITestListener 
{

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String failedMethod=result.getMethod().getMethodName().toString();
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File tempFile = ts.getScreenshotAs(OutputType.FILE);
		String timestamp=LocalDateTime.now().toString().replace(':', '-');
		File newFileLocation = new File("./src/test/resources/Screenshot"+failedMethod+timestamp+".png");
		
		try {
			FileHandler.copy(tempFile, newFileLocation);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
