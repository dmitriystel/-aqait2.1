package by.a1qa.task2_1.driver.page;

import by.a1qa.task2_1.driver.util.ParserJavaToJson;

import by.a1qa.task2_1.driver.bean.PrivacyPolicyRevision;
import by.a1qa.task2_1.driver.util.ParserJsonToJava;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class PrivacyPolicyPage extends BasePage{

    public static final String POLICY_REVISION_DB_PATH = "src/test/resources/testData/PrivacyPolicyRevisionDB.json";


    @FindBy(id = "languages")
    public WebElement languages;

    @FindBy(xpath = "//i[contains(text(),'2022')]")
    private WebElement policyRevision;

    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
    }



    public Boolean isSwitchLanguageElementsListDisplayed(){
        return languages.isDisplayed();
    }




   public String getPolicyRevisionString() throws IOException {
       PrivacyPolicyRevision privacyPolicyRevision = new PrivacyPolicyRevision(policyRevision.getText());
       ParserJavaToJson.writeJavaInJson(POLICY_REVISION_DB_PATH, privacyPolicyRevision);
       PrivacyPolicyRevision revision = ParserJsonToJava.jsonParseObject(POLICY_REVISION_DB_PATH);
       return revision.toString();
   }



}
