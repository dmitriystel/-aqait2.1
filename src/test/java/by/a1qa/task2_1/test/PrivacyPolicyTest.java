package by.a1qa.task2_1.test;

import by.a1qa.task2_1.page.MainPage;
import by.a1qa.task2_1.page.GameSearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import by.a1qa.task2_1.page.PrivacyPolicyPage;

import java.io.IOException;
import java.time.Year;

public class PrivacyPolicyTest extends BaseTest {
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
}