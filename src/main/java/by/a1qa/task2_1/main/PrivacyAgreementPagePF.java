package by.a1qa.task2_1.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrivacyAgreementPagePF extends BasePage{
    public PrivacyAgreementPagePF(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//i[contains(text(),'2022')]")
    private WebElement policyRevision;


    public String getPolicyRevisionString(){
        return policyRevision.getText();
    }
}
