package by.a1qa.task2_1test.main;

import by.a1qa.task2_1.main.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Year;

public class StoreSteamTest {
    WebDriver driver;
    HomePagePF homePagePF;
    PrivacyAgreementPagePF privacyAgreementPagePF;
    SearchResultPagePF searchResultPagePF;

    @BeforeMethod
    public void setWebDriver() {
        driver = WebDriverSingleton.getInstance();
        homePagePF = PageFactory.initElements(driver, HomePagePF.class);
        privacyAgreementPagePF = PageFactory.initElements(driver, PrivacyAgreementPagePF.class);
        searchResultPagePF = PageFactory.initElements(driver, SearchResultPagePF.class);
        driver.get(HomePagePF.HOMEPAGE_URL);
    }

    @AfterClass
    public void closeWebDiver() {
        driver.quit();
    }

    @Test
    public void testPrivacyPolicySignedInCurrentYear(){
        homePagePF.clickButtonPrivacyPolicy();

        // Это тестовые данные? Т.е. эту строку нужно сохранить в json или xml?
        String policyRevisionString = privacyAgreementPagePF.getPolicyRevisionString();

        // Строку я должен получать из json

        Assert.assertTrue(policyRevisionString.contains(Integer.toString(Year.now().getValue())),
                "Policy revision signed not in the current year.");
    }

    @Test
    public void testGameSearch(){
        homePagePF.searchDota2();
        // Это тестовые данные которые надо сохранить в файл?
        String firstResultFromListAfterSearchDota_2 = searchResultPagePF.getFirstResultFromListAfterSearchDota2();
        String secondResultFromListAfterSearchDota_2 = searchResultPagePF.getSecondResultFromListAfterSearchDota2();

        String secondNameFromResultListAfterSearchDota_2 = searchResultPagePF.getSecondNameFromResultListAfterSearchDota2();
        searchResultPagePF.writeSecondNameFromResultListAfterSearchDota_2InSearchField(secondNameFromResultListAfterSearchDota_2);
        searchResultPagePF.clickSearchInSearchField2();

        String firstNameFromResultListSecondSearch = searchResultPagePF.getFirstNameFromResultListSecondSearch();
        Boolean firstCompare =
                searchResultPagePF.compareFirstNameFromResultListSecondSearchWithListAfterSearchDota_2(firstNameFromResultListSecondSearch,
                firstResultFromListAfterSearchDota_2, secondResultFromListAfterSearchDota_2);
        String secondNameFromResultListSecondSearch = searchResultPagePF.getSecondNameFromResultListSecondSearch();

        Boolean secondCompare =
                searchResultPagePF.compareSecondNameFromResultListSecondSearchWithListAfterSearchDota_2(secondNameFromResultListSecondSearch,
                firstResultFromListAfterSearchDota_2, secondResultFromListAfterSearchDota_2);

        Assert.assertTrue(firstCompare && secondCompare,
                "Result list doesn't contain 2 stored items form the previous search. All stored data aren't matched.");
    }
}
