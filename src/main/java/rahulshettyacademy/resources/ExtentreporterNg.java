package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreporterNg {
 
	public static ExtentReports getextentobject()
	{

		String  path =System.getProperty("user.dir")+"//reports//index.html";
		  ExtentSparkReporter reporter = new  ExtentSparkReporter(path);
		  reporter.config().setReportName("webAutomation Results"); 
		  reporter.config().setDocumentTitle("test Results");
		  ExtentReports  extent = new ExtentReports();
		  extent.attachReporter(reporter);
		  extent.setSystemInfo("tester", "aswini");
		  return extent;
	       
	   
	}

}
