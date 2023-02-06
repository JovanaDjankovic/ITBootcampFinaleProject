package DemoQA_Tests;

import DemoQA_Base.TestBase;
import DemoQA_Pages.HomePage;
import DemoQA_Pages.SidebarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class HomePageTests extends TestBase {


    @BeforeMethod
    public void pageSetUp() {
        /*WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));*/
        driver.manage().window().maximize();
        driver.get(homeURL);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");

        homePage = new HomePage(driver, wdwait);
        sidebarPage = new SidebarPage(driver, wdwait);

    }

    @Test (priority = 10)
    public void CheckHomeBunnerClickability () {
        homePage.clickOnHomeBunner();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 1));
        driver.close();

    }

    @Test (priority = 20)
    public void VerifyElementsButtonIsClickable ()  {
        scrollIntoView(homePage.getCards().get(0));
        homePage.clickOnElements();
        Assert.assertEquals((driver.getCurrentUrl()),
                excelReader.getStringData("URL", 1, 2));
    }

    @Test (priority = 30)
    public void VerifyFormsButtonIsClickable ()  {
        scrollIntoView(homePage.getCards().get(1));
        homePage.clickOnForms();
        Assert.assertEquals((driver.getCurrentUrl()),
                excelReader.getStringData("URL", 1, 3));
    }

    @Test (priority = 40)
    public void VerifyAlertsButtonIsClickable ()  {
        scrollIntoView(homePage.getCards().get(2));
        homePage.clickOnAlerts();
        Assert.assertEquals((driver.getCurrentUrl()),
                excelReader.getStringData("URL", 1, 4));
    }

    @Test (priority = 50)
    public void VerifyWidgetsButtonIsClickable ()  {
        scrollIntoView(homePage.getCards().get(0));
        homePage.clickOnWidgets();
        Assert.assertEquals((driver.getCurrentUrl()),
                excelReader.getStringData("URL", 1, 5));
    }

    @Test (priority = 60)
    public void VerifyInteractionsButtonIsClickable ()  {
        scrollIntoView(homePage.getCards().get(0));
        homePage.clickOnInteractions();
        Assert.assertEquals((driver.getCurrentUrl()),
                excelReader.getStringData("URL", 1, 6));
    }

    @Test (priority = 70)
    public void VerifyBookstoreButtonIsClickable ()  {
        scrollIntoView(homePage.getCards().get(0));
        homePage.clickOnBookstore();
        Assert.assertEquals((driver.getCurrentUrl()),
                excelReader.getStringData("URL", 1, 7));
    }

    /*@AfterMethod
    public void quit () {
        driver.quit();
    }*/


}
