package gmibank.stepdefinitions;

import com.github.javafaker.Faker;
import gmibank.pages.MainPage;
import gmibank.pages.PasswordPage;
import gmibank.pages.RegistrationPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import static org.junit.Assert.*;

public class US002_RegistrationStepDefs {

    MainPage mainPage = new MainPage();
    RegistrationPage registrationPage = new RegistrationPage();
    PasswordPage passwordPage = new PasswordPage();
    Faker faker = new Faker();

    @Given("User on the registration page")
    public void user_on_the_registration_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        mainPage.btnAccountMenu.click();
        mainPage.btnRegisterMain.click();
        String expectedURL = "https://gmibank-qa-environment.com/account/register";
        assertEquals(expectedURL, Driver.getDriver().getCurrentUrl());
    }


    @When("User fills in the blanks")
    public void userFillsInTheBlanks() {
        registrationPage.btnRegister.click();
        registrationPage.whichBoxIsMissing();
    }

    @Then("User doesn't should see any error message")
    public void userDoesnTShouldSeeAnyErrorMessage() {
    }

    @When("User clicks on Register button without filling blanks")
    public void userClicksOnRegisterButtonWithoutFillingBlanks() {
        registrationPage.btnRegister.click();
        registrationPage.whichBoxIsMissing();

    }

    @Then("User should see all error message")
    public void userShouldSeeAllErrorMessage() {
        System.out.println(registrationPage.feedbacks.size());
        assertTrue(registrationPage.feedbacks.size() == 9);
    }

    @When("User fill in the blanks with valid credentials")
    public void userFillInTheBlanksWithValidCredentials() {
        String ssn = faker.idNumber().ssnValid().replace(".", "-");
        String firstName = faker.name().firstName().replaceAll("'", "");
        String lastName = faker.name().lastName().replaceAll("'", "");
        String mobileNumber = faker.phoneNumber().cellPhone()
                .replace(".", "-")
                .replace("(", "")
                .replace(")", "")
                .replace(" ", "-");
        System.out.println(mobileNumber);
        String username = firstName.toLowerCase() + lastName.toLowerCase() + faker.number().digits(2);
        String password = faker.internet().password(8, 12, true, true);
        registrationPage.inputSSN.sendKeys(ssn);
        registrationPage.inputFirstname.sendKeys(firstName);
        registrationPage.inputLastname.sendKeys(lastName);
        registrationPage.inputAddress.sendKeys(faker.address().fullAddress());
        registrationPage.inputMobilePhone.sendKeys(mobileNumber);
        registrationPage.inputUsername.sendKeys(username);
        registrationPage.inputEmail.sendKeys(username + "@onlinemail.com");
        registrationPage.inputFirstPass.sendKeys(password);
        registrationPage.inputSecondPass.sendKeys(password);

        String customerInfo = ssn + ", " + firstName + ", " + lastName + ", " + mobileNumber + ", " + username + ", " + password;

        registrationPage.customerInfoToTxt(customerInfo);
        registrationPage.btnRegister.click();
    }

    @Then("User should not see any feedback error")
    public void userShouldNotSeeAnyFeedbackError() {
        assertTrue(registrationPage.feedbacks.size() == 0);
    }

    @When("User fill in the Mobile Phone Number textbox with {string}")
    public void userFillInTheMobilePhoneNumberTextboxWith(String phone_number) {
        registrationPage.inputMobilePhone.sendKeys(phone_number + Keys.TAB);
        Driver.wait(4);
    }

    @Then("User should see the Mobile Phone Number error feedback message")
    public void userShouldSeeTheMobilePhoneNumberErrorFeedbackMessage() {
        assertTrue(registrationPage.mobilePhoneErrorMsg.isDisplayed());
    }

    @When("User fill in the E-Mail textbox with {string}")
    public void userFillInTheEMailTextboxWith(String invalid_mail) {
        registrationPage.inputEmail.sendKeys(invalid_mail + Keys.TAB);
        Driver.wait(4);
    }

    @Then("User should see the E-Mail error feedback message")
    public void userShouldSeeTheEMailErrorFeedbackMessage() {
        assertTrue(registrationPage.emailErrorMsg.isDisplayed());
    }

    @When("User fill in the SSN textbox with {string}")
    public void userFillInTheSSNTextboxWith(String invalid_ssn) {
        registrationPage.inputSSN.sendKeys(invalid_ssn + Keys.TAB);
    }

    @Then("User should see the SSN error feedback message")
    public void userShouldSeeTheSSNErrorFeedbackMessage() {
        assertTrue(registrationPage.ssnErrorMsg.isDisplayed());
    }


    @Given("User logs in the system as {string}")
    public void user_logs_in_the_system_as(String user_type) {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        mainPage.btnAccountMenu.click();
        mainPage.btnSignInMain.click();

        switch(user_type) {
            case "TestAdmin":
                mainPage.inputUsername.sendKeys("TestAdmin47");
                mainPage.inputPassword.sendKeys("Testadmin47,");
                break;
            case "TestCustomer":
                mainPage.inputUsername.sendKeys("TestCustomer47");
                mainPage.inputPassword.sendKeys("Testcustomer47,");
                break;
            case "TestManager":
                mainPage.inputUsername.sendKeys("TestManager47");
                mainPage.inputPassword.sendKeys("Testmanager47,");
                break;
            case "TestEmployee":
                mainPage.inputUsername.sendKeys("TestEmployee47");
                mainPage.inputPassword.sendKeys("Testemployee47,");
                break;
            default:
                System.out.println("Select one of TestAdmin, TestCustomer, TestManager, TestEmployee");
        }

        mainPage.btnSignInMain.click();

    }

    @When("User navigate to Password page")
    public void user_navigate_to_password_page() {
        mainPage.btnAccountMenu.click();
        mainPage.btnPassword.click();
    }

    @And("User write {string} as a current password")
    public void userWriteAsACurrentPassword(String current_pass) {
        passwordPage.inputCurrentPassword.sendKeys(current_pass);
    }

    @And("User write {string} as a new password")
    public void userWriteAsANewPassword(String new_pass) {
        passwordPage.inputNewPassword.sendKeys(new_pass);
        passwordPage.inputConfirmPassword.sendKeys(new_pass);
        passwordPage.btnSavePassword.click();
        Driver.wait(3);
    }

    @Then("User should not get {string}")
    public void user_should_not_get(String string) {
        assertFalse(passwordPage.passChangedAlert.isDisplayed());
    }

}