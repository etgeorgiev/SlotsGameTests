package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    static HomePage homePage;

    By gamesButtonInHeader = By.xpath("//*[@id='main-nav']/nav/a[2]/span");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public static HomePage getInstance(WebDriver driver){
        if(homePage == null){
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public void clickOnGamesInHeader(){
        driver.findElement(gamesButtonInHeader).click();
    }


}
