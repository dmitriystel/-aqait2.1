package by.a1qa.task2_1.driver.page;

import by.a1qa.task2_1.driver.bean.GameInformation;
import by.a1qa.task2_1.driver.util.ConfigManager;
import by.a1qa.task2_1.driver.util.ParserJsonToJava;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static by.a1qa.task2_1.driver.page.SearchResultPage.DOTA2_SEARCH_RESULT_LIST_DB_PATH;
import static by.a1qa.task2_1.driver.page.SearchResultPage.SECOND_SEARCH_GAME_RESULT_LIST_DB_PATH;

public class MainPage extends BasePage {
    private WebDriver driver;

    public static final String GAME_TITLE = "Dota 2";

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href=\"https://store.steampowered.com/privacy_agreement/?snr=1_44_44_\"]")
    private WebElement privacyPolicy;

    @FindBy(id = "store_nav_search_term")
    private WebElement searchField;


    @FindBy(xpath = "//img[@src=\"https://store.akamai.steamstatic.com/public/images/blank.gif\"]")
    private WebElement searchButtonInSearchField;

    public MainPage navigateToMainPage() {
        driver.get(ConfigManager.getURL());
        return this;
    }

    public PrivacyPolicyPage scrollAndOpenPrivacyPolicy() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
        new WebDriverWait(driver, Duration.ofSeconds(ConfigManager.getWaitDurationInSeconds()))
                .until(ExpectedConditions.elementToBeClickable(privacyPolicy));
        privacyPolicy.click();
        switchToNewWindow();
        return new PrivacyPolicyPage(driver);
    }

    public void switchToNewWindow() {
        String windowHandleBefore = driver.getWindowHandle(); // Store the current window handle
        for (String windowHandle : driver.getWindowHandles()) { // Switch to new window opened
            driver.switchTo().window(windowHandle);
        }
    }

    public SearchResultPage searchDota2() {
        new WebDriverWait(driver, Duration.ofSeconds(ConfigManager.getWaitDurationInSeconds()))
                .until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys(GAME_TITLE);
        searchButtonInSearchField.click();
        return new SearchResultPage(driver);
    }

    public SearchResultPage secondSearchGame(String someGame){
        new WebDriverWait(driver, Duration.ofSeconds(ConfigManager.getWaitDurationInSeconds()))
                .until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys(someGame);
        searchButtonInSearchField.click();
        return new SearchResultPage(driver);
    }
}
