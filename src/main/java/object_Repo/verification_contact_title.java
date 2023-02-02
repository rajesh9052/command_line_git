package object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class verification_contact_title {
	
	public verification_contact_title(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
     @FindBy(xpath ="//span[@class='dvHeaderText']")
     private WebElement contctitle;
     
     
	public WebElement getContctitle() {
		return contctitle;
	}
	
	public void verifycontati(WebDriver driver, String data)
	{
		    if(contctitle.getText().contains(data))
		    {
		    	System.out.println("verfication of contact is passed");
		    	
		    }
		    else
		    {
		    	System.out.println("verification of contact is failed");
		    }
	}
     
     
}
