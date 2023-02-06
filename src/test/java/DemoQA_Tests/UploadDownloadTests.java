package DemoQA_Tests;

import DemoQA_Base.TestBase;
import DemoQA_Pages.HomePage;
import DemoQA_Pages.SidebarPage;
import DemoQA_Pages.UploadDownloadPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class UploadDownloadTests extends TestBase {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeURL);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");

        homePage = new HomePage(driver, wdwait);
        sidebarPage = new SidebarPage(driver, wdwait);
        uploadDownloadPage = new UploadDownloadPage (driver, wdwait);
    }

    @Test (priority = 10)
    public void verifyPageTitle () {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Upload and Download");
        waitForVisibility(uploadDownloadPage.PageTitle);
        String expectedTitle = "Upload and Download";
        Assert.assertEquals(uploadDownloadPage.PageTitle.getText(), expectedTitle);
    }

    @Test (priority = 20)
    public void checkUploadImage () throws InterruptedException {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Upload and Download");
        waitForVisibility(uploadDownloadPage.UploadFileButton);
        clickElementJS(uploadDownloadPage.UploadFileButton);
        uploadDownloadPage.UploadFileButton.sendKeys("C:\\Users\\Jovana\\Desktop\\imageQA.jpg");
        String expectedUploadedFile = "C:\\fakepath\\imageQA.jpg";
        String actualUploadedFile = uploadDownloadPage.UploadedFile.getText();
        Assert.assertEquals(expectedUploadedFile, actualUploadedFile);
    }

    @Test (priority = 30)
    public void checkDownloadImage () throws InterruptedException, IOException {
        goToElementsPage();
        scrollToTheEnd();
        sidebarPage.clickOnButton("Upload and Download");
        waitForVisibility(uploadDownloadPage.UploadFileButton);
        clickElementJS(uploadDownloadPage.UploadFileButton);
        uploadDownloadPage.UploadFileButton.sendKeys("C:\\Users\\Jovana\\Desktop\\imageQA.jpg");
        waitForVisibility(uploadDownloadPage.DownloadButton);
        clickElementJS(uploadDownloadPage.DownloadButton);
        uploadDownloadPage.isFileDownloaded("C:\\Users\\Jovana\\Downloads", "sampleFile");
    }

    @AfterClass
    public void tearDown () {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
