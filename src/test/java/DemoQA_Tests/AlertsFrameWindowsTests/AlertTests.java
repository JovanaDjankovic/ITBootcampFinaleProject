package DemoQA_Tests.AlertsFrameWindowsTests;

import DemoQA_Base.TestBase;
import DemoQA_Pages.AlertsFrameWindows.AlertsPage;
import DemoQA_Pages.HomePage;
import DemoQA_Pages.SidebarPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeURL);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");

        homePage = new HomePage(driver, wdwait);
        sidebarPage = new SidebarPage(driver, wdwait);
        alertsPage = new AlertsPage(driver, wdwait);
    }

    @Test (priority = 10)
    public void verifyPageTitle() {
        goToAlerts();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Alerts");
        waitForVisibility(alertsPage.PageTitle);
        String expectedTitle = "Alerts";
        Assert.assertEquals(alertsPage.PageTitle.getText(), expectedTitle);
    }

    @Test (priority = 20)
    public void userClickOnAlertButton() throws InterruptedException {
        goToAlerts();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Alerts");
        waitForVisibility(alertsPage.PageTitle);
        alertsPage.clickOnButtonAlert();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals("You clicked a button", alertText);
        alert.accept();
    }

    @Test (priority = 30)
    public void userClickOnAlertButtonAlertShowsAfter5s() throws InterruptedException {
        goToAlerts();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Alerts");
        waitForVisibility(alertsPage.PageTitle);
        alertsPage.clickOnButtonAlertAfter5s();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals("This alert appeared after 5 seconds", alertText);
        alert.accept();
    }

    @Test (priority = 40)
    public void userClickOnConfirmBoxButton() throws InterruptedException {
        goToAlerts();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Alerts");
        waitForVisibility(alertsPage.PageTitle);
        alertsPage.clickOnConfirmButton();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals("Do you confirm action?", alertText);
        alert.accept();
        String result = alertsPage.confirmText.getText();
        Assert.assertEquals("You selected Ok", result);
    }

    @Test (priority = 50)
    public void userClickCancelOnConfirmBoxButton() throws InterruptedException {
        goToAlerts();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Alerts");
        waitForVisibility(alertsPage.PageTitle);
        alertsPage.clickOnConfirmButton();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals("Do you confirm action?", alertText);
        alert.dismiss();
        String result = alertsPage.confirmText.getText();
        Assert.assertEquals("You selected Cancel", result);
    }

    @Test (priority = 60)
    public void userClickOnPromptBoxButton() throws InterruptedException {
        goToAlerts();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Alerts");
        waitForVisibility(alertsPage.PageTitle);
        alertsPage.clickOnPromptBoxButton();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals("Please enter your name", alertText);
        String ime = "Jovana";
        alert.sendKeys(ime);
        alert.accept();
        String result = alertsPage.promptText.getText();
        Assert.assertEquals("You entered " + ime, result);
    }

    @AfterClass
    public void tearDown () {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
