package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.constant.APS_contsant;

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
