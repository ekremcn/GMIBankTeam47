package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

public MainPage(){  PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(id = "account-menu")
    public WebElement btnAccountMenu;

    @FindBy(xpath = "//*[.='Register']")
    public WebElement btnRegisterMain;

    @FindBy(css="#login-item")
    public WebElement btnSigninMain;

    @FindBy(xpath= "//button[contains(@class,'btn-primary')]")
    public WebElement btnSignin;

    @FindBy(css="#username")
    public WebElement inputUsername;

    @FindBy(css="#password")
    public WebElement inputPassword;

    @FindBy(xpath="//*[contains(@class,'fa-lock')]")
    public WebElement btnPassword;

}
