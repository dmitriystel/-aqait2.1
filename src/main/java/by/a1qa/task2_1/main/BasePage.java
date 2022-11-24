package by.a1qa.task2_1.main;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
