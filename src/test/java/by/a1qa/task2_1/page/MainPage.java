package by.a1qa.task2_1.page;

import by.a1qa.task2_1.driver.DriverSingleton;
import by.a1qa.task2_1.util.ConfigManager;
import by.a1qa.task2_1.wait.ConditionalWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
/*
Code review 24.12.2022
3rd comment:
@findby will look for an item in the locator right away, even if we don't need it yet, so we shouldn't use it.
Use findElement

fixed: findElement is used
*/
public class MainPage extends BasePage {
    private WebDriver driver;

    public MainPage() {
        super();
    }

//    @FindBy(xpath = "//a[contains(@href,'/privacy_agreement/?snr=1_44_44_')]")
//    private WebElement privacyPolicy;
    By policyRevisionLocator = By.xpath("//a[contains(@href,'/privacy_agreement/?snr=1_44_44_')]");


//    @FindBy(id = "store_nav_search_term")
//    private WebElement searchField;
    By searchFieldLocator = By.id("store_nav_search_term");

//    @FindBy(xpath = "//a[@id='store_search_link']//img[contains(@src,'blank.gif')]")
//    private WebElement searchButtonSubmit;
     By searchButtonSubmitLocator = By.xpath("//a[@id='store_search_link']//img[contains(@src,'blank.gif')]");

    public MainPage navigateToMainPage() {
        (DriverSingleton.getInstance()).get(ConfigManager.getURL());
        return this;
    }

    /*
        public Boolean isPageOpen(){
        return driver.findElement(languageListLocator).isDisplayed();
    }
     */

    public PrivacyPolicyPage scrollAndOpenPrivacyPolicy() {
        ((JavascriptExecutor) (DriverSingleton.getInstance())).executeScript("arguments[0].scrollIntoView(true);",
                (DriverSingleton.getInstance()).findElement(policyRevisionLocator));
        ConditionalWait.waitToBeClickable(policyRevisionLocator);
        (DriverSingleton.getInstance()).findElement(policyRevisionLocator).click();
//        privacyPolicy.click();
        switchToNewWindow();
        return new PrivacyPolicyPage();
    }

    public void switchToNewWindow() {
        String windowHandleBefore = (DriverSingleton.getInstance()).getWindowHandle(); // Store the current window handle
        for (String windowHandle : (DriverSingleton.getInstance()).getWindowHandles()) { // Switch to new window opened
            (DriverSingleton.getInstance()).switchTo().window(windowHandle);
        }
    }

    public GameSearchPage searchDota2() {
        ConditionalWait.waitToBeClickable(searchFieldLocator);
        (DriverSingleton.getInstance()).findElement(searchFieldLocator).sendKeys(ConfigManager.getGameTitle());
//        searchField.sendKeys(ConfigManager.getGameTitle());
        (DriverSingleton.getInstance()).findElement(searchButtonSubmitLocator).click();
//        searchButtonSubmit.click();
        return new GameSearchPage();
    }

    public GameSearchPage secondSearchGame(String someGame){
        ConditionalWait.waitToBeClickable(searchFieldLocator);
        (DriverSingleton.getInstance()).findElement(searchFieldLocator).sendKeys(someGame);
//        searchField.sendKeys(someGame);
        (DriverSingleton.getInstance()).findElement(searchButtonSubmitLocator).click();

//        searchButtonSubmit.click();
        return new GameSearchPage();
    }
}