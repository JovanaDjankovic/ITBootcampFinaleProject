package DemoQA_Tests.Widgets;

import DemoQA_Base.TestBase;
import DemoQA_Pages.HomePage;
import DemoQA_Pages.SidebarPage;
import DemoQA_Pages.Widgets.ProgressBarPage;
import io.cucumber.java.bs.A;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ProgressBarTests extends TestBase {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeURL);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");

        homePage = new HomePage(driver, wdwait);
        sidebarPage = new SidebarPage(driver, wdwait);
        progressBarPage = new ProgressBarPage(driver, wdwait);
    }

    @Test(priority = 10)
    public void verifyPageTitle() {
        goToWidgets();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Progress Bar");
        waitForVisibility(progressBarPage.PageTitle);
        String expectedTitle = "Progress Bar";
        Assert.assertEquals(progressBarPage.PageTitle.getText(), expectedTitle);
    }

    @Test(priority = 20)
    public void userClickStartProgressBar() {
        goToWidgets();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Progress Bar");
        waitForVisibility(progressBarPage.PageTitle);
        progressBarPage.clickOnStartStopButton();
        waitForVisibility(progressBarPage.resetButton);
        int finalProgress = progressBarPage.getProgress();
        Assert.assertNotEquals(100, finalProgress);
    }

    @AfterClass
    public void tearDown () {
        driver.manage().deleteAllCookies();
        driver.quit();
    }


}
