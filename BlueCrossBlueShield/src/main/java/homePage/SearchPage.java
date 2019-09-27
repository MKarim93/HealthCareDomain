package homePage;

import base.CommonAPI2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchPage extends CommonAPI2 {

    @FindBy(how = How.ID, using = "edit-keys")
    public static WebElement searchElement;
    public WebElement getSearchElement(){return searchElement;}

    @FindBy(how = How.ID, using = "block-searchapipagesearchblockform")
    public static WebElement submitButton;
    public WebElement getSubmitButton(){return submitButton;}

    public void searchFor(String item){getSearchElement().sendKeys(item);}
    public void searchButton(){getSubmitButton().click();}
    public void clearInput(){getSearchElement().clear();}

    public void searchItemsAndSubmit()throws Exception, IOException, SQLException, ClassNotFoundException{
        List<String> list = getItemValue();
        for(int i=0; i<list.size(); i++) {
            searchFor(list.get(i));  // compared to - searchInputWebElement.sendKeys(); - not fancy
            Thread.sleep(2000);
            searchButton();
//            String num = Integer.toString(i);
            String screenshots = "screenshots-"+Integer.toString(i);
            System.out.println(screenshots);
//            captureScreenshot(driver,screenshots);
            Thread.sleep(2000);
            clearInput();
        }
    }

    public List<String> getItemValue(){
        List<String> itemList = new ArrayList<>();
        itemList.add("Dental insurance");
        itemList.add("Vision insurance");
        itemList.add("Dentist");
        itemList.add("Surgeon");
        itemList.add("pediatrician");
        return itemList;
    }
}
