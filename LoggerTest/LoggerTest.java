package myPackage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//import org.apache.logging.log4j.core.config.Configurator;

public class LoggerTest {
	public static void main(String[] args) {
		Logger log = LogManager.getLogger(LoggerTest.class);
		PropertyConfigurator.configure("log4j.properties");
		log.error("Error Message");
	}
}
