package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.By;


import static utils.UrlConstants.BASE_URL;

public class HomePage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(HomePage.class);

    // ==============================================
    // Section 1: WebElement Locators
    // ==============================================

    @FindBy(xpath = ".//button[@id='start']")
    private WebElement playButtonLocator;

    @FindBy(xpath = "//input[@type='text' and @id='number']")
    private WebElement textInputBoxLocator;

    @FindBy(xpath = ".//div[@id='endgame']")
    private WebElement endGameOverlayLocator;

    public HomePage open() {
        driver.get(BASE_URL);
        return this;
    }


    // ==============================================
    // Section 2: Page Actions
    // ==============================================

    /**
     * Method to click the Play Button
     */
    public void clickPlayButton() {
        System.out.println("clickPlayButton()");
        playButtonLocator.click();
    }

    /**
     * Method to enter a number in the Text Input Box
     */
    public void enterNumberInTextInputBox(int number) {
        System.out.println("enterNumberInTextInputBox()");
        textInputBoxLocator.clear();
        textInputBoxLocator.sendKeys(String.valueOf(number));
    }

    /**
     * Method to click on a specific cell by its ID
     */
    public static void clickOnCell(WebDriver driver, String cellId) {
        System.out.println("clickOnCell()");

        // Locate the cell element by its ID
        WebElement cell = driver.findElement(By.id(cellId));
        cell.click();
        System.out.println("Clicked on cell with ID: " + cellId);
    }


    // ==============================================
    // Section 3: Element Visibility Checks
    // ==============================================

    /**
     * Is the Play button displayed
     *
     * @return boolean - true if present
     */
    public boolean isPlayButtonDisplayed() {
        System.out.println("isPlayButtonDisplayed()");
        return isElementPresent(playButtonLocator, 2);
    }

    /**
     * Is the Text Input box displayed
     *
     * @return boolean - true if present
     */
    public boolean isTextInputBoxDisplayed() {
        System.out.println("isTextInputBoxDisplayed()");
        return isElementPresent(textInputBoxLocator, 2);
    }

    /**
     * Is the End Game Overlay displayed
     *
     * @return boolean - true if present
     */
    public boolean isEndGameOverlayDisplayed() {
        System.out.println("isEndGameOverlayDisplayed()");
        return isElementPresent(endGameOverlayLocator, 2);
    }


    // ==============================================
    // Section 4: Validation and Assertion Helpers
    // ==============================================

    /**
     * Get the text of the End Game Overlay
     *
     * @return String - End Game Overlay Text
     */
    public String getEndGameOverlayText() {
        System.out.println("getEndGameOverlayText()");
        return endGameOverlayLocator.getText();
    }


}
