package Product;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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

import Generic_utility.Excel_utility;
import Generic_utility.File_utility;
import Generic_utility.Webdriver_utility;
import Generic_utility.java_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import object_Repo.Home_page;
import object_Repo.Login_page;
import object_Repo.create_product;
import object_Repo.verify_create_product_delete;

public class create_product_and_delete_product {
	
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
		 Excel_utility ex = new Excel_utility();
		 

		 
			String	ur =    fi.getKeyandValue("url");
			  String user = fi.getKeyandValue("username");
			  String pass = fi.getKeyandValue("password");
		 
		 driver.get(ur);
		 
		 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 wb.maximizeScreen(driver);
		 wb.waitForpageToload(driver);
		
		 Login_page lo = new Login_page(driver);
		  lo.loginApp(user, pass);
		  
		 Thread.sleep(2000);
		
		Home_page ho = new Home_page(driver);
		ho.product_click();
		
       create_product po = new create_product(driver);
       po.clickprdctImg();
  
		//avoiding duplicates excel data
		java_utility jr = new java_utility();
		  int rannum=  jr.getRandom();
		 
		   String data =   ex.ExcelValues("Manikanta", 0, 1)+rannum;
			   
			  po.prodtxt(data);
			  po.save();
			   
			   Thread.sleep(200);
			   verify_create_product_delete vp = new verify_create_product_delete(driver);
			   vp.productverifcation(driver, data);
			   
			   po.delet();
			    wb.switchToAlertAndAccept(driver);
			    Thread.sleep(3000);
			    po.searchprodu(driver, data);
			    po.prodropdown(driver, "Product Name");
			    po.searchbutton(driver);
			    
			    vp.not(driver);
			    
			    
			    ho.signoutapp();
	}

}
