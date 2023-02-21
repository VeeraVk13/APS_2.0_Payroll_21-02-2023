package actionHelper;

import constant.APS_contsant;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebActionHelperMethods{

    private static WebDriver driver;
    static WebDriverWait wait;

    public WebActionHelperMethods(WebDriver driver) {
        this.driver = driver;

    }

    public void writeOnEditText(String data, String xpath) {
        driver.findElement(By.xpath(xpath)).sendKeys(data);
    }

    public boolean clickbutton(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
        return true;
    }

    public boolean clickbutton(WebElement xpath) {
        xpath.click();
        return true;
    }

    public void clickLink(String data) {
        driver.findElement(By.linkText(data));
    }

    public void clickImage(String data, String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public String getObjectText(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public boolean compareString(String First, String Second) {
        if (First.equalsIgnoreCase(Second)) {
            return true;
        } else
            return false;

    }

    public boolean containsString(String First, String Second) {
        if (First.contains(Second)) {
            return true;
        } else
            return false;

    }

    /**
     * This Keyword verifies the Text of an specified object on the web page. It
     * takes an object as object input argument and before & after as data input
     * arguments.
     *
     * @param Text
     * @param xpath
     * @return
     */
    public boolean verifyObjectText(String Text, String xpath) {

        return compareString(Text, driver.findElement(By.xpath(xpath)).getText());
    }

    /**
     * This keyword verifies whether the specified object exist over the given web
     * page or not. This keyword takes object as object input argument.
     *
     * @param xpath
     * @return
     */
    public boolean VerifyObjectExists(String xpath) {
        if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
            return true;

        } else {
            return false;
        }
    }

    /**
     * This keyword verifies that the provided Object is enabled on page or not.
     * This keyword is mostly used in situations where you have to provide an Object
     * and want to verify that the particular object is enabled on the page or not.
     *
     * @param xpath
     * @return
     */
    public boolean VerifyObjectEnabled(String xpath) {
        if (driver.findElement(By.xpath(xpath)).isEnabled()) {
            return true;

        } else {
            return false;
        }
    }

    /**
     * This keyword verifies that the specified object is disabled on the page.
     *
     * @param xpath
     * @return
     */
    public boolean VerifyObjectDisabled(String xpath) {
        if (driver.findElement(By.xpath(xpath)).isEnabled()) {
            return true;

        } else {
            return false;
        }
    }

    /**
     * Method is used to get Internal text
     *
     * @param xpath
     * @return
     * @author Ashish
     */
    public String getobjectValue(String xpath) {
        return driver.findElement(By.xpath(xpath)).getAttribute("value");
    }

    /**
     * This keyword clears the value of specified Edit box.
     *
     * @param xpath
     */
    public void ClearEditField(String xpath) {
        driver.findElement(By.xpath(xpath)).clear();
    }

    /**
     * This keyword clears the text from specified TextArea
     *
     * @param xpath
     */
    public void ClearTextArea(String xpath) {
        driver.findElement(By.xpath(xpath)).clear();
    }

    /**
     * This keyword clicks on given button and waits for the specified Time. It
     * takes Button object and time in seconds as input argument.
     *
     * @param xpath
     * @param time
     * @throws Exception
     */
    public void ClickButtonAndWait(String xpath, long time) throws Exception {
        driver.findElement(By.xpath(xpath)).click();
        TimeUnit.SECONDS.sleep(time);
    }

    /**
     * This keyword closes all the open browser sessions started by Selenium. It
     * does not take any input argument.
     *
     * @return
     */
    public boolean CloseAllBrowsers() {
        try {
            driver.quit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This keyword closes the currently opened browser session.
     *
     * @return
     */
    public boolean CloseBrowser() {
        try {
            driver.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This keyword closes the selected window. It takes title name of the window to
     * be closed as data input argument.
     *
     * @param title
     * @return
     */
    public boolean CloseSelectedWindow(String title) {
        String currentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (driver.switchTo().window(window).getTitle().equals(title)) {
                driver.close();
                return true;
            } else {
                driver.switchTo().window(currentWindow);
                return false;
            }

        }
        return false;
    }

    /**
     * This keyword double clicks on the specified object.
     *
     * @param xpath
     * @return
     */
    public boolean DoubleClick(String xpath) {
        try {
            new Actions(driver).doubleClick(driver.findElement(By.xpath(xpath))).build().perform();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This keyword double clicks on an object and waits for the specified time
     * after double click.
     *
     * @param xpath
     * @param seconds
     * @return
     */
    public boolean DoubleClickAndWait(String xpath, long seconds) {
        try {
            new Actions(driver).doubleClick(driver.findElement(By.xpath(xpath))).build().perform();
            TimeUnit.SECONDS.sleep(seconds);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * This keyword double clicks on object according to specified co-ordinates. It
     * is used in situations where you want to double click on Object according to
     * its position on web page, when we are not able to identify that object.
     *
     * @param xpath
     * @param start
     * @param end
     * @return
     */

    public boolean DoubleClickAt(String xpath, int start, int end) {
        try {
            new Actions(driver).moveToElement(driver.findElement(By.xpath(xpath))).moveByOffset(start, end).click()
                    .perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This keyword presses the Enter key.
     *
     * @param xpath
     * @return
     */
    public boolean Enter(String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This keyword presses the ESC key.
     *
     * @param xpath
     * @return
     */
    public boolean pressESC(String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).sendKeys(Keys.ESCAPE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This keyword presses the ESC key.
     *
     * @param xpath
     * @return
     */
    public boolean pressESC(WebElement xpath) {
        try {
            xpath.sendKeys(Keys.ESCAPE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This keyword navigates back to previous page and then wait for specified
     * seconds.
     *
     * @param seconds
     * @return
     */
    public boolean GoBackAndWait(long seconds) {
        try {
            driver.navigate().back();
            TimeUnit.SECONDS.sleep(seconds);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This keyword navigates forward to next browser page.
     *
     * @return
     */
    public boolean GoForward() {
        try {
            driver.navigate().forward();
            // TimeUnit.SECONDS.sleep(seconds);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This keyword navigates forward to next browser page.
     *
     * @return
     */
    public boolean NavigateTo(String URL) {
        try {
            driver.navigate().to(URL);
            // TimeUnit.SECONDS.sleep(seconds);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This keyword navigates forward to next browser page and waits for specified
     * time. It takes timeout (sec) as input parameter.
     *
     * @param seconds
     * @return
     */
    public boolean GoForwardAndWait(long seconds) {
        try {
            driver.navigate().forward();
            TimeUnit.SECONDS.sleep(seconds);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This keyword presses left Arrow Key of keyboard. It does not take any input
     * argument.
     *
     * @param xpath
     * @return true else false
     */
    public boolean KeyLeft(String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).sendKeys(Keys.ARROW_LEFT);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * This keyword presses Right Arrow Key of keyboard. It does not take any input
     * argument.
     *
     * @param xpath
     * @return
     */
    public boolean KeyRight(String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).sendKeys(Keys.RIGHT);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * This keyword presses Down Arrow Key of keyboard. It does not take any input
     * argument.
     *
     * @param xpath
     * @return true else false
     */
    public boolean KeyDown(String xpath) {
        try {
            driver.findElement(By.xpath(".//a")).sendKeys(Keys.ARROW_DOWN);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * This keyword presses Page Down Key of keyboard. It takes Key, No. of
     * repetition as input parameter. input argument.
     * <p>
     * If you want to press a pagedown single time, then Pass 1 and so on.
     *
     * @return true else false
     */
    public boolean PageDown(int PageDownTimes) {
        try {
            while (PageDownTimes > 0) {
                driver.findElement(By.xpath(".//a")).sendKeys(Keys.PAGE_DOWN);
                PageDownTimes--;
            }

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * This keyword presses Page Up Key of keyboard. It takes Key, No. of repetition
     * as input parameter. input argument.
     * <p>
     * If you want to press a Page Up single time, then Pass 1 and so on.
     *
     * @return true else false
     */
    public boolean PageUP(int PageUpTimes) {
        try {
            while (PageUpTimes > 0) {
                driver.findElement(By.xpath(".//a")).sendKeys(Keys.PAGE_UP);
                PageUpTimes--;
            }

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * This keyword maximizes the current browser.
     *
     * @return
     */
    public boolean MaximizeBrowser() {
        try {
            driver.manage().window().maximize();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * This keyword hovers mouse on specified OR object.
     *
     * @param xpath
     * @return
     */
    public boolean MouseHover(String xpath) {
        try {
            new Actions(driver).moveToElement(driver.findElement(By.xpath(xpath))).perform();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * This keyword refreshes the current browser session.
     *
     * @return
     */
    public boolean RefreshBrowser() {
        try {
            driver.navigate().refresh();
            // driver.get(driver.getCurrentUrl());
            // driver.findElement(By.xpath(".//a")).sendKeys(Keys.F5);

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * This keyword refreshes the browser page and waits for the given timeout. This
     * keyword takes timeout (in seconds) to wait after refreshing the page.
     *
     * @param seconds
     * @return
     */
    public boolean RefreshAndWait(long seconds) {
        try {
            driver.navigate().refresh();
            TimeUnit.SECONDS.sleep(seconds);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * This keyword Right clicks on object. This keyword is mostly used in
     * situations where you want to perform a Right Click on provided Object before
     * performing any action on it.
     * <p>
     * For example, you want to Click Right on Object.
     *
     * @param xpath
     * @return
     */
    public boolean RightClickOnObject(String xpath) {
        try {
            new Actions(driver).contextClick(driver.findElement(By.xpath(xpath))).build().perform();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean OpenNewTab() {
        try {
            driver.findElement(By.xpath(".//a")).sendKeys(Keys.CONTROL, "t");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * LiDropdown is used where dropdown contains values in li tag
     *
     * @return
     *//*
     *
     * public boolean LiDropdown(Xpath.Locators LocatorType, String LocatorValue,
     * String value) { List<WebElement> elements =
     * driver.findElements(Locators(LocatorType, LocatorValue));
     * elements.stream().filter(p ->
     * p.getText().trim().equalsIgnoreCase(value)).findFirst().get().click(); return
     * true;
     *
     *
     */
    /*
     * elements.stream().forEach(a -> { System.out.println(a.getText()); if
     * (a.getText().contains((value))) { a.click(); } }); return true;
     *//*
     * }
     */
    public void SelectByValue() {

        Select select = new Select(driver.findElement(By.xpath("")));
        select.selectByIndex(1);
    }

    public boolean selectdropdown(String xpath, String value) {

        try {
            List<WebElement> elements = driver.findElements(By.xpath(xpath));

            for (WebElement element : elements) {
                System.out.println(element.getText());
                if (element.getText().contains(value)) {
                    // System.out.println(element.getText());
                    element.click();
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static String Screenshot_method(String filename) throws IOException {

        String dateName = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + APS_contsant.Screen_Shot + filename + dateName + "_.png";

        FileUtils.copyFile(source, new File(destination));

        return destination;

    }

    public static String dateName() {
        String dateName = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
        return dateName;
    }

    public void highlight(WebElement usernamer) {

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');",
                    usernamer);
            Thread.sleep(1000);
            js.executeScript("arguments[0].style.border=''", usernamer, "");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // Mouseover

    /**
     * Hover over {@link WebElement}.
     *
     * @param element - {@link WebElement}.
     */
    public void mouseover(final WebElement element) {
        final Actions builder = new Actions(this.driver);
        builder.moveToElement(element).build().perform();
    }

    /**
     * Hover over {@link WebElement}.
     *
     * @param by - {@link WebElement} as {@link By} object.
     */
    public void mouseover(final By by) {
        mouseover(this.driver.findElement(by));
    }

    // Drag And Drop

    /**
     * Drag and drop from a specified {@link WebElement} to coordinates.
     *
     * @param by      - {@link WebElement}.
     * @param xOffset - How many pixel move element left or right. A negative value
     *                is left.
     * @param yOffset - How many pixel move element up or down. A negative value is
     *                up.
     */
    public void dragAndDrop(final WebElement element, final int xOffset, final int yOffset) {
        final Actions builder = new Actions(this.driver);
        final Action dragAndDrop = builder.clickAndHold(element).moveByOffset(xOffset, yOffset).release().build();
        dragAndDrop.perform();
    }

    /**
     * Drag and drop from a specified {@link WebElement} to coordinates.
     *
     * @param by      - {@link WebElement} as {@link By} object.
     * @param xOffset - How many pixel move element left or right. A negative value
     *                is left.
     * @param yOffset - How many pixel move element up or down. A negative value is
     *                up.
     */
    public void dragAndDrop(final By by, final int xOffset, final int yOffset) {
        dragAndDrop(this.driver.findElement(by), xOffset, yOffset);
    }

    // Switch Window

    /**
     * Switch to a open window.
     *
     * @param url - A part of the URL from the window you want switch.
     */
    public void switchWindow(final String url) {
        sleep(2000);
        String currentHandle = null;
        final Set<String> handles = this.driver.getWindowHandles();
        if (handles.size() > 1) {
            currentHandle = this.driver.getWindowHandle();
        }
        if (currentHandle != null) {
            for (final String handle : handles) {
                this.driver.switchTo().window(handle);
                if (this.driver.getCurrentUrl().contains(url) && currentHandle.equals(handle) == false) {
                    break;
                }
            }
        } else {
            for (final String handle : handles) {
                this.driver.switchTo().window(handle);
                if (this.driver.getCurrentUrl().contains(url)) {
                    break;
                }
            }
        }
    }

    // Is Readonly

    /**
     * @param element - {@link WebElement}.
     * @return If element read only true; else false.
     */
    public boolean isReadonly(final WebElement element) {
        return Boolean.valueOf(element.getAttribute("readonly")).booleanValue();
    }

    /**
     * @param by - {@link WebElement} as {@link By}.
     * @return If element read only true; else false.
     */
    public boolean isReadonly(final By by) {
        return isReadonly(this.driver.findElement(by));
    }

    // Get Element Position

    /**
     * @param element - {@link WebElement}.
     * @return Get position of element as {@link Point} object.
     */
    public Point getElementPosition(final WebElement element) {
        return element.getLocation();
    }

    /**
     * @param element - {@link WebElement}.
     * @return Get distance to left of element.
     */
    public int getElementPositionX(final WebElement element) {
        final Point pos = getElementPosition(element);
        return pos.getX();
    }

    /**
     * @param element - {@link WebElement}.
     * @return Get distance to top of element.
     */
    public int getElementPositionY(final WebElement element) {
        final Point pos = getElementPosition(element);
        return pos.getY();
    }

    // Backspace Input Clear

    /**
     * Clear input with backspace key.
     *
     * @param element - {@link WebElement}.
     */
    public void backspaceInputClear(final WebElement element) {
        final int numberOfCharacters = element.getAttribute("value").length();
        for (int i = 0; i <= numberOfCharacters; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    /**
     * Clear input with backspace key.
     *
     * @param element            - {@link WebElement}.
     * @param numberOfCharacters - How many characters will delete.
     */
    public void backspaceInputClear(final WebElement element, final int numberOfCharacters) {
        for (int i = 0; i <= numberOfCharacters; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    // Scroll

    /**
     * Scroll in current window.
     *
     * @param x - How many pixel scroll left or right. A negative value is left.
     * @param y - How many pixel scroll up or down. A negative value is up.
     */
    public void scroll(final int x, final int y) {
        final JavascriptExecutor js = (JavascriptExecutor) this.driver;
        for (int i = 0; i <= x; i = i + 50) {
            js.executeScript("scroll(" + i + ",0)");
        }
        for (int j = 0; j <= y; j = j + 50) {
            js.executeScript("scroll(0," + j + ")");
        }
    }

    // Highlight WebElement

    /**
     * Highlight a {@link WebElement}.
     *
     * @param element - {@link WebElement}.
     * @return {@link JavascriptExecuter} object.
     */
    public JavascriptExecutor highlightElementPermanently(final WebElement element) {
        final JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        return js;
    }

    /**
     * Highlight a {@link WebElement} for 3 seconds.
     *
     * @param element - {@link WebElement}.
     */
    public void highlightElement(final WebElement element) {
        final String originalStyle = element.getAttribute("style");
        final JavascriptExecutor js = highlightElementPermanently(element);
        sleep(3000);
        js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
    }

    // Zoom

    /**
     * Zoom current window +1.
     */
    public void zoomPlus() {
        Actions actions = new Actions(this.driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ADD).perform();
        actions = new Actions(this.driver);
        actions.keyUp(Keys.CONTROL).perform();
    }

    /**
     * Zoom current window -1.
     */
    public void zoomMinus() {
        Actions actions = new Actions(this.driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).perform();
        actions = new Actions(this.driver);
        actions.keyUp(Keys.CONTROL).perform();
    }

    public boolean isAlertPresent() {
        try {
            final Alert alert = this.driver.switchTo().alert();
            alert.getText();
        } catch (final NoAlertPresentException nape) {
            return false;
        }
        return true;
    }

    /**
     * @return Get text from alert.
     */
    public String getAlertText() {
        final Alert alert = this.driver.switchTo().alert();
        return alert.getText();
    }

    /**
     * Accept alert.
     */
    public void acceptAlert() {
        final Alert alert = this.driver.switchTo().alert();
        alert.accept();
    }

    /**
     * Cancel alert.
     */
    public void dismissAlert() {
        final Alert alert = this.driver.switchTo().alert();
        alert.dismiss();
    }

    public void sleep(final int millis) {

        try {
            Thread.sleep(millis);
        } catch (final InterruptedException e) {
            // Nothing happens.
        }

    }

    public WebElement webdriverwait(WebElement element) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(element));
        highlightElement(ele);
        clickbutton(ele);
        return ele;
    }


}