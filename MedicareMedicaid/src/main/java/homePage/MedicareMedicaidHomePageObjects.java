package homePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MedicareMedicaidHomePageObjects {

    @FindBy(linkText = "Medicare")
    WebElement Medicare;

    @FindBy(linkText = "Medicaid/CHIP")
    WebElement MedicardCHIP;

    @FindBy(linkText = "Medicare-Medicaid Coordination")
    WebElement MedicareMedicaidCoordination;

    @FindBy(linkText = "Private Insurance")
    WebElement PrivateInsurance;

    @FindBy(linkText = "Innovation Center")
    WebElement InnovationCenter;

    @FindBy(linkText = "Regulations & Guidance")
    WebElement RegulationsGuidance;

    @FindBy(linkText = "Research, Statistics, Data & Systems")
    WebElement ResearchStatisticsDataSystems;

    @FindBy(linkText = "Outreach & Education")
    WebElement OutreachEducation;

    @FindBy(xpath = "//*[@id=\"hd\"]/div/div[2]/div[1]/a")
    WebElement cmsLogo;

    @FindBy(xpath = "//*[@id=\'query\']")
    WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"search_form\"]/input[4]")
    WebElement searchButton;

    public void clickOnMedicareModule(){
        Medicare.click();
    }

    public void clickOnMedicaidCHIPModule(){
        MedicardCHIP.click();
    }

    public void clickOnMedicareMedicaidCoordinationModule(){
        MedicareMedicaidCoordination.click();
    }

    public void clickOnPrivateInsuranceModule(){
        PrivateInsurance.click();
    }

    public void clickOnInnovationCenterModule(){
        InnovationCenter.click();
    }

    public void clickOnRegulationsGuidanceModule(){
        RegulationsGuidance.click();
    }

    public void clickOnResearchStatisticsDataSystemsModule(){
        ResearchStatisticsDataSystems.click();
    }

    public void clickOnOutreachEducationModule(){
        OutreachEducation.click();
    }

    public void setSearchBar(String text){
        searchBar.sendKeys(text);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }
}
