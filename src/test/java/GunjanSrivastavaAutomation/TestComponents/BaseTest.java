package GunjanSrivastavaAutomation.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import GunjanSrivastavaAutomation.pageObjects.LandingPage;
import GunjanSrivastavaAutomation.resoucres.LocatorConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties(); 
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/main/java/GunjanSrivastavaAutomation/resoucres/GlobalData.properties");
		prop.load(fis); 
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) { 
			options.addArguments("headless"); 
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900)); 
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/gunjansrivastava/Documents/Automation/BrowserDrivers exes/geckodriver");
			driver = new FirefoxDriver();
		} 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		return driver;

	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {

		driver = initializeDriver();
		landingPage = new LandingPage(driver); 
		landingPage.goTo("https://www.google.com/"); 
		LocatorConfig.getLocatorFromJson();
		return landingPage;
	}

	@AfterMethod(alwaysRun = true)
	public void closeDriver() {
		driver.close();
	}

	public List<HashMap<String, String>> getJsonDataToString(String filePath) throws IOException {
		
		String jsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper(); 
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
    	
    			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    			File destn = new File(System.getProperty("user.dir") + "/reports/" + testCaseName + ".png");
    			FileUtils.copyFile(src, destn);
    			return System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
    }
	
}
