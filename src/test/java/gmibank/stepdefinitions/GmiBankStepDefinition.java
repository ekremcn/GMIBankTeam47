package gmibank.stepdefinitions;

import gmibank.utilities.Driver;
import io.cucumber.java.en.Given;

public class GmiBankStepDefinition {

    @Given("User go to {string}")
    public void user_go_to(String homepage) {

        Driver.getDriver().get(homepage);


    }
}
