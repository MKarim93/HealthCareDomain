package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public static WebDriver driver = null;

    public static WebDriver getLocalDriver() {
        System.setProperty("webdriver.chrome.driver", "C://Users//Mohammad Karim//HealthCareDomain//Generic//Drivers//chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.cms.gov/");
        return driver;
    }
}
