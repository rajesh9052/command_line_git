package object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	//initialization
	public Login_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath ="//input[@name='user_name']")
	private WebElement usernametext;
	
	@FindBy(xpath ="//input[@name='user_password']")
	private WebElement passwordtext;
	
	@FindBy(xpath ="//input[@id='submitButton']")
	private WebElement loginButton;

	public WebElement getUsernametext() 
	{
		return usernametext;
	}

	public WebElement getPasswordtext() {
		return passwordtext;
	}

	
	public WebElement getLoginButton() {
		return loginButton;
	}

	public void loginApp(String username, String password)
	{
		usernametext.sendKeys(username);
		passwordtext.sendKeys(password);
		loginButton.click();
	}

	
	


}
