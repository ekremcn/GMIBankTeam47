package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public SignInPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameTextBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[text()='My Operations']")
    public WebElement loginConfirm;

    @FindBy(xpath = "//li[@id='account-menu'] ")
    public WebElement employeeDD;

    @FindBy(xpath = "//*[text()='User Info']")
    public WebElement UserInfo;

    @FindBy(xpath = "//a[@href='/account/reset/request']")
    public WebElement forgetPassword;

    @FindBy(xpath = "//a[@href='/account/register']")
    public WebElement registerNewAccount;

    @FindBy(xpath = "//div[@class='alert alert-danger fade show']")
    public WebElement signInFail;

}
