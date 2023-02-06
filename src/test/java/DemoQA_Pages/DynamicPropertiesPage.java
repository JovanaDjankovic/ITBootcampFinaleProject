package DemoQA_Pages;

import DemoQA_Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicPropertiesPage extends TestBase {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public DynamicPropertiesPage (WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(this.driver, this);
    }

    public @FindBy (xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p")
    WebElement dynamicIdText;

    public @FindBy (id = "enableAfter")
    WebElement Enable5sButton;

    public @FindBy (id = "colorChange")
    WebElement ColorChangeButton;

    public @FindBy (id = "visibleAfter")
    WebElement Visible5sAfterButton;
    public @FindBy (className = "main-header")
    WebElement PageTitle;

    //---------------------------

    public boolean isEnabled (WebElement element) {

            boolean webelement = false;
            try {
                webelement = element.isEnabled();
            } catch (Exception e) {

            }
            return webelement;
        }




}
