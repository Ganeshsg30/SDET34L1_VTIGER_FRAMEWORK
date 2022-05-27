package com.vtiger.objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericlibrary.WebDriverUse;

//create the class as webpage name and make it as public
public class SearchOrganizationPage 
{
	//declare all the element and specify the access specifier as private
	@FindBy(id = "search_txt")
	private WebElement searchTxt;
	
	@FindBy(css = "[name='search']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//a[contains(@onclick,'set_return_contact_address')]")
	private WebElement clickFirstOrganization;
	
	//initialize the driver address to all the elements through contructors and make it as public
	public SearchOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Business library
	public void selectOrganization(String organizationName,WebDriver driver)
	{
		WebDriverUse.switchToWindowBasedOnTitle(driver,"Organizations");
		searchTxt.sendKeys(organizationName);
		searchBtn.click();
		clickFirstOrganization.click();
		WebDriverUse.switchToWindowBasedOnTitle(driver, "Contacts");
	}
	
	public void selectMemberOfOrganization(String organizationName , WebDriver driver)
	{
		WebDriverUse.switchToWindowBasedOnTitle(driver, "Accounts&action");
		searchTxt.sendKeys(organizationName);
		searchBtn.click();
		clickFirstOrganization.click();
		WebDriverUse.switchToWindowBasedOnTitle(driver,"Organizations");
	}
	
	public void selectMemberOfOrganizationAndClear(String organizationName , WebDriver driver)
	{
		WebDriverUse.switchToWindowBasedOnTitle(driver, "Accounts&action");
		searchTxt.sendKeys(organizationName);
		searchTxt.clear();
		clickFirstOrganization.click();
		WebDriverUse.switchToWindowBasedOnTitle(driver,"Organizations");
	}
}
