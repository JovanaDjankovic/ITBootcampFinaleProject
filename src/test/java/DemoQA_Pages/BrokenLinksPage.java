package DemoQA_Pages;

import DemoQA_Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokenLinksPage extends TestBase {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public BrokenLinksPage (WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(this.driver, this);
    }

    public @FindBy (xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/img[1]")
    WebElement ValidImage;

    public @FindBy (xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p[2]")
    WebElement BrokenImage;

    public @FindBy (className = "main-header")
    WebElement PageTitle;

    public @FindBy (linkText = "Click Here for Valid Link")
    WebElement ValidLinkButton;

    public @FindBy (linkText = "Click Here for Broken Link")
    WebElement BrokenLinkButton;

    public @FindBy (id = "flash-messages")
    WebElement BrokenLinkPage;

    //---------------------------------

    public void clickOnValidLink () {
        ValidLinkButton.click();
    }

    public void clickOnBrokenLink () {
        BrokenLinkButton.click();
    }


}
