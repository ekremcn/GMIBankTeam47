package gmibank.stepdefinitions;

import gmibank.pages.*;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import io.cucumber.java.en.*;


public class Demo_47_StepDefinition {
    MainPage mainPage=new MainPage();
    RegistrationPage registrationPage=new RegistrationPage();
    SignInPage signInPage=new SignInPage();
    AdminMainPage adminMainPage=new AdminMainPage();
    UserMainPage userMainPage=new UserMainPage();
    EmployeeMainPage employeeMainPage=new EmployeeMainPage();
    CreateOrEditACustomerPage createOrEditACustomerPage=new CreateOrEditACustomerPage();




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
        mainPage.icon.click();
        Driver.wait(2);
        mainPage.btnSignInMain.click();
    }

    @And("Admin provide valid {string} and {string}")
    public void adminProvideValidAnd(String arg0, String arg1) {
        signInPage.usernameTextBox.sendKeys("admin_Name");
        Driver.wait(2);
        signInPage.passwordTextBox.sendKeys("admin_Password");
        Driver.wait(2);
        signInPage.signInButton.click();

    }

    @Then("Admin activates the account of the user")
    public void adminActivatesTheAccountOfTheUser() {
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
    public void employeeLoginToAccountWithValidAnd(String arg0, String arg1) {
       mainPage.icon.click();
       Driver.wait(2);
       mainPage.btnSignInMain.click();
       Driver.wait(2);
       signInPage.usernameTextBox.sendKeys("employeeusername");
       signInPage.passwordTextBox.sendKeys("employeepassword");
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


    }

    @Then("Employee sign out from account")
    public void employeeSignOutFromAccount() {
    }

    @Then("Demo customer sign in the own account")
    public void demoCustomerSignInTheOwnAccount() {
    }

    @And("Demo customer navigates to My Operations")
    public void demoCustomerNavigatesToMyOperations() {
    }

    @Then("Demo customer makes money transfer")
    public void demoCustomerMakesMoneyTransfer() {
    }

    @And("Demo customer verifies their money transfer")
    public void demoCustomerVerifiesTheirMoneyTransfer() {
    }
}

