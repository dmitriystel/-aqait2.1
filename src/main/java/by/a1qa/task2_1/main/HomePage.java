package by.a1qa.task2_1.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public static final String HOMEPAGE_URL = "https://store.steampowered.com/";
    private final String GAME_TITLE = "Dota 2";
    By privacy_policy_locator = By.xpath("//a[@href=\"https://store.steampowered.com/privacy_agreement/?snr=1_44_44_\"]");
    By search_field_locator = By.xpath("//input[@id=\"store_nav_search_term\"]");
    By search_button_in_search_field_locator = By.xpath("//*[@id=\"store_search_link\"]/img");

    public HomePage(WebDriver driver) {
        super(driver);
    }


//private static HomePage instance;
//    private HomePage(WebDriver driver){
//        super(driver);
//    }
//    public static HomePage getInstance(){
//        if(instance == null){
//            instance = new HomePage(driver);
//        }
//        return instance;
//    }

    public void clickButtonPrivacyPolicy(){ //  rename openPrivacyPolice
        WebElement webElementPrivacyPolicy =
                driver.findElement(privacy_policy_locator);
        webElementPrivacyPolicy.click();


    }

    public void switchToNewWindow(){
        String windowHandleBefore = driver.getWindowHandle(); // Store the current window handle
        for(String windowHandle : driver.getWindowHandles()){ // Switch to new window opened
            driver.switchTo().window(windowHandle);
        }
    }

    public void writeGameTitleInSearchField(){
        WebElement webElementSearchFieldBasePage = driver.findElement(search_field_locator);
        webElementSearchFieldBasePage.sendKeys(GAME_TITLE);
    }

    public void clickButtonSearchInSearchField(){
        WebElement webElementSearchButtonInSearchFieldBasePage = driver
                .findElement(search_button_in_search_field_locator);
        webElementSearchButtonInSearchFieldBasePage.click();
    }
}

/*
from Web Driver course by Epam

    public SeleniumHQHomePage(){
    driver.get(HOMEPAGE_URL);
    new WebDriverWait(driver, 10)
        .until(CustomCondition.jQueryAJAXsCompleted());
        return this;
    }

 */