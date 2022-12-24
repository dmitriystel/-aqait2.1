package by.a1qa.task2_1.test;

import by.a1qa.task2_1.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import by.a1qa.task2_1.page.PrivacyPolicyPage;

import java.io.IOException;
import java.time.Year;

public class PrivacyPolicyTest extends BaseTest {
    @Test
    public void testPrivacyPolicySignedInCurrentYear() throws IOException {
        MainPage mainPage = new MainPage();
        PrivacyPolicyPage privacyPolicyPage;

        privacyPolicyPage = mainPage
                .navigateToMainPage()
                .scrollAndOpenPrivacyPolicy();

        Assert.assertTrue(privacyPolicyPage.isPageOpen(),
                "Privacy policy page isn't open in the new tab." +
                        "Switch language elements list didn't displayed.");
        Assert.assertTrue(privacyPolicyPage.isEnglishSupported(), "English isn't supported");
        Assert.assertTrue(privacyPolicyPage.isSpanishSupported(), "Spanish isn't supported");
        Assert.assertTrue(privacyPolicyPage.isFrenchSupported(), "French isn't supported");
        Assert.assertTrue(privacyPolicyPage.isGermanSupported(), "German isn't supported");
        Assert.assertTrue(privacyPolicyPage.isItalianSupported(), "Italian isn't supported");
        Assert.assertTrue(privacyPolicyPage.isRussianSupported(), "Russian isn't supported");
        Assert.assertTrue(privacyPolicyPage.isJapaneseSupported(), "Japanese isn't supported");
        Assert.assertTrue(privacyPolicyPage.isPortugueseSupported(), "Portuguese isn't supported");
        Assert.assertTrue(privacyPolicyPage.isBrazilianSupported(), "Brazilian isn't supported");

        String policyRevisionString = privacyPolicyPage
                .getPolicyRevisionString();

        Assert.assertTrue(policyRevisionString.contains(Integer.toString(Year.now().getValue())),
                "Policy revision didn't sign in the current year.");
    }
}