package homePage;

import base.CommonAPI2;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ManuPage extends CommonAPI2 {

    public void manuPageOptionBCBS() throws InterruptedException {
        //Action class---for the dropdown list
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.linkText("Member Service"))).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Access My Benefits")).click();
        Thread.sleep(2000);
    }

    public void manuPageOptionAmazon() throws InterruptedException {
        driver.get("https://www.delta.com/");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.linkText("Travel Info"))).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Baggage")).click();
        Thread.sleep(2000);
    }



}
