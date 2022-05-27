package com.vtiger.contactsTest;

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
import com.vtiger.objectRepository.CampaignInformationPage;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateNewCampaignPage;
import com.vtiger.objectRepository.CreateNewContactPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsTest extends BaseClass
{
	String contactName;
	ContactPage contactpage;
	CreateNewContactPage createnewcontactpage;
	ContactInformationPage contactinformationpage;
	
	@Test(groups = "sanity")
	public void createContactsTest() throws IOException
	{
		contactName = ExcelUse.getDataFromExcel("CreateContact", 2, 1)+randomnumber;
		
		contactpage = new ContactPage(driver);
		createnewcontactpage = new CreateNewContactPage(driver);
		contactinformationpage = new ContactInformationPage(driver);
		
		homepage.clickContact();
		contactpage.clickContactImg(driver);
		createnewcontactpage.contactCreateandSave(contactName);
		javautil.assertionThroughIfCondition(contactinformationpage.getContactName(), contactName,"Contact is ");	
		
	}
}