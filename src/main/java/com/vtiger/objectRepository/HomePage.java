package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericlibrary.WebDriverUse;

//create the class as webpage name and make it as public
public class HomePage 
{
	//declare all the elements and specify the access specifier as private
	@FindBy(linkText = "More")
	private WebElement moreDropDown;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignTab;
	
	@FindBy(xpath = "//a[text()='Documents']")
	private WebElement documentTab;
	
	@FindBy(xpath = "//a[text()='Contacts']/../../td[8]")
	private WebElement contactTab;
	
	@FindBy(xpath = "//a[text()='Organizations']/../../td[6]")
	private WebElement organizationTab;
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productTab;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	
	
	//initialize the driver address to all the elements through contructors and make it as public
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Business library
	public void clickCampaign(WebDriver driver,WebDriverUse webDriverUse)
	{
		webDriverUse.mouseHoverOntheElement(moreDropDown);
		campaignTab.click();
	}
	
	public void clickProduct()
	{
		productTab.click();
	}
	
	public void clickContact()
	{
		contactTab.click();
	}
	
	public void clickOrganization()
	{
		organizationTab.click();
	}
	
	public void clickDocument()
	{
		documentTab.click();
	}
	
	
	public void signOut(WebDriver driver,WebDriverUse webDriverUse)
	{
		webDriverUse.mouseHoverOntheElement(administratorIcon);
		signOutLink.click();
	}
}
