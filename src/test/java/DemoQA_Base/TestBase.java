package DemoQA_Base;


import DemoQA_Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class TestBase {
    public WebDriver driver;
    public WebDriverWait wdwait;

    public ExcelReader excelReader;
    public String homeURL;

    public SidebarPage sidebarPage;
    public HomePage homePage;
    public TextBoxPage textBoxPage;
    public CheckBoxPage checkBoxPage;
    public RadioButtonPage radioButtonPage;
    public ButtonsPage buttonsPage;
    public LinksPage linksPage;
    public BrokenLinksPage brokenLinksPage;
    public UploadDownloadPage uploadDownloadPage;
    public DynamicPropertiesPage dynamicPropertiesPage;






    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();   //ugasiti za LinksTest
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));

        excelReader = new ExcelReader("C:\\Users\\Jovana\\IdeaProjects\\ITBootcampFinaleProject\\src\\test\\java\\TableData.xlsx");
        homeURL = excelReader.getStringData("URL", 1, 0);
    }

    public void clickElementJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
    }

    public void actionDoubleClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public void actionRightClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToTheEnd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
    }

    public void switchToNewTab(int i) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(i));
    }

    public void waitForVisibility(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isDisplayed(WebElement element) {
        boolean webelement = false;
        try {
            webelement = element.isDisplayed();
        } catch (Exception e) {

        }
        return webelement;
    }

    public void goToElementsPage () {
        scrollIntoView(homePage.getCards().get(0));
        homePage.clickOnElements();
    }

    public void clickOnTextBoxButton () {
        goToElementsPage();
        sidebarPage.clickOnButton("Text Box");
    }

    /*@AfterClass
    public void tearDown () {
        driver.manage().deleteAllCookies();
        //driver.quit();
    }*/
}
