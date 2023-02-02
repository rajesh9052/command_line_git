package Generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import object_Repo.Home_page;
import object_Repo.Login_page;

public class Base_class {
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(alwaysRun = true)
	public void BS()
	{
		System.out.println("Database connection");
		
	}
	@BeforeTest(alwaysRun = true)
	public void BT()
	{
		System.out.println("Paralllel Execution");
	}
	
	// @Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void BC() throws Exception
	{
		File_utility fi = new File_utility();
		
		String Browser =  fi.getKeyandValue("browser");
		  
		
		  
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
		sdriver = driver;
	}
	@BeforeMethod(alwaysRun = true)
	public void BM() throws Exception
	{  File_utility fi = new File_utility();
		String	ur =    fi.getKeyandValue("url");
		  String user = fi.getKeyandValue("username");
		  String pass = fi.getKeyandValue("password");
		  
		  driver.get(ur);
		  Login_page lo =new Login_page(driver);
		   lo.loginApp(user, pass);
	}
	@AfterMethod(alwaysRun = true)
	public void AM()
	{
		System.out.println("logout application");
	}
	@AfterClass(alwaysRun = true)
	public void AC()
	{      Home_page ho = new Home_page(driver);
		 ho.signoutapp();
	}
	@AfterTest(alwaysRun = true)
	public void AT()
	{
		System.out.println("Excetion done");
		
	}
	@AfterSuite(alwaysRun = true)
    public void AS()
    {
    	System.out.println("close data base connection");
    }
}
