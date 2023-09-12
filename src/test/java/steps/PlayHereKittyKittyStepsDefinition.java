package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;

public class PlayHereKittyKittyStepsDefinition extends helpMethods {

    SoftAssert soft = new SoftAssert();

    @Given("User is in Here Kitty Kitty")
    public void user_is_in_here_kitty_kitty() throws InterruptedException {
        gameToBeReadyForPlaying();
    }

    @And("the user's balance is 100")
    public void theUserSBalanceIs100() {
        // Check for current balance of the player is or more than 100
        boolean isMoreThan = Double.parseDouble(getBalanceWithoutCurrency()) >= 100;
        Assert.assertTrue(isMoreThan);
    }

    // User can play the game
    @When("User press START button")
    public void user_press_play_button() throws InterruptedException {
        // Click Start button and games has to start
        gameHereKittyKittyPage.clickOnStartButton();
        Thread.sleep(2000);
    }
    @Then("The game is started")
    public void the_game_is_started()  {
        // Checking the balance after one game is played
        Assert.assertEquals("98.00", getBalanceWithoutCurrency());
        closeGameTab();
        switchToTab(hereKittyKittyParentPage);
        clearCookiesAndCache();
    }


    // User can change bet
    @When("User press Plus button")
    public void userPressButton() throws InterruptedException {
        //Click on Plus button to change the bet
        gameHereKittyKittyPage.clickOnBetPlusButton();
        Thread.sleep(3000);
    }
    @Then("The bet have been raised")
    public void theBetIncreases() {
        //Check that the new bet is correct
        Assert.assertEquals("4.00", getCurrentBetWithoutCurrency());
        closeGameTab();
        switchToTab(hereKittyKittyParentPage);
        clearCookiesAndCache();
    }


    // The balance is correct after three reel games
    @And("user's bet is One pound")
    public void userSBetIsDollar() {
        gameHereKittyKittyPage.clickOnMinusButton();
        Assert.assertEquals("1.00", getCurrentBetWithoutCurrency());
    }
    @When("User is played three reel games")
    public void userIsPlayedThreeReelGames() throws InterruptedException {
        gameHereKittyKittyPage.clickOnStartButton();
        Thread.sleep(2000);
        gameHereKittyKittyPage.clickOnStartButton();
        Thread.sleep(2000);
        gameHereKittyKittyPage.clickOnStartButton();
        Thread.sleep(2000);
    }
    @Then("The balance of user is three dollars less")
    public void theBalanceOfUserIsThreeDollarsLess() {
        soft.assertEquals(getBalanceWithoutCurrency(),"97.00");
        closeGameTab();
        switchToTab(hereKittyKittyParentPage);
        clearCookiesAndCache();
    }
}
