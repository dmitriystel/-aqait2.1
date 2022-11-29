package by.a1qa.task2_1.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePagePF extends BasePage{

    public static final String HOMEPAGE_URL = "https://store.steampowered.com/";


    public HomePagePF(WebDriver driver) {
        super(driver);
    }



//    private static HomePageAnnotated instance;
//    private HomePageAnnotated(WebDriver driver){
//        super(driver);
//    }
//    public static HomePageAnnotated getInstance(){
//        if(instance == null){
//            instance = new HomePageAnnotated(driver);
//        }
//        return instance;
//    }

    private final String GAME_TITLE = "Dota 2";


    @FindBy(xpath = "//a[@href=\"https://store.steampowered.com/privacy_agreement/?snr=1_44_44_\"]")
    private WebElement privacyPolicy;

    @FindBy (xpath = "//input[@id=\"store_nav_search_term\"]")
    private WebElement searchField;

    @FindBy (xpath = "//*[@id=\"store_search_link\"]/img")
    private WebElement searchButtonInSearchField;



    public void clickButtonPrivacyPolicy(){ //  rename openPrivacyPolice
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        privacyPolicy.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        switchToNewWindow();
    }

    public void switchToNewWindow(){
        String windowHandleBefore = driver.getWindowHandle(); // Store the current window handle
        for(String windowHandle : driver.getWindowHandles()){ // Switch to new window opened
            driver.switchTo().window(windowHandle);
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public void searchDota2(){ // was writeGameTitleInSearchField
        searchField.sendKeys(GAME_TITLE);
        searchButtonInSearchField.click();
    }

}
