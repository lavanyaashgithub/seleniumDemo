package framework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponents.Abstractcomponent;


	public class Orderpage extends Abstractcomponent{
		WebDriver driver;

		  public Orderpage(WebDriver driver) 
		  {
			  super(driver);
			  this.driver=driver;
			  PageFactory.initElements(driver, this);
			  
		  }
			@FindBy(css="tr td:nth-child(3)")
			List<WebElement> productName;
			
			public boolean VerifyOrderDisplay( String productname)
			{
				boolean match=productName.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(productname));
				return match;
			}

}
