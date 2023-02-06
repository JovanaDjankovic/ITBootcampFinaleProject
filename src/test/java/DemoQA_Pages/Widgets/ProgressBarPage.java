package DemoQA_Pages.Widgets;

import DemoQA_Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgressBarPage extends TestBase {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public ProgressBarPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(this.driver, this);
    }

    public @FindBy (className = "main-header")
    WebElement PageTitle;

    public @FindBy (id = "startStopButton")
    WebElement startStopButton;

    public @FindBy (xpath = "//div[@id='progressBar']")
    WebElement progressBar;

    public @FindBy (id = "resetButton")
    WebElement resetButton;


    public WebElement getProgressBar() {
        return progressBar;
    }

    //------------------------

    public void clickOnStartStopButton () {
       startStopButton.click();
    }

    public void waitForProgressCompletion() {
        wdwait.until(ExpectedConditions.attributeToBe(progressBar, "style", "width: 100%;"));
    }

    public int getProgress() {
        String progressBarStyle = progressBar.getAttribute("style");
        int startIndex = progressBarStyle.indexOf(": ");
        int endIndex = progressBarStyle.indexOf("%");
        if (startIndex == -1 || endIndex == -1) {
            return 0;
        }
        String progress = progressBarStyle.substring(startIndex + 1, endIndex);
        return Integer.parseInt(progress);
    }
}
