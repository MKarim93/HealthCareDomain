package homePageTest;

import base.CommonAPI;
import homePage.MedicareMedicaidHomePageObjects;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MedicareMedicaidHomePageModuleTest extends CommonAPI {

    MedicareMedicaidHomePageObjects homePage;
    String url = "https://www.cms.gov/";

    @BeforeClass
    public void intil(){
        getLocalDriver();
        homePage = PageFactory.initElements(driver, MedicareMedicaidHomePageObjects.class);
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
