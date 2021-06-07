package gmibank.stepdefinitions;

import gmibank.pages.MainPage;
import gmibank.pages.RegistrationPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class US002_RegistrationStepDefs {

    MainPage mainPage = new MainPage();
    RegistrationPage registrationPage = new RegistrationPage();

    @Given("User on the registration page")
    public void user_on_the_registration_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        mainPage.accountMenu.click();
        mainPage.btnRegisterMain.click();
        String expectedURL = "https://gmibank-qa-environment.com/account/register";
        assertEquals(expectedURL,Driver.getDriver().getCurrentUrl());
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

    }

    @Then("User should see all error message")
    public void userShouldSeeAllErrorMessage() {
        System.out.println(registrationPage.feedbacks.size());
        assertTrue(registrationPage.feedbacks.size()==9);
    }
}
