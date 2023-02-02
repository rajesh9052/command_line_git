package Campaign;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_utility.Base_class;
import Generic_utility.Excel_utility;
import Generic_utility.File_utility;
import Generic_utility.Webdriver_utility;
import Generic_utility.java_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import object_Repo.Home_page;
import object_Repo.Login_page;
import object_Repo.create_product;
@Listeners(Generic_utility.Listener_class_exec.class)
public class create_campaign_and_product_mam_said extends Base_class
{   @Test(retryAnalyzer =Generic_utility.RetryImpclass.class )
	//@Test()
	public void campaign() throws Exception {
		
		File_utility fi = new File_utility();
		 Webdriver_utility wb = new Webdriver_utility();
		   
		  wb.maximizeScreen(driver);

		  // File_utility fi = new File_utility();
			
		 
		 
		
		 
		  wb.maximizeScreen(driver);

		
		   
		 Thread.sleep(2000);
		  System.out.println(driver.getTitle());
		  
		  //object creation for home_page
		   Home_page ho = new Home_page(driver);
		   // clicking on product element
		     ho.product_click();
		  create_product po = new create_product(driver);
		  po.clickprdctImg();
		
		//avoiding duplicates excel data
		java_utility jr = new java_utility();
		  int rannum=  jr.getRandom();
		   
		  
			    //hardAssert
		      Assert.assertEquals(false, true);
		      
			  Excel_utility ex = new Excel_utility();
			   String data =  ex.ExcelValues("Manikanta", 0, 1)+rannum;
			   po.prodtxt(data);
			  
			   po.save();
			   
			   Thread.sleep(200);
			 
			    ho.More_campaign();
				
				driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
				
				 driver.findElement(By.name("campaignname")).sendKeys("rajesh");
				 driver.findElement(By.xpath("//img[@alt='Select']")).click();
				 
				 
			
				     wb.switchToWindow(driver, "Products&action");
				  Thread.sleep(3000);
				    	    driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(data);
				    	     Thread.sleep(2000);
				    	    driver.findElement(By.xpath("//input[@type='button']")).click();
				    	    
				    	    Thread.sleep(2000);
				    		
				    		driver.findElement(By.linkText(data)).click();
				    		
				    	
							  wb.switchToWindow(driver, "Campaigns&action=EditView&return_action");
							  
							  driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
							   
				    		
				  
				  
				  }
	
	@Test()
	public void rajesh()
	{
		System.out.println("Rajesh is talented");
		
	}
				
				
				
				
				
	}


