package homePageTest;

import homePage.ManuPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestManuPage extends ManuPage {
    @Test(priority = 1)
    public void manuTestBCBS() throws Exception{
        manuPageOptionBCBS();
    }

    @Test(priority = 2)
    public void manuTestAmazon() throws Exception{
        manuPageOptionAmazon();
    }
}

