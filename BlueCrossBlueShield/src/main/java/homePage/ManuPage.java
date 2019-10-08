package homePage;

import base.CommonAPI2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ManuPage extends CommonAPI2 {

    public void manuPageOptionBCBS() throws InterruptedException {
        //Action class---for the dropdown list
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.linkText("Member Services"))).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Access My Benefits")).click();
        Thread.sleep(2000);
    }

    //for testing the dropdown list in www.delta.com
    public void manuPageOptionDelta() throws InterruptedException {
        driver.get("https://www.delta.com/");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.linkText("Travel Info"))).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Baggage")).click();
        Thread.sleep(2000);
    }

    //direct click to the linkText
    public void manuPageOptionBCBS2() throws InterruptedException {
        //Action class---for the dropdown list
        driver.findElement(By.linkText("Member Services")).click();
        Thread.sleep(2000);
        captureScreenshot(driver,"Member Service - page");
    }

    //all the links in the homepage
    public void findAllElements() throws InterruptedException{

        //Find all the link text - all the links are represented by <a> html tag:
        List<WebElement> linklist = driver.findElements(By.tagName("a"));

        //1. get the total count of links on the homepage
        System.out.println(linklist.size());

        //2. print all the links on the homepage
        for (int i=1; i<linklist.size();i++) {
            String linkText = linklist.get(i).getText();
            if (linklist.isEmpty()) {
                System.out.println("linklist is empty");
            } else {
                System.out.println("The "+ i + "th link text is : " + linkText);
            }
        }
    }

    public void findADoctor() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.linkText("Find a Doctor"))).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//nav[@id='block-bcbs-main-menu']//a[@class='button--arrow-right'][contains(text(),'In the United States, Puerto Rico and U.S. Virgin')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("input-location")).sendKeys("Austin, TX");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='truncate p-1 bb-primary-1']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='input-group w-100']//input[@class='form-control']")).sendKeys("UTA");
        Thread.sleep(2000);
        driver.findElement(By.id("ember166")).click();
        driver.findElement(By.xpath("//div[@class='d-flex justify-content-between']")).click();
        driver.findElement(By.linkText("Doctors by name")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("input-what")).sendKeys("Huang", Keys.ENTER);
    }

}
