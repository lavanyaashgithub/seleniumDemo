package framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponents.Abstractcomponent;

public class Productcatalog extends Abstractcomponent{
	



	WebDriver driver;
	
	public Productcatalog(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	    @FindBy(css=".col-sm-10") 
	List   < WebElement > products;
	
	
	By addtocart =By.cssSelector(".card-body button:last-of-type");
	By productBy=By.cssSelector(".col-sm-10");
	By Spinner =By.cssSelector(".la-3x");
	By toastmsg=By.cssSelector(".toast-container");
	public List<WebElement> getproductlist()
	{
		waitForElementToAppear(productBy);
		return  products;
		
	}//.col-lg-4 h5
	 public WebElement getproductname(String productName)
	 {
           WebElement prob= products.stream().filter
	     (product-> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
                      return prob;
	 }
	 public void AddToCart(String productName) throws InterruptedException
	 {
		WebElement prob=getproductname(productName);
		prob.findElement(addtocart).click();
		 waitForElementToDisappear();
		 
         
 
	 }
	 

}
