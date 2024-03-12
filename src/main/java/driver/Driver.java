package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.Dimension;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static final String REMOTE_WEBDRIVER_URL = "http://192.168.1.217:4444/wd/hub";

    private static final String BROWSER_CONFIG_FILE = "browser.properties";
    private static final int PAGE_TIME_OUT = 30;
    private static WebDriver driver;

    private static final Logger log = LoggerFactory.getLogger(Driver.class);

    private Driver() {
    }

    private static WebDriver init() {

        // read browser name from 'resources/browser.properties'
        Properties appProps = new Properties();
        InputStream rootPath = Thread.currentThread().getContextClassLoader().getResourceAsStream(BROWSER_CONFIG_FILE);
        try {
            appProps.load(rootPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String browser = appProps.getProperty("browser").toLowerCase();
        String headlessMode = appProps.getProperty("headless").toLowerCase();

        switch (browser) {
            case "chrome":
                // Specify the path to the ChromeDriver executable
                String chromeDriverPath = "/usr/local/bin/chromedriver"; // Replace this with your actual path
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");

                if (headlessMode.equals("true")) {
                    chromeOptions.addArguments("--headless");
                }

                driver = new ChromeDriver(chromeOptions);
                break;
            // Other browser cases remain unchanged
        }

        driver.manage().timeouts().implicitlyWait(PAGE_TIME_OUT, TimeUnit.SECONDS);
        //        driver.manage().window().maximize();

        // Set browser window size
        Dimension size = new Dimension(1024, 768);
        driver.manage().window().setSize(size);

        return driver;
    }


    public static WebDriver getDriver() {
        return (driver == null) ? init() : driver;
    }
}
