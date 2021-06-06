package gmibank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends MainPage {

    @FindBy(id="ssn")
    public WebElement inputSSN;

    @FindBy(id="firstname")
    public WebElement inputFirstname;

    @FindBy(id="lastname")
    public WebElement inputLastname;

    @FindBy(id="address")
    public WebElement inputAddress;

    @FindBy(id="mobilephone")
    public WebElement inputMobilePhone;

    @FindBy(id="username")
    public WebElement inputUsername;

    @FindBy(id="email")
    public WebElement inputEmail;

    @FindBy(id="firstPassword")
    public WebElement inputFirstPass;

    @FindBy(id="secondPassword")
    public WebElement inputSecondPass;

    @FindBy(id="register-submit")
    public WebElement btnRegister;

}
