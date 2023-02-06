package DemoQA_Pages;

import DemoQA_Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinksPage extends TestBase {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public LinksPage (WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(this.driver, this);
    }

    public @FindBy (id = "simpleLink")
    WebElement Home;

    public @FindBy (id = "dynamicLink")
    WebElement HomevCkyE;

    public @FindBy (id = "created")
    WebElement Created;

    public @FindBy (id = "no-content")
    WebElement NoContent;

    public @FindBy (id = "moved")
    WebElement Moved;

    public @FindBy (id = "bad-request")
    WebElement BadRequest;

    public @FindBy (id = "unauthorized")
    WebElement Unauthorized;

    public @FindBy (id = "forbidden")
    WebElement Forbidden;

    public @FindBy (id = "invalid-url")
    WebElement NotFound;

    public @FindBy (id = "linkResponse")
    WebElement Notification;

    //------------------------------------------

    public void clickOnHomeLink () {
        Home.click();
    }

    public void clickOnHomevCkyELink () {
        HomevCkyE.click();
    }

    public void clickOnCreatedLink () {
        Created.click();
    }

    public void clickOnNoContentLink () {
        NoContent.click();
    }

    public void clickOnMovedLink () {
        Moved.click();
    }

    public void clickOnBadRequestLink () {
        BadRequest.click();
    }

    public void clickOnUnauthorizedLink () {
        Unauthorized.click();
    }

    public void clickOnForbiddenELink () {
        Forbidden.click();
    }

    public void clickOnNotFoundLink () {
        NotFound.click();
    }

    public String linksApiNotification() {
        return Notification.getText();
    }









}
