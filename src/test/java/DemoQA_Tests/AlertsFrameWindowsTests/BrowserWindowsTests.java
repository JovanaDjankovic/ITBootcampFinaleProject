package DemoQA_Tests.AlertsFrameWindowsTests;

import DemoQA_Base.TestBase;
import DemoQA_Pages.AlertsFrameWindows.BrowserWindowsPage;
import DemoQA_Pages.HomePage;
import DemoQA_Pages.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class BrowserWindowsTests extends TestBase {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeURL);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");

        homePage = new HomePage(driver, wdwait);
        sidebarPage = new SidebarPage(driver, wdwait);
        browserWindowsPage = new BrowserWindowsPage(driver, wdwait);
    }

    @Test(priority = 10)
    public void verifyPageTitle() {
        goToAlerts();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Browser Windows");
        waitForVisibility(browserWindowsPage.PageTitle);
        String expectedTitle = "Browser Windows";
        Assert.assertEquals(browserWindowsPage.PageTitle.getText(), expectedTitle);
    }

    @Test(priority = 20)
    public void userCanClickOnNewTabButton() {
        goToAlerts();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Browser Windows");
        waitForVisibility(browserWindowsPage.PageTitle);
        browserWindowsPage.clickOnNewTabButton();
        switchToNewTab(1);
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 8));
    }

    @Test(priority = 30)
    public void userCanClickOnNewWindowButton() {
        goToAlerts();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Browser Windows");
        waitForVisibility(browserWindowsPage.PageTitle);
        browserWindowsPage.clickOnNewWindowButton();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (!driver.getWindowHandle().equals(windowHandle)) {
                break;
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 8));
    }

    @Test(priority = 40)
    public void userCanClickOnNewWindowMessageButton() {
        goToAlerts();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Browser Windows");
        waitForVisibility(browserWindowsPage.PageTitle);
        browserWindowsPage.clickOnNewWindowMEssageButton();

        String windowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(windowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    @AfterClass
    public void tearDown () {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
