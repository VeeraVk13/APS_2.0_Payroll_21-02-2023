package Pages_objects;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class Employeepage extends BasePageClass {

	static Logger log = Logger.getLogger(Employeepage.class);

	public Employeepage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//span[@class='menu-item ng-tns-c66-7']")
	WebElement Adminsetting;
	@FindBy(xpath = "//button[@class='menu-list-item ng-tns-c65-9']")
	WebElement client;
	@FindBy(xpath = "//span[@class='menu-item ng-tns-c65-10']")
	WebElement company;

	@FindBy(xpath = "//a[normalize-space()='Add Client']")
	WebElement Add_Client;
	@FindBy(xpath = "//img[@src='/assets/Images/close-icon-white.svg']")
	WebElement close_btn;
	@FindBy(xpath = "//a[normalize-space()='Add Company']")
	WebElement Add_Company;
	@FindBy(xpath = "//a[normalize-space()='Add Client']")
	WebElement company_close_btn;
	@FindBy(xpath = "//button[@class='menu-list-item ng-tns-c66-5']")
	WebElement setting;

	public void Empy_screen() throws Exception {

		webActionHelperMethods.elementToBeClickable(Adminsetting);

	}

	public void setting() throws Exception{
		webActionHelperMethods.elementToBeClickable(setting);

	}

}
