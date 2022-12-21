package by.a1qa.task2_1.wait;

import by.a1qa.task2_1.driver.DriverSingle;
import by.a1qa.task2_1.util.ConfigManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConditionalWait {

    private static int seconds = ConfigManager.getWaitDurationInSeconds();
    private static Duration duration = Duration.ofSeconds(seconds);

    public static void waitToBeClickable(WebElement element){
        new WebDriverWait(DriverSingle.getInstance(), duration)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementDisappears(WebElement element){
        new WebDriverWait(DriverSingle.getInstance(), duration)
                .until(ExpectedConditions.visibilityOf(element));
    }
}