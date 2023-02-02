package Test_Ng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class v_tig {
	
   @Test(dataProvider ="data_provider")
	public void company_detail(String name, String pass ) throws InterruptedException 
	{
	    System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	    
	    WebDriver driver = new ChromeDriver();
	      driver.get("https://demo.actitime.com/login.do");
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      driver.findElement(By.xpath("//input[@id='username']")).sendKeys(name);
	      driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(pass);
	      driver.findElement(By.xpath("//div[text()='Login ']")).click();
	      Thread.sleep(2000); 
	      driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
	
	
	@DataProvider
	public Object[][] data_provider()
	{
		Object[][] obj = new Object[2][2];
		
	       obj[0][0] = "admin"; 
	       obj[0][1] = "manager";
	       
	       
	       obj[1][0] = "trainee"; 
	       obj[1][1] = "trainee";
	       return obj;
	       
	       
	       
	        
		
	}

}
