package DemoQA_Pages.AlertsFrameWindows;

import DemoQA_Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserWindowsPage extends TestBase {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public BrowserWindowsPage (WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(this.driver, this);
    }

    public @FindBy (className = "main-header")
    WebElement PageTitle;

    public @FindBy (id = "tabButton")
    WebElement TabButton;

    public @FindBy (id = "windowButton")
    WebElement WindowButton;

    public @FindBy (id = "messageWindowButton")
    WebElement WindowMessageButton;

    public @FindBy (xpath = "/html/body")
    WebElement textMessage;


    //-----------------------
    public void clickOnNewTabButton () {
        TabButton.click();
    }

    public void clickOnNewWindowButton () {
        WindowButton.click();
    }
    public void clickOnNewWindowMEssageButton () {
        WindowMessageButton.click();
    }



}
