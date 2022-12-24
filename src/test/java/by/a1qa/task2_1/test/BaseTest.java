package by.a1qa.task2_1.test;

import by.a1qa.task2_1.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    public WebDriver driver;

    @BeforeTest
    public void browserSetUp() {
        driver = DriverSingleton.getInstance();
    }

    @AfterTest(alwaysRun = true)
    public void closeWebDiver() {
        DriverSingleton.getInstance().quit();
        driver = null;
    }
}
