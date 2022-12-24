package by.a1qa.task2_1.wait;

import by.a1qa.task2_1.driver.DriverSingleton;
import by.a1qa.task2_1.util.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConditionalWait {

    private static int seconds = ConfigManager.getWaitDurationInSeconds();
    private static Duration duration = Duration.ofSeconds(seconds);

    public static void waitToBeClickable(By locator){
        new WebDriverWait(DriverSingleton.getInstance(), duration)
                .until(ExpectedConditions.elementToBeClickable(locator));




    }

    public static void waitElementDisappears(By locator){
//        new WebDriverWait(DriverSingle.getInstance(), duration)
//                .until(ExpectedConditions.visibilityOf(element));

        new WebDriverWait(DriverSingleton.getInstance(), duration)
                .until(ExpectedConditions.presenceOfElementLocated(locator));


    }
}