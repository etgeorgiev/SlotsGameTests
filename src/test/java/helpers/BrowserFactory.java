package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    private static Map<String, WebDriver> drivers = new HashMap<>();

    public static WebDriver getBrowser(String browserName) {

       WebDriver driver = null;

        switch (browserName) {
            case "Chrome":
                driver = drivers.get("Chrome");
                if (driver == null) {
                    System.setProperty("webdriver.chrome.driver", "D:\\AutomationTestingSlotsGame\\" +
                            "src\\test\\resources\\drivers\\chromedriver.exe");

                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    //Set time for waiting if there is a problem with network
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    drivers.put("Chrome", driver);
                }
                break;
        }
        return driver;
    }

    public static void closeDrivers() {
        for (String key : drivers.keySet()) {
                drivers.get(key).close();
        }
    }

    public static void quitDrivers() {
        for (String key: drivers.keySet()){
            drivers.get(key).quit();
        }
    }
}
