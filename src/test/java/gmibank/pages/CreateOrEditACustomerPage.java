package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class CreateOrEditACustomerPage {

    public CreateOrEditACustomerPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[text()='Create or edit a Customer']")
    public WebElement createOrEditACustomerHeader;

    @FindBy(id = "tp-customer-id")
    public WebElement idTextBox;

    @FindBy(id = "search-ssn")
    public WebElement ssnSearchTextBox;

    @FindBy(xpath = "//*[text()=Search")
    public WebElement searchButton;

    @FindBy(id = "tp-customer-firstName")
    public WebElement firstNameTextBox;

    @FindBy(id = "tp-customer-lastName")
    public WebElement lastNameTextBox;

    @FindBy(id = "tp-customer-middleInitial")
    public WebElement middleInitialTextBox;

    @FindBy(id = "tp-customer-email")
    public WebElement emailTextBox;

    @FindBy(id = "tp-customer-phoneNumber")
    public WebElement mobilePhoneNumberTextBox;

    @FindBy(id = "tp-customer-mobilePhoneNumber")
    public WebElement phoneNumberTextBox;

    @FindBy(id = "tp-customer-zipCode")
    public WebElement zipCodeTextBox;

    @FindBy(id = "tp-customer-address")
    public WebElement addressTextBox;

    @FindBy(id = "tp-customer-city")
    public WebElement cityTextBox;

    @FindBy(id = "tp-customer-ssn")
    public WebElement ssnTextBox;

    @FindBy(name = "createDate")
    public WebElement createDateTextBox;

    @FindBy(id = "tp-customer-country")
    public WebElement countryTextBox;

    @FindBy(id = "tp-customer-state")
    public WebElement stateTextBox;

    @FindBy(id = "tp-customer-user")
    public WebElement userDropDownMenu;

    @FindBy(id="tp-customer-account")
    public WebElement accountDropDownMenu;

    @FindBy(id = "tp-customer-zelleEnrolled")
    public WebElement zelleEnrolledCheckBox;

    @FindBy(xpath="//*[text()='Back']")
    public WebElement backButton;

    @FindBy(id="save-entity")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@class='av-valid']")
    public List<WebElement> availableValid;







}
