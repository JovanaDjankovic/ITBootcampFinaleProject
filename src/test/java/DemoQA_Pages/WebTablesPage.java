package DemoQA_Pages;

import DemoQA_Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebTablesPage extends TestBase {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public WebTablesPage (WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(this.driver, this);
    }

    public @FindBy( id = "addNewRecordButton")
    WebElement AddButton;

    public @FindBy( id = "searchBox")
    WebElement SearchBox;

    public @FindBy( id = "edit-record-1")
    WebElement EditButton1;

    public @FindBy( id = "delete-record-1")
    WebElement DeleteButton1;

    public @FindBy( id = "delete-record-2")
    WebElement DeleteButton2;

    public @FindBy( id = "delete-record-3")
    WebElement DeleteButton3;

    public @FindBy (className = "action-buttons")
    List<WebElement> ActionButton;

    public @FindBy( id = "firstName")
    WebElement FirstName;

    public @FindBy( id = "lastName")
    WebElement LastName;

    public @FindBy( id = "userEmail")
    WebElement Email;

    public @FindBy( id = "age")
    WebElement Age;

    public @FindBy( id = "salary")
    WebElement Salary;

    public @FindBy( id = "department")
    WebElement Department;

    public @FindBy( id = "submit")
    WebElement SubmitButton;

    public @FindBy( className = "rt-td")
    List<WebElement> CellInfo;

    public @FindBy( className = "rt-tr-group")
    List<WebElement> RowInfo;

    //---------------------


    public String cellText(int i) {
        return ((WebElement) this.CellInfo.get(i)).getText();
    }


    public void deleteAllEntries() {
        DeleteButton1.click();
        DeleteButton2.click();
        DeleteButton3.click();

        }

    public void clickOnAdd() {
        this.AddButton.click();
    }

    public void clickOnEdit() {
        EditButton1.click();
    }

    public void inputFirstName(String firstname) {
        this.FirstName.clear();
        this.FirstName.sendKeys(firstname);
    }

    public void inputLastName(String lastname) {
        this.LastName.clear();
        this.LastName.sendKeys(lastname);
    }

    public void inputEmail(String email) {
        this.Email.clear();
        this.Email.sendKeys(email);
    }

    public void inputAge(int age) {
        this.Age.clear();
        this.Age.sendKeys(new CharSequence[]{String.valueOf(age)});
    }

    public void inputSalary(int salary) {
        this.Salary.clear();
        this.Salary.sendKeys(new CharSequence[]{String.valueOf(salary)});
    }

    public void inputDepartment(String department) {
        this.Department.clear();
        this.Department.sendKeys(department);
    }

    public void clickOnSubmit() {
        this.SubmitButton.click();
    }


    public String rowText(int i) {
        return ((WebElement)this.RowInfo.get(i)).getText();
    }

    public void inputSearch(String input) {
        this.SearchBox.clear();
        this.SearchBox.sendKeys(input);
    }








}
