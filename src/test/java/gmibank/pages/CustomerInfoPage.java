package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class CustomerInfoPage {
    public CustomerInfoPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Customer']")
    public WebElement customerHeader;

    @FindBy(xpath ="//*[@class='jh-entity-details']")
    public List<WebElement> customerInfoList;

    @FindBy(id = "firstName")
    public WebElement customerFirstName;

    @FindBy(id = "lastName")
    public WebElement customerLastName;

    @FindBy(id = "middleInitial")
    public WebElement customerMiddleInitial;

    @FindBy(id = "email")
    public WebElement customerEmail;

    @FindBy(id = "mobilePhoneNumber")
    public WebElement customerMobilePhoneNumber;

    @FindBy(id = "phoneNumber")
    public WebElement customerPhoneNumber;

    @FindBy(id = "zipCode")
    public WebElement customerZipCode;

    @FindBy(id = "address")
    public WebElement customerAddress;

    @FindBy(id = "city")
    public WebElement customerCity;

    @FindBy(id = "ssn")
    public WebElement customerSsn;

    @FindBy(id = "createDate")
    public WebElement customerCreateDate;

    @FindBy(id = "zelleEnrolled")
    public WebElement customerZelleEnrolled;

    @FindBy(id = "Country")
    public WebElement customerCountry;

    @FindBy(id = "State")
    public WebElement customerState;

    @FindBy(id = "User")
    public WebElement customerUser;

    @FindBy(id = "Account")
    public WebElement customerAccount;

    @FindBy(xpath = "//*[text()='Back']")
    public WebElement backButton;

    @FindBy(xpath = "//*[text()='Edit']")
    public WebElement editButton;






}
