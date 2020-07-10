package Drivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
    private static WebDriver driver;

    public static void initDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
        driver = new ChromeDriver();
        driver.get(url);
    }

    public static void closeDriver() {
        driver.close();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
    }

}

