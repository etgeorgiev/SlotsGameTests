package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.*;

import static hooks.BeforeAndAfterHooks.driver;

public class helpMethods {

    // Initialization of new objects from each page
    AgeCheckPage ageCheckPage = AgeCheckPage.getInstance(driver);
    HomePage homePage = HomePage.getInstance(driver);
    GamesPage gamesPage = GamesPage.getInstance(driver);
    HereKittyKittyPage hereKittyKittyPage = HereKittyKittyPage.getInstance(driver);
    GameHereKittyKittyPage gameHereKittyKittyPage = GameHereKittyKittyPage.getInstance(driver);

    public static String hereKittyKittyParentPage;

    public void gameToBeReadyForPlaying() throws InterruptedException {
        // User has to be adult and here the valid birthdate is inserted
        if (ageCheckPage.elementIsThere()) {
            ageCheckPage.insertDayOfBirth("20");
            ageCheckPage.insertMonthOfBirth("5");
            ageCheckPage.insertYearOfBirth("1980");
            Thread.sleep(1000);
            ageCheckPage.clickEnterButton();
        }
        // Click on the Games in Header Bar
        homePage.clickOnGamesInHeader();
        Thread.sleep(1000);

        // Choose the game from list with many games
        gamesPage.clickOnTheGame("Here Kitty Kitty");
        hereKittyKittyPage.clickOnThePlayGameButton();

        // Switch to new tab where we can play the game
        hereKittyKittyParentPage = driver.getWindowHandle();
        switchTab(driver);

        // Click on Play Button in page of the Game
        Thread.sleep(2000);
        gameHereKittyKittyPage.clickOnPlayButton();
        //Check we are in the game page
        Assert.assertEquals("Here Kitty Kitty", gameHereKittyKittyPage.getTitleOfPage());


    }
    // Get Balance without sign of the Currency and return it in String
    public String getBalanceWithoutCurrency() {
        return gameHereKittyKittyPage.getBalanceOfPlayer().substring(1);
    }

    //Switch the tab
    private void switchTab(WebDriver driver) {
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
    }

    // Get amount of Bet without sign of the Currency and return it in String
    public String getCurrentBetWithoutCurrency() {
        return gameHereKittyKittyPage.getCurrentBet().substring(1);
    }

    //Deleting all Cookies and clearing cache
    public void clearCookiesAndCache() {
        driver.manage().deleteAllCookies();
        driver.get("chrome://settings/clearBrowserData");
        driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
    }
    //Closing the tab with game
    public void closeGameTab() {
        driver.close();
    }

    //Switching to tab which is sent
    public void switchToTab(String tab) {
        driver.switchTo().window(tab);
    }
}
