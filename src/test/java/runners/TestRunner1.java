package runners;

import java.io.File;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		

features= {"src/test/resources/Dummy.feature"},
glue= {"step"},
plugin={"com.cucumber.listener.ExtentCucumberFormatter:"})
public class TestRunner1
{
	
	@BeforeClass
	public static void setup() {
		Random rand = new Random();
		 int rand_int1 = rand.nextInt(1000); 
	    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    extentProperties.setReportPath("report/html/ExtentReport"+".html");
	}	
	

@AfterClass
public static void setup2()
{
	System.out.println("HELLLLLLLLO");
Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
}
}
