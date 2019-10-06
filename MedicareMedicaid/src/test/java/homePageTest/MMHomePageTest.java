package homePageTest;

import base.CommonAPI;
import medicareMedicaidPages.HomePageObjects;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MMHomePageTest extends CommonAPI {

    HomePageObjects homePage;
    String url = "https://www.cms.gov/";

    @BeforeClass
    public void intil(){
        getLocalDriver();
        homePage = PageFactory.initElements(driver, HomePageObjects.class);
        driver.get(url);
    }

    @Test
    public void medicareModuleTest(){
        homePage.clickOnMedicareModule();
        if(driver.getTitle().contains("Medicare")){
            System.out.println("Test has Passed");
        }else{
            System.out.println("Test has not Passed.");
        }
        driver.close();
    }
}
