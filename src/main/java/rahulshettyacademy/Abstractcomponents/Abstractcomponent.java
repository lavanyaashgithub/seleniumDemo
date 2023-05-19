package rahulshettyacademy.Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.pageobjects.Cartpage;
import framework.pageobjects.Orderpage;

public class Abstractcomponent {
	WebDriver driver;
	public Abstractcomponent( WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	@FindBy(css="[routerlink*='myorders']")
	WebElement OrderHeader;
	
	 
	public void waitForElementToAppear(By findBy)
	 {
		 WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		 w.until(ExpectedConditions.visibilityOfElementLocated(findBy)); 
	 }
	public void waitForwebElementToAppear(WebElement findBy)
	 {
		 WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		 w.until(ExpectedConditions.visibilityOf(findBy)); 
	 }
	public void waitForElementToDisappear() throws InterruptedException
	{
		// WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
	
		  // w.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
		// w.until(ExpectedConditions.invisibilityOfElementLocated(find));
		 Thread.sleep(1000);
		 
	}
	public void waitelement() throws InterruptedException
	{
		Thread.sleep(3000);
	}
	public Orderpage GoToOderPage()
	{
		OrderHeader.click();
		Orderpage Orderpage= new Orderpage(driver) ;
		return Orderpage;
	}
	public Cartpage GoToCartPage() throws InterruptedException
	{
		Thread.sleep(1000);
		cartHeader.click();
		Cartpage cp =new Cartpage(driver);
          return cp;
	}

}
