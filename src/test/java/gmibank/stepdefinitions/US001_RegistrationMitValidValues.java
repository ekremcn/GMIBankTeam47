package gmibank.stepdefinitions;

import gmibank.pages.MainPage;
import gmibank.pages.RegistrationPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class US001_RegistrationMitValidValues {

    MainPage mainPage = new MainPage();
    RegistrationPage registrationPage = new RegistrationPage();

    @Given("User goes to the Homepage")
    public void userGoesToTheHomepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("homepage_url"));
    }

    @And("User navigates to registration page")
    public void userNavigatesToRegistrationPage() {
        mainPage.accountMenu.click();
        mainPage.btnRegisterMain.click();
        String expectedURL = "https://gmibank-qa-environment.com/account/register";
        assertEquals(expectedURL,Driver.getDriver().getCurrentUrl());
    }

    @When("User clicks on SSN textbox")
    public void userClicksOnSSNTextbox() {

        registrationPage.inputSSN.click();
    }


}
