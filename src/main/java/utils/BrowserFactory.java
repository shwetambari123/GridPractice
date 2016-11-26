package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.logging.Logger;

/**
 * Created by Yogesh on 25-11-2016.
 */
public class BrowserFactory {
    public static WebDriver driver;

    //   static Logger LOGGER = Logger.getLogger(BrowserFactory.class);

    public static WebDriver StartBrowser(String browser, String URL) {
        if (driver == null || isSessionActive()) {
            driver = startRemoteWebBrowser(browser, URL);
        }
        driver.manage().window().maximize();

        return driver;
    }


    public static WebDriver getDriver() {
        return driver;
    }


    public static WebDriver startRemoteWebBrowser(String browser, String URL) {
        // if (AutomationConstant.Remote_Browser.equalsIgnoreCase("true")) {
        try {
            System.out.println("grid started:");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability("platform", Platform.VISTA);
            capabilities.setVersion("54");

            URL url = new URL(AutomationConstant.Sauce_URL);
            driver = new RemoteWebDriver(url, capabilities);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

       /*  } else

    {
        try {
            if (browser.equalsIgnoreCase("chrome"))
            {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/browser/chromedriver.exe");
                driver = new ChromeDriver();
            }

            driver.get(URL);
            driver.manage().deleteAllCookies();


        } catch (Exception e) {
            e.getStackTrace();
        }
    }*/


        driver.get(AutomationConstant.URL);
       return driver;
    // return null;

}


    public static boolean isSessionActive() {
        try {

            return driver.findElements(By.tagName("body")).size() > 0;
        } catch (Exception e) {

        }
        return false;
    }

    public static void closeBrowser() {
        driver.quit();
    }


}
