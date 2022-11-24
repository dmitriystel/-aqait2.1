package by.a1qa.task2_1.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StoreSteamGameSearchPage extends BasePage  {
    By first_result_from_list_after_search_dota_2_locator = By.xpath("//a[@href=\"https://store.steampowered.com/app/570/Dota_2/?snr=1_7_7_151_150_1\"]");
    By second_result_from_list_after_search_dota_2_locator = By.xpath("//a[@href=\"https://store.steampowered.com/app/652720/The_Dota_2_Remixes_EP/?snr=1_7_7_151_150_1\"]");
    By second_name_from_result_list_after_search_dota_2_locator = By.xpath("//span[text() = 'The Dota 2 Remixes EP']");
    By search_field_2_locator = By.xpath("//*[@id=\"term\"]");
    By search_in_search_field_2_locator = By.xpath("//*[@id=\"advsearchform\"]/div[1]/div/div[1]/div[1]/div[2]/button/span");
    By first_name_from_result_list_second_search_locator = By.xpath("//a[@href=\"https://store.steampowered.com/app/652720/The_Dota_2_Remixes_EP/?snr=1_7_7_151_150_1\"]");
    By second_name_from_result_list_second_search_locator = By.xpath("//a[@href=\"https://store.steampowered.com/bundle/232/Valve_Complete_Pack/?snr=1_7_7_151_150_1\"]");

    public StoreSteamGameSearchPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstResultFromListAfterSearchDota_2(){
        WebElement webElementFirstResultFromListAfterSearchDota_2 = driver
                .findElement(first_result_from_list_after_search_dota_2_locator);
        // Сохранить в  json или xml
        return webElementFirstResultFromListAfterSearchDota_2.getText();
    }

    public String getSecondResultFromListAfterSearchDota_2(){
        WebElement webElementSecondResultFromListAfterSearchDota_2 = driver
                .findElement(second_result_from_list_after_search_dota_2_locator);
        return webElementSecondResultFromListAfterSearchDota_2.getText();
    }

    public String getSecondNameFromResultListAfterSearchDota_2(){
        WebElement webElementSecondNameFromResultListAfterSearchDota_2 = driver
                .findElement(second_name_from_result_list_after_search_dota_2_locator);
        return webElementSecondNameFromResultListAfterSearchDota_2.getText();
    }

    public void writeSecondNameFromResultListAfterSearchDota_2InSearchField(String secondNameFromResultListAfterSearchDota_2){
        WebElement webElementSearchFieldAfterSearch = driver.findElement(search_field_2_locator);
        webElementSearchFieldAfterSearch.clear();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        webElementSearchFieldAfterSearch.sendKeys(secondNameFromResultListAfterSearchDota_2);
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));

    }

    public void clickSearchInSearchField2() {
        WebElement webElementSearchInSearchField2 = driver.findElement(search_in_search_field_2_locator);
        webElementSearchInSearchField2.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    public String getFirstNameFromResultListSecondSearch(){
        WebElement webElementFirstNameFromResultListSecondSearch = driver
                .findElement(first_name_from_result_list_second_search_locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        return webElementFirstNameFromResultListSecondSearch.getText();
    }

    public String getSecondNameFromResultListSecondSearch(){
        WebElement webElementSecondNameFromResultListSecondSearch = driver
                .findElement(second_name_from_result_list_second_search_locator);
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


      /*
           Page Factory
    Подготовка элементов страницы


    private final String xPathFirstResultFromListAfterSearchDota_2 = "//a[@href=\"https://store.steampowered.com/app/570/Dota_2/?snr=1_7_7_151_150_1\"]";
    By first_result_from_list_after_search_dota_2_locator = By.xpath("//a[@href=\"https://store.steampowered.com/app/570/Dota_2/?snr=1_7_7_151_150_1\"]");

    @FindBy (xpath = "//a[@href=\"https://store.steampowered.com/app/570/Dota_2/?snr=1_7_7_151_150_1\"]")
    private WebElement first_result_from_list_after_search_dota_2;




    private final String xPathSecondResultFromListAfterSearchDota_2 = "//a[@href=\"https://store.steampowered.com/app/652720/The_Dota_2_Remixes_EP/?snr=1_7_7_151_150_1\"]";
    By second_result_from_list_after_search_dota_2_locator = By.xpath("//a[@href=\"https://store.steampowered.com/app/652720/The_Dota_2_Remixes_EP/?snr=1_7_7_151_150_1\"]");

    @FindBy (xpath = "//a[@href=\"https://store.steampowered.com/app/652720/The_Dota_2_Remixes_EP/?snr=1_7_7_151_150_1\"]")
    private WebElement second_result_from_list_after_search_dota_2;




    private final String xPathSecondNameFromResultListAfterSearchDota_2 = "//span[text() = 'The Dota 2 Remixes EP']";
    By second_name_from_result_list_after_search_dota_2_locator = By.xpath("//span[text() = 'The Dota 2 Remixes EP']");

    @FindBy (xpath = "//span[text() = 'The Dota 2 Remixes EP']")
    private WebElement second_name_from_result_list_after_search_dota_2;




    private final String xPathSearchField2 = "//*[@id=\"term\"]";
    By search_field_2_locator = By.xpath("//*[@id=\"term\"]");

    @FindBy (xpath = "//*[@id=\"term\"]")
    private WebElement search_field_2;




    private final String xPathSearchInSearchField2 = "//*[@id=\"advsearchform\"]/div[1]/div/div[1]/div[1]/div[2]/button/span";
    By search_in_search_field_2_locator = By.xpath("//*[@id=\"advsearchform\"]/div[1]/div/div[1]/div[1]/div[2]/button/span");

    @FindBy (xpath = "//*[@id=\"advsearchform\"]/div[1]/div/div[1]/div[1]/div[2]/button/span")
    private WebElement search_in_search_field_2;




    private final String xPathFirstNameFromResultListSecondSearch = "//a[@href=\"https://store.steampowered.com/app/652720/The_Dota_2_Remixes_EP/?snr=1_7_7_151_150_1\"]";
    By first_name_from_result_list_second_search_locator = By.xpath("//a[@href=\"https://store.steampowered.com/app/652720/The_Dota_2_Remixes_EP/?snr=1_7_7_151_150_1\"]");

    @FindBy (xpath = "//a[@href=\"https://store.steampowered.com/app/652720/The_Dota_2_Remixes_EP/?snr=1_7_7_151_150_1\"]")
    private WebElement first_name_from_result_list_second_search;




    private final String xPathSecondNameFromResultListSecondSearch = "//a[@href=\"https://store.steampowered.com/bundle/232/Valve_Complete_Pack/?snr=1_7_7_151_150_1\"]";
    By second_name_from_result_list_second_search_locator = By.xpath("//a[@href=\"https://store.steampowered.com/bundle/232/Valve_Complete_Pack/?snr=1_7_7_151_150_1\"]");

    @FindBy (xpath = "//a[@href=\"https://store.steampowered.com/bundle/232/Valve_Complete_Pack/?snr=1_7_7_151_150_1\"]")
    private WebElement second_name_from_result_list_second_search;

*/