package object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class create_contact {
	
	public create_contact(WebDriver driver)
	{
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	 private WebElement contacIMG;
	
	@FindBy(xpath ="//input[@name='firstname']")
	 private WebElement firstxt;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastxt;
	
	@FindBy(xpath ="(//img[@align='absmiddle'])[3]")
	private WebElement inputIMG;
	
	@FindBy(xpath ="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveB;
	
	

	public WebElement getSaveB() {
		return saveB;
	}

	public WebElement getContacIMG() {
		return contacIMG;
	}

	public WebElement getFirstxt() {
		return firstxt;
	}

	public WebElement getLastxt() {
		return lastxt;
	}

	public WebElement getInputIMG() {
		return inputIMG;
	}
	
	
	public void contactIMG()
	{
		contacIMG.click();
	}
	
	public void firsttxt(String data)
	{
		firstxt.sendKeys(data);
		
	}
	
	public void lasttxt(String data)
	{
		lastxt.sendKeys(data);
		
	}
	
	public void inpIMG()
	{
		inputIMG.click();
	}
	
	public void saveButton()
	{
		saveB.click();
	}

}
