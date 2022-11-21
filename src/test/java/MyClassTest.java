import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.time.Year;

public class MyClassTest { // rename

    @Test
    public void testCheckIfPrivacyPolicyRevisionSignedInCurrentYear(){
        // 1. Navigate to main page
        WebDriverManager.chromedriver().setup();
        String baseUrl = "https://store.steampowered.com/";
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        // 2. Scroll and open PRIVACY POLICY. Privacy policy page is open in the new tab. Switch language elements list displayed.
        String xPathPrivacyPolicy = "//a[@href=\"https://store.steampowered.com/privacy_agreement/?snr=1_44_44_\"]";
        WebElement webElementPrivacyPolicy = driver.findElement(By.xpath(xPathPrivacyPolicy));
        webElementPrivacyPolicy.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        // 3. Policy revision signed in the current year.
        String winHandleBefore = driver.getWindowHandle(); // Store the current window handle
        for(String winHandle : driver.getWindowHandles()){ // Switch to new window opened
            driver.switchTo().window(winHandle);
        }

// Close the new window, if that window no more required
        //driver.close();
// Switch back to original browser (first window)
        //driver.switchTo().window(winHandleBefore);
// Continue with original browser (first window)
        String xPathPolicyRevision = "//i[contains(text(),'2022')]";
        WebElement webElementPolicyRevision = driver.findElement(By.xpath(xPathPolicyRevision));
        String policyRevision = webElementPolicyRevision.getText();
        String currentYear = Integer.toString(Year.now().getValue());

        Assert.assertTrue(policyRevision.contains(currentYear), "Policy revision signed not in the current year.");
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
        // 2. Search "Dota 2" in the search field - OK
        String xPathSearchField = "//input[@id=\"store_nav_search_term\"]";
        String gameTitle = "Dota 2";
        WebElement webElementInputGame = driver.findElement(By.xpath(xPathSearchField));
        webElementInputGame.sendKeys(gameTitle);


        // изменить xPath так как дублируется, находит два варианта
        //String xPathSearchInSearchField = "//img[@src=\"https://store.akamai.steamstatic.com/public/images/blank.gif\"]";
        String xPathSearchInSearchField = "//*[@id=\"store_search_link\"]/img"; // xPath from devtool
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

        // Search the second name (received from result list) in the search field in the header
        // взять второе имя из списка - The Dota 2 Remixes EP
        // ввести в поиск и кликнуть
        // Search box on result page contains searched name
        //Result list contains 2 stored items form the previous search. All stored data are matched.


        // переписать с извлечением названия игры из переменной
        String xPathSecondNameFromResultList = "//span[text() = 'The Dota 2 Remixes EP']";
        // извлечь текст из веб элемента
        WebElement webElementSecondNameFromResultList = driver.findElement(By.xpath(xPathSecondNameFromResultList));
        String secondName = webElementSecondNameFromResultList.getText();
        System.out.println("second name is " + secondName);

        String xPathSearchField2 = "//*[@id=\"term\"]";
        WebElement webElementSearchField2 = driver.findElement(By.xpath(xPathSearchField2));
        webElementSearchField2.clear();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webElementSearchField2.sendKeys(secondName);


        //driver.quit();

    }



}
