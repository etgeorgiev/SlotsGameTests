package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HereKittyKittyPage {
    WebDriver driver;
    static HereKittyKittyPage hereKittyKittyPage;

    By playGameButton = By.xpath("//div[@class='btn-box w-hidden-small w-hidden-tiny w-clearfix']/" +
            "a[@href='https://gserver-rtg.redtiger.com/rtg/launcher/HereKittyKitty'][@class='danger-btn btn-text w-button']");

    public HereKittyKittyPage(WebDriver driver){
        this.driver = driver;
    }

    public static HereKittyKittyPage getInstance(WebDriver driver){
        if(hereKittyKittyPage == null){
            hereKittyKittyPage = new HereKittyKittyPage(driver);
        }
        return hereKittyKittyPage;
    }

    public void clickOnThePlayGameButton(){
        driver.findElement(playGameButton).click();
    }
}
