package DemoQA_Tests;

import DemoQA_Base.TestBase;
import DemoQA_Pages.CheckBoxPage;
import DemoQA_Pages.HomePage;
import DemoQA_Pages.RadioButtonPage;
import DemoQA_Pages.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTests extends TestBase {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeURL);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");

        homePage = new HomePage(driver, wdwait);
        sidebarPage = new SidebarPage(driver, wdwait);
        checkBoxPage = new CheckBoxPage(driver, wdwait);

    }

    @Test (priority = 10)
    public void checkboxingHomeWillCheckboxAllOthers() {
        goToElementsPage();
        sidebarPage.clickOnButton("Check Box");
        for (int i = 0 ; i<= checkBoxPage.UncheckedCheckbox.size() ; i++) {
            checkBoxPage.clickOnDropdownButton(0);
            scrollIntoView(checkBoxPage.DropdownButton.get(i));
            checkBoxPage.clickOnUnchecked(0);
            System.out.println(checkBoxPage.getNotificationSuccess());
            Assert.assertEquals("home", checkBoxPage.getNotificationSuccess());
            Assert.assertEquals(checkBoxPage.getCheckedList(i),4 );
        }

    }

    @Test (priority = 20)
    public void checkboxingDesktop () {
        goToElementsPage();
        sidebarPage.clickOnButton("Check Box");
        checkBoxPage.clickOnDropdownButton(0);
        checkBoxPage.clickOnUnchecked(1);
        System.out.println(checkBoxPage.getNotificationSuccess());
        Assert.assertEquals("desktop", checkBoxPage.getNotificationSuccess());
    }

    @Test (priority = 30)
    public void checkboxingDocuments () {
        goToElementsPage();
        sidebarPage.clickOnButton("Check Box");
        checkBoxPage.clickOnDropdownButton(0);
        checkBoxPage.clickOnUnchecked(2);
        System.out.println(checkBoxPage.getNotificationSuccess());
        Assert.assertEquals("documents", checkBoxPage.getNotificationSuccess());
    }

    @Test (priority = 40)
    public void checkboxingDownloads () {
        goToElementsPage();
        sidebarPage.clickOnButton("Check Box");
        checkBoxPage.clickOnDropdownButton(0);
        checkBoxPage.clickOnUnchecked(3);
        System.out.println(checkBoxPage.getNotificationSuccess());
        Assert.assertEquals("downloads", checkBoxPage.getNotificationSuccess());
    }

    @Test (priority = 50)
    public void checkboxingDesktopSubfolder () {
        goToElementsPage();
        sidebarPage.clickOnButton("Check Box");
        checkBoxPage.clickOnDropdownButton(0);
        checkBoxPage.clickOnDropdownButton(1);
        checkBoxPage.clickOnUnchecked(2);
        System.out.println(checkBoxPage.getNotificationSuccess());
        Assert.assertEquals("notes", checkBoxPage.getNotificationSuccess());
    }

    @Test (priority = 60)
    public void checkboxingDocumentsSubfolder  () {
        goToElementsPage();
        sidebarPage.clickOnButton("Check Box");
        checkBoxPage.clickOnDropdownButton(0);
        checkBoxPage.clickOnDropdownButton(2);
        checkBoxPage.clickOnUnchecked(3);
        System.out.println(checkBoxPage.getNotificationSuccess());
        Assert.assertEquals("workspace", checkBoxPage.getNotificationSuccess());
    }

    @Test (priority = 70)
    public void checkboxingDownloadsSubfolder  () {
        goToElementsPage();
        sidebarPage.clickOnButton("Check Box");
        checkBoxPage.clickOnDropdownButton(0);
        checkBoxPage.clickOnDropdownButton(3);
        checkBoxPage.clickOnUnchecked(4);
        System.out.println(checkBoxPage.getNotificationSuccess());
        Assert.assertEquals("wordFile", checkBoxPage.getNotificationSuccess());
    }

    @Test (priority = 80)
    public void checkboxingDocumentsSubSubfolder() {
        goToElementsPage();
        sidebarPage.clickOnButton("Check Box");
        for (int i = 0 ; i<=5 ; i++) {
            scrollIntoView(checkBoxPage.DropdownButton.get(i));
            checkBoxPage.clickOnDropdownButton(i);
        }
        Assert.assertEquals("rct-icon rct-icon-uncheck",checkBoxPage.React.getAttribute("class"));
        checkBoxPage.clickOnAngular();
        Assert.assertEquals("rct-icon rct-icon-check",checkBoxPage.React.getAttribute("class"));
        Assert.assertEquals("react", checkBoxPage.getNotificationSuccess());
    }



}
