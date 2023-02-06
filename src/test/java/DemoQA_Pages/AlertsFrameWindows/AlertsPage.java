package DemoQA_Pages.AlertsFrameWindows;

import DemoQA_Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends TestBase {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public AlertsPage (WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(this.driver, this);
    }

    public @FindBy (id = "alertButton")
    WebElement alertButton1;

    public @FindBy (id = "timerAlertButton")
    WebElement alertButton2;

    public @FindBy (id = "confirmButton")
    WebElement alertButton3;

    public @FindBy (id = "confirmResult")
    WebElement confirmText;

    public @FindBy (id = "promtButton")
    WebElement alertButton4;

    public @FindBy (id = "promptResult")
    WebElement promptText;

    public @FindBy (className = "main-header")
    WebElement PageTitle;


    //----------------------

    public void clickOnButtonAlert () {
        alertButton1.click();
    }

    public void clickOnButtonAlertAfter5s () {
        alertButton2.click();
    }
    public void clickOnConfirmButton () {
        alertButton3.click();
    }

    public void clickOnPromptBoxButton () {
        alertButton4.click();
    }

}





