package com.vtiger.documentsTest;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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
import com.vtiger.objectRepository.CreateNewDocumentPage;
import com.vtiger.objectRepository.DocumentInformationPage;
import com.vtiger.objectRepository.DocumentPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentsTest extends BaseClass
{
	String documenttitle;
	String documentpath;
	String documentdescription;
	String documentfileName;
	
	DocumentPage documentpage;
	CreateNewDocumentPage createNewdocumentpage;
	DocumentInformationPage documentinformationpage;
	
	@Test
	public void createCampaignTest() throws IOException
	{
		documenttitle = ExcelUse.getDataFromExcel("ProductTest", 8, 1)+randomnumber;
		documentpath = ExcelUse.getDataFromExcel("ProductTest", 8, 2);
		documentdescription = ExcelUse.getDataFromExcel("ProductTest", 8, 3);
		documentfileName = ExcelUse.getDataFromExcel("ProductTest", 8, 4);
		
		documentpage = new DocumentPage(driver);
		createNewdocumentpage= new CreateNewDocumentPage(driver);
		documentinformationpage = new DocumentInformationPage(driver);
		
		homepage.clickDocument();
		documentpage.clickCreateDocument();
		createNewdocumentpage.createDocuments(documenttitle);
		createNewdocumentpage.enterDescription(driver, documentdescription);
		createNewdocumentpage.scrollTillElementPage(driver);
		createNewdocumentpage.fileInformationFill(driver, documentfileName, 1);
		createNewdocumentpage.documentSave();
		javautil.printStatement(documentinformationpage.getUpdatedTitle());
		javautil.printStatement("Document created Successfully");
		}
}
