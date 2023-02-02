package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

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

import Generic_utility.Excel_utility;
import Generic_utility.File_utility;
import Generic_utility.Webdriver_utility;
import Generic_utility.java_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import object_Repo.Home_page;
import object_Repo.Login_page;

public class EmptyBrowser {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		
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
		 

		//   File_utility fi = new File_utility();
			String	ur =    fi.getKeyandValue("url");
			  String user = fi.getKeyandValue("username");
			  String pass = fi.getKeyandValue("password");
		 
		 driver.get(ur);
		 
		 Webdriver_utility wb = new Webdriver_utility();
		    wb.waitForpageToload(driver);
		    
		  Login_page lo = new Login_page(driver);
		  lo.loginApp(user, pass);
		 
		   Home_page ho = new Home_page(driver);
		     ho.product_click();
		 driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		   
		 java_utility ja = new java_utility();
		  int ran =  ja.getRandom();
		   
		   Excel_utility ex = new Excel_utility();
		String data =     ex.ExcelValues("Manikanta", 0, 1)+ran;
		 
		 
		 driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(data);
		 driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		 driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		 Thread.sleep(3000);
		 
		 
		 driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		 driver.close();
		 
		   
	}

}
