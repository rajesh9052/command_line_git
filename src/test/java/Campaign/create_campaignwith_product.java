package Campaign;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_utility.File_utility;
import Generic_utility.Webdriver_utility;
import Generic_utility.java_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import object_Repo.Home_page;
import object_Repo.Login_page;

public class create_campaignwith_product {
	public static void main(String[] args) throws Exception {
		File_utility fi = new File_utility();
		  
		  String Browser =  fi.getKeyandValue("browser");
		  
		  WebDriver driver;
		  
		  if(Browser.equalsIgnoreCase("chrome"))
		  {
			   WebDriverManager.chromedriver().setup();
			    driver = new ChromeDriver();
		  }
		  else if(Browser.equalsIgnoreCase("firefox"))
		  {
			   WebDriverManager.firefoxdriver().setup();
			   driver = new FirefoxDriver();
		  }
		  else if(Browser.equalsIgnoreCase("edge"))
		  { 
			  WebDriverManager.edgedriver().setup();
			  driver = new EdgeDriver();
			  
			  
		  }
		  else
		  {
			  driver = new ChromeDriver();
		  }
		
		Webdriver_utility wb  = new Webdriver_utility();
		  wb.maximizeScreen(driver);

		  // File_utility fi = new File_utility();
			String	ur =    fi.getKeyandValue("url");
			  String user = fi.getKeyandValue("username");
			  String pass = fi.getKeyandValue("password");
		 
		 driver.get(ur);
		 
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  wb.waitForpageToload(driver);
		  Login_page lo = new Login_page(driver);
		   lo.loginApp(user, pass);
		   
		 Thread.sleep(2000);
		  System.out.println(driver.getTitle());
		    Home_page ho = new Home_page(driver);
		    ho.product_click();
		
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		//avoiding duplicates excel data
		java_utility jr = new java_utility();
		  int rannum=  jr.getRandom();
		   
		  FileInputStream exfis = new FileInputStream("./src/test/resources/rajesh.xlsx");
			 Workbook book = WorkbookFactory.create(exfis);
			 Sheet sh = book.getSheet("Manikanta");
			  Row r = sh.getRow(0);
			   Cell c = r.getCell(1);
			   String data =   c.getStringCellValue()+rannum;
			   
			   driver.findElement(By.name("productname")).sendKeys(data);
			   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			   
			   Thread.sleep(200);
			   String parent =	 driver.getWindowHandle();
				  ho.More_campaign();
				driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
				
				 driver.findElement(By.name("campaignname")).sendKeys("rajesh");
				 driver.findElement(By.xpath("//img[@alt='Select']")).click();
				 
				 Thread.sleep(3000);
			
			    Set<String> chile =  driver.getWindowHandles();
			    
			    for(String allid : chile)
			    {
			    	if(!allid.equals(parent))
			    	{  driver.switchTo().window(allid);
			    	    System.out.println( driver.getTitle());
			    	      
			    	    Thread.sleep(3000);
			    	    driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(data);
			    	     Thread.sleep(2000);
			    	    driver.findElement(By.xpath("//input[@type='button']")).click();
			    	    
			    	    Thread.sleep(2000);
			    		
			    		driver.findElement(By.linkText(data)).click();
			    		
			    	 }
			    	
			    }
			    driver.switchTo().window(parent);
			    driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
			    driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			    driver.findElement(By.linkText("Sign Out")).click();
	}

}
