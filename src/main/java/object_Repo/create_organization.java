package object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_utility.Excel_utility;

public class create_organization {
	//Initialization
	public create_organization(WebDriver driver)
	{
		 PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement imgclick;
	
	@FindBy(xpath ="//input[@name='accountname']")
	private WebElement inputtext;
	
	@FindBy(xpath = "(//input[@name='button'])[1]")
	private WebElement saveButton;

	//getter method
	public WebElement getImgclick() {
		return imgclick;
	}

	public WebElement getInputtext() {
		return inputtext;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Business logic
	public void clickIMG()
	{
		imgclick.click();
	}
	
	public void txtbox(String data)
	{    
	      
		inputtext.sendKeys(data);
	}
	
	public void saving()
	{
		saveButton.click();
	}

}
