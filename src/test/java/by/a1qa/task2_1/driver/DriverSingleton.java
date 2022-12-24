package by.a1qa.task2_1.driver;

import by.a1qa.task2_1.util.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(ConfigManager.getBrowserMode());
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }
}
