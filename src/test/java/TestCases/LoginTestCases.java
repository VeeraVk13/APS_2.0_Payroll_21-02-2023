package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.log4j.Logger;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.constant.APS_contsant;

public class LoginTestCases extends BaseTest {

	static Logger log = Logger.getLogger(LoginTestCases.class);

	@Test(groups = "unit")
	public void Login_to_DashBoard() throws Exception {

		log.info("Get the URL");
		driver.get(APS_contsant.URL);
		String CurrentURL = driver.getCurrentUrl().toString();
		String AcutalUrl = APS_contsant.URL;
		log.info("checking the url is equal or not   " + CurrentURL);
		AssertJUnit.assertEquals(AcutalUrl, CurrentURL);
		log.info("sending the username =   " + APS_contsant.USERNAME + " and password=   " + APS_contsant.PASSWORD);
		loginPage.Logindetails(APS_contsant.USERNAME, APS_contsant.PASSWORD);

	}

}