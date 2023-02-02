package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_utility.File_utility;
import object_Repo.Login_page;

public class createcontact_product {
	
	
	public static void main(String[] args) throws Exception {
		
	
	 System.setProperty("window.chrome.driver", "./src/main/resources/chromedriver.exe");
	 
	 WebDriver driver = new ChromeDriver();
	 
	   File_utility fi = new File_utility();
		String	ur =    fi.getKeyandValue("url");
		  String user = fi.getKeyandValue("username");
		  String pass = fi.getKeyandValue("password");
	     
	     driver.get(ur);
	     
	    Login_page lo = new Login_page(driver);
	     lo.loginApp(user, pass);
	     
		 Thread.sleep(2000);
		 
	     
	     
	      
	 
	}

}
