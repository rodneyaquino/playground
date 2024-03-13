package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public void init(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * Check if specified web element is present within the specified timeout
     *
     * @param element The WebElement to check for presence
     * @param timeoutInSeconds The maximum time to wait for the element to be present, in seconds
     * @return boolean Whether element is present or not
     */
    public boolean isElementPresent(WebElement element,  long timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true; // Element is present
        } catch (TimeoutException e) {
            return false; // Element is not present within the specified timeout
        }
    }

}
