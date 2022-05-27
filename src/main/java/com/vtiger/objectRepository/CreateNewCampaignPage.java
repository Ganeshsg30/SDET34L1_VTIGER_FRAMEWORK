package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//create the class as webpage name and make it as public
public class CreateNewCampaignPage 
{
	//declare all the element and specify the access specifier as private
	@FindBy(css ="[name='campaignname']")
	private WebElement campaignNameTxt;
	
	@FindBy(css = "[title='Select']")
	private WebElement addProductImg;
	
	@FindBy(css = "[class='crmButton small save']")
	private WebElement saveBtn;
	
	
	//initialize the driver address to all the elements through contructors and make it as public
	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Business library
	public void campaignCreateandSave(String campaignName)
	{
		campaignNameTxt.sendKeys(campaignName);
		saveBtn.click();
	}
	
	public void enterCampaignNameAndSwitchtoSearchProduct(String campaignName)
	{
		campaignNameTxt.sendKeys(campaignName);
		addProductImg.click();
	}
	
	public void saveCampaign() 
	{
		saveBtn.click();
	}
}
