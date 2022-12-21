package by.a1qa.task2_1.test;

import by.a1qa.task2_1.page.GameSearchResultPage;
import by.a1qa.task2_1.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GameSearchResultTest  extends BaseTest  {
    @Test
    public void testGameSearch() throws IOException {
        MainPage mainPage = new MainPage(driver);

        GameSearchResultPage searchResultPage;
        GameSearchResultPage searchResultPage2;

        searchResultPage = mainPage
                .navigateToMainPage()
                .searchDota2();

        Assert.assertTrue(searchResultPage.isSearchBoxOnResultPageContainsSearchedName(),
                "The first name is not equal to searched name");

        String GameInfoResult1_Game2_Name = searchResultPage
                .getGameInfoResult1()
                .getSearchResultSecondGameName();

        new MainPage(driver)
                .navigateToMainPage()
                .secondSearchGame(GameInfoResult1_Game2_Name)
                .getGameInfoResult2();

        Assert.assertTrue(searchResultPage.isStoredItemsAreMatched(),
                "The results of the first search don't match the results of the second search.");
    }
}
