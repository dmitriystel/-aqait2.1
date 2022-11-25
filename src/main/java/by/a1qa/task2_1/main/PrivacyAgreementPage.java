package by.a1qa.task2_1.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrivacyAgreementPage extends BasePage {
    // String xPathPolicyRevision = "//i[contains(text(),'2022')]";
    By policy_revision_locator = By.xpath("//i[contains(text(),'2022')]");

    public PrivacyAgreementPage(WebDriver driver) {
        super(driver);
    }

    public String getPolicyRevisionString(){
        WebElement webElementPolicyRevision = driver.findElement(policy_revision_locator);
        return webElementPolicyRevision.getText();
    }



}
