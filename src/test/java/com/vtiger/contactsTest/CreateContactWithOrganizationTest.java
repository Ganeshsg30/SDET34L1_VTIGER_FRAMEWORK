package com.vtiger.contactsTest;

import java.io.IOException;
import org.testng.annotations.Test;

import com.sdet34l1.genericlibrary.BaseClass;
import com.sdet34l1.genericlibrary.ExcelUse;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateNewContactPage;
import com.vtiger.objectRepository.CreateNewOrganizationPage;
import com.vtiger.objectRepository.OrganizationInformationPage;
import com.vtiger.objectRepository.OrganizationPage;
import com.vtiger.objectRepository.SearchOrganizationPage;


public class CreateContactWithOrganizationTest extends BaseClass
{
	String organizationName;
	String contactName;
	OrganizationInformationPage organizationinformationpage;
	OrganizationPage organizationpage;
	CreateNewOrganizationPage createneworganizationpage;
	ContactPage contactpage;
	CreateNewContactPage createnewcontactpage;
	ContactInformationPage contactinformationpage;
	SearchOrganizationPage searchorganizationpage;
	
	
	@Test(groups = "regression")
	public void createContactWithOrganizationTest() throws IOException
	{
		organizationName = ExcelUse.getDataFromExcel("CreateContact",5,1)+randomnumber;
		contactName = ExcelUse.getDataFromExcel("CreateContact",5,2)+randomnumber;
		organizationinformationpage= new OrganizationInformationPage(driver);
		organizationpage = new OrganizationPage(driver);
		createneworganizationpage = new CreateNewOrganizationPage(driver);
		
		contactpage = new ContactPage(driver);
		createnewcontactpage = new CreateNewContactPage(driver);
		contactinformationpage = new ContactInformationPage(driver);
		searchorganizationpage = new SearchOrganizationPage(driver);
		
		homepage.clickOrganization();
		organizationpage.clickCreateOrganization(driver);
		createneworganizationpage.organizationCreateandSave(organizationName);
		organizationinformationpage.getOrganizationName();
		
		homepage.clickContact();
		contactpage.clickContactImg(driver);
		createnewcontactpage.enterContactNameAndSwitchtoSearchOrganization(contactName);
		searchorganizationpage.selectOrganization(organizationName, driver);
		createnewcontactpage.saveContact();
		javautil.assertionThroughIfCondition(contactinformationpage.getContactName(), contactName,"Contact with Organization ");
	}	
}