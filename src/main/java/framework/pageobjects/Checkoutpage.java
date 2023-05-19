package framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponents.Abstractcomponent;

public class Checkoutpage extends Abstractcomponent{
	WebDriver driver;

	  public Checkoutpage(WebDriver driver) 
	  {
		  super(driver);
		  this.driver=driver;
		  PageFactory.initElements(driver, this);
		  
	  }
	  @FindBy(css="[placeholder='Select Country']")
	  WebElement country;
	  @FindBy(css="button[class*='ta-item']:last-of-type")
	  WebElement selectcountry;
	  @FindBy(css=".action__submit")
	  WebElement submit;
	By results = By.cssSelector(".ta-results");
	
	  
	 public void selectcountry(String countryname)
	 {
		  Actions a=new Actions(driver);
		  a.sendKeys(country,countryname).build().perform();
		 // Thread.sleep(3000);
		  waitForElementToAppear(results);
		  selectcountry.click();
	 }
	 public ConfirmationPage submitorder() throws InterruptedException
	 {

		 JavascriptExecutor js =( JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		 submit .click();
		 ConfirmationPage ConfirmationPage = new ConfirmationPage(driver);
		 return ConfirmationPage;
	 }

}
