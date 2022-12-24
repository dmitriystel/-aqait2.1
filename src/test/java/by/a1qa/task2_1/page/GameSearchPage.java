package by.a1qa.task2_1.page;

import by.a1qa.task2_1.bean.GameInformation;
import by.a1qa.task2_1.bean.Platform;
import by.a1qa.task2_1.driver.DriverSingleton;
import by.a1qa.task2_1.util.ConfigManager;
import by.a1qa.task2_1.util.ParserJavaToJson;
import by.a1qa.task2_1.util.ParserJsonToJava;
import by.a1qa.task2_1.wait.ConditionalWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
Code review 24.12.2022
3rd comment:
@findby will look for an item in the locator right away, even if we don't need it yet, so we shouldn't use it.
Use findElement

fixed: findElement is used
*/
public class GameSearchPage extends BasePage {

    public GameSearchPage() {
        super();
    }
    public static final String DOTA2_SEARCH_RESULT_LIST_DB_PATH = "src/test/resources/testData/Dota2SearchResultListDB.json";
    public static final String SECOND_SEARCH_GAME_RESULT_LIST_DB_PATH = "src/test/resources/testData/SecondSearchGameResultListDB.json";

    By searchResultsFilteredLocator = By.id("search_results_filtered_warning_persistent");
    By searchResultFirstGameNameLocator = By.xpath("//div[@id='search_resultsRows']/a[1]//span[@class='title']");
    By searchResultSecondGameNameLocator = By.xpath("//div[@id='search_resultsRows']/a[2]//span[@class='title']");
    By winPlatformLocator = By.xpath("//div[@id='search_resultsRows']/a[1]//span[@class='platform_img win']");
    By macPlatformLocator = By.xpath("//div[@id='search_resultsRows']/a[1]//span[@class='platform_img mac']");
    By linuxPlatformLocator = By.xpath("//div[@id='search_resultsRows']/a[1]//span[@class='platform_img linux']");
    By searchResultFirstGameReleaseDateLocator =
        By.xpath("//div[@id='search_resultsRows']/a[1]//div[contains(@class,'released')]");
    By searchResultSecondGameReleaseDateLocator
        = By.xpath("//div[@id='search_resultsRows']/a[2]//div[contains(@class,'released')]");
    By searchResultFirstGameReviewSummaryResultLocator
            = By.xpath("//div[@id='search_resultsRows']/a[1]//span[contains(@class,'summary')]");
    By searchResultSecondGameReviewSummaryResultLocator
            = By.xpath("//div[@id='search_resultsRows']/a[2]//span[contains(@class,'summary')]");
    By searchFirstResultFirstGamePriceLocator = By.xpath("//div[@id='search_resultsRows']/a[1]//div[contains(@class,'price_')]");
    By searchSecondResultSecondGamePriceLocator
            = By.xpath("//div[@id='search_resultsRows']/a[2]//div[contains(@class,'col search_price ')]");
    By searchFirstResultSecondGamePriceLocator = By.xpath("//div[@id='search_resultsRows']/a[2]//div[contains(@class,'col search_price_')]");
    By searchSecondResultFirstGamePriceLocator = By.xpath("//div[@id='search_resultsRows']/a[1]//div[contains(@class,'col search_price_')]");
    By searchResultSecondGameRemixMusicLocator = By.xpath("//div[@id='search_resultsRows']/a[2]//span[@class='platform_img music']");
    By searchSecondResultFirstGameRemixMusicLocator = By.xpath("//div[@id='search_resultsRows']/a[1]//span[@class='platform_img music']");
    By searchField2Locator = By.name("displayterm");
    By searchInSearchField2Locator = By.xpath("//*[@class='searchbar']//button/span");

    public Boolean isPageOpen(){
        ConditionalWait.waitElementDisappears(searchResultsFilteredLocator);
        return driver.findElement(searchResultsFilteredLocator).isDisplayed();
    }

    public Boolean isSearchBoxOnResultPageContainsSearchedName(){
        return ((DriverSingleton.getInstance()).findElement(searchField2Locator).getAttribute("value"))
                .equals(ConfigManager.getGameTitle());
    }

    public Boolean isSearchBoxOnResultPageContainsSearchedName2(){
        return ((DriverSingleton.getInstance()).findElement(searchField2Locator).getAttribute("value"))
                .equals((DriverSingleton.getInstance()).findElement(searchResultFirstGameNameLocator).getText());
    }

