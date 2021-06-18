package gmibank.stepdefinitions;

import gmibank.pages.*;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

import java.security.Signature;

public class US016_TransferMoney {
    MainPage home = new MainPage();
    SignIn signIn = new SignIn();
    CustomerPage customer = new CustomerPage();
    MyAccountsPage accounts = new MyAccountsPage();
    TransferMoney transfer = new TransferMoney();

    double firstAccBalance;
    double secondAccBalance;
    String balance;

    @When("User navigates to sign in page")
    public void userNavigatesToSignInPage() {
        home.accountMenu.click();
        Driver.wait(1);
        home.signInButton.click();
        Driver.wait(1);
    }
    @And("User provide a valid username {string}")
    public void userProvideAValidUsername(String username) {
        signIn.usernameTextBox.sendKeys(ConfigurationReader.getProperty(username));
        Driver.wait(1);
    }
    @And("User provide a valid password {string}")
    public void userProvideAValidPassword(String password) {
        signIn.passwordTextBox.sendKeys(ConfigurationReader.getProperty(password));
        Driver.wait(1);
    }
    @And("User click on the sign in button")
    public void userClickOnTheSignInButton() {
        signIn.signInButton.click();
        Driver.wait(1);
    }
    @Then("User navigates My Accounts Page")
    public void userNavigatesMyAccountsPage() {
        customer.myOperationsSection.click();
        Driver.wait(1);
        customer.myAccountsButton.click();
        Driver.wait(1);
    }
    @And("User gets the info about Users accounts balances")
    public void userGetsTheInfoAboutUsersAccountsBalance() {
        int size = accounts.denemeList.size();
        System.out.println("=================================" + size);
        firstAccBalance = Double.parseDouble(accounts.accountsBalanceList.get(0).getText());
        Driver.wait(1);
        secondAccBalance = Double.parseDouble(accounts.accountsBalanceList.get(1).getText());
        Driver.wait(1);
    }
    @Then("User navigates to Transfer Money Page")
    public void userNavigatesToTransferMoneyPage() {
        customer.myOperationsSection.click();
        Driver.wait(1);
        customer.transferMoneyButton.click();
        Driver.wait(1);
    }
    @And("User does the money transfer")
    public void userDoesTheMoneyTransfer() {
        balance = "50";
        Select from = new Select(transfer.fromDropDown);
        Driver.wait(1);
        Select to = new Select(transfer.toDropDown);
        Driver.wait(1);
        from.selectByIndex(1);
        Driver.wait(1);
        to.selectByValue("3563");
        Driver.wait(1);
        transfer.balanceTextBox.sendKeys(balance);
        Driver.wait(1);
        transfer.centTextBox.clear();
        transfer.centTextBox.sendKeys("50");
        transfer.descriptionTextBox.sendKeys("Kurs Ucreti");
        Driver.wait(1);
        transfer.makeTransferButton.click();
        Driver.wait(1);
    }
    @Then("User validates that User s money transferred successfully")
    public void userValidatesThatUserSMoneyTransferredSuccessfully() {
        customer.myOperationsSection.click();
        Driver.wait(1);
        customer.myAccountsButton.click();
        Driver.wait(1);
        double firstAccBalanceAfterTransfer = Double.parseDouble(accounts.accountsBalanceList.get(0).getText()); //15.5 -> 15 ->15.0
        double secondAccBalanceAfterTransfer = Double.parseDouble(accounts.accountsBalanceList.get(1).getText());
        double balanceDouble = Double.parseDouble(balance);
        balanceDouble += 0.50;
        Assert.assertEquals(firstAccBalanceAfterTransfer, firstAccBalance - balanceDouble, "Paralar uyusmuyor!");
        Assert.assertEquals(secondAccBalanceAfterTransfer, secondAccBalance + balanceDouble, "Paralar uyusmuyor!");
    }
}
