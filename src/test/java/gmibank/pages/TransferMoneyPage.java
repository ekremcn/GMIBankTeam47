package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferMoneyPage {
    public TransferMoneyPage(){  PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(id ="fromAccountId" )
    public WebElement fromAccountDD;

    @FindBy(id ="toAccountId" )
    public WebElement toAccountDD;

    @FindBy(id ="balance" )
    public WebElement balance$TextBox;

    @FindBy(xpath ="//*[@id='balancecent']" )
    public WebElement centTextBox;

    @FindBy(id ="description" )
    public WebElement descriptionTextBox;

    @FindBy(id ="make-transfer" )
    public WebElement makeTransferButton;
}
