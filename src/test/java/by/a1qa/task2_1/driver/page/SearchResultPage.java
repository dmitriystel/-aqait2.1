package by.a1qa.task2_1.driver.page;

import by.a1qa.task2_1.driver.bean.GameInformation;
import by.a1qa.task2_1.driver.bean.Platform;
import by.a1qa.task2_1.driver.util.ParserJavaToJson;
import by.a1qa.task2_1.driver.util.ParserJsonToJava;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.a1qa.task2_1.driver.page.MainPage.GAME_TITLE;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public static final String DOTA2_SEARCH_RESULT_LIST_DB_PATH = "src/test/resources/testData/Dota2SearchResultListDB.json";
    public static final String SECOND_SEARCH_GAME_RESULT_LIST_DB_PATH = "src/test/resources/testData/SecondSearchGameResultListDB.json";
// ok
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[1]//span[@class=\"title\"]")
    private WebElement gameInfoResult1_Game1_Name;

    // ok
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[1]//span[@class=\"platform_img win\"]")
    private WebElement gameInfoResult1_Game1_WinPlatform;
    // ok
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[1]//span[@class=\"platform_img mac\"]")
    private WebElement gameInfoResult1_Game1_MacPlatform;

    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[1]//span[@class=\"platform_img linux\"]")
    private WebElement gameInfoResult1_Game1_LinuxPlatform;

    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[1]//div[@class=\"col search_released responsive_secondrow\"]")
    private WebElement gameInfoResult1_Game1_ReleaseDate;

    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[1]//span[@class=\"search_review_summary positive\"]")
    private WebElement gameInfoResult1_Game1_ReviewSummaryResult;

    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[1]//div[@class=\"col search_price_discount_combined responsive_secondrow\"]")
    private WebElement gameInfoResult1_Game1_Price;


    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[2]//span[@class=\"title\"]")
    private WebElement gameInfoResult1_Game2_Name;

    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[2]//span[@class=\"platform_img music\"]")
    private WebElement gameInfoResult1_Game2_RemixeMusic;

    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[2]//div[@class=\"col search_released responsive_secondrow\"]")
    private WebElement gameInfoResult1_Game2_ReleaseDate;

    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[2]//span[@class=\"search_review_summary positive\"]")
    private WebElement gameInfoResult1_Game2_ReviewSummaryResult;

    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[2]//div[@class=\"col search_price_discount_combined responsive_secondrow\"]")
    private WebElement gameInfoResult1_Game2_Price;



    //
    @FindBy (name = "displayterm")
    private WebElement searchField2;

    //
    @FindBy (xpath = "//*[@class=\"searchbar\"]//button/span")
    private WebElement searchInSearchField2;

    // duplication
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[1]//span[@class=\"title\"]")
    private WebElement gameInfoResult2_Game1_Name;

    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[1]//span[@class=\"platform_img music\"]")
    private WebElement gameInfoResult2_Game1_RemixeMusic;

    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[1]//div[@class=\"col search_released responsive_secondrow\"]")
    private WebElement gameInfoResult2_Game1_ReleaseDate;

    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[1]//span[@class=\"search_review_summary positive\"]")
    private WebElement gameInfoResult2_Game1_ReviewSummaryResult;

    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[1]//div[@class=\"col search_price  responsive_secondrow\"]")
    private WebElement gameInfoResult2_Game1_Price;

    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[2]//span[@class=\"title\"]")
    private WebElement gameInfoResult2_Game2_Name;

    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[2]//span[@class=\"platform_img music\"]")
    private WebElement gameInfoResult2_Game2_RemixeMusic;

    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[2]//div[@class=\"col search_released responsive_secondrow\"]")
    private WebElement gameInfoResult2_Game2_ReleaseDate;

    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[2]//span[@class=\"search_review_summary positive\"]")
    private WebElement gameInfoResult2_Game2_ReviewSummaryResult;

    //
    @FindBy(xpath = "//div[@id=\"search_resultsRows\"]/a[2]//div[@class=\"col search_price  responsive_secondrow\"]")
    private WebElement gameInfoResult2_Game2_Price;




    public Boolean isSearchBoxOnResultPageContainsSearchedName(){
        return (searchField2.getAttribute("value")).equals(GAME_TITLE);
    }


    public SearchResultPage getGameInfoResult1() throws IOException {

        List<GameInformation> gameInfoResult1 = new ArrayList<>();

        GameInformation gameInfoResult1_Game1 =
                new GameInformation(gameInfoResult1_Game1_Name.getText(),
                        new Platform(gameInfoResult1_Game1_WinPlatform.getAttribute("class"),

                                gameInfoResult1_Game1_MacPlatform.getAttribute("class"),

                                gameInfoResult1_Game1_LinuxPlatform.getAttribute("class")),
                        gameInfoResult1_Game1_ReleaseDate.getText(),
                        gameInfoResult1_Game1_ReviewSummaryResult.getAttribute("data-tooltip-html"),
                        gameInfoResult1_Game1_Price.getText() );
        gameInfoResult1.add(gameInfoResult1_Game1);

        GameInformation gameInfoResult1_Game2 =
                new GameInformation(gameInfoResult1_Game2_Name.getText(),
                        new Platform(gameInfoResult1_Game2_RemixeMusic.getAttribute("class")),
                        gameInfoResult1_Game2_ReleaseDate.getText(),
                        gameInfoResult1_Game2_ReviewSummaryResult.getAttribute("data-tooltip-html"),
                        gameInfoResult1_Game2_Price.getText());
        gameInfoResult1.add(gameInfoResult1_Game2);

        ParserJavaToJson.writeJavaInJson(DOTA2_SEARCH_RESULT_LIST_DB_PATH, gameInfoResult1);

        return this;
    }

    public String getGameInfoResult1_Game2_Name(){
    return gameInfoResult1_Game2_Name.getText();
    }

    public SearchResultPage getGameInfoResult2() throws IOException {

        List<GameInformation> gameInfoResult2 = new ArrayList<>();

        GameInformation gameInfoResult2_Game1 =
                new GameInformation(gameInfoResult2_Game1_Name.getText(),
                        new Platform(gameInfoResult2_Game1_RemixeMusic.getAttribute("class")),
                        gameInfoResult2_Game1_ReleaseDate.getText(),
                        gameInfoResult2_Game1_ReviewSummaryResult.getAttribute("data-tooltip-html"),
                        gameInfoResult2_Game1_Price.getText());
        gameInfoResult2.add(gameInfoResult2_Game1);

        GameInformation gameInfoResult2_Game2 =
                new GameInformation(gameInfoResult2_Game2_Name.getText(),
                        new Platform(gameInfoResult2_Game2_RemixeMusic.getAttribute("class")),
                        gameInfoResult2_Game2_ReleaseDate.getText(),
                        gameInfoResult2_Game2_ReviewSummaryResult.getAttribute("data-tooltip-html"),
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



