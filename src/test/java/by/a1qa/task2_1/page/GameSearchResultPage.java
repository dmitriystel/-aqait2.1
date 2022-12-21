package by.a1qa.task2_1.page;

import by.a1qa.task2_1.bean.GameInformation;
import by.a1qa.task2_1.bean.Platform;
import by.a1qa.task2_1.util.ParserJavaToJson;
import by.a1qa.task2_1.util.ParserJsonToJava;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameSearchResultPage extends BasePage {
    public GameSearchResultPage(WebDriver driver) {
        super(driver);
    }
    public static final String DOTA2_SEARCH_RESULT_LIST_DB_PATH = "src/test/resources/testData/Dota2SearchResultListDB.json";
    public static final String SECOND_SEARCH_GAME_RESULT_LIST_DB_PATH = "src/test/resources/testData/SecondSearchGameResultListDB.json";

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='title']")
    private WebElement searchResultFirstGameName;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//span[@class='title']")
    private WebElement searchResultSecondGameName;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='platform_img win']")
    private WebElement WinPlatform;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='platform_img mac']")
    private WebElement MacPlatform;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='platform_img linux']")
    private WebElement LinuxPlatform;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//div[@class='col search_released responsive_secondrow']")
    private WebElement searchResultFirstGameReleaseDate;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//div[@class='col search_released responsive_secondrow']")
    private WebElement searchResultSecondGameReleaseDate;

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='search_review_summary positive']")
    private WebElement searchResultFirstGameReviewSummaryResult;
//    //
//    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='search_review_summary positive']")
//    private WebElement gameInfoResult2_Game1_ReviewSummaryResult;

    //
    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//span[@class='search_review_summary positive']")
    private WebElement searchResultSecondGameReviewSummaryResult;
//    //
//    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//span[@class='search_review_summary positive']")
//    private WebElement gameInfoResult2_Game2_ReviewSummaryResult;




    //Price
    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//div[@class='col search_price_discount_combined responsive_secondrow']")
    private WebElement gameInfoResult1_Game1_Price; // searchFirstResultFirstGamePrice
    //

    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//div[@class='col search_price  responsive_secondrow']")
    private WebElement gameInfoResult2_Game2_Price; // searchSecondResultSecondGamePrice

    //
    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//div[@class='col search_price_discount_combined responsive_secondrow']")
    private WebElement gameInfoResult1_Game2_Price; // searchFirstResultSecondGamePrice
    //
    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//div[@class='col search_price  responsive_secondrow']")
    private WebElement gameInfoResult2_Game1_Price; // searchSecondResultFirstGamePrice



    //
    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//span[@class='platform_img music']")
    private WebElement gameInfoResult_Game2_RemixeMusic; // searchFirstResultSecondGameRemixMusic
//    //
//    @FindBy(xpath = "//div[@id='search_resultsRows']/a[2]//span[@class='platform_img music']")
//    private WebElement gameInfoResult2_Game2_RemixeMusic;




    //
    @FindBy(xpath = "//div[@id='search_resultsRows']/a[1]//span[@class='platform_img music']")
    private WebElement gameInfoResult2_Game1_RemixeMusic; // searchSecondResultSecondGameRemixMusic




    @FindBy (name = "displayterm")
    private WebElement searchField2;

    @FindBy (xpath = "//*[@class='searchbar']//button/span")
    private WebElement searchInSearchField2;



    public Boolean isSearchBoxOnResultPageContainsSearchedName(){
        return (searchField2.getAttribute("value")).equals(MainPage.GAME_TITLE);
    }


    public GameSearchResultPage getGameInfoResult1() throws IOException {

        List<GameInformation> gameInfoResult1 = new ArrayList<>();

        GameInformation gameInfoResult1_Game1 =
                new GameInformation(searchResultFirstGameName.getText(),
                        new Platform(WinPlatform.getAttribute("class"),

                                MacPlatform.getAttribute("class"),

                                LinuxPlatform.getAttribute("class")),
                        searchResultFirstGameReleaseDate.getText(),
                        searchResultFirstGameReviewSummaryResult.getAttribute("data-tooltip-html"),
                        gameInfoResult1_Game1_Price.getText() );
        gameInfoResult1.add(gameInfoResult1_Game1);

        GameInformation gameInfoResult1_Game2 =
                new GameInformation(searchResultSecondGameName.getText(),
                        new Platform(gameInfoResult_Game2_RemixeMusic.getAttribute("class")),
                        searchResultSecondGameReleaseDate.getText(),
                        searchResultSecondGameReviewSummaryResult.getAttribute("data-tooltip-html"),
                        gameInfoResult1_Game2_Price.getText());
        gameInfoResult1.add(gameInfoResult1_Game2);

        ParserJavaToJson.writeJavaInJson(DOTA2_SEARCH_RESULT_LIST_DB_PATH, gameInfoResult1);

        return this;
    }

    public String getSearchResultSecondGameName(){
        return searchResultSecondGameName.getText();
    }

    public GameSearchResultPage getGameInfoResult2() throws IOException {

        List<GameInformation> gameInfoResult2 = new ArrayList<>();

        GameInformation gameInfoResult2_Game1 =
                new GameInformation(searchResultFirstGameName.getText(),
                        new Platform(gameInfoResult2_Game1_RemixeMusic.getAttribute("class")),
                        searchResultFirstGameReleaseDate.getText(),
                        searchResultFirstGameReviewSummaryResult.getAttribute("data-tooltip-html"),
                        gameInfoResult2_Game1_Price.getText());
        gameInfoResult2.add(gameInfoResult2_Game1);

        GameInformation gameInfoResult2_Game2 =
                new GameInformation(searchResultSecondGameName.getText(),
                        new Platform(gameInfoResult_Game2_RemixeMusic.getAttribute("class")),
                        searchResultSecondGameReleaseDate.getText(),
                        searchResultSecondGameReviewSummaryResult.getAttribute("data-tooltip-html"),
                        gameInfoResult2_Game2_Price.getText());
        gameInfoResult2.add(gameInfoResult2_Game2);

        ParserJavaToJson.writeJavaInJson(SECOND_SEARCH_GAME_RESULT_LIST_DB_PATH, gameInfoResult2);

        return this;
    }

    public Boolean isStoredItemsAreMatched() throws IOException {
        List<GameInformation> gameInfoResult1FromDB = ParserJsonToJava.jsonParse(DOTA2_SEARCH_RESULT_LIST_DB_PATH);
        List<GameInformation> gameInfoResult2FromDB = ParserJsonToJava.jsonParse(SECOND_SEARCH_GAME_RESULT_LIST_DB_PATH);
        return gameInfoResult1FromDB.containsAll(gameInfoResult2FromDB);
    }
}



