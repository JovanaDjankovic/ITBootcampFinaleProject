package DemoQA_Tests;

import DemoQA_Base.TestBase;
import DemoQA_Pages.HomePage;
import DemoQA_Pages.RadioButtonPage;
import DemoQA_Pages.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTests extends TestBase {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeURL);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");

        homePage = new HomePage(driver, wdwait);
        sidebarPage = new SidebarPage(driver, wdwait);
        radioButtonPage = new RadioButtonPage(driver, wdwait);
    }

    @Test (priority = 10)
    public void clickOnYesRadioButton() {
        goToElementsPage();
        sidebarPage.clickOnButton("Radio Button");
        clickElementJS(radioButtonPage.Yes);
        Assert.assertEquals("Yes", radioButtonPage.notificationText());
    }

    @Test (priority = 20)
    public void clickOnImpressiveRadioButton() {
        goToElementsPage();
        sidebarPage.clickOnButton("Radio Button");
        clickElementJS(radioButtonPage.Impressive);
        Assert.assertEquals("Impressive", radioButtonPage.notificationText());
    }

    @Test (priority = 30)
    public void clickOnNoRadioButton() {
        goToElementsPage();
        sidebarPage.clickOnButton("Radio Button");
        clickElementJS(radioButtonPage.No);
        Assert.assertTrue(radioButtonPage.No.isEnabled());
    }

}
