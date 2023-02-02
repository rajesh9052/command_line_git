package Generic_utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_utility {
	/**
	 * this method used for maximizing the window
	 * @param driver
	 * @author Rajesh
	 */
	public void maximizeScreen(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * wait for page to load before identifying any Synchronized element in DOM
	 * @author Rajesh
	 * 
	 */
	public void waitForpageToload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * after every action it'll be wait for next action to perform
	 * @author user
	 */
	
	public void scriptTimeout(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	
	/**
	 * used to wait for element to be clickable in GUI and check for specific element for every 500 seconds
	 * @author user
	 */
	
	public void waitForElementWithCustomTimeout(WebDriver driver, WebElement Element, int pollingTime)
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
		
	}
	
	/**
	 * used to switch to any window based on window title
	 * @author user
	 */
	public void switchToWindow(WebDriver driver, String PartialWidowTitle)
	{
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		while(it.hasNext())
		{
			String wid =it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(PartialWidowTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * used to switch to AlertWindow and Accept (click on Ok Button)
	 * @author user
	 */
	
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	
	/**
	 * used to switch to AlertWindow and dismiss(click on ok Button)
	 * @author user
	 */
	
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
		
	}
	
	/**
	 * used to switch frame window based on Index
	 * @author user
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
		
	}
	
	/**
	 * used to Switch to frame window based on id or name attribute
	 * @author user
	 */
	public void switchToFrame(WebDriver driver, String id_name_Attribute)
	{
		driver.switchTo().frame(id_name_Attribute);
	}
	
	/**
	 * used to select the value from the dropDown based on Index
	 * @author user
	 */
	
	public void select(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);				
	}
	
	/**
	 * used to select the value from the dropdown based on text
	 * @author user
	 */
	public void select(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
		
	}
	
	/**
	 * used to place mouse cursor on specified element
	 * @author user
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * used to right click on specific element
	 * @author user
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act =new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void moveByOffest(WebDriver driver, int x, int y)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}

}
