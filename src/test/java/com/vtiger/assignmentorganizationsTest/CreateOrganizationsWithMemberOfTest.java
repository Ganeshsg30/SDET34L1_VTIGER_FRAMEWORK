package com.vtiger.assignmentorganizationsTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;
import com.sdet34l1.genericlibrary.ExcelUse;
import com.sdet34l1.genericlibrary.IconstantPath;
import com.sdet34l1.genericlibrary.JavaUtility;
import com.vtiger.objectRepository.CreateNewOrganizationPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganizationInformationPage;
import com.vtiger.objectRepository.OrganizationPage;
import com.vtiger.objectRepository.SearchOrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationsWithMemberOfTest extends BaseClass
{
	String organizationName;
	OrganizationInformationPage organizationinformationpage;
	OrganizationPage organizationpage;
	CreateNewOrganizationPage createneworganizationpage;
	SearchOrganizationPage searchorganizationpage;
	
	@Test
	public void createOrganizationsWithMemberOfTest() throws IOException
	{
		organizationName = ExcelUse.getDataFromExcel("CreateContact",5,1)+randomnumber;
		organizationinformationpage= new OrganizationInformationPage(driver);
		organizationpage = new OrganizationPage(driver);
		createneworganizationpage = new CreateNewOrganizationPage(driver);
		searchorganizationpage = new SearchOrganizationPage(driver);
		
		homepage.clickOrganization();
		organizationpage.clickCreateOrganization(driver);
		createneworganizationpage.enterOrganizationName(organizationName);
		createneworganizationpage.selectMemberOf();
		searchorganizationpage.selectMemberOfOrganization(organizationName, driver);
		createneworganizationpage.saveOrganization();
		javautil.printStatement(organizationinformationpage.getUpdatedTitle());
		javautil.printStatement(organizationinformationpage.getOrganizationName());
		javautil.assertionThroughIfCondition(organizationinformationpage.getOrganizationName(),organizationName,"Organization with Email opt out and Added Member ");
	}
}