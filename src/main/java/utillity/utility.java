package utillity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import constant.APS_contsant;
import org.openqa.selenium.WebDriver;


public class utility {

	static Properties properties;
	static InputStream input;

	static WebDriver driver;

	
	public static Properties loadProperties(String path) {
		try {
			input = new FileInputStream(path);
			properties = new Properties();
			properties.load(input);
			return properties;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public static void Load_properties() {
		APS_contsant.URL = properties.getProperty("url");
		APS_contsant.USERNAME = properties.getProperty("username");
		APS_contsant.PASSWORD = properties.getProperty("password");
		APS_contsant.BROWSER = properties.getProperty("browser");

	}

}
