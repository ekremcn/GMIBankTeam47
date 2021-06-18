package gmibank.pages;

import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAccountsPage {

    public MyAccountsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Bu 2 sini tekrar bak
    @FindBy (xpath = "//tbody//td")
    public List<WebElement> accountsBalanceList;

    @FindBy(xpath = "(//td[3])[1]")
    public List<WebElement> denemeList;
}
