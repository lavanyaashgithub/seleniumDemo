package Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import framework.pageobjects.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public  WebDriver driver;
	public  Landingpage lp;

	@Test
		public  WebDriver intializeDriver() throws IOException
		{
		Properties prop =new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\LENOVO\\eclipse\\framework\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
	
	if(browserName.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		driver.manage().window().maximize();
	}
	else if(browserName.equals("Firefox"))
	{
		
	}
	else if(browserName.equals("IE"))
	{
		
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
	driver.manage().window().maximize();
	return driver;
		}
	public List<HashMap<String, String>> getjsonDataToMap(String filepath) throws IOException
	{
		String Jsoncontent=FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>>	data=mapper.readValue(Jsoncontent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
     public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
     {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File Source=ts.getScreenshotAs(OutputType.FILE);
        File file= new File(System.getProperty("user.dir")+"//reports//"+testCaseName+"//.png");
    	FileUtils.copyFile(Source, file);
    	return System.getProperty("user.dir")+"//reports//"+testCaseName+"//.png";
     }
	@BeforeMethod(alwaysRun=true)
	public Landingpage LaunchApplication() throws IOException
	{
		driver=intializeDriver();
		lp=new Landingpage(driver);
		lp.Goto();
		return lp;
		
	}
	@AfterMethod(alwaysRun=true)
	public void TearDown()
	{
		driver.close();
	}


	}


