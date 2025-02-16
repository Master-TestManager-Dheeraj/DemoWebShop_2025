package drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static final Logger log = LogManager.getLogger(DriverFactory.class);

	public static WebDriver createDriver() {
		WebDriver driver = null;
		String browser = "";
		log.info("Creating WebDriver for browser: " + browser);
		
		// Set default browser to Chrome if not provided or empty
        if (browser == null || browser.isEmpty()) {
            browser = "chrome";
            log.info("Creating WebDriver for browser failed so creating Chrome Browser: " + browser);
        }

		try {
			switch (browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromiumdriver().setup();
				driver = new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "firefox":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			default:
				throw new IllegalArgumentException("Invalid browser name: " + browser);
			}
		} catch (Exception e) {
			log.error("Error while creating WebDriver for browser: " + browser, e);
			throw new RuntimeException("Failed to initialize the browser", e);
		}

		return driver;
	}
}