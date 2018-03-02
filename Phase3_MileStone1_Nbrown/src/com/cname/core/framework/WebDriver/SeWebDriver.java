package com.cname.core.framework.WebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cname.core.framework.utils.Driver;
import com.cname.core.framework.utils.FindBy;
import com.cname.core.framework.utils.Global;

public class SeWebDriver
{
	public WebDriver driver;
	public WebElement webElm;
	public List<WebElement> lWebElm;
	public SeWebDriver()
	{
		driver = Driver.getDriver();
	}
	
	public void lounchApp(String url)
	{
		try
		{
			driver.get(url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public WebElement findElement(String locator, String locatorValue)
	{
		try
		{
			webElm =driver.findElement(FindBy.seByMechanism(locator, locatorValue));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return webElm;
	}
	
	public List<WebElement> findElements(String locator, String locatorValue)
	{
		try
		{
			lWebElm =driver.findElements(FindBy.seByMechanism(locator, locatorValue));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return lWebElm;
	}
	
	public String getTitle()
	{
		String title = null;
		try
		{
			title = driver.getTitle();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return title;
	}
	
	public String getUrl()
	{
		String url = null;
		try
		{
			url = driver.getCurrentUrl();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return url;
	}
	
	public String getPageSource()
	{
		String sourceCode = null;
		try
		{
			sourceCode = driver.getPageSource();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sourceCode;
	}
	
	public void implicitlyWait()
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(Global.synTime, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void explicitlyWait(String locator, String locatorValue)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Global.synTime);
			wait.until(ExpectedConditions.presenceOfElementLocated(FindBy.seByMechanism(locator, locatorValue)));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void pageLoadWait()
	{
		try
		{
			driver.manage().timeouts().pageLoadTimeout(Global.synTime, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
