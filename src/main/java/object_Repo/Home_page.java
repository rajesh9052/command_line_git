package object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
	
	public Home_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	  private WebElement organization;
	
	@FindBy(xpath ="(//a[text()='Contacts'])[1]")
	private WebElement contact;
	
	@FindBy(xpath ="(//a[text()='Products'])[1]")
	private WebElement products;
	
	@FindBy(xpath = "(//a[text()='More'])[1]")
	
	private WebElement More;

	@FindBy(xpath ="(//a[text()='Campaigns'])[1]")
	private WebElement campaign;
	
	@FindBy(xpath ="(//a[text()='Sales Order'])[1]")
	private WebElement saleOrder;

	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement imgsignout;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutButton;
	
	
	//Getter methods for the webelements
	
	public WebElement getImgsignout() {
		return imgsignout;
	}

	public WebElement getSignoutButton() {
		return signoutButton;
	}

	public WebElement getSaleOrder() {
		return saleOrder;
	}

	public WebElement getCampaign() {
		return campaign;
	}

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getContact() {
		return contact;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getMore() {
		return More;
	}
	
	//for clicking on Organization
	public void organization_click()
	{
		 organization.click();
	}
	
	public void contact_click()
	{
		contact.click();
	}
	
	public void product_click()
	{
		products.click();
	}
	
	public void More_campaign()
	{
		More.click();
		campaign.click();
	}
	
	public void More_saleorder()
	{
		More.click();
		saleOrder.click();
	}
	
	public void signoutapp()
	{
		imgsignout.click();
		signoutButton.click();
	}
	
	
}
