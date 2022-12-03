package by.a1qa.task2_1test.main;

import by.a1qa.task2_1.bean.GameInformation;
import by.a1qa.task2_1.parser.ParserJsonToJava;
import by.a1qa.task2_1.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.time.Year;
import java.util.List;

import static by.a1qa.task2_1.selenium.SearchResultPagePF.DOTA2_SEARCH_RESULT_LIST_DB_PATH;
import static by.a1qa.task2_1.selenium.SearchResultPagePF.SECOND_SEARCH_GAME_RESULT_LIST_DB_PATH;

public class StoreSteamTest {
    private WebDriver driver;

    @BeforeMethod
    public void browserSetUp() {
        driver = WebDriverSingleton.getInstance();
        driver.manage().window().maximize();
    }

    @Test
    public void testPrivacyPolicySignedInCurrentYear() throws IOException {
        String policyRevisionString = new HomePagePF(driver)
                .openHomePage()
                .scrollHomePage()
                .openPrivacyPolicyPage()
                .getPolicyRevisionString();
        Assert.assertTrue(policyRevisionString.contains(Integer.toString(Year.now().getValue())),
                "Policy revision signed not in the current year.");
    }

    @Test
    public void testGameSearch() throws IOException {
        String GameInfoResult1_Game2_Name = new HomePagePF(driver)
                .openHomePage()
                .searchDota2()
                .getGameInfoResult1()
                .getGameInfoResult1_Game2_Name();

        new HomePagePF(driver)
                .openHomePage()
                .secondSearchGame(GameInfoResult1_Game2_Name)
                .getGameInfoResult2();

        List<GameInformation> gameInfoResult1FromDB = ParserJsonToJava.jsonParse(DOTA2_SEARCH_RESULT_LIST_DB_PATH);
        List<GameInformation> gameInfoResult2FromDB = ParserJsonToJava.jsonParse(SECOND_SEARCH_GAME_RESULT_LIST_DB_PATH);

        Assert.assertEqualsNoOrder(gameInfoResult1FromDB, gameInfoResult2FromDB,
                "The results of the first search do not match the results of the second search." );
    }

    @AfterMethod(alwaysRun = true)
    public void closeWebDiver() {
        driver.quit();
        driver = null;
    }
}

