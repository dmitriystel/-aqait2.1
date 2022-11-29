package by.a1qa.task2_1.main;

import by.a1qa.task2_1.Parser.JsonParser;
import by.a1qa.task2_1.Service.Writer;
import by.a1qa.task2_1.bean.PrivacyPolicyRevison;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class PrivacyAgreementPagePF extends BasePage{

    String path = "src/test/resources/policyRevision.json";

    public PrivacyAgreementPagePF(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//i[contains(text(),'2022')]")
    private WebElement policyRevision;


//    public String getPolicyRevisionString(){
//        return policyRevision.getText();
//    }


   public String getPolicyRevisionString(){
       String result = "";
       PrivacyPolicyRevison privacyPolicyRevison = new PrivacyPolicyRevison(policyRevision.getText());
       Writer.writeValueToJson(path, getPolicyRevisionString());
       try {
           result = JsonParser.jsonParse(path);
       } catch (IOException e) {
           e.printStackTrace();
       }


       return result;
 }

    // получить текст и создать объект PrivacyPolicyRevision с данными изменения политики безопасности

    //

}
