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
    public void manuTestDelta() throws Exception{
        manuPageOptionDelta();
    }

    @Test(priority = 3)
    public void manuTestBCBS2() throws Exception{
        manuPageOptionBCBS2();
    }

    @Test(priority = 4)
    public void testfindAllElements() throws InterruptedException {
        findAllElements();
    }

    @Test(priority = 5)
    public void testFindADoctor() throws InterruptedException {
        findADoctor();
    }

}

