package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CustomerMainPage {
    public CustomerMainPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//*[text() ='My Operations']" )
    public WebElement myOperations;

    @FindBy(xpath ="//*[text() ='My Accounts']" )
    public WebElement myAccounts;

    @FindBy(xpath ="//*[text() ='Transfer Money']" )
    public WebElement transferMoney;

    @FindBy(id ="fromAccountId" )
    public WebElement fromAccountTextBox;

    @FindBy(id ="toAccountId" )
    public WebElement toAccountTextBox;

    @FindBy(id ="balance" )
    public WebElement balance$TextBox;

    @FindBy(id ="balancecent" )
    public WebElement balanceCentTextBox;

    @FindBy(id ="description" )
    public WebElement descriptionTextBox;

    @FindBy(id ="make-transfer" )
    public WebElement makeTransferButton;




}
