package Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Testcomponents.BaseTest;
import framework.pageobjects.Cartpage;
import framework.pageobjects.Checkoutpage;
import framework.pageobjects.ConfirmationPage;
import framework.pageobjects.Landingpage;
import framework.pageobjects.Orderpage;
import framework.pageobjects.Productcatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";
	
	@Test(dataProvider="getData",groups="purchase")
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {
     	Productcatalog pc = lp.loginapplication(input.get("email"),input.get("password"));
		List<WebElement> products = pc.getproductlist();
		pc.AddToCart(input.get("product"));
		Cartpage cp=pc.GoToCartPage();
		boolean match = cp.VerifyProductsDisplay(input.get("product"));
		Assert.assertTrue(match);
		Checkoutpage Checkoutpage = cp.gotocheckout();
		Checkoutpage.selectcountry("india");
		ConfirmationPage ConfirmationPage = Checkoutpage.submitorder();
		String confirmationmessage = ConfirmationPage.getconfirmationmessage();
		Assert.assertEquals(confirmationmessage, "THANKYOU FOR THE ORDER.");

	}
	@Test(dependsOnMethods= {"submitOrder"})
	public void OderHistory()
	{
		Productcatalog pc = lp.loginapplication("anshika@gmail.com", "Iamking@000");
		Orderpage Orderpage=pc.GoToOderPage();
		Assert.assertTrue( Orderpage.VerifyOrderDisplay(productName));
	}
	
   @DataProvider
   public Object[][] getData() throws IOException
   {
	 
	List<HashMap<String,String>>  data= getjsonDataToMap( "C:\\Users\\LENOVO\\eclipse\\framework\\src\\test\\java\\rahulshettyacademy\\data\\purchaseorder.json");
	return new Object[][] {{data.get(0)},{data.get(1)}};
	   
   }
}
//return new Object[][] {{"shetty@gmail.com","Iamking@000","IPHONE 13 PRO"},{"aswinithumala@gmail.com","Aswini@123","ZARA COAT 3"}};
  // HashMap<String, String> map=new HashMap<String,String> ();
 //  map.put("email", "shetty@gmail.com");
 //  map.put("password", "Iamking@000");
 //  map.put("product", "IPHONE 13 PRO");
//   HashMap<String, String> map1=new HashMap<String,String> ();
 //  map1.put("email", "anshika@gmail.com");
 //  map1.put("password", "Iamking@000");
  // map1.put("product", "ZARA COAT 3");
