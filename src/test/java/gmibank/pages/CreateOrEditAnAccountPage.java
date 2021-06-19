package gmibank.pages;

import gmibank.utilities.Driver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrEditAnAccountPage {
    public CreateOrEditAnAccountPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "tp-account-description")
    public WebElement descriptionTextBox;

    @FindBy(id = "tp-account-balance")
    public WebElement balanceTextBox;

    @FindBy(id = "tp-account-accountType")
    public WebElement accountTypeDDMenu;

    @FindBy(id = "tp-account-accountStatusType")
    public WebElement accountStatusTypeDDMenu;

    @FindBy(id = "createDateLabel")
    public WebElement createDateLabel;

    @FindBy(id = "closedDateLabel")
    public WebElement closedDateLabel;

    @FindBy(id = "tp-account-employee")
    public WebElement employeeDDMenu;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(id = "cancel-save")
    public WebElement cancelButton;



}
