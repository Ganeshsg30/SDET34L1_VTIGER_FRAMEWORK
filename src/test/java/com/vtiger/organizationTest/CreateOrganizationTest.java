package com.vtiger.organizationTest;


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
import com.vtiger.objectRepository.CreateNewOrganizationPage;
import com.vtiger.objectRepository.CreateNewProductPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganizationInformationPage;
import com.vtiger.objectRepository.OrganizationPage;
import com.vtiger.objectRepository.ProductInformationPage;
import com.vtiger.objectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest extends BaseClass
{
	String organizationName;
	OrganizationInformationPage organizationinformationpage;
	OrganizationPage organizationpage;
	CreateNewOrganizationPage createneworganizationpage;
	
	@Test(groups = "sanity")
	public void createOrganizationTest() throws IOException
	{
		organizationName = ExcelUse.getDataFromExcel("CreateContact",5,1)+randomnumber;
		organizationinformationpage= new OrganizationInformationPage(driver);
		organizationpage = new OrganizationPage(driver);
		createneworganizationpage = new CreateNewOrganizationPage(driver);
		
		homepage.clickOrganization();
		organizationpage.clickCreateOrganization(driver);
		createneworganizationpage.organizationCreateandSave(organizationName);
		javautil.assertionThroughIfCondition(organizationinformationpage.getOrganizationName(), organizationName,"Organization is ");	
	}	
}