package drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DriverManager {
	private static final Logger logger = LogManager.getLogger(DriverManager.class);
	private DriverManager() {};
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	private static DriverManager DriverManagerInstance;

	//Getter method to access the private DriverManagerInstance
	public static DriverManager getinstance() {
		if (DriverManagerInstance == null) {
			synchronized (DriverManager.class) {
				if (DriverManagerInstance == null) {
					DriverManagerInstance = new DriverManager();
				}
			}
		}
		return DriverManagerInstance;
	}

}
