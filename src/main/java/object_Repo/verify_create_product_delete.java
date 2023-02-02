package object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class verify_create_product_delete {
	
	public verify_create_product_delete(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath ="//span[@class='lvtHeaderText']")
	 private WebElement productver;
	 
	
	 
	 @FindBy(xpath ="//span[@class='genHeaderSmall']")
	 private WebElement notfound;

	public WebElement getNotfound() {
		return notfound;
	}

	

	public WebElement getProductver() {
		return productver;
	}
	 
	 public void productverifcation(WebDriver driver, String data)
	 {     String exp ="productver.getText()";
	       String act = data;
		 Assert.assertEquals(act, exp);
//		   if(productver.getText().contains(data))
//		   {
//			   System.out.println("verification is successfull");
//		   }
//		   else
//		   {
//			   System.out.println("verification is failed");
//			   
//		   }
	 }
	 
	 public void not(WebDriver driver)
	 {
		 if(notfound.isDisplayed())
		 {
			 System.out.println("delete process is success");
			 
		 }
		 else
		 {
			 System.out.println("delete process is failed");
		 }
	 }
	 
	
	 
	 

}