    public Boolean isTheFirstNameIsEqualsToSearchName(){
        return ((DriverSingleton.getInstance()).findElement(searchResultFirstGameNameLocator).getText()).equals(ConfigManager.getGameTitle());
    }

//    public GameSearchPage getGameInfoResult1() throws IOException {
//        List<GameInformation> gameInfoResult1 = new ArrayList<>();
//
//        GameInformation gameInfoResult1_Game1 =
//                new GameInformation((DriverSingleton.getInstance()).findElement(searchResultFirstGameNameLocator).getText(),
//                        new Platform((DriverSingleton.getInstance()).findElement(winPlatformLocator).getAttribute("class"),
//                                (DriverSingleton.getInstance()).findElement(macPlatformLocator).getAttribute("class"),
//                                (DriverSingleton.getInstance()).findElement(linuxPlatformLocator).getAttribute("class")),
//                        (DriverSingleton.getInstance()).findElement(searchResultFirstGameReleaseDateLocator).getText(),
//                        (DriverSingleton.getInstance()).findElement(searchResultFirstGameReviewSummaryResultLocator).getAttribute("data-tooltip-html"),
//                        (DriverSingleton.getInstance()).findElement(searchFirstResultFirstGamePriceLocator).getText());
//        gameInfoResult1.add(gameInfoResult1_Game1);
//
//        GameInformation gameInfoResult1_Game2 =
//                new GameInformation((DriverSingleton.getInstance()).findElement(searchResultSecondGameNameLocator).getText(),
//                        new Platform((DriverSingleton.getInstance()).findElement(searchResultSecondGameRemixMusicLocator).getAttribute("class")),
//                        (DriverSingleton.getInstance()).findElement(searchResultSecondGameReleaseDateLocator).getText(),
//                        (DriverSingleton.getInstance()).findElement(searchResultSecondGameReviewSummaryResultLocator).getAttribute("data-tooltip-html"),
//                        (DriverSingleton.getInstance()).findElement(searchFirstResultSecondGamePriceLocator).getText());
//        gameInfoResult1.add(gameInfoResult1_Game2);
//
//        ParserJavaToJson.writeJavaInJson(DOTA2_SEARCH_RESULT_LIST_DB_PATH, gameInfoResult1);
//
//        return this;
//    }

    public String getSearchResultSecondGameName(){
        return (DriverSingleton.getInstance()).findElement(searchResultSecondGameNameLocator).getText();
    }
//    public GameSearchPage getGameInfoResult2() throws IOException {
//        List<GameInformation> gameInfoResult2 = new ArrayList<>();
//
//        GameInformation gameInfoResult2_Game1 =
//                new GameInformation( (DriverSingleton.getInstance()).findElement(searchResultFirstGameNameLocator).getText(),
//                        new Platform((DriverSingleton.getInstance()).findElement(searchSecondResultFirstGameRemixMusicLocator).getAttribute("class")),
//                        (DriverSingleton.getInstance()).findElement(searchResultFirstGameReleaseDateLocator).getText(),
//                        (DriverSingleton.getInstance()).findElement(searchResultFirstGameReviewSummaryResultLocator).getAttribute("data-tooltip-html"),
//                       (DriverSingleton.getInstance()).findElement(searchSecondResultFirstGamePriceLocator).getText());
//        gameInfoResult2.add(gameInfoResult2_Game1);
//
//        GameInformation gameInfoResult2_Game2 =
//                new GameInformation((DriverSingleton.getInstance()).findElement(searchResultSecondGameNameLocator).getText(),
//                        new Platform((DriverSingleton.getInstance()).findElement(driver.findElement(searchResultSecondGameRemixMusicLocator).getAttribute("class")),
//                        (DriverSingleton.getInstance()).findElement(searchResultSecondGameReleaseDateLocator).getText()),
//                        (DriverSingleton.getInstance()).findElement(searchResultSecondGameReviewSummaryResultLocator).getAttribute("data-tooltip-html"),
//                        searchSecondResultSecondGamePrice.getText());
//        gameInfoResult2.add(gameInfoResult2_Game2);
//
//        ParserJavaToJson.writeJavaInJson(SECOND_SEARCH_GAME_RESULT_LIST_DB_PATH, gameInfoResult2);
//        return this;
//    }

    public Boolean isStoredItemsAreMatched() throws IOException {
        List<GameInformation> gameInfoResult1FromDB = ParserJsonToJava.jsonParse(DOTA2_SEARCH_RESULT_LIST_DB_PATH);
        List<GameInformation> gameInfoResult2FromDB = ParserJsonToJava.jsonParse(SECOND_SEARCH_GAME_RESULT_LIST_DB_PATH);
        return gameInfoResult1FromDB.containsAll(gameInfoResult2FromDB);
    }
}


/*
 //    @FindBy (id = "search_results_filtered_warning_persistent")
//    private WebElement searchResultsFiltered;
//    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='title']")
//    private WebElement searchResultFirstGameName;
//    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//span[@class='title']")
//    private WebElement searchResultSecondGameName;
//    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='platform_img win']")
//    private WebElement WinPlatform;
//    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='platform_img mac']")
//    private WebElement searchResultSecondGameReleaseDate;
//    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[contains(@class,'summary')]")
//    private WebElement searchResultFirstGameReviewSummaryResult;
//    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//span[contains(@class,'summary')]")
//    private WebElement searchResultSecondGameReviewSummaryResult;
//    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//div[contains(@class,'price_')]")
//    private WebElement searchFirstResultFirstGamePrice;
//    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//div[contains(@class,'col search_price_')]")
//    private WebElement searchFirstResultSecondGamePrice;//    private WebElement MacPlatform;
//    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='platform_img linux']")
//    private WebElement LinuxPlatform;
//    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//div[contains(@class,'released')]")
//    private WebElement searchResultFirstGameReleaseDate;
//    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//div[contains(@class,'released')]")
 //    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//div[contains(@class,'col search_price_')]")
//    private WebElement searchSecondResultFirstGamePrice;
//    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//span[@class='platform_img music']")
//    private WebElement searchResultSecondGameRemixMusic;
//    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='platform_img music']")
//    private WebElement searchSecondResultFirstGameRemixMusic;
//    @FindBy (name = "displayterm")
//    private WebElement searchField2;
//    @FindBy (xpath = "//*[@class='searchbar']//button/span")
//    private WebElement searchInSearchField2;
    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//div[contains(@class,'col search_price ')]")
    private WebElement searchSecondResultSecondGamePrice;
 */

