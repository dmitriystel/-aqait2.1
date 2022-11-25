package by.a1qa.task2_1.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPagePF extends BasePage {
    public SearchResultPagePF(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href=\"https://store.steampowered.com/app/570/Dota_2/?snr=1_7_7_151_150_1\"]")
    private WebElement firstResultFromListAfterSearchDota2;

    @FindBy (xpath = "//a[@href=\"https://store.steampowered.com/app/652720/The_Dota_2_Remixes_EP/?snr=1_7_7_151_150_1\"]")
    private WebElement secondResultFromListAfterSearchDota2;

    @FindBy (xpath = "//span[text() = 'The Dota 2 Remixes EP']")
    private WebElement secondNameFromResultListAfterSearchDota2;

    @FindBy (xpath = "//*[@id=\"term\"]")
    private WebElement searchField2;

    @FindBy (xpath = "//*[@id=\"advsearchform\"]/div[1]/div/div[1]/div[1]/div[2]/button/span")
    private WebElement searchInSearchField2;

    @FindBy (xpath = "//a[@href=\"https://store.steampowered.com/app/652720/The_Dota_2_Remixes_EP/?snr=1_7_7_151_150_1\"]")
    private WebElement firstNameFromResultListSecondSearch;

    @FindBy (xpath = "//a[@href=\"https://store.steampowered.com/bundle/232/Valve_Complete_Pack/?snr=1_7_7_151_150_1\"]")
    private WebElement secondNameFromResultListSecondSearch;

    public String getFirstResultFromListAfterSearchDota2(){
        return firstResultFromListAfterSearchDota2.getText();
    }


    public String getSecondResultFromListAfterSearchDota2(){
    return secondResultFromListAfterSearchDota2.getText();
    }

    public String getSecondNameFromResultListAfterSearchDota2(){
        return secondNameFromResultListAfterSearchDota2.getText();
    }

    // объединить два следующих метода в один, т.е. очистить поле, ввести элемент и кликнуть в один элемент
    public void writeSecondNameFromResultListAfterSearchDota_2InSearchField(String secondNameFromResultListAfterSearchDota_2){
        searchField2.clear();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        searchField2.sendKeys(secondNameFromResultListAfterSearchDota_2);
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));

    }

    public void clickSearchInSearchField2() {
        searchInSearchField2.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    public String getFirstNameFromResultListSecondSearch(){
        return firstNameFromResultListSecondSearch.getText();
    }

    public String getSecondNameFromResultListSecondSearch(){
        return secondNameFromResultListSecondSearch.getText();
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
