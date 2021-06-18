package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {

    public SignIn() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "username")
    public WebElement usernameTextBox;

    @FindBy (id= "password")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;


}
