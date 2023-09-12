package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AgeCheckPage {
    WebDriver driver;
    static AgeCheckPage ageChek;

    By dayOfBirth = By.className("day-input");
    By monthOfBirth = By.className("month-input");
    By yearOfBirth = By.className("year-input");
    By enterButton = By.className("danger-btn-2");

    public AgeCheckPage(WebDriver driver){
        this.driver = driver;
    }

    public static AgeCheckPage getInstance(WebDriver driver){
        if(ageChek == null){
            ageChek = new AgeCheckPage(driver);
        }
        return ageChek;
    }

    public void insertDayOfBirth(String day){
        driver.findElement(dayOfBirth).sendKeys(day);
    }

    public void insertMonthOfBirth(String month){
        driver.findElement(monthOfBirth).sendKeys(month);
    }

    public void insertYearOfBirth(String year){
        driver.findElement(yearOfBirth).sendKeys(year);
    }

    public void clickEnterButton(){
        driver.findElement(enterButton).click();
    }

    public Boolean elementIsThere(){
        return driver.findElement(dayOfBirth).isDisplayed();
    }
}
