package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GamesPage {
    WebDriver driver;
    static GamesPage gamesPage;

    By hereKittyKittyGame = By.xpath("//*[@id=\"w-tabs-0-data-w-pane-1\"]/div[1]/div[1]/div[7]/a");

    public GamesPage(WebDriver driver){
        this.driver = driver;
    }

    public static GamesPage getInstance(WebDriver driver){
        if (gamesPage == null){
            gamesPage = new GamesPage(driver);
        }
        return gamesPage;
    }

    public void clickOnTheGame(String gameName){
        switch (gameName){
            case "Here Kitty Kitty": driver.findElement(hereKittyKittyGame).click();
            break;
        }
    }
}
