package StepDefinations;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Testcomponents.BaseTest;
import framework.pageobjects.Cartpage;
import framework.pageobjects.Checkoutpage;
import framework.pageobjects.ConfirmationPage;
import framework.pageobjects.Landingpage;
import framework.pageobjects.Productcatalog;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImp extends BaseTest {
	 public Landingpage lp;
	 public Productcatalog pc;
	 public  Cartpage cp;
	 public ConfirmationPage ConfirmationPage;
	  @Given("I landed on ecommerce page")
	    public void i_landed_on_ecommerce_page() throws Throwable {
		  lp =LaunchApplication();
	      
	    }

	    @Given("^logged in username (.+) and password (.+)$")
	    public void logged_in_username_and_password(String name, String password) throws Throwable {
	    	 pc = lp.loginapplication(name,password);
	    }

	    @When("^I add product (.+) to cart$")
	    public void i_add_product_to_cart(String productName) throws Throwable {
	    	List<WebElement> products = pc.getproductlist();
			pc.AddToCart(productName);
	    }
	    @And("^checkout (.+) and submit the order$")
	    public void checkout_and_submit_the_order(String productName) throws Throwable {
	    	Cartpage cp=pc.GoToCartPage();
			boolean match = cp.VerifyProductsDisplay(productName);
			Assert.assertTrue(match);
			Checkoutpage Checkoutpage = cp.gotocheckout();
			Checkoutpage.selectcountry("india");
			 ConfirmationPage = Checkoutpage.submitorder(); 
	    }


	

	    @Then("^\"([^\"]*)\" message is displayed on confirmation page$")
	    public void something_message_is_displayed_on_confirmation_page(String strArg1) throws Throwable {
	    	String confirmationmessage = ConfirmationPage.getconfirmationmessage();
	    	Assert.assertTrue(confirmationmessage.equalsIgnoreCase(strArg1));
			
	    }
	    @Then("^\"([^\"]*)\" message is displayed $")
	    public void something_message_is_displayed(String strArg1) throws Throwable {
	    	Assert.assertEquals(strArg1, lp.getErrorMessage());
	    }
}
