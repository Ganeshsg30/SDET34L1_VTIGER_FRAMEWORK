package com.vtiger.productsTest;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
import com.vtiger.objectRepository.ProductInformationPage;
import com.vtiger.objectRepository.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductsTest extends BaseClass
{
	String expectedproductName;
	ProductPage productpage;
	CreateNewProductPage createnewproductpage;
	ProductInformationPage productinformationpage;
	
	@Test(groups = "regression")
	public void createProductsTest() throws IOException
	{
		expectedproductName = ExcelUse.getDataFromExcel("ProductTest",5,2)+randomnumber;
		productpage = new ProductPage(driver);
		createnewproductpage = new CreateNewProductPage(driver);
		productinformationpage = new ProductInformationPage(driver);
		
		homepage.clickProduct();
		productpage.clickProductImg(driver);
		createnewproductpage.productCreateandSave(expectedproductName);
		javautil.assertionThroughIfCondition(productinformationpage.getProductName(),expectedproductName,"Product Name is ");		
	}
}