package gmibank.stepdefinitions;

import gmibank.pages.MainPage;
import gmibank.pages.SignInPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class US004_LoginPageStepDefinition {

    MainPage mainPage = new MainPage();
    SignInPage signInPage = new SignInPage();


    @Given("User access to main page")
    public void userAccessToMainPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_qa_url"));
    }

    @And("User click to icon")
    public void userClickToIcon() {
        mainPage.icon.click();
        Driver.wait(2);
    }

    @And("User click to Sign in button")
    public void userClickToSignInButton() {
        mainPage.btnSigninMain.click();
        Driver.wait(2);
    }

    @Then("User provides a valid username {string}")
    public void userProvidesAValidUsername(String username) {
        signInPage.usernameTextBox.sendKeys(username);
        Driver.wait(3);
    }

    @And("User provides a valid  password {string}")
    public void userProvidesAValidPassword(String password) {
        signInPage.passwordTextBox.sendKeys(password);
        Driver.wait(3);
    }

    @And("User click on sign in button")
    public void userClickOnSignInButton() {
        signInPage.signInButton.click();
        Driver.wait(2);
    }

    @And("User verifies that user logined successfully")
    public void userVerifiesThatUserLoginedSuccessfully() {
        Assert.assertEquals("My Operations", Driver.getDriver().findElement(By.xpath("//*[text()='My Operations']")).getText());


    }

    @And("User click on user icon")
    public void userClickOnUserIcon() {
        Driver.getDriver().findElement(By.xpath("//*[@id='account-menu']")).click();
        Driver.wait(1);

    }

    @And("User click on sign out button")
    public void userClickOnSignOutButton() {
        Driver.getDriver().findElement(By.xpath("//*[text()='Sign out']")).click();
    }

    @When("User provides valid username {string} and password {string}")
    public void userProvidesValidUsernameAndPassword(String username, String password) {
        signInPage.usernameTextBox.sendKeys(username);
        signInPage.passwordTextBox.sendKeys(password);
        Driver.wait(2);
    }

    @And("User click on cancel button")
    public void userClickOnCancelButton() {
        signInPage.cancelButton.click();
        Driver.wait(2);
    }

    @And("User should be back to Main page")
    public void userShouldBeBackToMainPage() {
        Assert.assertTrue(mainPage.icon.isDisplayed());

    }

}

