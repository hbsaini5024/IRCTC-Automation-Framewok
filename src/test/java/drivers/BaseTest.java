package drivers;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class BaseTest {
	
	protected WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void browserSetup(String browser) {
		
		Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);

        ChromeOptions options = new ChromeOptions();
        EdgeOptions options1 = new EdgeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-blink-features=AutomationControlled");
        
        options1.setExperimentalOption("prefs", prefs);
        options1.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options1.setExperimentalOption("useAutomationExtension", false);
        options1.addArguments("--disable-blink-features=AutomationControlled");
        

        if(browser.equalsIgnoreCase("chrome")) {
        	driver = new ChromeDriver(options);
        }else if(browser.equalsIgnoreCase("edge")) {
        	System.setProperty("webdriver.edge.driver", "D:\\edgedriver_win64\\msedgedriver.exe");
//        	driver = new EdgeDriver(options1);
        	driver = new EdgeDriver(options1);
        }
        
		
		((JavascriptExecutor) driver).executeScript(
			    "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
//		driver = new EdgeDriver(options1);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@AfterTest
	public void closeBrowser() {
		
		driver.close();
	}

}
