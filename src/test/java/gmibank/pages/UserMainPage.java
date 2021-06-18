package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UserMainPage {
    public UserMainPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//*[text() ='My Operations']" )
    public WebElement myOperations;

    @FindBy(xpath ="//*[text() ='Manage Customers']" )
    public WebElement menageCustomers;

    @FindBy(xpath ="//*[text() ='Manage Accounts']" )
    public WebElement menageAccounts;

    @FindBy(xpath ="//*[text() ='Home']" )
    public WebElement homeButtonUserPage;

    @FindBy(id ="account-menu" )
    public WebElement iconAdminPAge;


}
