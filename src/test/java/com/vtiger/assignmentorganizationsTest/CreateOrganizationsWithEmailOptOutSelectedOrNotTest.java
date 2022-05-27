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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationsWithEmailOptOutSelectedOrNotTest extends BaseClass
{
	String organizationName;
	OrganizationInformationPage organizationinformationpage;
	OrganizationPage organizationpage;
	CreateNewOrganizationPage createneworganizationpage;
	
	@Test
	public void createOrganizationsWithEmailOptOutSelectedOrNotTest() throws IOException
	{
		organizationName = ExcelUse.getDataFromExcel("CreateContact",5,1)+randomnumber;
		organizationinformationpage= new OrganizationInformationPage(driver);
		organizationpage = new OrganizationPage(driver);
		createneworganizationpage = new CreateNewOrganizationPage(driver);
		
		homepage.clickOrganization();
		organizationpage.clickCreateOrganization(driver);
		createneworganizationpage.enterOrganizationName(organizationName);
		createneworganizationpage.clickCheckBox();
		createneworganizationpage.clickCheckBox();
		createneworganizationpage.clickCheckBox();
		javautil.printStatement("Email opt out checkbox is Enabled");
		createneworganizationpage.saveOrganization();
		javautil.printStatement(organizationinformationpage.getUpdatedTitle());
		javautil.printStatement(organizationinformationpage.getOrganizationName());
		javautil.assertionThroughIfCondition(organizationinformationpage.getOrganizationName(),organizationName,"Organization with Email opt out is enabled");
	}	
}
	