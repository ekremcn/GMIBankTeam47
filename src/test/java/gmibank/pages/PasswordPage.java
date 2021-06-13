package gmibank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPage extends MainPage{

    @FindBy(css="#currentPassword")
    public WebElement inputCurrentPassword;

    @FindBy(css="#newPassword")
    public WebElement inputNewPassword;

    @FindBy(css="#confirmPassword")
    public WebElement inputConfirmPassword;

    @FindBy(xpath ="//button[contains(@class,'btn-success')]")
    public WebElement btnSavePassword;

    @FindBy(xpath="//*[text()='Password changed!']")
    public WebElement passChangedAlert;

}
