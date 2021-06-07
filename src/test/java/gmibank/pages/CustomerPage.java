package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
    public CustomerPage(){  PageFactory.initElements(Driver.getDriver(),this); }

}
