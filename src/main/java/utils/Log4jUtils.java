package utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4jUtils {

	private static Logger logger;

	private Log4jUtils() {
		// Private constructor to prevent instantiation
	}

	public static Logger getLogger(Class<?> className) {
		if (logger == null) {
			logger = LogManager.getLogger(className);
		}
		return logger;
	}

	public static void info(String message) {
		logger.info(message);
	}

	public static void warn(String message) {
		logger.warn(message);
	}

	public static void error(String message) {
		logger.error(message);
	}

	public static void debug(String message) {
		logger.debug(message);
	}
}
