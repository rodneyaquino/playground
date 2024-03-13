package automation.smoke;

import automation.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import static utils.UrlConstants.BASE_URL;

public class TicTacToe extends BaseTest {

    @Override
    public void init() {
    }

    /**
     * TEST - Verify Landing Page URL and ELEMENTS
     * - Open up Landing Page
     * - Verify URL is correct
     * - Verify Play Button is displayed on landing page
     * - Verify Text Input Box is displayed on landing page
     */
    @Test(description = "Verify Landing Page URL and Elements", priority = 1)
    public void verifyLandingPage() {
        System.out.println("verifyLandingPage()");
        homePage.open();

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = BASE_URL;

        // Assert that the current URL matches the expected URL
        Assert.assertEquals(currentUrl, expectedUrl, "Current URL doesn't match expected URL");

        // Assert that the Play Button is displayed on the landing page
        Assert.assertTrue(homePage.isPlayButtonDisplayed(), "Play Button is not displayed on the landing page");

        // Assert that the Text Input Box is displayed on the landing page
        Assert.assertTrue(homePage.isTextInputBoxDisplayed(), "Text Input Box is not displayed on the landing page");

        System.out.println("TEST PASSED | verifyLandingPage()");
    }

    /**
     * TEST - Verify Winning Scenario in Tic-Tac-Toe Game - 3x3
     * - Open up Landing Page
     * - Type in "3" in the textInputBox
     * - Click on "Play" to start game
     * - Win the game
     * - Verify End Game Overlay Text has correct text
     * TODO ISSUE #03: Red Overlay reports wrong winner | Update assertion once bug is fixed
     */
    @Test(description = "Verify Winning Scenario in Tic-Tac-Toe Game - 3x3", priority = 2)
    public void verifyPlayGameWinningScenario3x3() {
        System.out.println("verifyPlayGameWinningScenario3x3()");
        homePage.open();

        if (homePage.isPlayButtonDisplayed()) {
            homePage.enterNumberInTextInputBox(3);
            homePage.clickPlayButton();

            // Click on specific cells to win the game
            homePage.clickOnCell(driver, "0");
            homePage.clickOnCell(driver, "2");
            homePage.clickOnCell(driver, "3");
            homePage.clickOnCell(driver, "5");
            homePage.clickOnCell(driver, "6");

            if (homePage.isEndGameOverlayDisplayed()) {

                String actualText = homePage.getEndGameOverlayText();

                // TODO ISSUE #03: Red Overlay reports wrong winner | Update assertion once bug is fixed
                Assert.assertTrue(
                        actualText.contains("Congratulations player") &&
                                 actualText.contains("You've won. Refresh to play again!"),
                        "End game overlay text is missing expected phrases");
            } else {
                Assert.fail("End game overlay is not displayed. Test cannot proceed further.");
            }
        } else {
            Assert.fail("Play button is not displayed. Test cannot proceed further.");
        }

        System.out.println("TEST PASSED | verifyPlayGameWinningScenario3x3()");
    }

    /**
     * TEST - Verify Tic Tac Toe game can be reset
     * - Open up Landing Page
     * - Type in "5" in the textInputBox
     * - Click on "Play" to start game
     * - Win the game to trigger the End Game Overlay
     * - Refresh Browser to clear out game
     * - Verify End Game Overlay is not displayed
     */
    @Test(description = "Verify user can reset the game with a browser refresh", priority = 3)
    public void verifyGameReset() {
        System.out.println("verifyGameReset()");
        homePage.open();

        if (homePage.isPlayButtonDisplayed()) {
            homePage.enterNumberInTextInputBox(5);
            homePage.clickPlayButton();

            // Click on specific cells to win the game
            homePage.clickOnCell(driver, "0");
            homePage.clickOnCell(driver, "1");
            homePage.clickOnCell(driver, "5");
            homePage.clickOnCell(driver, "6");
            homePage.clickOnCell(driver, "10");
            homePage.clickOnCell(driver, "11");
            homePage.clickOnCell(driver, "15");
            homePage.clickOnCell(driver, "16");
            homePage.clickOnCell(driver, "20");
            homePage.clickOnCell(driver, "21");


            if (homePage.isEndGameOverlayDisplayed()) {

                // Refresh the Browser
                driver.navigate().refresh();

                // Verify Browser refresh, clears out End Game Overlay
                Assert.assertFalse(homePage.isEndGameOverlayDisplayed(), "End Game Overlay should not be displayed");

            } else {
                Assert.fail("End game overlay is not displayed. Test cannot proceed further.");
            }
        } else {
            Assert.fail("Play button is not displayed. Test cannot proceed further.");
        }

        System.out.println("TEST PASSED | verifyGameReset()");

    }
}
