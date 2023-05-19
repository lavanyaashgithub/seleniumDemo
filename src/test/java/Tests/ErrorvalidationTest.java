package Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Testcomponents.BaseTest;
import Testcomponents.Retry;
import framework.pageobjects.Cartpage;
import framework.pageobjects.Checkoutpage;
import framework.pageobjects.ConfirmationPage;
import framework.pageobjects.Productcatalog;

public class ErrorvalidationTest extends BaseTest {
//public WebDriver driver;
	@Test(groups= {"Errorhandling"},retryAnalyzer=Retry.class)
	public void loginError() throws InterruptedException, IOException {

		String productname = "ZARA COAT 3";

		String produc = "carrot";

		String product = "apple";

		lp.loginapplication("aswinithumala@gmail.com", "Aswini123");
		lp.getErrorMessage();
		Assert.assertEquals("Incorrect email or password.", lp.getErrorMessage());
	

	}
	@Test
	public void Errorproduct() throws InterruptedException, IOException {

		String productname = "ZARA COAT 3";
		String product = "apple";
		int as= 569;
		int sw= 105;
		Productcatalog pc = lp.loginapplication("anshika@gmail.com", "Iamking@000");
		List<WebElement> products = pc.getproductlist();
		pc.getproductname(productname);
		pc.AddToCart(productname);
		pc.GoToCartPage();
		Cartpage cp = new Cartpage(driver);
		boolean match = cp.VerifyProductsDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
