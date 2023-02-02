package object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class create_product {
	
	public create_product(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//img[@alt='Create Product...']")
	private WebElement prodIMG;
	
	@FindBy(name ="productname")
	private WebElement prodtxt;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveB;
	
	@FindBy(xpath ="//input[@title='Delete [Alt+D]']")
	private WebElement deleteB;
	
	@FindBy(xpath ="//input[@class='txtBox']")
	private WebElement searchpro;
	
	@FindBy(xpath = "(//select[@name='search_field'])[1]")
	private WebElement prodrop;
	
	@FindBy(xpath ="(//input[@type='button'])[1]")
	private WebElement searchB;
	
	//getter methods

	public WebElement getSearchB() {
		return searchB;
	}

	public WebElement getProdrop() {
		return prodrop;
	}

	public WebElement getSearchpro() {
		return searchpro;
	}

	public WebElement getProdIMG() {
		return prodIMG;
	}

	public WebElement getProdtxt() {
		return prodtxt;
	}

	public WebElement getSaveB() {
		return saveB;
	}

	public WebElement getDeleteB() {
		return deleteB;
	}
	
	//Business Logic
    public void clickprdctImg()
    {
    	prodIMG.click();
    }
    
    public void prodtxt(String data)
    {
    	 prodtxt.sendKeys(data);
    	
    }
	
    public void save()
    {
    	saveB.click();
    }
	
    public void delet()
    {
    	deleteB.click();
    }
    
    public void searchprodu(WebDriver driver, String data)
    {
    	searchpro.sendKeys(data);
    	
    }
    
    public void prodropdown(WebDriver driver, String text)
    {
    	Select s = new Select(prodrop);
    	  s.selectByVisibleText(text);
    }
    
    public void searchbutton(WebDriver driver)
    {
    	 searchB.click();
    }
    
    
	
	
	

}
