package object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class create_campaign {
	
	public create_campaign(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//img[@title='Create Campaign...']")
	private WebElement campIMG;
	
	@FindBy(name = "campaignname")
	private WebElement cmpnametxt;
	
	@FindBy(xpath ="//img[@alt='Select']")
	private WebElement prdctinputwinIMG;
	
	@FindBy(xpath ="//input[@id='search_txt'")
	private WebElement txtchild;
	
	@FindBy(xpath ="//input[@type='button']")
	private WebElement searchild;
	
		
	
	
	

}
