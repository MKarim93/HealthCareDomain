package cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

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

    public void clickOnMedicare(){
        Medicare.click();
    }

    public void moduleValidation(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if (Medicare.isDisplayed()){
            System.out.println(Medicare.getText() + " : is displayed");
        }
        if (MedicardCHIP.isDisplayed()){
            System.out.println(MedicardCHIP.getText() + " : is displayed");
        }
        if (MedicareMedicaidCoordination.isDisplayed()){
            System.out.println(MedicareMedicaidCoordination.getText() + " : is displayed");
        }
        if (PrivateInsurance.isDisplayed()){
            System.out.println(PrivateInsurance.getText() + " : is displayed");
        }
        if (InnovationCenter.isDisplayed()){
            System.out.println(InnovationCenter.getText() + " : is displayed");
        }
        if (RegulationsGuidance.isDisplayed()){
            System.out.println(RegulationsGuidance.getText() + " : is displayed");
        }
        if (ResearchStatisticsDataSystems.isDisplayed()){
            System.out.println(ResearchStatisticsDataSystems.getText() + " : is displayed");
        }
        if (OutreachEducation.isDisplayed()){
            System.out.println(OutreachEducation.getText() + " : is displayed");
        }
    }
}
