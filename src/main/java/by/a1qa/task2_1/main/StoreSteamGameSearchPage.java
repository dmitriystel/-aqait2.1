package by.a1qa.task2_1.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class StoreSteamGameSearchPage extends BasePage  {

    private final String xPathFirstResultFromListAfterSearchDota_2 = "//a[@href=\"https://store.steampowered.com/app/570/Dota_2/?snr=1_7_7_151_150_1\"]";
    private final String xPathSecondResultFromListAfterSearchDota_2 = "//a[@href=\"https://store.steampowered.com/app/652720/The_Dota_2_Remixes_EP/?snr=1_7_7_151_150_1\"]";
    private final String xPathSecondNameFromResultListAfterSearchDota_2 = "//span[text() = 'The Dota 2 Remixes EP']";
    private final String xPathSearchField2 = "//*[@id=\"term\"]";
    private final String xPathSearchInSearchField2 = "//*[@id=\"advsearchform\"]/div[1]/div/div[1]/div[1]/div[2]/button/span";
    private final String xPathFirstNameFromResultListSecondSearch = "//a[@href=\"https://store.steampowered.com/app/652720/The_Dota_2_Remixes_EP/?snr=1_7_7_151_150_1\"]";
    private final String xPathSecondNameFromResultListSecondSearch = "//a[@href=\"https://store.steampowered.com/app/690180/Music_for_The_Long_Dark__Volume_One/?snr=1_7_7_151_150_1\"]";


    public StoreSteamGameSearchPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstResultFromListAfterSearchDota_2(){
        WebElement webElementFirstResultFromListAfterSearchDota_2 = driver
                .findElement(By.xpath(xPathFirstResultFromListAfterSearchDota_2));
        // Сохранить в  json или xml
        return webElementFirstResultFromListAfterSearchDota_2.getText();
    }

    public String getSecondResultFromListAfterSearchDota_2(){
        WebElement webElementSecondResultFromListAfterSearchDota_2 = driver
                .findElement(By.xpath(xPathSecondResultFromListAfterSearchDota_2));
        return webElementSecondResultFromListAfterSearchDota_2.getText();
    }

    public String getSecondNameFromResultListAfterSearchDota_2(){
        WebElement webElementSecondNameFromResultListAfterSearchDota_2 = driver
                .findElement(By.xpath(xPathSecondNameFromResultListAfterSearchDota_2));
        return webElementSecondNameFromResultListAfterSearchDota_2.getText();
    }

    public void writeSecondNameFromResultListAfterSearchDota_2InSearchField(String secondNameFromResultListAfterSearchDota_2){
        WebElement webElementSearchFieldAfterSearch = driver.findElement(By.xpath(xPathSearchField2));
        webElementSearchFieldAfterSearch.clear();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webElementSearchFieldAfterSearch.sendKeys(secondNameFromResultListAfterSearchDota_2);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void clickSearchInSearchField2() {
        WebElement webElementSearchInSearchField2 = driver.findElement(By.xpath(xPathSearchInSearchField2));
        webElementSearchInSearchField2.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }


    public String getFirstNameFromResultListSecondSearch(){
        WebElement webElementFirstNameFromResultListSecondSearch = driver
                .findElement(By.xpath(xPathFirstNameFromResultListSecondSearch));
        return webElementFirstNameFromResultListSecondSearch.getText();
    }


    public String getSecondNameFromResultListSecondSearch(){
        WebElement webElementSecondNameFromResultListSecondSearch = driver
                .findElement(By.xpath(xPathSecondNameFromResultListSecondSearch));
        return webElementSecondNameFromResultListSecondSearch.getText();
    }

    public boolean compareFirstNameFromResultListSecondSearchWithListAfterSearchDota_2 (String firstNameFromResultListSecondSearch,
                                                                                        String firstResultFromListAfterSearchDota_2, String secondResultFromListAfterSearchDota_2) {

        return firstNameFromResultListSecondSearch.equals(secondResultFromListAfterSearchDota_2) ||
                firstNameFromResultListSecondSearch.equals(firstResultFromListAfterSearchDota_2);
    }

    public boolean compareSecondNameFromResultListSecondSearchWithListAfterSearchDota_2 (String secondNameFromResultListSecondSearch,
                                                                                         String firstResultFromListAfterSearchDota_2, String secondResultFromListAfterSearchDota_2){

        return secondNameFromResultListSecondSearch.equals(secondResultFromListAfterSearchDota_2) || secondNameFromResultListSecondSearch.equals(firstResultFromListAfterSearchDota_2);

    }
}
