package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager; //log4j2
import org.apache.logging.log4j.Logger;//log4j2
import org.apache.poi.ss.formula.atp.Switch;


public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
		
//		loading properties file
//		FileReader file = new FileReader(".//src//test//resources//config.properties");
		FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);
		
//		loading log4j2 file
		logger  = LogManager.getLogger(this.getClass()); //log4j2
		
//		loading differemt browser
		switch(br.toLowerCase()) {
			case "edge": driver = new EdgeDriver(); break;
			case "chrome": driver = new ChromeDriver(); break;
			default: System.out.println("NO browser matching");
						return;
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://demo.opencart.com/");
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
		
	}
	
//	@AfterClass
//	public void tearDown() {
//		
//		driver.close();
//	}
	
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String randomeAlphaNumberic() {
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (str+"@"+num);
	}
	
	
}
