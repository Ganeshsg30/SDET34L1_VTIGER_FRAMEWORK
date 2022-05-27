package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//create the class as webpage name and make it as public
public class OrganizationInformationPage 
{
	//declare all the element and specify the access specifier as private
	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement getNameText;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']/..")
	private WebElement getUpdatedText;
	
	
	
	//initialize the driver address to all the elements through contructors and make it as public
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Business library
	public String getOrganizationName()
	{
		return getNameText.getText();
	}
	
	public String getUpdatedTitle()
	{
		return getUpdatedText.getText();
	}
	 
}
