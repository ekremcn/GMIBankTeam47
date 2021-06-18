package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
    public CustomerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id ="entity-menu")
    public WebElement myOperationsSection;

    @FindBy(xpath = "//*[text()='My Accounts']")
    public WebElement myAccountsButton;

    @FindBy(xpath = "//*[text()='Transfer Money']")
    public WebElement transferMoneyButton;



}
