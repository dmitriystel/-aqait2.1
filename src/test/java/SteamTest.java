import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.time.Year;

public class SteamTest {

    @Test
    public void testCheckIfPrivacyPolicyRevisionSignedInCurrentYear(){
        // 1. Navigate to main page
        WebDriverManager.chromedriver().setup();
        String baseUrl = "https://store.steampowered.com/";
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // попробовать добавить .get(baseUrl), должно работать
        driver.get(baseUrl);
        // 2. Scroll and open PRIVACY POLICY. Privacy policy page is open in the new tab. Switch language elements list displayed.
        String xPathPrivacyPolicy = "//a[@href=\"https://store.steampowered.com/privacy_agreement/?snr=1_44_44_\"]";
        WebElement webElementPrivacyPolicy = driver.findElement(By.xpath(xPathPrivacyPolicy));
        webElementPrivacyPolicy.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        // 3. Policy revision signed in the current year.
        String windowHandleBefore = driver.getWindowHandle(); // Store the current window handle
        for(String windowHandle : driver.getWindowHandles()){ // Switch to new window opened
            driver.switchTo().window(windowHandle);
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
        //driver.quit();
    }


    @Test
    public void testGameSearch(){
        // 1. Navigate to main page - OK. Открывается главная страница
        WebDriverManager.chromedriver().setup();
        String baseUrl = "https://store.steampowered.com/"; // повтор, базовая страница одинакова для обоих тестов
        ChromeDriver driver = new ChromeDriver();   //  такая же строчка в первом методе
        driver.manage().window().maximize(); //  такая же строчка в первом методе
        driver.get(baseUrl); //  такая же строчка в первом методе
        // 2. Search "Dota 2" in the search field - OK. В поиске набираем Dota 2, нажимаем найти. Получаем список игр
        String xPathSearchFieldBasePage = "//input[@id=\"store_nav_search_term\"]";
        String gameTitle = "Dota 2";
        WebElement webElementSearchFieldBasePage = driver.findElement(By.xpath(xPathSearchFieldBasePage));
        webElementSearchFieldBasePage.sendKeys(gameTitle);


        // изменить xPath так как дублируется, находит два варианта
        //String xPathSearchInSearchField = "//img[@src=\"https://store.akamai.steamstatic.com/public/images/blank.gif\"]";
        String xPathSearchButtonInSearchFieldBasePage = "//*[@id=\"store_search_link\"]/img"; // xPath from devtool
        WebElement webElementSearchButtonInSearchFieldBasePage = driver.findElement(By.xpath(xPathSearchButtonInSearchFieldBasePage));
        webElementSearchButtonInSearchFieldBasePage.click();

        // 3. Save information about the 1st and 2nd results from the list (name, platforms, release date,
        // review summary result, price)
        // Сохраняем инфу и первом и втором результате

        // Первый результат. xPath->webElement->строка, инфа по игре
        String xPathGameFromListOne = "//a[@href=\"https://store.steampowered.com/app/570/Dota_2/?snr=1_7_7_151_150_1\"]";
        WebElement webElementGameFromListOne = driver.findElement(By.xpath(xPathGameFromListOne));
        // Сохранить в  json или xml
        String resultFromListOne = webElementGameFromListOne.getText();

        // Второй результат. xPath->webElement->строка, инфа по игре
        String xPathGameFromListTwo = "//a[@href=\"https://store.steampowered.com/app/652720/The_Dota_2_Remixes_EP/?snr=1_7_7_151_150_1\"]";
        WebElement webElementGameFromListTwo = driver.findElement(By.xpath(xPathGameFromListTwo));
        String resultFromListTwo = webElementGameFromListTwo.getText();

        // 4.
        // Search the second name (received from result list) in the search field in the header
        // взять второе имя из списка - The Dota 2 Remixes EP
        // ввести в поиск и кликнуть
        // Search box on result page contains searched name
        //Result list contains 2 stored items form the previous search. All stored data are matched.
        // переписать с извлечением названия игры из переменной - что это значит?

        // сохраняю название второй игры из списка
        // xPath->webElement-> текст в виде строки
        String xPathSecondNameFromResultList = "//span[text() = 'The Dota 2 Remixes EP']";
        // извлечь текст из веб элемента
        WebElement webElementSecondNameFromResultList = driver.findElement(By.xpath(xPathSecondNameFromResultList));
        String secondName = webElementSecondNameFromResultList.getText();


        // очищаю поле поиска: xPath->webElement->clear->ввел название второй игры (send keys)
        String xPathSearchField2 = "//*[@id=\"term\"]";
        WebElement webElementSearchField2 = driver.findElement(By.xpath(xPathSearchField2));
        webElementSearchField2.clear();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webElementSearchField2.sendKeys(secondName);

        // ввести ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        // ввели в поиск, надо кликнуть название The Dota 2 Remixes EP



        // !!!!!!!!!!!! исправить xPath
        // xPath кнопки поиск в окне поиск
        String xPathSearchInSearchField2 = "//*[@id=\"advsearchform\"]/div[1]/div/div[1]/div[1]/div[2]/button/span";
        // веб элемент кнопки поиск в окне поиск
        WebElement webElementSearchInSearchField2 = driver.findElement(By.xpath(xPathSearchInSearchField2));

        webElementSearchInSearchField2.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        /*
Search box on result page contains searched name. Result list contains 2 stored items form the previous search.
All stored data are matched.
Поле поиска на странице результатов содержит искомое имя. Список результатов содержит 2 сохраненных элемента из
предыдущего поиска. Все сохраненные данные совпадают.
         */

        // Взять первый элемент из списка и сравнить совпадает ли он с первым или вторым содержимым сохраненных поисков
        String xPathFirstNameFromResultList = "//a[@href=\"https://store.steampowered.com/app/652720/The_Dota_2_Remixes_EP/?snr=1_7_7_151_150_1\"]";
        WebElement webElementFirstNameFromResultList = driver.findElement(By.xpath(xPathFirstNameFromResultList));

        // извлечь текст из веб элемента
        String FirstNameFromResultList = webElementFirstNameFromResultList.getText();
        // сравнить совпадает ли он с первым или вторым содержимым сохраненных поисков

        System.out.println(FirstNameFromResultList.equals(resultFromListTwo) || FirstNameFromResultList.equals(resultFromListOne));

        // Взять второй элемент из списка и сравнить совпадает ли он с первым или вторым содержимым сохраненных поисков

        String xPathSecondNameFromResultList2 = "//a[@href=\"https://store.steampowered.com/app/690180/Music_for_The_Long_Dark__Volume_One/?snr=1_7_7_151_150_1\"]";
        WebElement webElementSecondNameFromResultList2 = driver.findElement(By.xpath(xPathSecondNameFromResultList2));

        // извлечь текст из веб элемента
        String SecondNameFromResultList = webElementSecondNameFromResultList2.getText();
        // сравнить совпадает ли он с первым или вторым содержимым сохраненных поисков

        System.out.println(SecondNameFromResultList.equals(resultFromListTwo) || SecondNameFromResultList.equals(resultFromListOne));

        //driver.quit();
    }
}
