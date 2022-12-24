package by.a1qa.task2_1.test;

import by.a1qa.task2_1.page.GameSearchPage;
import by.a1qa.task2_1.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GameSearchTest extends BaseTest  {
    @Test
    public void testGameSearch() throws IOException {
        MainPage mainPage = new MainPage();
        MainPage mainPage2 = new MainPage();
        GameSearchPage searchResultPage;
        GameSearchPage searchResultPage2;

        searchResultPage = mainPage
                .navigateToMainPage()
                .searchDota2();

        Assert.assertTrue(searchResultPage.isPageOpen(), "Results page isn't open.");
        Assert.assertTrue(searchResultPage.isSearchBoxOnResultPageContainsSearchedName(),
                "Search box on result page doesn't contain searched name");
        Assert.assertTrue(searchResultPage.isTheFirstNameIsEqualsToSearchName(),
                "The first name isn't equal to searched name.");
//        String GameInfoResult1_Game2_Name = searchResultPage
//                .getGameInfoResult1()
//                .getSearchResultSecondGameName();
//
//        searchResultPage2 = mainPage2
//                .navigateToMainPage()
//                .secondSearchGame(GameInfoResult1_Game2_Name)
//                .getGameInfoResult2();

//        Assert.assertTrue(searchResultPage2.isSearchBoxOnResultPageContainsSearchedName2(),
//                "Search box on result page doesn't contain searched name" );
//        Assert.assertTrue(searchResultPage2.isStoredItemsAreMatched(),
//                "The results of the first search don't match the results of the second search.");
    }
}