package base;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonAPI2 {
    public WebDriver driver = null;
    public WebDriverWait wait = null;
    public String browserstack_username= "";
    public String browserstack_accesskey = "";
    public String saucelabs_username = "";
    public String saucelabs_accesskey = "";

    // basic parameters
    @Parameters({"useCloudEnv","cloudEnvName","os","os_version","browserName","browserVersion","url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv, @Optional("false")String cloudEnvName,
                      @Optional("Windows") String os, @Optional("10") String os_version, @Optional("chrome-options") String browserName, @Optional("34")
                              String browserVersion, @Optional("http://www.bcbs.com") String url)throws IOException {
        //1st (optional): get the name of local machine operating system
        String getOSNameFromSystem = System.getProperty("os.name");
        System.out.println("*******The local machine operating system is ------>> " + getOSNameFromSystem);
        System.out.println();

        // 2nd (optional): choose the cloudDriver or local drivers: browserstack or saucelabs ---> older OS and webdriver
        if(useCloudEnv==true){
            if(cloudEnvName.equalsIgnoreCase("browserstack")) {
                getCloudDriver(cloudEnvName,browserstack_username,browserstack_accesskey,os,os_version, browserName, browserVersion);
            }else if (cloudEnvName.equalsIgnoreCase("saucelabs")){
                getCloudDriver(cloudEnvName,saucelabs_username, saucelabs_accesskey,os,os_version, browserName, browserVersion);
            }
        }else{
            getLocalDriver(os, browserName);
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
    }

    // ref to 2nd: cloud driver setting
    public WebDriver getCloudDriver(String envName,String envUsername, String envAccessKey,String os, String os_version,String browserName,
                                    String browserVersion)throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser",browserName);
        cap.setCapability("browser_version",browserVersion);
        cap.setCapability("os", os);
        cap.setCapability("os_version", os_version);
        if(envName.equalsIgnoreCase("Saucelabs")){
            //resolution for Saucelabs
            driver = new RemoteWebDriver(new URL("http://"+envUsername+":"+envAccessKey+
                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
        }else if(envName.equalsIgnoreCase("Browserstack")) {
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), cap);
        }
        return driver;
    }

    // ref to 2nd: local driver setting
    public WebDriver getLocalDriver(@Optional("mac") String OS, String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            if(OS.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.chrome.driver", "../Generic/Drivers/chromedriver");
            }else if(OS.equalsIgnoreCase("Windows")){
                System.setProperty("webdriver.chrome.driver", "../Generic/Drivers/chromedriver.exe");
            }
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("chrome-options")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            if(OS.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.chrome.driver", "../Generic/browser-driver/chromedriver");
            }else if(OS.equalsIgnoreCase("Windows")){
                System.setProperty("webdriver.chrome.driver", "../Generic/browser-driver/chromedriver.exe");
            }
            driver = new ChromeDriver(options);
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            if(OS.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.gecko.driver", "../Generic/browser-driver/geckodriver");
            }else if(OS.equalsIgnoreCase("Windows")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/browser-driver/geckodriver.exe");
            }
            driver = new FirefoxDriver();
        } else if(browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "../Generic/browser-driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        return driver;
    }

    @AfterMethod
    public void cleanUp() {
        System.out.println("******Test is finished!******");
        driver.close();
    }

    //******for element enter******
    // only for element type in
    public void typeOnElement(String locator, String value){
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
            System.out.println("The findElement-css is successfully used !");
        }catch(Exception ex1) {
            try{
                driver.findElement(By.id(locator)).sendKeys(value);
                System.out.println("The findElement-id is successfully used !");
            }catch(Exception ex2) {
                try {
                    driver.findElement(By.name(locator)).sendKeys(value);
                    System.out.println("The findElement-name is successfully used !");
                } catch (Exception ex3) {
                    driver.findElement(By.xpath(locator)).sendKeys(value);
                    System.out.println("The findElement-xpath is successfully used !");
                }
            }
        }
    }
    // element type in with enter
    public void typeOnElementEnter(String locator, String value){
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
            System.out.println("The findElement-css is successfully used !");
        }catch(Exception ex1) {
            try{
                driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
                System.out.println("The findElement-id is successfully used !");
            }catch(Exception ex2) {
                try {
                    driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
                    System.out.println("The findElement-name is successfully used !");
                } catch (Exception ex3) {
                    driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
                    System.out.println("The findElement-xpath is successfully used !");
                }
            }
        }
    }
    // element type in with enter / with different driver  ---> vary the elements as you need
    public static void typeOnElementNEnter(String locator, String value,WebDriver driverX) {
        try {
            driverX.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            try {
                System.out.println("First Attempt was not successful");
                driverX.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
            } catch (Exception ex2) {
                try {
                    System.out.println("Second Attempt was not successful");
                    driverX.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
                } catch (Exception ex3) {
                    System.out.println("Third Attempt was not successful");
                    driverX.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
                }
            }
        }
    }

    //****** for field clear ******
    // clear field using different locator
    public void clearField(String locator){
        try {
            driver.findElement(By.cssSelector(locator)).clear();
        }catch(Exception ex1) {
            try{
                driver.findElement(By.id(locator)).clear();
            }catch(Exception ex2) {
                try {
                    driver.findElement(By.name(locator)).clear();
                } catch (Exception ex3) {
                    driver.findElement(By.xpath(locator)).clear();
                }
            }
        }
    }

    //go back to your last page
    public void navigateBack(){ driver.navigate().back(); }
    public void navigateBack2(WebDriver driverX){ driverX.navigate().back(); }

    //Taking Screen Shots
    public static void captureScreenshot(WebDriver driver, String screenshotName){
        DateFormat df = new SimpleDateFormat("(MMddyyyy HH-mma)"); // you can not use : or .
        Date date = new Date();
        df.format(date);
//        System.out.println(df.format(date));
//        System.out.println(System.getProperty("user.dir")); // fold direction
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir")+ "/screenshots/"+screenshotName+" "+df.format(date)+".png"));
//            FileUtils.copyFile(file, new File("D:\\Studies\\Java\\IdeaProjects\\WebAutomation\\ECommenceClass\\Demo\\src\\main\\ScreenShots\\ScreenShot2.png"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot "+e.getMessage());;
        }
    }

    public static String convertToString(String st){
        String splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        return splitString;
    }
}
