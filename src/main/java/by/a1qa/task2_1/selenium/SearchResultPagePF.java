package by.a1qa.task2_1.selenium;

import by.a1qa.task2_1.bean.GameInformation;
import by.a1qa.task2_1.bean.Platform;
import by.a1qa.task2_1.parser.ParserJavaToJson;
import by.a1qa.task2_1.parser.ParserJsonToJava;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchResultPagePF extends BasePage {
    public SearchResultPagePF(WebDriver driver) {
        super(driver);
    }

    public static final String DOTA2_SEARCH_RESULT_LIST_DB_PATH = "src/test/resources/Dota2SearchResultListDB.json";
    public static final String SECOND_SEARCH_GAME_RESULT_LIST_DB_PATH = "src/test/resources/SecondSearchGameResultListDB.json";

    @FindBy(xpath = "//span[text()=\"Dota 2\"]\n")
    private WebElement gameInfoResult1_Game1_Name;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[1]/div[2]/div[1]/div/span[1]")
    private WebElement gameInfoResult1_Game1_WinPlatform;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[1]/div[2]/div[1]/div/span[2]")
    private WebElement gameInfoResult1_Game1_MacPlatform;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[1]/div[2]/div[1]/div/span[3]")
    private WebElement gameInfoResult1_Game1_LinuxPlatform;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[1]/div[2]/div[2]")
    private WebElement gameInfoResult1_Game1_ReleaseDate;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[1]/div[2]/div[3]/span")
    private WebElement gameInfoResult1_Game1_ReviewSummaryResult;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[1]/div[2]/div[4]/div[2]")
    private WebElement gameInfoResult1_Game1_Price;


    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[2]/div[2]/div[1]/span")
    private WebElement gameInfoResult1_Game2_Name;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[2]/div[2]/div[1]/div/span")
    private WebElement gameInfoResult1_Game2_RemixeMusic;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[2]/div[2]/div[2]")
    private WebElement gameInfoResult1_Game2_ReleaseDate;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[2]/div[2]/div[3]/span")
    private WebElement gameInfoResult1_Game2_ReviewSummaryResult;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[2]/div[2]/div[4]/div[2]")
    private WebElement gameInfoResult1_Game2_Price;



    @FindBy (xpath = "//*[@id=\"term\"]")
    private WebElement searchField2;

    @FindBy (xpath = "//*[@id=\"advsearchform\"]/div[1]/div/div[1]/div[1]/div[2]/button/span")
    private WebElement searchInSearchField2;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[1]/div[2]/div[1]/span")
    private WebElement gameInfoResult2_Game1_Name;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[1]/div[2]/div[1]/div/span")
    private WebElement gameInfoResult2_Game1_RemixeMusic;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[1]/div[2]/div[2]")
    private WebElement gameInfoResult2_Game1_ReleaseDate;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[1]/div[2]/div[3]/span")
    private WebElement gameInfoResult2_Game1_ReviewSummaryResult;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[1]/div[2]/div[4]/div[2]")
    private WebElement gameInfoResult2_Game1_Price;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[2]/div[2]/div[1]")
    private WebElement gameInfoResult2_Game2_Name;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[2]/div[2]/div[1]/div/span")
    private WebElement gameInfoResult2_Game2_RemixeMusic;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[2]/div[2]/div[2]")
    private WebElement gameInfoResult2_Game2_ReleaseDate;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[2]/div[2]/div[3]/span")
    private WebElement gameInfoResult2_Game2_ReviewSummaryResult;

    @FindBy(xpath = "//*[@id=\"search_resultsRows\"]/a[2]/div[2]/div[4]/div[2]")
    private WebElement gameInfoResult2_Game2_Price;

    public SearchResultPagePF getGameInfoResult1() throws IOException {

        List<GameInformation> gameInfoResult1 = new ArrayList<>();

        GameInformation gameInfoResult1_Game1 =
                new GameInformation(gameInfoResult1_Game1_Name.getText(),
                        new Platform(gameInfoResult1_Game1_WinPlatform.getAttribute("class"),

                                gameInfoResult1_Game1_MacPlatform.getAttribute("class"),
//                                gameInfoResult1_Game1_MacPlatform.getText(),

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

    public SearchResultPagePF getGameInfoResult2() throws IOException {

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
}



