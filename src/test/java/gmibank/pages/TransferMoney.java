package gmibank.pages;


import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TransferMoney {

    public TransferMoney() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "fromAccountId")
    public WebElement fromDropDown;

    @FindBy(id = "toAccountId")
    public WebElement toDropDown;

    @FindBy(id= "balance")
    public WebElement balanceTextBox;

    @FindBy(id= "balancecent")
    public WebElement centTextBox;

    @FindBy(id= "description")
    public WebElement descriptionTextBox;

    @FindBy(id= "make-transfer")
    public WebElement makeTransferButton;


}
