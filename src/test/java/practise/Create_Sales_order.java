package practise;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_utility.Base_class;
import Generic_utility.Excel_utility;
import Generic_utility.File_utility;
import Generic_utility.Webdriver_utility;
import Generic_utility.java_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import object_Repo.Home_page;
import object_Repo.Login_page;

public class Create_Sales_order extends Base_class
{ @Test()
	public void create_sale() throws Exception {
		File_utility fi = new File_utility();
		  
		 
		  
		
		
		// driver.manage().window().maximize();
		 //utility methods 
		 Webdriver_utility wb = new Webdriver_utility();
		 Excel_utility ex = new Excel_utility();
		 java_utility ja = new java_utility();
		
		  
		 
         wb.maximizeScreen(driver);
		  
		
		 
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		 Thread.sleep(2000);
		 
		 
		 
		 
		  Home_page ho = new Home_page(driver);
		   ho.More_saleorder();
		   
		 driver.findElement(By.xpath("//img[@alt='Create Sales Order...']")).click();
		 
		 driver.findElement(By.xpath("(//img[@alt='Select'])[3]")).click();
		 
		/* Set<String> win =  driver.getWindowHandles();
		  Iterator<String> t1 = win.iterator();
		  while(t1.hasNext())
		  {
			  String w =  t1.next();
			      driver.switchTo().window(w);
			   String title =   driver.getTitle();
			   
			     if(title.contains("Contacts&action"))
			     { break;
			     
			     }
		  }*/
		 //hardAssert 
		   Assert.assertEquals(false, true);
		   
		 wb.switchToWindow(driver,"Contacts&action");
		  driver.findElement(By.linkText("Rajesh72 Rajesh72")).click();
		  
		 // Alert alt = driver.switchTo().alert();
		   //    alt.accept();
		   wb.switchToAlertAndAccept(driver);
		       
		       Thread.sleep(2000);
		     /*  Set<String > win1 = driver.getWindowHandles();
		         Iterator<String> t2 = win1.iterator();
		         while(t2.hasNext())
		         {
		        	String w1 = t2.next();
		        	     driver.switchTo().window(w1);
		        	String tit2 =     driver.getTitle();
		        	if(tit2.contains("8888/index.php?module=SalesOrder&action="))
		        	{
		        		break;
		        	}
		         }*/
		       wb.switchToWindow(driver, "8888/index.php?module=SalesOrder&action=");
		       
	}

}
