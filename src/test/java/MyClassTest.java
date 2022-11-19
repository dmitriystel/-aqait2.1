import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Year;
import java.util.Date;

public class MyClassTest { // rename

//    не находит элемент 2022
    @Test
    public void testCheckIfPrivacyPolicyRevisionSignedInCurrentYear(){


        // 1. Navigate to main page - OK
        WebDriverManager.chromedriver().setup();
        String baseUrl = "https://store.steampowered.com/";
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        // 2. Scroll and open PRIVACY POLICY. Privacy policy page is open in the new tab. - OK
        // надо ли скролить? Открывается и без скролинга
        String xPathPrivacyPolicy = "//a[@href=\"https://store.steampowered.com/privacy_agreement/?snr=1_44_44_\"]";
        WebElement webElementPrivacyPolicy = driver.findElement(By.xpath(xPathPrivacyPolicy));
        webElementPrivacyPolicy.click(); // добавить открытие на всю страницу
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        Privacy policy page is open in the new tab. - да, но для этого ничего не делал, просто кликнул

//        2. Switch language elements list displayed.
//        Supported languages: English, Spanish, French, German, Italian, Russian, Japanese,
//        Portuguese, Brazilian.
//        да, но окрылись сами по себе. Надо ли проверять как то список?



//        3. Policy revision signed in the current year.
//             //i[contains(text(), '2022')]

        String xPathPolicyRevision = "//i[contains(text(),'2022')]";
        //String xPathPolicyRevisionCopyFromSite = "//*[@id=\"newsColumn\"]/i[3]";
        WebElement webElementPolicyRevision = driver.findElement(By.xpath(xPathPolicyRevision));

        //WebElement webElementPolicyRevision = driver.findElement(By.xpath(xPathPolicyRevisionCopyFromSite));

        System.out.println(webElementPolicyRevision.getText());


        // get current year
       //int expectedResult = Year.now().getValue();





        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //driver.quit();
    }


    @Test
    public void testGameSearch(){
        // 1. Navigate to main page - OK
        WebDriverManager.chromedriver().setup();
        String baseUrl = "https://store.steampowered.com/";
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        // 2. Search "Dota 2" in the search field
        String xPathSearchField = "//input[@id=\"store_nav_search_term\"]";
        String gameTitle = "Dota 2";
        WebElement webElementInputGame = driver.findElement(By.xpath(xPathSearchField));
        webElementInputGame.sendKeys(gameTitle);


        // изменить xPath так как дублируется
        //String xPathSearchInSearchField = "//img[@src=\"https://store.akamai.steamstatic.com/public/images/blank.gif\"]";

        String xPathSearchInSearchField = "//*[@id=\"store_search_link\"]/img"; // xPath from devtool
        // /html/body/div[1]/div[7]/div[6]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div[9]/div[1]/form/div/a/img
        WebElement webElementSearchInSearchField = driver.findElement(By.xpath(xPathSearchInSearchField));
        webElementSearchInSearchField.click();

        // Save information about the 1st and 2nd results from the list (name, platforms, release date,
        // review summary result, price)

        String xPathGameFromList1 = "//a[@href=\"https://store.steampowered.com/app/570/Dota_2/?snr=1_7_7_151_150_1\"]";
        WebElement webElementGameFromList1 = driver.findElement(By.xpath(xPathGameFromList1));
        // Куда сохранить инфу? Можно в файл txt или json
        String resultFromList1 = webElementGameFromList1.getText();
        System.out.println(resultFromList1);


        String xPathGameFromList2 = "//a[@href=\"https://store.steampowered.com/app/652720/The_Dota_2_Remixes_EP/?snr=1_7_7_151_150_1\"]";
        WebElement webElementGameFromList2 = driver.findElement(By.xpath(xPathGameFromList2));
        String resultFromList2 = webElementGameFromList2.getText();
        System.out.println(resultFromList2);




        //driver.quit();

    }



}
