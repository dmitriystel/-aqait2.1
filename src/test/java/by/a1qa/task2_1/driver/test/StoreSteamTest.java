package by.a1qa.task2_1.driver.test;

import by.a1qa.task2_1.driver.page.MainPage;
import by.a1qa.task2_1.driver.page.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import by.a1qa.task2_1.driver.page.PrivacyPolicyPage;

import java.io.IOException;
import java.time.Year;

public class StoreSteamTest extends BaseTest {


    @Test
    public void testPrivacyPolicySignedInCurrentYear() throws IOException {
        MainPage mainPage = new MainPage(driver);
        PrivacyPolicyPage privacyPolicyPage;

        privacyPolicyPage = mainPage
                .navigateToMainPage()
                .scrollAndOpenPrivacyPolicy();

        Assert.assertTrue(privacyPolicyPage.isSwitchLanguageElementsListDisplayed(),
                "Privacy policy page is not open in the new tab.");

        String policyRevisionString = privacyPolicyPage
                .getPolicyRevisionString();

        Assert.assertTrue(policyRevisionString.contains(Integer.toString(Year.now().getValue())),
                "Policy revision didn't sign in the current year.");
    }

    @Test
    public void testGameSearch() throws IOException {
        MainPage mainPage = new MainPage(driver);

        SearchResultPage searchResultPage;
        SearchResultPage searchResultPage2;

        searchResultPage = mainPage
                .navigateToMainPage()
                .searchDota2();

        Assert.assertTrue(searchResultPage.isSearchBoxOnResultPageContainsSearchedName(),
                "The first name is not equal to searched name");

        String GameInfoResult1_Game2_Name = searchResultPage
                .getGameInfoResult1()
                .getGameInfoResult1_Game2_Name();


        new MainPage(driver)
                .navigateToMainPage()
                .secondSearchGame(GameInfoResult1_Game2_Name)
                .getGameInfoResult2();

        Assert.assertTrue(searchResultPage.isStoredItemsAreMatched(),
                "The results of the first search don't match the results of the second search.");


    }


}
