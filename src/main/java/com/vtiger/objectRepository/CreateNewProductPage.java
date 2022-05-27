package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//create the class as webpage name and make it as public
public class CreateNewProductPage 
{
	//declare all the element and specify the access specifier as private
	@FindBy(css = "[name='productname']")
	private WebElement productNameTxt;
	
	@FindBy(css = "[value='  Save  ']")
	private WebElement saveBtn;
	
	
	//initialize the driver address to all the elements through contructors and make it as public
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Business library
	public void productCreateandSave(String productName)
	{
		productNameTxt.sendKeys(productName);
		saveBtn.click();
	}
}
