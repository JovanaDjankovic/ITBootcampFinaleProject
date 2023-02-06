package DemoQA_Tests;

import DemoQA_Base.TestBase;
import DemoQA_Pages.ButtonsPage;
import DemoQA_Pages.HomePage;
import DemoQA_Pages.LinksPage;
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

public class LinksTests extends TestBase {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeURL);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");

        homePage = new HomePage(driver, wdwait);
        sidebarPage = new SidebarPage(driver, wdwait);
        linksPage = new LinksPage(driver, wdwait);
    }

    @Test(priority = 10)
    public void UserClickOnHomeLink(){
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Links");
        linksPage.clickOnHomeLink();
        switchToNewTab(1);
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));
        closeNewTab(1);
        switchToNewTab(0);
    }

    @Test (priority = 20)
    public void UserClickOnHomevCkyELink () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Links");
        linksPage.clickOnHomevCkyELink();
        switchToNewTab(1);
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));
        closeNewTab(1);
        switchToNewTab(0);
    }

    @Test (priority = 30)
    public void UserClickOnCreatedELink () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Links");
        linksPage.clickOnCreatedLink();
        waitForVisibility(linksPage.Notification);
        Assert.assertTrue(linksPage.Notification.isDisplayed());
        Assert.assertEquals("Link has responded with staus 201 and status text Created", linksPage.linksApiNotification());
    }

    @Test (priority = 40)
    public void UserClickOnNoContentLink () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Links");
        linksPage.clickOnNoContentLink();
        waitForVisibility(linksPage.Notification);
        Assert.assertTrue(linksPage.Notification.isDisplayed());
        Assert.assertEquals("Link has responded with staus 204 and status text No Content", linksPage.linksApiNotification());
    }

    @Test (priority = 50)
    public void UserClickOnMovedLink () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Links");
        linksPage.clickOnMovedLink();
        waitForVisibility(linksPage.Notification);
        Assert.assertTrue(linksPage.Notification.isDisplayed());
        Assert.assertEquals("Link has responded with staus 301 and status text Moved Permanently", linksPage.linksApiNotification());
    }

    @Test (priority = 60)
    public void UserClickOnBadRequestLink () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Links");
        linksPage.clickOnBadRequestLink();
        waitForVisibility(linksPage.Notification);
        Assert.assertTrue(linksPage.Notification.isDisplayed());
        Assert.assertEquals("Link has responded with staus 400 and status text Bad Request", linksPage.linksApiNotification());
    }

    @Test (priority = 70)
    public void UserClickOnUnauthorizedLink () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Links");
        linksPage.clickOnUnauthorizedLink();
        waitForVisibility(linksPage.Notification);
        Assert.assertTrue(linksPage.Notification.isDisplayed());
        Assert.assertEquals("Link has responded with staus 401 and status text Unauthorized", linksPage.linksApiNotification());
    }

    @Test (priority = 80)
    public void UserClickOnForbiddenLink () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Links");
        linksPage.clickOnForbiddenELink();
        waitForVisibility(linksPage.Notification);
        Assert.assertTrue(linksPage.Notification.isDisplayed());
        Assert.assertEquals("Link has responded with staus 403 and status text Forbidden", linksPage.linksApiNotification());
    }

    @Test (priority = 90)
    public void UserClickOnNotFoundLink () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Links");
        linksPage.clickOnNotFoundLink();
        waitForVisibility(linksPage.Notification);
        Assert.assertTrue(linksPage.Notification.isDisplayed());
        Assert.assertEquals("Link has responded with staus 404 and status text Not Found", linksPage.linksApiNotification());
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
