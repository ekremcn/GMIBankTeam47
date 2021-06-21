package gmibank.stepdefinitions;

import gmibank.pages.RegistrationPage;
import gmibank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class US003_stepDefinitions {
    RegistrationPage registrationPage= new RegistrationPage();


    @When("User provides {string} with six-character")
    public void user_provides_with_six_character(String sixcharacter) {
        registrationPage.inputFirstPass.sendKeys(sixcharacter);
        Driver.wait(3);
    }

    @When("The level chart shows only one red bar")
    public void the_level_chart_shows_only_one_red_bar() {
        Assert.assertEquals(registrationPage.red.size(),1);
        Assert.assertEquals(registrationPage.grey.size(),4);

    }

    @When("User enters {string}")
    public void user_enters(String character) {
     registrationPage.inputFirstPass.sendKeys(character);
     Driver.wait(2);
    }

    @Then("The level chart changes into two bars")
    public void the_level_chart_changes_into_two_bars() {
    Assert.assertEquals(registrationPage.orange.size(),2);
    Assert.assertEquals(registrationPage.grey.size(),3);
    }

    @Then("the level chart changes accordingly")
    public void the_Level_Chart_Changes_Accordingly() {
        Assert.assertEquals(registrationPage.green.size(),4);
        Assert.assertEquals(registrationPage.grey.size(),1);
    }

    @Then("the level chart shows all bars green")
    public void the_Level_Chart_Shows_AllBars_Green() {
        Assert.assertEquals(registrationPage.greendark.size(),5);


    }
}
