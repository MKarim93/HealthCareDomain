package homePageTest;

import base.CommonAPI2;
import homePage.SearchPage;
import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestSearchPage extends CommonAPI2 {


    @Test(priority = 1)
    public void searchItem1() throws Exception{
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        searchPage.searchFor("dental insurance");
        Thread.sleep(2000);
        searchPage.getSubmitButton();
        Thread.sleep(2000);
        searchPage.clearInput();
    }

    @Test(priority = 2)
    public void searchItem2() throws Exception{
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        searchPage.searchItemsAndSubmit();
    }

    @Test(priority = 3)
    public void searchItem3() throws Exception{
        driver.findElement(By.id("edit-keys")).sendKeys("dental insurance");
        Thread.sleep(2000);
        captureScreenshot(driver,"priority3-A");
        driver.findElement(By.id("block-searchapipagesearchblockform")).click();
        captureScreenshot(driver,"priority3-B");
        Thread.sleep(2000);
    }

}
