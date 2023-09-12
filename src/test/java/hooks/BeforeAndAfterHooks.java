package hooks;

import helpers.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BeforeAndAfterHooks extends BrowserFactory {
    public static WebDriver driver;

    @Before()
    public static void beforeTest() {
        driver = getBrowser("Chrome");
        driver.get("https://www.redtiger.com/");
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void quitDriver(){
        quitDrivers();
    }
}