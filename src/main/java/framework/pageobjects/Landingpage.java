package framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponents.Abstractcomponent;

public class Landingpage extends Abstractcomponent {
	WebDriver driver;

  public Landingpage(WebDriver driver) 
  {
	  super(driver);
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
	  
  }
	@FindBy(id="userEmail")
	WebElement useremail;
	@FindBy(id="userPassword")
	WebElement userpassword;
	@FindBy(id="login")
	WebElement submit;
	@FindBy(css="[class*='flyInOut']")
	WebElement ErrorMsg;
	
							//.ng-tns-c4-34.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	public Productcatalog loginapplication(String email,String password)
	{
		useremail.sendKeys(email);
		userpassword.sendKeys(password);
		submit.click();
		Productcatalog pc=new  Productcatalog(driver);
		return pc;
		
	}
	public String getErrorMessage()
	{
		waitForwebElementToAppear(ErrorMsg);
		return ErrorMsg.getText();
		
	}
	public void Goto()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	

	
			 

}
