package DemoQA_Tests;

import DemoQA_Base.TestBase;
import DemoQA_Pages.HomePage;
import DemoQA_Pages.SidebarPage;
import DemoQA_Pages.TextBoxPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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

    public void userCanFillFullnameFieldWithValidInput () {
        clickOnTextBoxButton();
        for (int i = 1; i <= excelReader.getLastRowNumber(); i++) {
            String validFullname = excelReader.getStringData("Textbox", i, 0);
            textBoxPage.insertUsername(validFullname);
            scrollIntoView(textBoxPage.Submit);
            textBoxPage.clickOnSubmit();
            //System.out.println(textBoxPage.outputText(0));
        }
    }

    @Test
    public void userCanFillFullnameFieldWithInvalidInput () {
        clickOnTextBoxButton();
        for (int i = 1; i <= excelReader.getLastRowNumber(); i++) {
            String invalidFullname = excelReader.getStringData("Textbox", i, 4);
            textBoxPage.insertUsername(invalidFullname);
            scrollIntoView(textBoxPage.Submit);
            textBoxPage.clickOnSubmit();
            System.out.println(textBoxPage.outputText(0));
        }
    }

    @Test
    public void userCanFillEmailFieldWithValidInput () {
        clickOnTextBoxButton();
        for (int i = 1; i <= excelReader.getLastRowNumber(); i++) {
            String validEmail = excelReader.getStringData("Textbox", i, 1);
            textBoxPage.insertUsername(validEmail);
            scrollIntoView(textBoxPage.Submit);
            textBoxPage.clickOnSubmit();
            //System.out.println(textBoxPage.outputText(1));
        }
    }




}
