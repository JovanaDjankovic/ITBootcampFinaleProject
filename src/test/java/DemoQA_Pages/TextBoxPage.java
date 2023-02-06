package DemoQA_Pages;

import DemoQA_Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TextBoxPage extends TestBase {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public TextBoxPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(this.driver, this);
    }


    public @FindBy( id = "userName")
    WebElement Username;

    public @FindBy( id = "userEmail")
    WebElement Email;

    public @FindBy( id = "currentAddress")
    WebElement CurrentAddress;

    public @FindBy( id = "permanentAddress")
    WebElement PermanentAddress;

    public @FindBy( id = "submit")
    WebElement Submit;

    public @FindBy( className = "mb-1")
    List<WebElement> Output;

    //-------------------------------------------------

    public void insertUsername(String username) {
        Username.clear();
        Username.sendKeys(username);
    }

    public void insertEmail(String email) {
        Email.clear();
        Email.sendKeys(email);
    }

    public void insertCurrentAddress(String current) {
        CurrentAddress.clear();
        CurrentAddress.sendKeys(current);
    }

    public void insertPermanentAddress(String permanent) {
        PermanentAddress.clear();
        PermanentAddress.sendKeys(permanent);
    }

    public String outputText(int i) {
        return Output.get(i).getText();
    }


    public void clickOnSubmit() {
        Submit.click();
    }



}
