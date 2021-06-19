package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAccountsPage {
    public MyAccountsPage(){  PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "(//td)[3]")
    public WebElement firstBalance1;

    @FindBy(xpath = "(//td)[7]")
    public WebElement secondBalance1;

    @FindBy(xpath = "//tbody//tr//td[3]")
    public List<WebElement> accountsBalancesList;


}
