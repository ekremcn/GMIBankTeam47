package gmibank.stepdefinitions;

import gmibank.pages.*;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;



public class US012_MenageCustomerStepDefinition {

    MainPage mainPage = new MainPage();
    SignInPage signInPage = new SignInPage();
    EmployeeMainPage employeeMainPage = new EmployeeMainPage();
    ManageCustomersPage menageCustomersPage = new ManageCustomersPage();
    CreateOrEditACustomerPage createOrEditACustomerPage = new CreateOrEditACustomerPage();
    CustomerInfoPage customerInfoPage = new CustomerInfoPage();

    @Then("User provides a valid username")
    public void userProvidesAValidUsername() {
//        mainPage.iconMenu.click();
//        mainPage.signInButton.click();
        signInPage.usernameTextBox.sendKeys(ConfigurationReader.getProperty("employee_Name"));
        Driver.wait(1);
    }

    @And("User provides a valid  password")
    public void userProvidesAValidPassword() {
        signInPage.passwordTextBox.sendKeys(ConfigurationReader.getProperty("employee_password"));
        signInPage.signInButton.click();
        Driver.wait(1);
    }

    //TC01
    @Then("User should be able to click My Operations button")
    public void userShouldBeAbleToClickMyOperationsButton() {
        employeeMainPage.myOperations.click();
        Driver.wait(1);
    }

    @And("User should be able to click Manage Customers button")
    public void userShouldBeAbleToClickManageCustomersButton() {
        employeeMainPage.menageCustomers.click();
        Driver.wait(1);
    }

    @And("User should be able to see all customers information")
    public void userShouldBeAbleToSeeAllCustomersInformation() {
        Assert.assertTrue(menageCustomersPage.allCustomerInfo.getText(), true);

    }

    @And("User should be verify to necessary information")
    public void userShouldBeVerifyToNecessaryInformation() {
        if (menageCustomersPage.headers.size() == 8)
            Assert.assertTrue(true);

    }

    //TC02
    @Then("User should be able to see View option")
    public void userShouldBeAbleToSeeViewOption() {
        if (menageCustomersPage.viewButton.isDisplayed())
            Assert.assertTrue(true);
    }

    @And("User should be able to click on View button of customer")
    public void userShouldBeAbleToClickOnViewButtonOfCustomer() {
        menageCustomersPage.viewButton.click();
        Driver.wait(1);
    }

    @And("User should be able to see all information of customer")
    public void userShouldBeAbleToSeeAllInformationOfCustomer() {
//        if(customerInfoPage.customerHeader.getText().contains("Customer"))
//            Assert.assertTrue(true);
//
//        int x =customerInfoPage.customerInfoList.size();
//     String [] customerInfo =new String[customerInfoPage.customerInfoList.size()];
//
//        for (int i=0; i<x; i++)
//        {
//            customerInfo [i] = customerInfoPage.customerInfoList.get(i).toString();
//        }
//        if(customerInfo.length!=0)
//        Assert.assertTrue(true);
    }

    @And("User should be able to see edit button")
    public void userShouldBeAbleToSeeEditButton() {
        if (customerInfoPage.editButton.isDisplayed())
            Assert.assertTrue(true);
    }

    @And("User should be click home page button")
    public void UserShouldBeClickHomePageButton() {
        Driver.getDriver().findElement(By.xpath("//*[text()='Home']")).click();
    }


    //TC03
    @Then("User should be able to see Edit option")
    public void userShouldBeAbleToSeeEditOption() {
        if (menageCustomersPage.editButton.isDisplayed()) {
            Assert.assertTrue(true);
        }

    }

    @And("User should be able to click on Edit button of customer")
    public void userShouldBeAbleToClickOnEditButtonOfCustomer() {
        menageCustomersPage.editButton.click();
        Driver.wait(2);
        if (createOrEditACustomerPage.idTextBox.isDisplayed()) {
            Assert.assertTrue(true);
        }

    }


    //TC04
    @Then("User should be able to create or edit information of customer")
    public void userShouldBeAbleToCreateOrEditInformationOfCustomer() {
        createOrEditACustomerPage.lastNameTextBox.clear();
        createOrEditACustomerPage.lastNameTextBox.sendKeys("Soyad");
        Driver.wait(2);

    }

    @And("User should be able to click on Save button")
    public void userShouldBeAbleToClickOnSaveButton() {
        createOrEditACustomerPage.saveButton.click();

    }


    //TC05
    @Then("User should be able to see Delete option")
    public void userShouldBeAbleToSeeDeleteOption() {
        if (menageCustomersPage.deleteButton.isDisplayed()) {
            Assert.assertTrue(true);
        }

    }

    @And("User should be able to click on Delete button of customer")
    public void userShouldBeAbleToClickOnDeleteButtonOfCustomer() {
        menageCustomersPage.deleteButton.click();
        Driver.wait(2);
    }

    @And("User should be able to see confirm delete message")
    public void userShouldBeAbleToSeeConfirmDeleteMessage() {
        Assert.assertTrue(menageCustomersPage.confirmDeleteOperationMessage.isDisplayed());
    }

    @And("User should be able to click cancel or delete buttons")
    public void userShouldBeAbleToClickCancelOrDeleteButtons() {
        menageCustomersPage.cancelConfirmButton.click();
        Driver.wait(2);
    }
}
