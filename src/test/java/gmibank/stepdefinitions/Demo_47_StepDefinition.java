package gmibank.stepdefinitions;

import gmibank.pages.*;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Double.*;


public class Demo_47_StepDefinition {
    MainPage mainPage = new MainPage();
    RegistrationPage registrationPage = new RegistrationPage();
    SignInPage signInPage = new SignInPage();
    AdminMainPage adminMainPage = new AdminMainPage();
    UserMainPage userMainPage = new UserMainPage();
    EmployeeMainPage employeeMainPage = new EmployeeMainPage();
    CreateOrEditACustomerPage createOrEditACustomerPage = new CreateOrEditACustomerPage();
    CreateOrEditAnAccountPage createOrEditAnAccountPage = new CreateOrEditAnAccountPage();
    CustomerMainPage customerMainPage = new CustomerMainPage();
    MyAccountsPage myAccountsPage = new MyAccountsPage();
    TransferMoneyPage transferMoneyPage = new TransferMoneyPage();
    double firstAccBalance1;
    double secondAccBalance1;
    double transfer$;
    double firstAccBalance2;
    double secondAccBalance2;


    @Given("User is on main page")
    public void userIsOnMainPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        mainPage.icon.click();
        Driver.wait(2);
        mainPage.btnRegisterMain.click();
        Driver.wait(2);
    }

    @And("User access to registration page")
    public void userNavigatesToRegistrationPage() {
        Driver.wait(2);
    }

    @And("User provides information for registration")
    public void userProvidesInformationForRegistration() {
        registrationPage.inputSSN.sendKeys(ConfigurationReader.getProperty("demo_ssn"));
        Driver.wait(2);
        registrationPage.inputFirstname.sendKeys(ConfigurationReader.getProperty("demo_firstname"));
        Driver.wait(2);
        registrationPage.inputLastname.sendKeys(ConfigurationReader.getProperty("demo_lastname"));
        Driver.wait(2);
        registrationPage.inputAddress.sendKeys(ConfigurationReader.getProperty("demo_address"));
        Driver.wait(2);
        registrationPage.inputMobilePhone.sendKeys(ConfigurationReader.getProperty("demo_mobilePhone"));
        Driver.wait(2);
        registrationPage.inputUsername.sendKeys(ConfigurationReader.getProperty("demo_username"));
        Driver.wait(2);
        registrationPage.inputEmail.sendKeys(ConfigurationReader.getProperty("demo_email"));
        Driver.wait(2);
        registrationPage.inputFirstPass.sendKeys(ConfigurationReader.getProperty("demo_pswd"));
        Driver.wait(2);
        registrationPage.inputSecondPass.sendKeys(ConfigurationReader.getProperty("demo_pswd"));
        Driver.wait(2);
        registrationPage.btnRegister.click();
        Driver.wait(2);

    }

    @Then("Admin user clicks sign in button")
    public void adminUserClicksSignInButton() {
        Driver.getDriver().findElement(By.xpath("//*[text() ='Home']")).click();
        Driver.wait(2);
        mainPage.icon.click();
        Driver.wait(2);
        mainPage.btnSignInMain.click();
    }

    @And("Admin provide valid {string} and {string}")
    public void adminProvideValidAnd(String str1, String str2) {
        signInPage.usernameTextBox.sendKeys(str1);
        Driver.wait(2);
        signInPage.passwordTextBox.sendKeys(str2);
        Driver.wait(2);
        //signInPage.usernameTextBox.sendKeys(ConfigurationReader.getProperty("admin_Name"));
        //signInPage.passwordTextBox.sendKeys(ConfigurationReader.getProperty("admin_Password"));

        signInPage.signInButton.click();

    }

    @Then("Admin activates the account of the user")
    public void adminActivatesTheAccountOfTheUser() {
        Driver.wait(2);
        adminMainPage.administration.click();
        Driver.wait(2);
        adminMainPage.userManagement.click();
        Driver.wait(2);
        adminMainPage.createDateButton.click();
        Driver.wait(2);
        adminMainPage.editButton.click();
        Driver.wait(2);
        adminMainPage.activateButton.click();
        Driver.wait(2);
        adminMainPage.saveButton.click();


    }

    @And("Admin sign out from the account")
    public void adminSignOutFromTheAccount() {
        adminMainPage.icon.click();
        Driver.wait(2);
        adminMainPage.signOutButton.click();
    }

    @Then("Employee login to account with valid {string} and {string}")
    public void employeeLoginToAccountWithValidAnd(String str1, String str2) {
        mainPage.icon.click();
        Driver.wait(2);
        mainPage.btnSignInMain.click();
        Driver.wait(2);
        signInPage.usernameTextBox.sendKeys(str1);
        signInPage.passwordTextBox.sendKeys(str2);
        //signInPage.usernameTextBox.sendKeys(ConfigurationReader.getProperty("employee_Name"));
        //signInPage.passwordTextBox.sendKeys(ConfigurationReader.getProperty("employee_password"));
        Driver.wait(2);
        signInPage.signInButton.click();

    }

    @And("Employee integrates accounts for the user")
    public void employeeIntegratesAccountsForTheUser() {
        Driver.wait(2);
        employeeMainPage.myOperations.click();
        Driver.wait(2);
        employeeMainPage.menageAccounts.click();
        Driver.wait(2);
        employeeMainPage.createANewAccountButton.click();
        Driver.wait(2);
        createOrEditAnAccountPage.descriptionTextBox.sendKeys(ConfigurationReader.getProperty("demo_firstAccount"));
        Driver.wait(2);
        createOrEditAnAccountPage.balanceTextBox.sendKeys("47000");
        Driver.wait(2);
        Driver.selectDdValue(createOrEditAnAccountPage.accountTypeDDMenu, "CHECKING");
        Driver.wait(2);
        createOrEditAnAccountPage.saveButton.click();
        Driver.wait(2);
        employeeMainPage.createANewAccountButton.click();
        Driver.wait(2);
        createOrEditAnAccountPage.descriptionTextBox.sendKeys(ConfigurationReader.getProperty("demo_secondAccount"));
        Driver.wait(2);
        createOrEditAnAccountPage.balanceTextBox.sendKeys("8000");
        Driver.wait(2);
        Driver.selectDdValue(createOrEditAnAccountPage.accountTypeDDMenu, "SAVING");
        Driver.wait(2);
        createOrEditAnAccountPage.saveButton.click();
        Driver.wait(2);

        employeeMainPage.myOperations.click();
        Driver.wait(2);
        employeeMainPage.menageCustomers.click();
        Driver.wait(2);
        Driver.getDriver().findElement(By.xpath("//*[text()='Create a new Customer']")).click();
        Driver.wait(2);
        createOrEditACustomerPage.ssnSearchTextBox.sendKeys(ConfigurationReader.getProperty("demo_ssn"));
        Driver.wait(2);
        createOrEditACustomerPage.searchButton.click();
        Driver.wait(2);
        createOrEditACustomerPage.middleInitialTextBox.sendKeys("MI");
        Driver.wait(2);
        createOrEditACustomerPage.phoneNumberTextBox.sendKeys(ConfigurationReader.getProperty("demo_phone"));
        Driver.wait(2);
        createOrEditACustomerPage.zipCodeTextBox.sendKeys("47470");
        Driver.wait(2);
        createOrEditACustomerPage.cityTextBox.sendKeys("Istanbul");
        Driver.wait(2);
        Driver.selectDdValue(createOrEditACustomerPage.countryDDTextBox, "TURKEY");
        Driver.wait(2);
        createOrEditACustomerPage.stateTextBox.sendKeys("TURKEY");
        Driver.wait(2);

       // Driver.selectDdValue(createOrEditACustomerPage.accountDDMenu, ConfigurationReader.getProperty("demo_firstAccount"));


        Actions actions = new Actions(Driver.getDriver());
        actions
                .keyDown(Keys.LEFT_CONTROL)
                .click(createOrEditACustomerPage.checking476)
                .click(createOrEditACustomerPage.saving476)
                .keyUp(Keys.LEFT_CONTROL)
                .perform();
        Driver.wait(1);
        //Driver.selectDdValue(createOrEditACustomerPage.accountDDMenu, ConfigurationReader.getProperty("demo_secondAccount"));
        //actions.keyUp(Keys.LEFT_CONTROL).perform();
        Driver.wait(1);

        createOrEditACustomerPage.zelleEnrolledCheckBox.click();
        Driver.wait(2);
        createOrEditACustomerPage.saveButton.click();


    }

    @Then("Employee sign out from account")
    public void employeeSignOutFromAccount() {
        Driver.getDriver().findElement(By.xpath("//*[text()='Home']")).click();
        Driver.wait(2);
        employeeMainPage.iconEmployeePage.click();
        Driver.wait(2);
        employeeMainPage.signOutButton.click();
    }

    @Then("Demo customer sign in the own account")
    public void demoCustomerSignInTheOwnAccount() {
        mainPage.icon.click();
        Driver.wait(2);
        mainPage.btnSignInMain.click();
        Driver.wait(2);
        signInPage.usernameTextBox.sendKeys(ConfigurationReader.getProperty("demo_username"));
        Driver.wait(2);
        signInPage.passwordTextBox.sendKeys(ConfigurationReader.getProperty("demo_pswd"));
        Driver.wait(2);
        signInPage.signInButton.click();


    }

    @And("Demo customer navigates to My Operations")
    public void demoCustomerNavigatesToMyOperations() {
        Driver.wait(2);
        customerMainPage.myOperations.click();
        Driver.wait(2);
        customerMainPage.myAccounts.click();
        Driver.wait(2);


    }

    @And("Demo customer gets the info about own accounts balance")
    public void demoCustomerGetsTheInfoAboutOwnAccountsBalance() {
        firstAccBalance1 = parseDouble(myAccountsPage.accountsBalancesList.get(0).getText());
        secondAccBalance1 = parseDouble(myAccountsPage.accountsBalancesList.get(1).getText());

    }

    @Then("Demo customer makes money transfer")
    public void demoCustomerMakesMoneyTransfer() {
        Driver.getDriver().findElement(By.xpath("//*[text()='Home']")).click();
        customerMainPage.myOperations.click();
        Driver.wait(2);
        customerMainPage.transferMoney.click();
        Driver.wait(2);
        Select fromDD = new Select(transferMoneyPage.fromAccountDD);
        Select toDD = new Select(transferMoneyPage.toAccountDD);

        fromDD.selectByIndex(1);
        Driver.wait(2);
        toDD.selectByIndex(1);
        Driver.wait(2);
        transferMoneyPage.balance$TextBox.sendKeys(ConfigurationReader.getProperty("balance$"));
        Driver.wait(2);
        transferMoneyPage.centTextBox.clear();
        Driver.wait(2);
        transferMoneyPage.centTextBox.sendKeys(ConfigurationReader.getProperty("balanceCent"));
        Driver.wait(2);
        transferMoneyPage.descriptionTextBox.sendKeys(ConfigurationReader.getProperty("descriptionTextBox"));
        Driver.wait(2);
        transferMoneyPage.makeTransferButton.click();
    }

    @And("Demo customer verifies their money transfer")
    public void demoCustomerVerifiesTheirMoneyTransfer() {
        Driver.wait(2);
        customerMainPage.myOperations.click();
        Driver.wait(2);
        customerMainPage.myAccounts.click();
        Driver.wait(2);
        double cent = 0.05;
        firstAccBalance2 = parseDouble(myAccountsPage.accountsBalancesList.get(0).getText());
        secondAccBalance2 = parseDouble(myAccountsPage.accountsBalancesList.get(1).getText());
        transfer$ = parseDouble(ConfigurationReader.getProperty("balance$")) + cent;
        Driver.wait(2);


       Assert.assertTrue((firstAccBalance2 == (firstAccBalance1 - transfer$))
                &&(secondAccBalance2 == (secondAccBalance1 + transfer$)));
            System.out.println("Transfer Successful\nApplıcation is all up and running");

    }


}

