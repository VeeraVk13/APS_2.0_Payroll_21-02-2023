package Pages_objects;

import actionHelper.WebActionHelperMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.constant.APS_contsant;

public class LoginPage extends BasePageClass {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement usernamer;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//span[normalize-space()='Login']")
	WebElement loginBtn;

	public void Logindetails(String user, String pass) throws InterruptedException {
		webActionHelperMethods.MaximizeBrowser();
		webActionHelperMethods.clickbutton(usernamer);
		webActionHelperMethods.highlight(usernamer);
		usernamer.sendKeys(user);
		Thread.sleep(APS_contsant.threatsleep);
		webActionHelperMethods.highlight(password);
		webActionHelperMethods.clickbutton(password);
		password.sendKeys(pass);
		Thread.sleep(APS_contsant.threatsleep);
		webActionHelperMethods.highlight(loginBtn);
		webActionHelperMethods.clickbutton(loginBtn);
		

	}

}
