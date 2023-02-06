package DemoQA_Pages;

import DemoQA_Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RadioButtonPage extends TestBase {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public RadioButtonPage (WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(this.driver, this);
    }

    public @FindBy( id = "yesRadio")
    WebElement Yes;

    public @FindBy( id = "noRadio")
    WebElement No;

    public @FindBy( id = "impressiveRadio")
    WebElement Impressive;

    public @FindBy( className = "text-success")
    WebElement Notification;

    public @FindBy(className = "mt-3")
    List<WebElement> NotificationExistence;

    //------------------------------

    public void clickYes() {
        Yes.click();
    }

    public void clickNo() {
        No.click();
    }

    public void clickImpressive() {
        Impressive.click();
    }

    public String notificationText() {
        return Notification.getText();
    }

    public String notificationExistenceText(int i) {
        return NotificationExistence.get(i).getText();
    }



}
