package object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class verification_campaign_title {
	
	public  verification_campaign_title(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement productTitle;

	public WebElement getProductTitle() {
		return productTitle;
	}
	
	
	public void verfyproduct(WebDriver driver, String data)
	{
		 if(productTitle.getText().contains(data))
		 {
			 System.out.println("verification is passed");
			 
		 }
		 else
		 {
			 System.out.println("verification is failed");
		 }
	}


}
