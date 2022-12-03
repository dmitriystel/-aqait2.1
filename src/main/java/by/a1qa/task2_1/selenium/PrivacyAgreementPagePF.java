package by.a1qa.task2_1.selenium;

import by.a1qa.task2_1.parser.ParserJavaToJson;

import by.a1qa.task2_1.bean.PrivacyPolicyRevision;
import by.a1qa.task2_1.parser.ParserJsonToJava;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class PrivacyAgreementPagePF extends BasePage{

    public static final String POLICY_REVISION_DB_PATH = "src/test/resources/PrivacyPolicyRevisionDB.json";

    public PrivacyAgreementPagePF(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//i[contains(text(),'2022')]")
    private WebElement policyRevision;

   public String getPolicyRevisionString() throws IOException {
       PrivacyPolicyRevision privacyPolicyRevision = new PrivacyPolicyRevision(policyRevision.getText());
       ParserJavaToJson.writeJavaInJson(POLICY_REVISION_DB_PATH, privacyPolicyRevision);
       PrivacyPolicyRevision revision = ParserJsonToJava.jsonParseObject(POLICY_REVISION_DB_PATH);
       return revision.toString();
   }
}
