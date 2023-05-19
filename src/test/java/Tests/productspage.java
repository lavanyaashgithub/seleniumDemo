package Tests;




		import java.time.Duration;
		import java.util.List;

		import org.openqa.selenium.By;
		import org.openqa.selenium.JavascriptExecutor;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
		import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.WebDriverWait;
		import org.testng.Assert;

		import io.github.bonigarcia.wdm.WebDriverManager;
		public class productspage {
		

			public static void main(String[] args) throws InterruptedException {
				// TODO Auto-generated method stub
				WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();
				//System.setProperty("webdriver.edge.driver", "C:\\Users\\LENOVO\\Downloads\\msedgedriver.exe");
				//WebDriver driver = new EdgeDriver();
				//System.setProperty("webdriver.edge.driver", "C:\\Users\\LENOVO\\Downloads\\msedgedriver.exe");
				//driver.get("https://google.com");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
				driver.manage().window().maximize();
				WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
				driver.get("https://rahulshettyacademy.com/client/");
				driver.findElement(By.id("userEmail")).sendKeys("aswinithumala@gmail.com");
				driver.findElement(By.id("userPassword")).sendKeys("Aswini@123");
				driver.findElement(By.id("login")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-sm-10")));
			   List<WebElement> products   =driver.findElements(By.cssSelector(".col-sm-10"));
			  // w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".col-sm-10")));
			  
			 WebElement item= products.stream().filter
		     (product-> product.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);
			  driver.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			   w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".la-3x")));
			 w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".toast-container")));
			  // Thread.sleep(5000);
			   driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
			List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
			boolean match=cartproducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase("IPHONE 13 PRO"));
			  Assert.assertTrue(match);
			  driver.findElement(By.cssSelector(".totalRow button")).click();
			  Actions a=new Actions(driver);
			  a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
			 // Thread.sleep(3000);
			  w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
			  driver.findElement(By.cssSelector("button[class*='ta-item']:last-of-type")).click();
			 // Thread.sleep(3000);
			 // driver.findElement(By.cssSelector(".action__submit")).click();
			  Thread.sleep(1000);
				 JavascriptExecutor js =( JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,500)");
				Thread.sleep(3000);

			  driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
			 String conformationmsg =driver.findElement(By.cssSelector(".hero-primary")).getText();
			 Assert.assertEquals(conformationmsg, "THANKYOU FOR THE ORDER.");
			  driver.close();
			  
			   
			  

			}

		


	

}
