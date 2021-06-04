package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

public MainPage(){

    PageFactory.initElements(Driver.getDriver(),this);
}
}
