package by.a1qa.task2_1test.main;

import by.a1qa.task2_1.main.StoreSteamGameSearchPage;
import by.a1qa.task2_1.main.StoreSteamHomePage;
import by.a1qa.task2_1.main.StoreSteamPrivacyAgreementPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Year;

public class StoreSteamTest extends BaseTest {

    @Test
    public void testPrivacyPolicySignedInCurrentYear(){
        // как объекты создать перед тестом?
        StoreSteamHomePage storeSteamHomePage = StoreSteamHomePage.getInstance();
        StoreSteamPrivacyAgreementPage storeSteamPrivacyAgreementPage = new StoreSteamPrivacyAgreementPage(driver);
        driver.get(storeSteamHomePage.URL);
        // 2. Scroll and open PRIVACY POLICY. Privacy policy page is open in the new tab. Switch language elements list displayed.
        storeSteamHomePage.clickButtonPrivacyPolicy();
        // 3. Policy revision signed in the current year.
        storeSteamHomePage.switchToNewWindow();
        String policyRevisionString = storeSteamPrivacyAgreementPage.getPolicyRevisionString();

        Assert.assertTrue(policyRevisionString.contains(Integer.toString(Year.now().getValue())),
                "Policy revision signed not in the current year.");
    }

    @Test
    public void testGameSearch(){
        // как объекты создать перед тестом?
        StoreSteamHomePage storeSteamPage = StoreSteamHomePage.getInstance();
        StoreSteamGameSearchPage storeSteamGameSearchPage = new StoreSteamGameSearchPage(driver);
        driver.get(storeSteamPage.URL); //  такая же строчка в первом методе
        // 2. Search "Dota 2" in the search field - OK. В поиске набираем Dota 2, нажимаем найти. Получаем список игр
        storeSteamPage.writeGameTitleInSearchField();
        storeSteamPage.clickButtonSearchInSearchField();
        // 3. Save information about the 1st and 2nd results from the list (name, platforms, release date,
        // review summary result, price)
        String firstResultFromListAfterSearchDota_2 = storeSteamGameSearchPage.getFirstResultFromListAfterSearchDota_2();
        String secondResultFromListAfterSearchDota_2 = storeSteamGameSearchPage.getSecondResultFromListAfterSearchDota_2();
        // 4. Search the second name (received from result list) in the search field in the header
        // Search box on result page contains searched name
        //Result list contains 2 stored items form the previous search. All stored data are matched.
        String secondNameFromResultListAfterSearchDota_2 = storeSteamGameSearchPage.getSecondNameFromResultListAfterSearchDota_2();
        storeSteamGameSearchPage.writeSecondNameFromResultListAfterSearchDota_2InSearchField(secondNameFromResultListAfterSearchDota_2);
        storeSteamGameSearchPage.clickSearchInSearchField2();
        /*
Search box on result page contains searched name. Result list contains 2 stored items form the previous search.
All stored data are matched.
Поле поиска на странице результатов содержит искомое имя. Список результатов содержит 2 сохраненных элемента из
предыдущего поиска. Все сохраненные данные совпадают.
         */
        String firstNameFromResultListSecondSearch = storeSteamGameSearchPage.getFirstNameFromResultListSecondSearch();
        Boolean firstCompare =
                storeSteamGameSearchPage.compareFirstNameFromResultListSecondSearchWithListAfterSearchDota_2(firstNameFromResultListSecondSearch,
                firstResultFromListAfterSearchDota_2, secondResultFromListAfterSearchDota_2);
        String secondNameFromResultListSecondSearch = storeSteamGameSearchPage.getSecondNameFromResultListSecondSearch();

        Boolean secondCompare =
                storeSteamGameSearchPage.compareSecondNameFromResultListSecondSearchWithListAfterSearchDota_2(secondNameFromResultListSecondSearch,
                firstResultFromListAfterSearchDota_2, secondResultFromListAfterSearchDota_2);

        Assert.assertTrue(firstCompare && secondCompare,
                "Result list doesn't contain 2 stored items form the previous search. All stored data aren't matched.");
    }
}
