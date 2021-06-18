package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AdminMainPage {
    public AdminMainPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//*[text() ='Administration']" )
    public WebElement administration;

    @FindBy(xpath ="//*[text() ='User management']" )
    public WebElement userManagement;

    @FindBy(xpath = "//*[text()='Created date']")
    public WebElement createDateButton;

    @FindBy(xpath="//a[@href='/admin/user-management/demo47username001/edit']")
    public WebElement editButton;

    @FindBy(id="activated")
    public WebElement activateButton;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath ="//*[text() ='My Operations']" )
    public WebElement myOperations;

    @FindBy(xpath ="//*[text() ='Manage Customers']" )
    public WebElement menageCustomers;

    @FindBy(xpath ="//*[text() ='Manage Accounts']" )
    public WebElement menageAccounts;

    @FindBy(id ="account-menu" )
    public WebElement icon;

    @FindBy(xpath="//*[text()='Sign out']")
    public WebElement signOutButton;






}
