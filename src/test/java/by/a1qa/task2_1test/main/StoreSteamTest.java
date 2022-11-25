package by.a1qa.task2_1test.main;

import by.a1qa.task2_1.main.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Year;

public class StoreSteamTest extends BaseTest {

    @Test
    public void testPrivacyPolicySignedInCurrentYear(){
        // как объекты создать перед тестом?
        //HomePage storeSteamHomePage = HomePage.getInstance();
        HomePagePF homePageAnnotated = PageFactory.initElements(driver, HomePagePF.class);

        // PrivacyAgreementPage storeSteamPrivacyAgreementPage = new PrivacyAgreementPage(driver);
        PrivacyAgreementPagePF privacyAgreementPageAnnotated = PageFactory.initElements(driver, PrivacyAgreementPagePF.class);
        driver.get(HomePagePF.HOMEPAGE_URL);
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // 2. Scroll and open PRIVACY POLICY. Privacy policy page is open in the new tab. Switch language elements list displayed.
        homePageAnnotated.clickButtonPrivacyPolicy();
        // 3. Policy revision signed in the current year.
        homePageAnnotated.switchToNewWindow();
        String policyRevisionString = privacyAgreementPageAnnotated.getPolicyRevisionString();

        Assert.assertTrue(policyRevisionString.contains(Integer.toString(Year.now().getValue())),
                "Policy revision signed not in the current year.");
    }

    @Test
    public void testGameSearch(){
        // как объекты создать перед тестом?
        // HomePage storeSteamPage = HomePage.getInstance();
        //HomePage storeSteamPage = new HomePage(driver);
        HomePagePF homePageAnnotated = PageFactory.initElements(driver, HomePagePF.class);

        // SearchResultPage storeSteamGameSearchPage = new SearchResultPage(driver);
        SearchResultPagePF searchResultPageAnnotated = PageFactory.initElements(driver, SearchResultPagePF.class);



        driver.get(homePageAnnotated.HOMEPAGE_URL); //  такая же строчка в первом методе
        // 2. Search "Dota 2" in the search field - OK. В поиске набираем Dota 2, нажимаем найти. Получаем список игр
        homePageAnnotated.searchDota2();
        //homePageAnnotated.clickButtonSearchInSearchField();
        // 3. Save information about the 1st and 2nd results from the list (name, platforms, release date,
        // review summary result, price)
        String firstResultFromListAfterSearchDota_2 = searchResultPageAnnotated.getFirstResultFromListAfterSearchDota2();
        String secondResultFromListAfterSearchDota_2 = searchResultPageAnnotated.getSecondResultFromListAfterSearchDota2();
        // 4. Search the second name (received from result list) in the search field in the header
        // Search box on result page contains searched name
        //Result list contains 2 stored items form the previous search. All stored data are matched.
        String secondNameFromResultListAfterSearchDota_2 = searchResultPageAnnotated.getSecondNameFromResultListAfterSearchDota2();
        searchResultPageAnnotated.writeSecondNameFromResultListAfterSearchDota_2InSearchField(secondNameFromResultListAfterSearchDota_2);
        searchResultPageAnnotated.clickSearchInSearchField2();
        /*
Search box on result page contains searched name. Result list contains 2 stored items form the previous search.
All stored data are matched.
Поле поиска на странице результатов содержит искомое имя. Список результатов содержит 2 сохраненных элемента из
предыдущего поиска. Все сохраненные данные совпадают.
         */
        String firstNameFromResultListSecondSearch = searchResultPageAnnotated.getFirstNameFromResultListSecondSearch();
        Boolean firstCompare =
                searchResultPageAnnotated.compareFirstNameFromResultListSecondSearchWithListAfterSearchDota_2(firstNameFromResultListSecondSearch,
                firstResultFromListAfterSearchDota_2, secondResultFromListAfterSearchDota_2);
        String secondNameFromResultListSecondSearch = searchResultPageAnnotated.getSecondNameFromResultListSecondSearch();

        Boolean secondCompare =
                searchResultPageAnnotated.compareSecondNameFromResultListSecondSearchWithListAfterSearchDota_2(secondNameFromResultListSecondSearch,
                firstResultFromListAfterSearchDota_2, secondResultFromListAfterSearchDota_2);

        Assert.assertTrue(firstCompare && secondCompare,
                "Result list doesn't contain 2 stored items form the previous search. All stored data aren't matched.");
    }
}
