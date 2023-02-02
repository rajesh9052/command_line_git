package practise;

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
import org.testng.annotations.Test;

import Generic_utility.Base_class;
import Generic_utility.Excel_utility;
import Generic_utility.File_utility;
import Generic_utility.Webdriver_utility;
import Generic_utility.java_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import object_Repo.Home_page;
import object_Repo.Login_page;
import object_Repo.create_contact;
import object_Repo.verification_contact_title;

public class creating_contacts extends Base_class
{   @Test(groups ={"smoke", "Regression"})
	public void contacts() throws Exception {
		File_utility fi = new File_utility();
		  
		
		
		 Webdriver_utility wb  = new Webdriver_utility();
		// Excel_utility ex  = new Excel_utility();
		 java_utility ja = new java_utility();
		 

		
			
		 
	
		 
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 wb.waitForpageToload(driver);
		  
		    
		 Thread.sleep(2000);
		    Home_page ho = new Home_page(driver);
		    ho.contact_click();
		  
		   create_contact co = new create_contact(driver);
		    co.contactIMG();
		  
		  
		java_utility jr = new java_utility();
		  int rannum=  jr.getRandom();
		   
		   Excel_utility ex = new Excel_utility();
		     String data = ex.ExcelValues("Manikanta", 0, 1)+rannum;
		  
		 co.firsttxt(data);
		  co.lasttxt(data);
		  
		  co.inpIMG();
		//switching multiple windows 
		    wb.switchToWindow(driver, "Accounts&action");
		   // searching and clicking on saved one
		    
		    driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("Tummapudi Rajesh");
		    driver.findElement(By.xpath("//input[@type='button']")).click();
		    driver.findElement(By.linkText("Tummapudi Rajesh")).click();
		    //switching back to main window
		    
		    wb.switchToWindow(driver, "Contacts&action");
		    Thread.sleep(3000);
		    // for save button
		    
			  co.saveButton();
			  Thread.sleep(2000);
			  
			  verification_contact_title vc = new verification_contact_title(driver);
			   vc.verifycontati(driver, data);
			   
			  //for signout button
			  
			    
	}
	

}
