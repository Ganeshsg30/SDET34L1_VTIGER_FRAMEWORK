package com.vtiger.practice;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;
import com.sdet34l1.genericlibrary.ExcelUse;
import com.sdet34l1.genericlibrary.IconstantPath;
import com.sdet34l1.genericlibrary.JavaUtility;
import com.sdet34l1.genericlibrary.PropertiesFile;
import com.vtiger.objectRepository.CreateNewOrganizationPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganizationInformationPage;
import com.vtiger.objectRepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgSelectIndustryTest extends BaseClass
{
	String organizationName;
	String visibletextindustry ;
	String visibletexttype;
	OrganizationInformationPage organizationinformationpage;
	OrganizationPage organizationpage;
	CreateNewOrganizationPage createneworganizationpage;
	
	@Test(groups = "sanity")
	public void createOrganizationTest() throws IOException
	{
		visibletextindustry = PropertiesFile.getDataFromPropertyFile("industry");
		visibletexttype = PropertiesFile.getDataFromPropertyFile("type");
		organizationName = ExcelUse.getDataFromExcel("CreateContact",5,1)+randomnumber;
		organizationinformationpage= new OrganizationInformationPage(driver);
		organizationpage = new OrganizationPage(driver);
		createneworganizationpage = new CreateNewOrganizationPage(driver);
		
		homepage.clickOrganization();
		organizationpage.clickCreateOrganization(driver);
		createneworganizationpage.enterOrganizationName(organizationName);
		createneworganizationpage.selectIndustry(element, visibletextindustry);
		createneworganizationpage.selectType(element, visibletexttype);
		createneworganizationpage.saveOrganization();
		javautil.assertionThroughIfCondition(organizationinformationpage.getOrganizationName(),organizationName,"Organization with select industry and type ");
	}
}

