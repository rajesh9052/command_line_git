package Generic_utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener_class_exec implements ITestListener {

	public void onTestFailure(ITestResult result) {
		 
		String testName = result.getMethod().getMethodName();
		System.out.println("Execution started");
		
		EventFiringWebDriver event =new EventFiringWebDriver(Base_class.sdriver);
		
		
		   String datename = new SimpleDateFormat("yyyy-MM-dd_(hh-mm-ss)").format(new Date());

		File src = event.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+testName+"_"+datename+".png");
		
		
		try {
			
			
			FileUtils.copyFile(src, dest);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
