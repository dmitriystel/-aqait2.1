import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyClassTest { // rename

    @Test
    public void testCheckIfPrivacyPolicyRevisionSignedInCurrentYear(){
        // 1. Navigate to main page - OK
        WebDriverManager.chromedriver().setup();
        String baseUrl = "https://store.steampowered.com/";
        ChromeDriver driver = new ChromeDriver();
        driver.get(baseUrl);

        // 2. Scroll and open PRIVACY POLICY. Privacy policy page is open in the new tab. - OK
        // надо ли скролить? Открывается и без скролинга
        String xPathPrivacyPolicy = "//a[@href=\"https://store.steampowered.com/privacy_agreement/?snr=1_44_44_\"]";
        WebElement webElementPrivacyPolicy = driver.findElement(By.xpath(xPathPrivacyPolicy));
        webElementPrivacyPolicy.click(); // добавить открытие на всю страницу
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

//        Privacy policy page is open in the new tab. - да, но для этого ничего не делал, просто кликнул

//        2. Switch language elements list displayed.
//        Supported languages: English, Spanish, French, German, Italian, Russian, Japanese,
//        Portuguese, Brazilian.
//        да, но окрылись сами по себе. Надо ли проверять как то список?



//        3. Policy revision signed in the current year.
//             //i[contains(text(), '2022')]

        String xPathLogInPolicyRevision = "//i[contains(text(),'2022')]"; // в дев туле срабатывает, тут не находит элемент
        WebElement webElementPolicyRevision = driver.findElement(By.xpath(xPathLogInPolicyRevision));
        webElementPolicyRevision.getText(); // добавить открытие на всю страницу

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //driver.quit();
    }






}
