package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//create the class as webpage name and make it as public
public class DocumentPage 
{
	//declare all the element and specify the access specifier as private
	@FindBy(css = "[title='Create Document...']")
	private WebElement clickDocumentImg;

	
	//initialize the driver address to all the elements through contructors and make it as public
	public DocumentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Business library
	public void clickCreateDocument()
	{
		clickDocumentImg.click();
	}
	
}