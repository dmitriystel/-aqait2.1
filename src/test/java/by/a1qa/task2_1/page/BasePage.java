package by.a1qa.task2_1.page;

import by.a1qa.task2_1.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
/*
Code review 24.12.2022

4th comment:
the base class must be abstract, so you can't create an instance of it

fixed: BasePage class is abstract

5th comment:
The driver should not be passed as a parameter to a method or constructor.
If you need a driver, call it through DriverSingleton.getInstance()

fixed: driver called through DriverSingleton.getInstance()
*/
public abstract class BasePage {
    protected WebDriver driver;

    protected BasePage() {
        driver = DriverSingleton.getInstance();
    }
}
