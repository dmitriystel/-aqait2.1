package by.a1qa.task2_1.page;

import by.a1qa.task2_1.driver.DriverSingleton;
import by.a1qa.task2_1.util.ParserJavaToJson;

import by.a1qa.task2_1.bean.PrivacyPolicyRevision;
import by.a1qa.task2_1.util.ParserJsonToJava;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
/*
Code review 24.12.2022
3rd comment:
@findby will look for an item in the locator right away, even if we don't need it yet, so we shouldn't use it.
Use findElement

fixed: findElement is used
*/
public class PrivacyPolicyPage extends BasePage{
    public static final String POLICY_REVISION_DB_PATH = "src/test/resources/testData/PrivacyPolicyRevisionDB.json";
    By languageListLocator = By.id("languages");
    By policyRevisionLocator = By.xpath("//i[contains(text(),'2022')]");
    By englishFlagLocator = By.xpath("//img[contains(@src,'english')]");
    By spanishFlagLocator = By.xpath("//img[contains(@src,'spanish')]");
    By frenchFlagLocator = By.xpath("//img[contains(@src,'french')]");
    By germanFlagLocator = By.xpath("//img[contains(@src,'german')]");
    By italianFlagLocator = By.xpath("//img[contains(@src,'italian')]");
    By russianFlagLocator = By.xpath("//img[contains(@src,'russian')]");
    By japaneseFlagLocator = By.xpath("//img[contains(@src,'japanese')]");
    By portugueseFlagLocator = By.xpath("//img[contains(@src,'portuguese')]");
    By brazilianFlagLocator = By.xpath("//img[contains(@src,'brazilian')]");

    public PrivacyPolicyPage() {
        super();
    }

    public Boolean isPageOpen(){
        return (DriverSingleton.getInstance()).findElement(languageListLocator).isDisplayed();
    }

    public Boolean isEnglishSupported(){
        return (DriverSingleton.getInstance()).findElement(englishFlagLocator).isDisplayed();
    }

    public Boolean isSpanishSupported(){
        return (DriverSingleton.getInstance()).findElement(spanishFlagLocator).isDisplayed();
    }

    public Boolean isFrenchSupported(){
        return (DriverSingleton.getInstance()).findElement(frenchFlagLocator).isDisplayed();
    }

    public Boolean isGermanSupported(){
        return (DriverSingleton.getInstance()).findElement(germanFlagLocator).isDisplayed();
    }

    public Boolean isItalianSupported(){
        return (DriverSingleton.getInstance()).findElement(italianFlagLocator).isDisplayed();
    }

    public Boolean isRussianSupported(){
        return (DriverSingleton.getInstance()).findElement(russianFlagLocator).isDisplayed();
    }

    public Boolean isJapaneseSupported(){
        return (DriverSingleton.getInstance()).findElement(japaneseFlagLocator).isDisplayed();
    }

    public Boolean isPortugueseSupported(){
        return (DriverSingleton.getInstance()).findElement(portugueseFlagLocator).isDisplayed();
    }

    public Boolean isBrazilianSupported(){
        return (DriverSingleton.getInstance()).findElement(brazilianFlagLocator).isDisplayed();
    }

    public String getPolicyRevisionString() throws IOException {
        PrivacyPolicyRevision privacyPolicyRevision
                = new PrivacyPolicyRevision((DriverSingleton.getInstance()).findElement(policyRevisionLocator).getText());
        ParserJavaToJson.writeJavaInJson(POLICY_REVISION_DB_PATH, privacyPolicyRevision);
        PrivacyPolicyRevision revision = ParserJsonToJava.jsonParseObject(POLICY_REVISION_DB_PATH);
        return revision.toString();
    }
}

/*
//    @FindBy(id = "languages")
//    public WebElement languages;
//    @FindBy(xpath = "//i[contains(text(),'2022')]")
//    private WebElement policyRevision;
//    @FindBy(xpath = "//img[contains(@src,'english')]")
//    private WebElement englishFlag;
//    @FindBy(xpath = "//img[contains(@src,'spanish')]")
//    private WebElement spanishFlag;
//    @FindBy(xpath = "//img[contains(@src,'french')]")
//    private WebElement frenchFlag;
//    @FindBy(xpath = "//img[contains(@src,'german')]")
//    private WebElement germanFlag;
//    @FindBy(xpath = "//img[contains(@src,'italian')]")
//    private WebElement italianFlag;
//    @FindBy(xpath = "//img[contains(@src,'russian')]")
//    private WebElement russianFlag;
//    @FindBy(xpath = "//img[contains(@src,'japanese')]")
//    private WebElement japaneseFlag;
//    @FindBy(xpath = "//img[contains(@src,'portuguese')]")
//    private WebElement portugueseFlag;
//    @FindBy(xpath = "//img[contains(@src,'brazilian')]")
//    private WebElement brazilianFlag;
 */



