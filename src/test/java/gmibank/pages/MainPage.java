package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

public MainPage(){  PageFactory.initElements(Driver.getDriver(),this); }





















    @FindBy(id = "account-menu")
    public WebElement btnAccountMenu;

    @FindBy(xpath = "//a[@aria-haspopup='true']")
    public WebElement icon;

    @FindBy(xpath = "(//*[text='Sign in'])[1]")
    public WebElement btnSignInMain;

    @FindBy(xpath = "(//*[text='Register']")
    public WebElement btnRegisterMain;

// <<<<<<< Harun47
//     @FindBy(xpath ="//*[text() ='Register']")
//     public WebElement register;

//     @FindBy(xpath = "(//*[text()='Sign in'])[1]")
//     public WebElement signInButton;

//     @FindBy(id = "account-menu")
//     public WebElement iconMenu;
// =======
    @FindBy(css="#login-item")
    public WebElement btnSigninMain;
// >>>>>>> main

    @FindBy(xpath= "//button[contains(@class,'btn-primary')]")
    public WebElement btnSignin;

// <<<<<<< Harun47
//     @FindBy(xpath = "//*[text()='Register']")
//     public WebElement registerButton;
// =======
    @FindBy(css="#username")
    public WebElement inputUsername;
// >>>>>>> main

    @FindBy(css="#password")
    public WebElement inputPassword;

    @FindBy(xpath="//*[contains(@class,'fa-lock')]")
    public WebElement btnPassword;

}
