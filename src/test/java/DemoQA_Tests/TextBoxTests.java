package DemoQA_Tests;

import DemoQA_Base.TestBase;
import DemoQA_Pages.HomePage;
import DemoQA_Pages.SidebarPage;
import DemoQA_Pages.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TextBoxTests extends TestBase {


    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeURL);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");

        homePage = new HomePage(driver, wdwait);
        sidebarPage = new SidebarPage(driver, wdwait);
        textBoxPage = new TextBoxPage(driver, wdwait);
    }

    @Test(priority = 10)
    public void checkTextboxURL () {
        String validURLTextbox = excelReader.getStringData("URL", 3, 2);
        goToElementsPage();
        sidebarPage.clickOnButton("Text Box");
        Assert.assertEquals(driver.getCurrentUrl(), validURLTextbox);
    }

    @Test (priority = 20)
    public void userCanFillTextboxesHappyFlow() {
        String validFullname = excelReader.getStringData("Textbox",1, 0);
        String validEmail = excelReader.getStringData("Textbox", 1, 1);
        String currentAddress = excelReader.getStringData("Textbox", 1, 2);
        String permanentAddress = excelReader.getStringData("Textbox", 1, 3);

        clickOnTextBoxButton();
        textBoxPage.insertUsername(validFullname);
        textBoxPage.insertEmail(validEmail);
        textBoxPage.insertCurrentAddress(currentAddress);
        textBoxPage.insertPermanentAddress(permanentAddress);
        scrollIntoView(textBoxPage.Submit);
        textBoxPage.clickOnSubmit();

        for (int i = 0; i < textBoxPage.Output.size(); i++) {
            System.out.println(textBoxPage.outputText(i));
        }
    }

    @Test (priority = 30)
    public void userCanFillFullnameFieldWithValidInput () {
        clickOnTextBoxButton();
        for (int i = 1; i < excelReader.getLastRow("Fullname"); i++) {
            String validFullname = excelReader.getStringData("Fullname", i, 0);
            textBoxPage.insertUsername(validFullname);
            scrollIntoView(textBoxPage.Submit);
            textBoxPage.clickOnSubmit();
        }
        Assert.assertTrue(isDisplayed(textBoxPage.Output.get(0)));
    }

    @Test (priority = 40)
    public void userCanFillFullnameFieldWithInvalidInput () {
        clickOnTextBoxButton();
        for (int i = 1; i <= excelReader.getLastRow("Fullname"); i++) {

            String invalidFullname = excelReader.getStringData("Fullname", i, 1);
            textBoxPage.insertUsername(invalidFullname);
            scrollIntoView(textBoxPage.Submit);
            textBoxPage.clickOnSubmit();
        }
        Assert.assertTrue(isDisplayed(textBoxPage.Output.get(0)));
    }

    @Test (priority = 50)
    public void userCanFillEmailFieldWithValidInput () {
        clickOnTextBoxButton();
        for (int i = 1; i <= excelReader.getLastRow("Textbox"); i++) {
            String validEmail = excelReader.getStringData("Textbox", i, 1);
            textBoxPage.insertEmail(validEmail);
            scrollIntoView(textBoxPage.Submit);
            textBoxPage.clickOnSubmit();
        }
    }

    @Test (priority = 60)
    public void userCanFillEmailFieldWithInvalidInput () {
        clickOnTextBoxButton();
        for (int i = 1; i <= excelReader.getLastRow("Email"); i++) {
            String invalidEmail = excelReader.getStringData("Email", i, 0);
            textBoxPage.insertEmail(invalidEmail);
            scrollIntoView(textBoxPage.Submit);
            textBoxPage.clickOnSubmit();
        }
    }

    @Test (priority = 70)
    public void userCanFillCurrentAddressFieldWithValidInput () {
        clickOnTextBoxButton();
        for (int i = 1; i <= excelReader.getLastRow("Address"); i++) {
            String validCurrentAddress = excelReader.getStringData("Address", i,0 );
            textBoxPage.insertCurrentAddress(validCurrentAddress);
            scrollIntoView(textBoxPage.Submit);
            textBoxPage.clickOnSubmit();
        }
        Assert.assertTrue(isDisplayed(textBoxPage.Output.get(0)));
    }

    @Test (priority = 80)
    public void userCanFillCurrentAddressFieldWithInvalidInput () {
        clickOnTextBoxButton();
        for (int i = 1; i <= excelReader.getLastRow("Address"); i++) {
            String invalidCurrentAddress = excelReader.getStringData("Address", i,1 );
            textBoxPage.insertCurrentAddress(invalidCurrentAddress);
            scrollIntoView(textBoxPage.Submit);
            textBoxPage.clickOnSubmit();
        }
        Assert.assertTrue(isDisplayed(textBoxPage.Output.get(0)));
    }

    @Test (priority = 90)
    public void userCannotFillTextwithAllInvalidInput() {
        String invalidFullname = excelReader.getStringData("Textbox",1, 4);
        String invalidEmail = excelReader.getStringData("Textbox", 1, 5);
        String invalidcurrentAddress = excelReader.getStringData("Textbox", 1, 6);
        String invalidpermanentAddress = excelReader.getStringData("Textbox", 1, 7);

        clickOnTextBoxButton();

        textBoxPage.insertUsername(invalidFullname);
        textBoxPage.insertEmail(invalidEmail);
        textBoxPage.insertCurrentAddress(invalidcurrentAddress);
        textBoxPage.insertPermanentAddress(invalidpermanentAddress);
        scrollIntoView(textBoxPage.Submit);
        textBoxPage.clickOnSubmit();

        waitForClickability(textBoxPage.Submit);

    }

    @AfterClass
    public void tearDown () {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
