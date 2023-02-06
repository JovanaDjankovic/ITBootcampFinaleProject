package DemoQA_Pages;

import DemoQA_Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckBoxPage extends TestBase {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public CheckBoxPage (WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(this.driver, this);
    }

    public @FindBy( css = ".rct-collapse.rct-collapse-btn")
    List<WebElement> DropdownButton;

    public @FindBy( css = ".rct-icon.rct-icon-uncheck")
    List<WebElement> UncheckedCheckbox;

    public @FindBy( css = ".rct-icon.rct-icon-check")
    List<WebElement> CheckedCheckbox;

    public @FindBy( xpath = "//label[@for='tree-node-react']//span[@class='rct-checkbox']//*[name()='svg']")
    WebElement React;


    public @FindBy( className = "text-success")
    WebElement Notification;

    //------------------------------------------

    public void clickOnDropdownButton(int i) {
        DropdownButton.get(i).click();
    }

    public int getUncheckedList(int i) {
        return UncheckedCheckbox.size();
    }

    public int getCheckedList(int i) {
        return CheckedCheckbox.size();
    }

    public void clickOnUnchecked(int i) {
        UncheckedCheckbox.get(i).click();
    }

    public void clickOnAngular() {
        React.click();
    }

    public String getNotificationSuccess() {
        return Notification.getText();
    }


}
