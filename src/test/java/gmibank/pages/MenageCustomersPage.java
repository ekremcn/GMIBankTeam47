package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class MenageCustomersPage {

    public MenageCustomersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//*[text() ='My Operations']" )
    public WebElement myOperations;

    @FindBy(xpath ="//*[text() ='Manage Customers']" )
    public WebElement manageCustomers;

    @FindBy(xpath = "//*[@class='info jhi-item-count']")
    public WebElement allCustomerInfo;

    @FindBy(xpath ="//*[text()='Create a new Customer']" )
    public WebElement createANewCustomer;

    @FindBy(xpath="//thead//th[@class='hand']")
    public List<WebElement> headers;

    @FindBy(xpath ="//*[text()='View']" )
    public WebElement viewButton;

    @FindBy(xpath="//*[text()='Edit']")
    public WebElement editButtonCustomerViewPage;

    @FindBy(xpath="//*[text()='Back']")
    public WebElement backButtonCustomerViewPage;

    @FindBy(xpath ="//*[text()='Edit']" )
    public WebElement editButton;

    @FindBy(xpath ="//*[text()='Delete']" )
    public WebElement deleteButton;

    @FindBy(xpath ="//*[text()='Confirm delete operation']" )
    public WebElement confirmDeleteOperationMessage;

    @FindBy(id ="gmibankfrontendApp.tPCustomer.delete.question" )
    public WebElement deleteQuestionMessage;

    @FindBy(xpath ="//*[@class='btn btn-secondary']" )
    public WebElement cancelConfirmButton;

    @FindBy(id ="jhi-confirm-delete-tPCustomer" )
    public WebElement deleteConfirmButton;



}
