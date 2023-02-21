package Pages_objects;

import actionHelper.WebActionHelperMethods;
import constant.APS_contsant;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePageClass{

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

        usernamer.sendKeys(user);


        webActionHelperMethods.implicitlyWait();

        password.sendKeys(pass);

        webActionHelperMethods.implicitlyWait();

        loginBtn.click();
    }

}
