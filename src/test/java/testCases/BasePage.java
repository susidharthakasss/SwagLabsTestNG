
package testCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePage {
	WebDriver driver;

	@BeforeMethod
	public void browserLaunch() throws MalformedURLException {

		String DriverType = System.getProperty("Browser");
		if (DriverType.contains("firefox")) {

			driver = new FirefoxDriver();

		} else if (DriverType.contains("remote")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-using");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--headless");
			;
			driver = new RemoteWebDriver(new URL("http://54.163.63.255:4444/"), options);
		}

		else {

			// added some comments
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-using");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
		}

		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@AfterMethod
	public void tearDown() {

		driver.close();
	}

}
