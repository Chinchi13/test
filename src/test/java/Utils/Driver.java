package Utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.Scenario;

import java.util.concurrent.TimeUnit;

public class Driver {
	private static final String URL_SGC = "url.SGC";
	public static WebDriver driver;
	public static Scenario scenario;

	@SuppressWarnings("deprecation")
	@Before
	public static WebDriver initChromeDriver() {
		propertiesLoader pl = new propertiesLoader();
		// Explorer
		// System.setProperty("webdriver.ie.driver",
		// "win32_chromedriver_77.0.3865.40/IEDriverServer.exe");
		// driver = new InternetExplorerDriver();
	

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mirka\\Downloads\\as\\win32_chromedriver_77.0.3865.40\\chromedriver.exe");

		DesiredCapabilities i = DesiredCapabilities.chrome (); 
		i.setAcceptInsecureCerts(true);

		driver = new ChromeDriver(i);

		
		// scenario = pScenario;

		// System.setProperty("webdriver.gecko.driver",
		// "win32_chromedriver_77.0.3865.40/geckodriver.exe");
		// driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(pl.getProperty(URL_SGC));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}

	public static WebDriver quitDriver() {
		driver.close();
		driver.quit();
		return driver;	
		}

	public static WebDriver getDriver() {
		return driver;
	}

}