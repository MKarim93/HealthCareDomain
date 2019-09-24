package cucumber.stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class HomePageSteps {

    public static WebDriver driver;
    HomePage homePage;

    @Given("^User navigates to https://www\\.cms\\.gov/$")
    public void user_navigates_to_https_www_cms_gov(){
        System.setProperty("webdriver.chrome.driver", "C://Users//Mohammad Karim//Browsers//chromedriver.exe");
        driver.get("https://www.cms.gov/");
    }

    @When("^User validates the page has been loaded$")
    public void user_validates_the_page_has_been_loaded(){
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.cms.gov/";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Then("^User validate all the modules on the top of the page are displayed$")
    public void user_validate_all_the_modules_on_the_top_of_the_page_are_displayed(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.moduleValidation();
    }
}
