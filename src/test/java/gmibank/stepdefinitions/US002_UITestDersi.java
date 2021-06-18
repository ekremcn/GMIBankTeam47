package gmibank.stepdefinitions;

import gmibank.pages.MainPage;
import gmibank.pages.RegistrationPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class US002_UITestDersi {

        MainPage homePage = new MainPage();
        RegistrationPage registrationPage = new RegistrationPage();
        Actions actions = new Actions(Driver.getDriver());
        SoftAssert softAssert = new SoftAssert();


        @Given("User on the home page {string}")
        public void userOnTheHomePageD(String url) {
            Driver.getDriver().get(ConfigurationReader.getProperty(url)); //homepage_url
        }

        @And("User navigates to registeration pageD")
        public void userNavigatesToRegisterPageD() {
            homePage.accountMenu.click();
            Driver.wait(2);
            homePage.btnRegisterMain.click();
            Driver.wait(2);
        }

        @Then("User clicks on SSN textboxD")
        public void userClicksOnSSNTextboxD() {
            registrationPage.inputSSN.click();
        }

        @Then("User doesnt provide ssn and click tabD")
        public void userDoesntProvideAndClickTabD() {
            // registrationPage.ssnTextBox.sendKeys(Keys.TAB);
            actions.sendKeys(Keys.TAB).perform();
        }

        @And("User should see the SSN error message {string}D")
        public void userShouldSeeTheSSNErrorMessageD(String errorMessage) {
            //alternatif validation
            softAssert.assertTrue(registrationPage.ssnRequiredErrorMessage.isDisplayed());
            softAssert.assertEquals(registrationPage.ssnRequiredErrorMessage.getText(), ConfigurationReader.getProperty(errorMessage));
            softAssert.assertAll();
        /*
        Alternatif olmayan elementin validation islemleri
        try{
            Assert.assertFalse(Driver.getDriver().findElement(By.xpath("//div[@class='invalid-feedback']")).isDisplayed());
        }catch (Exception e){
            Assert.assertTrue(true);
        }*/

        }

        @Then("User clicks on Mobile Phone Number textboxD")
        public void userClicksOnMobilePhoneNumberTextboxD() {

            registrationPage.inputMobilePhone.click();
        }


        @Then("User provide invalid Mobile Phone Number {string} and click tabD")
        public void userProvideInvalidMobilePhoneNumberAndClickTabD(String invalidPhoneNumbers) {
            registrationPage.inputMobilePhone.sendKeys(ConfigurationReader.getProperty(invalidPhoneNumbers) + Keys.TAB);
        }

        @And("User should see the Mobile Phone Number error message {string}D")
        public void userShouldSeeTheMobilePhoneNumberErrorMessageD(String errorMessage) {
            Assert.assertEquals(ConfigurationReader.getProperty(errorMessage), registrationPage.mobilePhoneNumberErrorMessage.getText());
        }

}
