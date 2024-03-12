package automation.smoke;

import automation.BaseTest;
import org.testng.annotations.Test;

public class Calendly extends BaseTest {

    @Override
    public void init() {
    }

    @Test(description = "Test login with valid credentials", priority = 1)
    public void openHomePage() {
        homePage.open();
        try {
            // Sleep for 5 seconds
            Thread.sleep(10000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
