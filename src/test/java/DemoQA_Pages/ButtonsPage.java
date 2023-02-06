package DemoQA_Pages;

import DemoQA_Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonsPage extends TestBase {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public ButtonsPage (WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(this.driver, this);
    }

    public @FindBy( xpath = "//*[text()='Click Me']")
    WebElement ClickMe;

    public @FindBy( id = "doubleClickBtn")
    WebElement DoubleClick;

    public @FindBy( id = "rightClickBtn")
    WebElement RightClick;

    public @FindBy( id = "dynamicClickMessage")
    WebElement Notification;

    public @FindBy( id = "doubleClickMessage")
    WebElement DoubleClickNotification;

    public @FindBy( id = "rightClickMessage")
    WebElement RightClickNotification;

    //-----------------------------------------------

    public void clickOnClick() {
        ClickMe.click();
    }

    public String clickNotification() {
        return Notification.getText();
    }

    public String doubleClickNotification() {
        return DoubleClickNotification.getText();
    }

    public String rightClickNotification() {
        return RightClickNotification.getText();
    }

}
