package DemoQA_Tests;

import DemoQA_Base.TestBase;
import DemoQA_Pages.DynamicPropertiesPage;
import DemoQA_Pages.HomePage;
import DemoQA_Pages.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicPropertiesTests extends TestBase {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeURL);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");

        homePage = new HomePage(driver, wdwait);
        sidebarPage = new SidebarPage(driver, wdwait);
        dynamicPropertiesPage = new DynamicPropertiesPage(driver, wdwait);
    }

    @Test(priority = 10)
    public void verifyPageTitle () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Dynamic Properties");
        waitForVisibility(dynamicPropertiesPage.PageTitle);
        String expectedTitle = "Dynamic Properties";
        Assert.assertEquals(dynamicPropertiesPage.PageTitle.getText(), expectedTitle);
    }

    @Test(priority = 20)
    public void testDynamicId()  {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Dynamic Properties");
        waitForVisibility(dynamicPropertiesPage.PageTitle);
        String initialId = dynamicPropertiesPage.dynamicIdText.getAttribute("id");
        driver.navigate().refresh();
        String changedId = dynamicPropertiesPage.dynamicIdText.getAttribute("id");
        Assert.assertNotEquals(initialId, changedId);
    }

    @Test(priority = 30)
    public void checkEnableButtonAfter5s()  {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Dynamic Properties");
        waitForVisibility(dynamicPropertiesPage.Enable5sButton);
        Assert.assertFalse(dynamicPropertiesPage.isEnabled(dynamicPropertiesPage.Enable5sButton));
        waitForClickability(dynamicPropertiesPage.Enable5sButton);
        Assert.assertTrue(dynamicPropertiesPage.isEnabled(dynamicPropertiesPage.Enable5sButton));
    }

    @Test(priority = 40)
    public void checkColorChangeButtonAfter5s()  {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Dynamic Properties");
        String initialColor = dynamicPropertiesPage.ColorChangeButton.getCssValue("color");
        waitForClickability(dynamicPropertiesPage.Enable5sButton);
        String changedColor = dynamicPropertiesPage.ColorChangeButton.getCssValue("color");
        Assert.assertNotEquals(initialColor, changedColor);
    }

    @Test(priority = 50)
    public void checkVisibleButtonAfter5s()  {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Dynamic Properties");
        Assert.assertFalse(isDisplayed(dynamicPropertiesPage.Visible5sAfterButton));
        waitForVisibility(dynamicPropertiesPage.Visible5sAfterButton);
        Assert.assertTrue(isDisplayed(dynamicPropertiesPage.Visible5sAfterButton));
    }

    @AfterClass
    public void tearDown () {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
