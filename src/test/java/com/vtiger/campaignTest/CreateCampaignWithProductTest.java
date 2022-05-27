package com.vtiger.campaignTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;
import com.sdet34l1.genericlibrary.ExcelUse;
import com.sdet34l1.genericlibrary.IconstantPath;
import com.sdet34l1.genericlibrary.JavaUtility;
import com.vtiger.objectRepository.CampaignInformationPage;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.CreateNewCampaignPage;
import com.vtiger.objectRepository.CreateNewProductPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.ProductPage;
import com.vtiger.objectRepository.SearchProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProductTest extends BaseClass
{
	String campaignname;
	String expectedproductName;
	CampaignPage campaignpame;
	CreateNewCampaignPage createnewcampaignpage;
	CampaignInformationPage campaigninformationpage;
	ProductPage productpage;
	CreateNewProductPage createnewproductpage;
	SearchProductPage searchproductpage;
	
	@Test(groups = "sanity")
	public void createCampaignWithProductTest() throws IOException
	{
		campaignname = ExcelUse.getDataFromExcel("ProductTest",5,1)+randomnumber;
		expectedproductName = ExcelUse.getDataFromExcel("ProductTest",5,2)+randomnumber;
		
		campaignpame = new CampaignPage(driver);
		createnewcampaignpage = new CreateNewCampaignPage(driver);
		campaigninformationpage = new CampaignInformationPage(driver);
		productpage = new ProductPage(driver);
		createnewproductpage = new CreateNewProductPage(driver);
		searchproductpage = new SearchProductPage(driver);
		
		homepage.clickProduct();
		productpage.clickProductImg(driver);	
		createnewproductpage.productCreateandSave(expectedproductName);
		
		homepage.clickCampaign(driver, webDriverUse);
		campaignpame.clickCampaignImg(driver);
		createnewcampaignpage.enterCampaignNameAndSwitchtoSearchProduct(campaignname);
		searchproductpage.selectProduct(expectedproductName, driver);
		createnewcampaignpage.saveCampaign();
		javautil.assertionThroughIfCondition(campaigninformationpage.getCampaignName(), campaignname, "Campaign with Product is ");
	}
}
	
