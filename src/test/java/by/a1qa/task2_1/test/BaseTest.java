package by.a1qa.task2_1.test;

import by.a1qa.task2_1.driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    public WebDriver driver;

    @BeforeTest
    public void browserSetUp() {
        driver = WebDriverSingleton.getInstance();
    }

    @AfterTest(alwaysRun = true)
    public void closeWebDiver() {
        driver.quit();
        driver = null;
    }
}
