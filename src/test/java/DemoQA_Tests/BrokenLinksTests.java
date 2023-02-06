package DemoQA_Tests;

import DemoQA_Base.TestBase;
import DemoQA_Pages.BrokenLinksPage;
import DemoQA_Pages.HomePage;
import DemoQA_Pages.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.testng.AssertJUnit.fail;

public class BrokenLinksTests extends TestBase {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeURL);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");

        homePage = new HomePage(driver, wdwait);
        sidebarPage = new SidebarPage(driver, wdwait);
        brokenLinksPage = new BrokenLinksPage(driver, wdwait);
    }

    @Test (priority = 10)
    public void verifyPageTitle () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Broken Links - Images");
        waitForVisibility(brokenLinksPage.PageTitle);
        String expectedTitle = "Broken Links - Images";
        Assert.assertEquals(brokenLinksPage.PageTitle.getText(), expectedTitle);
    }


    @Test (priority = 20)
    public void checkValidImageIsPresent () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Broken Links - Images");
        String imageSrc = brokenLinksPage.ValidImage.getAttribute("src");
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(imageSrc).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();  //Ovaj test će pokušati da otvori konekciju na URL
            Assert.assertEquals(200, responseCode); // slike i proveri da li se slika uspešno učitala (HTTP status code 200)
        } catch (Exception e) {
            fail("Failed to load image");
        }
    }

    @Test (priority = 30)
    public void checkBrokenImageIsPresent () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Broken Links - Images");
        String expectedText = "Broken image";
        Assert.assertEquals(brokenLinksPage.BrokenImage.getText(), expectedText);
    }

    @Test (priority = 40)
    public void checkValidLink () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Broken Links - Images");
        brokenLinksPage.clickOnValidLink();
        switchToNewTab(0);
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));
    }

    @Test (priority = 50)
    public void checkBrokenLink () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Broken Links - Images");
        brokenLinksPage.clickOnBrokenLink();
        switchToNewTab(0);
        Assert.assertTrue(isDisplayed(brokenLinksPage.BrokenLinkPage));
    }

    @AfterClass
    public void tearDown () {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
