package Campaign;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import object_Repo.verification_campaign_title;

public class Create_campaign extends Base_class
{   @Test(groups = "Regression")
	public void campaign() throws Exception {
		
		 
		 File_utility fi = new File_utility();
		  
	
		  Webdriver_utility wb = new Webdriver_utility();
		  

		  // File_utility fi = new File_utility();
		
		 
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				 Thread.sleep(2000);
		
		Home_page ho = new Home_page(driver);
		 ho.More_campaign();
		
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		//avoiding duplicates excel data
		java_utility jr = new java_utility();
		  int rannum=  jr.getRandom();
		   
		 
			   
			   Excel_utility  ex = new Excel_utility();
			String data =   ex.ExcelValues("Manikanta", 0, 1)+rannum;
			   
			   driver.findElement(By.name("campaignname")).sendKeys(data);
			   
			   driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			   
			   verification_campaign_title vrc = new verification_campaign_title(driver);
			    vrc.verfyproduct(driver, data);
			   
			   
			   
			   driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			   //pulled 
			   //pushed the code
			 
	}

}
