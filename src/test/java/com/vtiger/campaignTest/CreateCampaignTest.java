package com.vtiger.campaignTest;

import java.io.IOException;
import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;
import com.sdet34l1.genericlibrary.ExcelUse;
import com.vtiger.objectRepository.CampaignInformationPage;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.CreateNewCampaignPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


public class CreateCampaignTest extends BaseClass
{	
	String campaignname;
	CampaignPage campaignpame;
	CreateNewCampaignPage createnewcampaignpage;
	CampaignInformationPage campaigninformationpage;
	
	@Description ("Description: CreateCampaignTest")
	@Epic("Epic : Created")
	@Story("Story: CreateCampaign")
	@Step("Step: CreateCampaign")
	@Severity(SeverityLevel.BLOCKER)
	
	@Test(groups = "sanity")
	public void createCampaignTest() throws IOException
	{
		campaignname = ExcelUse.getDataFromExcel("ProductTest",5,1)+randomnumber;
		campaignpame = new CampaignPage(driver);
		createnewcampaignpage = new CreateNewCampaignPage(driver);
		campaigninformationpage = new CampaignInformationPage(driver);
		
		homepage.clickCampaign(driver, webDriverUse);
		campaignpame.clickCampaignImg(driver);
		createnewcampaignpage.campaignCreateandSave(campaignname);
		javautil.assertionThroughIfCondition(campaigninformationpage.getCampaignName(), campaignname, "Campaign is ");
		}
}