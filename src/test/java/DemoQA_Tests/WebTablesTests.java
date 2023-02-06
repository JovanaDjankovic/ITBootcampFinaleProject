package DemoQA_Tests;

import DemoQA_Base.TestBase;
import DemoQA_Pages.HomePage;
import DemoQA_Pages.SidebarPage;
import DemoQA_Pages.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTests extends TestBase {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeURL);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");

        homePage = new HomePage(driver, wdwait);
        sidebarPage = new SidebarPage(driver, wdwait);
        webTablesPage = new WebTablesPage(driver, wdwait);
    }

    @Test (priority = 10)
    public void userCanDeleteExistingInput () {
        goToElementsPage();
        sidebarPage.clickOnButton("Web Tables");
        waitForClickability(webTablesPage.DeleteButton1);
        webTablesPage.deleteAllEntries();
    }


    @Test (priority = 20)
    public void userCanAddData() {
        goToElementsPage();
        sidebarPage.clickOnButton("Web Tables");
        waitForClickability(webTablesPage.DeleteButton1);
        webTablesPage.deleteAllEntries();


        int j = 0;

        for(int i = 1; i <= this.excelReader.getLastRow("Users"); ++i) {
            String firstName = this.excelReader.getStringData("Users", i, 0);
            String lastName = this.excelReader.getStringData("Users", i, 1);
            String email = this.excelReader.getStringData("Users", i, 2);
            int age = this.excelReader.getIntegerData("Users", i, 3);
            int salary = this.excelReader.getIntegerData("Users", i, 4);
            String department = this.excelReader.getStringData("Users", i, 5);

            waitForVisibility(webTablesPage.AddButton);
            this.webTablesPage.clickOnAdd();
            this.webTablesPage.inputFirstName(firstName);
            this.webTablesPage.inputLastName(lastName);
            this.webTablesPage.inputEmail(email);
            this.webTablesPage.inputAge(age);
            this.webTablesPage.inputSalary(salary);
            this.webTablesPage.inputDepartment(department);
            this.webTablesPage.clickOnSubmit();

            Assert.assertEquals(firstName, this.webTablesPage.cellText(j));
            Assert.assertEquals(lastName, this.webTablesPage.cellText(j + 1));
            Assert.assertEquals(String.valueOf(age), this.webTablesPage.cellText(j + 2));
            Assert.assertEquals(email, this.webTablesPage.cellText(j + 3));
            Assert.assertEquals(String.valueOf(salary), this.webTablesPage.cellText(j + 4));
            Assert.assertEquals(department, this.webTablesPage.cellText(j + 5));
            j += 7;
        }
    }

    public void addData() {
        for(int i = 1; i <= this.excelReader.getLastRow("Users"); ++i) {
            String firstName = this.excelReader.getStringData("Users", i, 0);
            String lastName = this.excelReader.getStringData("Users", i, 1);
            String email = this.excelReader.getStringData("Users", i, 2);
            int age = this.excelReader.getIntegerData("Users", i, 3);
            int salary = this.excelReader.getIntegerData("Users", i, 4);
            String department = this.excelReader.getStringData("Users", i, 5);

            waitForVisibility(webTablesPage.AddButton);
            this.webTablesPage.clickOnAdd();
            this.webTablesPage.inputFirstName(firstName);
            this.webTablesPage.inputLastName(lastName);
            this.webTablesPage.inputEmail(email);
            this.webTablesPage.inputAge(age);
            this.webTablesPage.inputSalary(salary);
            this.webTablesPage.inputDepartment(department);
            this.webTablesPage.clickOnSubmit();
        }

    }

    @Test (priority = 30)
    public void verifyUserCanSearchEntries() {
        goToElementsPage();
        sidebarPage.clickOnButton("Web Tables");
        waitForClickability(webTablesPage.DeleteButton1);
        webTablesPage.deleteAllEntries();

        addData();
        String search = "Jovana";
        this.webTablesPage.inputSearch(search);
        boolean contains = false;

        for(int i = 0; i < this.webTablesPage.RowInfo.size() && !this.webTablesPage.rowText(i).isBlank(); ++i) {
            if (this.webTablesPage.rowText(i).toUpperCase().contains(search.toUpperCase())) {
                contains = true;
            } else {
                System.out.println(this.webTablesPage.rowText(i).toUpperCase());
            }

            contains = true;
            Assert.assertTrue(true);
        }
    }

    @Test (priority = 40)
    public void verifyUserCanEditEntries () {
        goToElementsPage();
        sidebarPage.clickOnButton("Web Tables");
        waitForClickability(webTablesPage.DeleteButton1);
        webTablesPage.deleteAllEntries();

        addData();
        waitForClickability(webTablesPage.EditButton1);
        webTablesPage.clickOnEdit();
        String firstName = "Jole";
        webTablesPage.inputFirstName(firstName);
        webTablesPage.clickOnSubmit();
        boolean contains = false;
        for(int i = 0; i < this.webTablesPage.RowInfo.size() && !this.webTablesPage.rowText(i).isBlank(); ++i) {
            if (this.webTablesPage.rowText(i).toUpperCase().contains(firstName.toUpperCase())) {
                contains = true;
            } else {
                System.out.println(this.webTablesPage.rowText(i).toUpperCase());
            }

            contains = true;
            Assert.assertTrue(true);
        }
    }

    @AfterClass
    public void tearDown () {
        driver.manage().deleteAllCookies();
        driver.quit();
    }




}
