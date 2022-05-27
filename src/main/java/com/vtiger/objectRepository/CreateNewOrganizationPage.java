package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericlibrary.WebDriverUse;

//create the class as webpage name and make it as public
public class CreateNewOrganizationPage 
{
	//declare all the element and specify the access specifier as private
	@FindBy(css = "[name='accountname']")
	private WebElement organizationNameTxt;
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name='emailoptout']")
	private WebElement clickCheckBox;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement selectMemberOfImg;
	
	@FindBy(css = "[name='industry']")
	private WebElement industryDropDown;
	
	@FindBy(css = "[name='accounttype']")
	private WebElement typeDropDown;
	
	@FindBy(css = "[value='T']")
	private WebElement clickGroupRadioBtn;
	
	@FindBy(css = "[value='U']")
	private WebElement clickUserRadioBtn;
	
	@FindBy(css = "[name='assigned_user_id']")
	private WebElement UserListDropDown;
	
	
	//initialize the driver address to all the elements through contructors and make it as public
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Business library
	public void organizationCreateandSave(String organizationName)
	{
		organizationNameTxt.sendKeys(organizationName);
		saveBtn.click();
	}
	
	public void enterOrganizationName(String organizationName)
	{
		organizationNameTxt.sendKeys(organizationName);
	}
	
	public void selectIndustry(WebElement element,  String visibleText)
	{
		WebDriverUse.selectDropDown(visibleText, industryDropDown);
	}
	
	public void selectType(WebElement element,String visibleText)
	{
		WebDriverUse.selectDropDown(visibleText, typeDropDown);
	}
	
	public void clickCheckBox()
	{
		clickCheckBox.click();
	}
	
	public void selectMemberOf()
	{
		selectMemberOfImg.click();
	}
	
	public void selectUser()
	{
		clickUserRadioBtn.click();
	}
	
	public void selectGroup()
	{
		clickGroupRadioBtn.click();
	}

	public void saveOrganization()
	{
		saveBtn.click();
	}
	
	public void selectUserDropDown(WebDriver driver, int index)
	{
		WebDriverUse.selectDropDown(UserListDropDown, index);
	}
}
