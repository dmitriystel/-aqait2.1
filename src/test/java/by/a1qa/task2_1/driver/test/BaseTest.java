package by.a1qa.task2_1.driver.test;

import by.a1qa.task2_1.driver.driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void browserSetUp() {
        driver = WebDriverSingleton.getInstance();
    }

    @AfterMethod(alwaysRun = true)
    public void closeWebDiver() {
        driver.quit();
        driver = null;
    }
}
