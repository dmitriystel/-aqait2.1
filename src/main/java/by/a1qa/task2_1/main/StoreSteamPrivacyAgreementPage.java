package by.a1qa.task2_1.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StoreSteamPrivacyAgreementPage extends BasePage {
    String xPathPolicyRevision = "//i[contains(text(),'2022')]";
    public StoreSteamPrivacyAgreementPage(WebDriver driver) {
        super(driver);
    }

    public String getPolicyRevisionString(){
        WebElement webElementPolicyRevision = driver.findElement(By.xpath(xPathPolicyRevision));
        return webElementPolicyRevision.getText();
    }

}
