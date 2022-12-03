package by.a1qa.task2_1.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePagePF extends BasePage{
    public static final String HOMEPAGE_URL = "https://store.steampowered.com/";
    private final String GAME_TITLE = "Dota 2";

    private WebDriver driver;

    public HomePagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href=\"https://store.steampowered.com/privacy_agreement/?snr=1_44_44_\"]")
    private WebElement privacyPolicy;

    @FindBy (xpath = "//input[@id=\"store_nav_search_term\"]")
    private WebElement searchField;

    @FindBy (xpath = "//*[@id=\"store_search_link\"]/img")
    private WebElement searchButtonInSearchField;

    public HomePagePF openHomePage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(3));
        return this;
    }

    public HomePagePF scrollHomePage(){
        WebElement element = driver.findElement(By.xpath("//a[@href=\"https://store.steampowered.com/privacy_agreement/?snr=1_44_44_\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public PrivacyAgreementPagePF openPrivacyPolicyPage(){
        privacyPolicy.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        switchToNewWindow();
        return new PrivacyAgreementPagePF(driver);
    }

    public void switchToNewWindow(){
        String windowHandleBefore = driver.getWindowHandle(); // Store the current window handle
        for(String windowHandle : driver.getWindowHandles()){ // Switch to new window opened
            driver.switchTo().window(windowHandle);
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public SearchResultPagePF searchDota2(){
        searchField.sendKeys(GAME_TITLE);
        searchButtonInSearchField.click();
        return new SearchResultPagePF(driver);
    }

    public SearchResultPagePF secondSearchGame(String someGame){
        searchField.sendKeys(someGame);
        searchButtonInSearchField.click();
        return new SearchResultPagePF(driver);
    }
}
