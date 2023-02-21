package TestCases;

import actionHelper.WebActionHelperMethods;

import driverManager.DriverManagerType;
import driverManager.WebDrivers;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.constant.APS_contsant;

import Pages_objects.Employeepage;
import Pages_objects.LoginPage;
import util.utility;

import java.util.Properties;

public class BaseTest {

	static LoginPage loginPage;
	static Employeepage Emply_page;

	public WebDriver driver;
	static Properties properties;

@BeforeSuite(groups = "unit")
	public void setUp() {

		try {
			Properties_setup();
			utility.Load_properties();
			PropertyConfigurator.configure(System.getProperty("user.dir") + APS_contsant.LOG4J);

			driver = WebDrivers.getDriver(DriverManagerType.CHROME);
			loginPage = new LoginPage(driver);
			Emply_page = new Employeepage(driver);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterSuite
	public void destroyDriver() throws InterruptedException {

		// driver.quit();
	}

	public void Properties_setup() {
		String propertyPath = System.getProperty("user.dir") + APS_contsant.CONFICPATH;
		properties = utility.loadProperties(propertyPath);
	}
}