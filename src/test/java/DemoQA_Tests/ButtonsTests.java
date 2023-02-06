package DemoQA_Tests;

import DemoQA_Base.TestBase;
import DemoQA_Pages.ButtonsPage;
import DemoQA_Pages.CheckBoxPage;
import DemoQA_Pages.HomePage;
import DemoQA_Pages.SidebarPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends TestBase {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeURL);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");

        homePage = new HomePage(driver, wdwait);
        sidebarPage = new SidebarPage(driver, wdwait);
        buttonsPage = new ButtonsPage(driver, wdwait);
    }

    @Test (priority = 10)
    public void clickOnAllButtons(){
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Buttons");
        actionDoubleClick(buttonsPage.DoubleClick);
        Assert.assertTrue(buttonsPage.DoubleClickNotification.isDisplayed());
        Assert.assertEquals("You have done a double click", buttonsPage.doubleClickNotification());
        actionRightClick(buttonsPage.RightClick);
        Assert.assertTrue(buttonsPage.RightClickNotification.isDisplayed());
        Assert.assertEquals("You have done a right click", buttonsPage.rightClickNotification());
        buttonsPage.clickOnClick();
        Assert.assertTrue(buttonsPage.Notification.isDisplayed());
        Assert.assertEquals("You have done a dynamic click",buttonsPage.clickNotification());
    }

    @Test (priority = 20)
    public void clickOnDoubleClickButton () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Buttons");
        actionDoubleClick(buttonsPage.DoubleClick);
        Assert.assertTrue(buttonsPage.DoubleClickNotification.isDisplayed());
        Assert.assertEquals("You have done a double click", buttonsPage.doubleClickNotification());
    }

    @Test (priority = 30)
    public void clickOnRightClickButton () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Buttons");
        actionRightClick(buttonsPage.RightClick);
        Assert.assertTrue(buttonsPage.RightClickNotification.isDisplayed());
        Assert.assertEquals("You have done a right click", buttonsPage.rightClickNotification());
    }

    @Test (priority = 40)
    public void clickOnClickButton () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Buttons");
        buttonsPage.clickOnClick();
        Assert.assertTrue(buttonsPage.Notification.isDisplayed());
        Assert.assertEquals("You have done a dynamic click",buttonsPage.clickNotification());
    }

}
