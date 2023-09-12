package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.spi.AbstractResourceBundleProvider;

public class GameHereKittyKittyPage {
    WebDriver driver;
    static GameHereKittyKittyPage gameHereKittyKittyPage;

    By playButton = By.xpath("//button[@class='play-button v-btn v-btn--depressed theme--dark transparent base-button base-button-primary base-button-shiny']");
    By startButton = By.className("btn-circle-inner-play-button");
    By balance = By.className("statistics-field-value");
    By plusBet = By.xpath("//*[@id='app']/div[14]/div[10]/div/div/div/div[2]/div[1]/div/button[2]");
    By minusBet = By.xpath("//*[@id=\"app\"]/div[14]/div[10]/div/div/div/div[2]/div[1]/div/button[1]");
    By bet = By.xpath("//*[@id=\"app\"]/div[14]/div[10]/div/div/div/div[2]/div[1]/div/div/div[2]");
    By turboButton = By.xpath("//button[@class='v-btn v-btn--depressed theme--dark transparent base-button turbo-button']");


    public GameHereKittyKittyPage(WebDriver driver){
        this.driver = driver;
    }

    public static GameHereKittyKittyPage getInstance(WebDriver driver){
        if(gameHereKittyKittyPage == null){
            gameHereKittyKittyPage = new GameHereKittyKittyPage(driver);
        }
        return gameHereKittyKittyPage;
    }

    public void clickOnPlayButton(){
        driver.findElement(playButton).click();
    }

    public void clickOnStartButton(){
        driver.findElement(startButton).click();
    }

    public String getBalanceOfPlayer(){
        return driver.findElement(balance).getText();
    }

    public String getTitleOfPage(){
        return driver.getTitle();
    }

    public void clickOnBetPlusButton(){
        driver.findElement(plusBet).click();
    }

    public void clickOnMinusButton(){ driver.findElement(minusBet).click(); }

    public String getCurrentBet(){
        return driver.findElement(bet).getText();
    }

    public void clickTurboButton() { driver.findElement(turboButton).click();}
}

