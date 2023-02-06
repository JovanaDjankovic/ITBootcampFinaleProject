package DemoQA_Pages;

import DemoQA_Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class UploadDownloadPage extends TestBase {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public UploadDownloadPage (WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(this.driver, this);
    }

    public @FindBy (id = "downloadButton")
    WebElement DownloadButton;

    public  @FindBy (id = "uploadFile")
    WebElement UploadFileButton;

    public @FindBy (id = "uploadedFilePath")
    WebElement UploadedFile;

    public @FindBy (className = "main-header")
    WebElement PageTitle;

    //-----------------------------------

    public void clickOnUploadFileButton () {
        UploadFileButton.click();
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }




}
