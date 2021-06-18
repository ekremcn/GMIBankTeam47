package gmibank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegistrationPage extends MainPage {

    @FindBy(id="ssn")
    public WebElement inputSSN;

    @FindBy(id="firstname")
    public WebElement inputFirstname;

    @FindBy(id="lastname")
    public WebElement inputLastname;

    @FindBy(id="address")
    public WebElement inputAddress;

    @FindBy(id="mobilephone")
    public WebElement inputMobilePhone;

    @FindBy(id="username")
    public WebElement inputUsername;

    @FindBy(id="email")
    public WebElement inputEmail;

    @FindBy(id="firstPassword")
    public WebElement inputFirstPass;

    @FindBy(id="secondPassword")
    public WebElement inputSecondPass;

    @FindBy(id="register-submit")
    public WebElement btnRegister;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement ssnRequiredErrorMessage;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement mobilePhoneNumberErrorMessage;

    @FindAll({
            @FindBy(xpath = "//input/../*[3]")
    })
    public List<WebElement> feedbacks;

    public void whichBoxIsMissing(){
        ArrayList<String> feedbacksTexts = new ArrayList<String>();
        ArrayList<String> expectedList = new ArrayList<>(Arrays.asList(
                "SSN", "First Name", "Last Name",
                "Address", "Mobile Number", "Username",
                "Email", "Password First Box", "Password Second Box" ));
        for (WebElement each : feedbacks) {
            feedbacksTexts.add(each.getText());
            System.out.println(each.getText());
            if(each.getText().contains("SSN")){
                expectedList.remove("SSN");
            }else if(each.getText().contains("First")){
                expectedList.remove("First Name");
            }else if(each.getText().contains("Last")){
                expectedList.remove("Last Name");
            }else if(each.getText().contains("address")){
                expectedList.remove("Address");
            }else if(each.getText().contains("mobile")){
                expectedList.remove("Mobile Number");
            }else if(each.getText().contains("username")){
                expectedList.remove("Username");
            }else if(each.getText().contains("email")){
                expectedList.remove("Email");
            }else if(each.getText().contains("Your password")){
                expectedList.remove("Password First Box");
            }else if(each.getText().contains("confirmation")){
                expectedList.remove("Password Second Box");
            }
        }

        if(expectedList.size()>0){
            System.out.println( expectedList.toString()+" feedbacks is missing");
        }else{
            System.out.println("All input boxes was filled successfully");
        }
    }
}
