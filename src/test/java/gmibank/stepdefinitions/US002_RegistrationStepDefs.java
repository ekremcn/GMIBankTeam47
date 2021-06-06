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
        mainPage.registerBtn.click();
        String expectedURL = "https://gmibank-qa-environment.com/account/register";
        assertEquals(expectedURL,Driver.getDriver().getCurrentUrl());
    }


    @When("User fills in the blanks")
    public void userFillsInTheBlanks() {
        registrationPage.inputSSN.sendKeys("");
    }

    @Then("User doesn't should see any error message")
    public void userDoesnTShouldSeeAnyErrorMessage() {
    }
}
