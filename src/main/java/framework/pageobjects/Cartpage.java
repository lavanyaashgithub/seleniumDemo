package framework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponents.Abstractcomponent;

public class Cartpage extends Abstractcomponent{
	WebDriver driver;

	  public Cartpage(WebDriver driver) 
	  {
		  super(driver);
		  this.driver=driver;
		  PageFactory.initElements(driver, this);
		  
	  }
	 // driver.findElement(By.cssSelector(".totalRow button")).click();
		@FindBy(css=".cartSection h3")
		List<WebElement> cartproducts;
		@FindBy(css=".totalRow button")
		WebElement checkoutEle;
		public boolean VerifyProductsDisplay( String productname)
		{
			boolean match=cartproducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(productname));
			return match;
		}
		public Checkoutpage gotocheckout()
		{
			checkoutEle.click();
			  Checkoutpage Checkoutpage= new Checkoutpage(driver);
			  return Checkoutpage;
		}

}
