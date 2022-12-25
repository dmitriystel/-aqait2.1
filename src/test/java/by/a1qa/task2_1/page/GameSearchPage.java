package by.a1qa.task2_1.page;

import by.a1qa.task2_1.bean.GameInformation;
import by.a1qa.task2_1.bean.Platform;
import by.a1qa.task2_1.driver.DriverSingleton;
import by.a1qa.task2_1.util.ConfigManager;
import by.a1qa.task2_1.util.ParserJavaToJson;
import by.a1qa.task2_1.util.ParserJsonToJava;
import by.a1qa.task2_1.wait.ConditionalWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    By gameRowsLocator = By.xpath("//a[contains(@class,'search_result_row')]");
    By nameLocator = By.xpath(".//span[contains(@class, 'title')]");
    By platformLocator = By.xpath(".//span[contains(@class, 'platform')]");
    By releaseDateLocator = By.xpath(".//div[contains(@class, 'release')]");
    By reviewSummaryResultLocator = By.xpath(".//span[contains(@class, 'review')]");
    By priceLocator = By.xpath(".//div[contains(@class, 'price')]//div[contains(@class, 'price')]");

    public List<WebElement> getGameRows(){
        List<WebElement> gameRows = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            gameRows.add(((DriverSingleton.getInstance()).findElement(gameRowsLocator)));
        }
        return gameRows;
    }

    public GameSearchPage getGamesInfoResults(List<WebElement> gameRows){
        List<GameInformation> gameInfoResults = new ArrayList<>();
        for(WebElement element : gameRows){
            gameInfoResults.add(getGameInfo(element)); ;
        }
        return this;
    }

    public GameInformation getGameInfo(WebElement element){
        String title = element.findElement(nameLocator).getText();
        String windowsOrRemixe = "";
        if ( (DriverSingleton.getInstance()).findElement(platformLocator).isDisplayed() ){
            windowsOrRemixe = (DriverSingleton.getInstance()).findElement(platformLocator).getAttribute("class");
        } else {
            windowsOrRemixe = "not provided";
        }

        String macOS = "";
        if ((DriverSingleton.getInstance()).findElement(platformLocator).isDisplayed()){
            macOS = (DriverSingleton.getInstance()).findElement(platformLocator).getAttribute("class");
        } else {
            macOS = "not provided";
        }
        String steamOS = "";
        if ((DriverSingleton.getInstance()).findElement(platformLocator).isDisplayed()){
            steamOS = (DriverSingleton.getInstance()).findElement(platformLocator).getAttribute("class");
        } else {
            steamOS = "not provided";
        }
        String releaseDate = (DriverSingleton.getInstance()).findElement(releaseDateLocator).getText();
        String reviewSummaryResult =  (DriverSingleton.getInstance()).findElement(reviewSummaryResultLocator).getAttribute("data-tooltip-html");
        String price = (DriverSingleton.getInstance()).findElement(priceLocator).getText();
        GameInformation gameInfoResult = new GameInformation (title, new Platform(windowsOrRemixe, macOS, steamOS), releaseDate, reviewSummaryResult, price);
        System.out.println(gameInfoResult);
        return gameInfoResult;
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


    public GameSearchPage getGamesInfoResults(String path) throws IOException {
        List<GameInformation> gameInfoResults = new ArrayList<>();

        String title1 = (DriverSingleton.getInstance()).findElement(searchResultFirstGameNameLocator).getText();
        String windowsOrRemixe1 = "";

        if ( (DriverSingleton.getInstance()).findElement(winPlatformLocator).isDisplayed() ){
            windowsOrRemixe1 = (DriverSingleton.getInstance()).findElement(winPlatformLocator).getAttribute("class");
        } else if ( (DriverSingleton.getInstance()).findElement(searchSecondResultFirstGameRemixMusicLocator).isDisplayed() ){
            (DriverSingleton.getInstance()).findElement(searchResultSecondGameRemixMusicLocator).getAttribute("class");
        }

        String macOS1 = "";
        if ((DriverSingleton.getInstance()).findElement(macPlatformLocator).isDisplayed()){
            macOS1 = (DriverSingleton.getInstance()).findElement(macPlatformLocator).getAttribute("class");
        } else {
            macOS1 = "not provided";
        }
        String steamOS1 = "";
        if ((DriverSingleton.getInstance()).findElement(linuxPlatformLocator).isDisplayed()){
            steamOS1 = (DriverSingleton.getInstance()).findElement(linuxPlatformLocator).getAttribute("class");
        } else {
            steamOS1 = "not provided";
        }
        String releaseDate = (DriverSingleton.getInstance()).findElement(searchResultFirstGameReleaseDateLocator).getText();
        String reviewSummaryResult =  (DriverSingleton.getInstance()).findElement(searchResultFirstGameReviewSummaryResultLocator).getAttribute("data-tooltip-html");
        String price = (DriverSingleton.getInstance()).findElement(searchFirstResultFirstGamePriceLocator).getText();
        GameInformation gameInfoResul1 = new GameInformation (title1, new Platform(windowsOrRemixe1, macOS1, steamOS1), releaseDate, reviewSummaryResult, price);



        gameInfoResults.add(gameInfoResul1);



        String title2 = (DriverSingleton.getInstance()).findElement(searchResultSecondGameNameLocator).getText();





        String windowsOrRemixe2 = "";
        if ( (DriverSingleton.getInstance()).findElement(winPlatformLocator).isDisplayed() ){
            windowsOrRemixe2 = (DriverSingleton.getInstance()).findElement(winPlatformLocator).getAttribute("class");
        } else if ( (DriverSingleton.getInstance()).findElement(searchSecondResultFirstGameRemixMusicLocator).isDisplayed() ){
            (DriverSingleton.getInstance()).findElement(searchResultSecondGameRemixMusicLocator).getAttribute("class");
        }



        String macOS2 = "";
        if ((DriverSingleton.getInstance()).findElement(macPlatformLocator).isDisplayed()){
            macOS2 = (DriverSingleton.getInstance()).findElement(macPlatformLocator).getAttribute("class");
        } else {
            macOS2 = "not provided";
        }


        String steamOS2 = "";
        if ((DriverSingleton.getInstance()).findElement(linuxPlatformLocator).isDisplayed()){
            steamOS2 = (DriverSingleton.getInstance()).findElement(linuxPlatformLocator).getAttribute("class");
        } else {
            steamOS2 = "not provided";
        }
        String releaseDate2 = (DriverSingleton.getInstance()).findElement(searchResultSecondGameReleaseDateLocator).getText();
        String reviewSummaryResult2 =  (DriverSingleton.getInstance()).findElement(searchResultSecondGameReviewSummaryResultLocator).getAttribute("data-tooltip-html");
        String price2 = (DriverSingleton.getInstance()).findElement(searchFirstResultSecondGamePriceLocator).getText();
        GameInformation gameInfoResul2 = new GameInformation (title2, new Platform(windowsOrRemixe2, macOS2, steamOS2), releaseDate2, reviewSummaryResult2, price2);
        gameInfoResults.add(gameInfoResul2);


        ParserJavaToJson.writeJavaInJson(path, gameInfoResults);



        return this;

    }








    public String getSearchResultSecondGameName(){
        return (DriverSingleton.getInstance()).findElement(searchResultSecondGameNameLocator).getText();
    }


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