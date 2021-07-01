package gmibank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.pages.*;
import gmibank.pojos.Applicants;
import gmibank.pojos.CountryObject;
import gmibank.pojos.CustomerObject;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import gmibank.utilities.ReadTxt;
import gmibank.utilities.WriteToTxt;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Demo48_firstPartStepsDef {
    MainPage mainPage = new MainPage();
    RegistrationPage registrationPage = new RegistrationPage();
    SignInPage signInPage = new SignInPage();
    AdminMainPage adminMainPage = new AdminMainPage();
    UserMainPage userMainPage = new UserMainPage();
    EmployeeMainPage employeeMainPage = new EmployeeMainPage();
    CreateOrEditACustomerPage createOrEditACustomerPage = new CreateOrEditACustomerPage();
    CreateOrEditAnAccountPage createOrEditAnAccountPage = new CreateOrEditAnAccountPage();
    CustomerMainPage customerMainPage = new CustomerMainPage();
    MyAccountsPage myAccountsPage = new MyAccountsPage();

    Response response;
    Response responseGet;
    String token;
    CustomerObject[] customer;
    Applicants[] applicants;
    CountryObject[] country;
    String filePath = "src/test/resources/testdata/apiCustomersInfo.txt";
    String filePath41 = "src/test/resources/testdata/AllApplicantsSSN.txt";
    int expectedId;
    int updateId;
    String expectedSsn;

    @Given("User is on main page for access")
    public void userIsOnMainPageForAccess() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        mainPage.icon.click();
        Driver.wait(1);

    }

    @And("User access to applicant registration page")
    public void userAccessToApplicantRegistrationPage() {
        mainPage.btnRegisterMain.click();
        Driver.wait(1);
    }

    @And("User provides correct information for registration")
    public void userProvidesCorrectInformationForRegistration() {
        expectedSsn = ConfigurationReader.getProperty("demo_ssn");
        registrationPage.inputSSN.sendKeys(expectedSsn);
        Driver.wait(1);
        registrationPage.inputFirstname.sendKeys(ConfigurationReader.getProperty("demo_firstname"));
        Driver.wait(1);
        registrationPage.inputLastname.sendKeys(ConfigurationReader.getProperty("demo_lastname"));
        Driver.wait(1);
        registrationPage.inputAddress.sendKeys(ConfigurationReader.getProperty("demo_address"));
        Driver.wait(1);
        registrationPage.inputMobilePhone.sendKeys(ConfigurationReader.getProperty("demo_mobilePhone"));
        Driver.wait(1);
        registrationPage.inputUsername.sendKeys(ConfigurationReader.getProperty("demo_username"));
        Driver.wait(1);
        registrationPage.inputEmail.sendKeys(ConfigurationReader.getProperty("demo_email"));
        Driver.wait(1);
        registrationPage.inputFirstPass.sendKeys(ConfigurationReader.getProperty("demo_pswd"));
        Driver.wait(1);
        registrationPage.inputSecondPass.sendKeys(ConfigurationReader.getProperty("demo_pswd"));
        Driver.wait(1);
        registrationPage.btnRegister.click();
        Driver.wait(1);
    }

    @Then("Admin activate to applicant")
    public void adminActivateToApplicant() {
        Driver.getDriver().findElement(By.xpath("//*[text() ='Home']")).click();
        Driver.wait(1);
        mainPage.icon.click();
        Driver.wait(1);
        mainPage.btnSignInMain.click();
        signInPage.usernameTextBox.sendKeys("team47admin");
        Driver.wait(1);
        signInPage.passwordTextBox.sendKeys("Team47admin.");
        Driver.wait(1);
        signInPage.signInButton.click();
        Driver.wait(1);
        adminMainPage.administration.click();
        Driver.wait(1);
        adminMainPage.userManagement.click();
        Driver.wait(1);
        adminMainPage.createDateButton.click();
        Driver.wait(1);
        adminMainPage.editButton.click();
        Driver.wait(1);
        adminMainPage.activateButton.click();
        Driver.wait(1);
        adminMainPage.saveButton.click();
        Driver.wait(1);
        adminMainPage.icon.click();
        Driver.wait(1);
        adminMainPage.signOutButton.click();
    }

    @Then("Employee create two new account for the customer")
    public void employeeCreateTwoNewAccountForTheCustomer() {
        mainPage.icon.click();
        Driver.wait(1);
        mainPage.btnSignInMain.click();
        Driver.wait(1);
        signInPage.usernameTextBox.sendKeys("team47employee");
        Driver.wait(1);
        signInPage.passwordTextBox.sendKeys("Team47employee.");
        Driver.wait(1);
        signInPage.signInButton.click();
    }

    @Then("User sign in to an Employee Account")
    public void employeeCreateTwoNewAccountForTheCustomer2() {
        Driver.getDriver().findElement(By.xpath("//*[text() ='Home']")).click();
        Driver.wait(1);
        mainPage.icon.click();
        Driver.wait(1);
        mainPage.btnSignInMain.click();
        Driver.wait(1);
        signInPage.usernameTextBox.sendKeys("team47employee");
        Driver.wait(1);
        signInPage.passwordTextBox.sendKeys("Team47employee.");
        Driver.wait(1);
        signInPage.signInButton.click();
    }

    @And("Employee integrate account for the customer")
    public void employeeIntegrateAccountForTheCustomer() {
        Driver.wait(1);
        employeeMainPage.myOperations.click();
        Driver.wait(1);
        employeeMainPage.menageAccounts.click();
        Driver.wait(1);
        employeeMainPage.createANewAccountButton.click();
        Driver.wait(1);
        createOrEditAnAccountPage.descriptionTextBox.sendKeys(ConfigurationReader.getProperty("demo_firstAccount"));
        Driver.wait(1);
        createOrEditAnAccountPage.balanceTextBox.sendKeys("47000");
        Driver.wait(1);
        Driver.selectDdValue(createOrEditAnAccountPage.accountTypeDDMenu, "CHECKING");
        Driver.wait(1);
        createOrEditAnAccountPage.saveButton.click();
        Driver.wait(1);
        employeeMainPage.createANewAccountButton.click();
        Driver.wait(1);
        createOrEditAnAccountPage.descriptionTextBox.sendKeys(ConfigurationReader.getProperty("demo_secondAccount"));
        Driver.wait(1);
        createOrEditAnAccountPage.balanceTextBox.sendKeys("8000");
        Driver.wait(1);
        Driver.selectDdValue(createOrEditAnAccountPage.accountTypeDDMenu, "SAVING");
        Driver.wait(1);
        createOrEditAnAccountPage.saveButton.click();
        Driver.wait(1);
        employeeMainPage.myOperations.click();
        Driver.wait(1);
        employeeMainPage.menageCustomers.click();
        Driver.wait(1);
        Driver.getDriver().findElement(By.xpath("//*[text()='Create a new Customer']")).click();
        Driver.wait(1);
        createOrEditACustomerPage.ssnSearchTextBox.sendKeys(ConfigurationReader.getProperty("demo_ssn"));
        Driver.wait(1);
        createOrEditACustomerPage.searchButton.click();
        Driver.wait(1);
        createOrEditACustomerPage.middleInitialTextBox.sendKeys("MI");
        Driver.wait(1);
        createOrEditACustomerPage.phoneNumberTextBox.sendKeys(ConfigurationReader.getProperty("demo_phone"));
        Driver.wait(1);
        createOrEditACustomerPage.zipCodeTextBox.sendKeys("47470");
        Driver.wait(1);
        createOrEditACustomerPage.cityTextBox.sendKeys("Springfield");
        Driver.wait(1);
        Driver.selectDdValue(createOrEditACustomerPage.countryDDTextBox, "USA");
        Driver.wait(1);
        createOrEditACustomerPage.stateTextBox.sendKeys("Missouri");
        Driver.wait(1);

        Actions actions = new Actions(Driver.getDriver());

        actions.keyDown(Keys.LEFT_CONTROL)
                .click(createOrEditACustomerPage.checking476)
                .click(createOrEditACustomerPage.saving476)
                .keyUp(Keys.LEFT_CONTROL)
                .perform();

        Driver.wait(1);
        createOrEditACustomerPage.zelleEnrolledCheckBox.click();
        Driver.wait(1);
        createOrEditACustomerPage.saveButton.click();

    }

    @Then("Authorized user access the api endpoint for read the customer info {string}")
    public void authorizedUserAccessTheApiEndpointForReadTheCustomerInfo(String endpoint) {
        Map<String, Object> mapForToken = new HashMap<>();
        mapForToken.put("username", "team47admin");
        mapForToken.put("password", "Team47admin.");
        mapForToken.put("rememberMe", false);

        response = given()
                .headers("Content-Type", ContentType.JSON, "accept", ContentType.JSON)
                .when().body(mapForToken)
                .post("https://gmibank-qa-environment.com/api/authenticate")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        // response.prettyPrint();

        token = response.prettyPrint().substring(19, response.prettyPrint().length() - 3);
        System.out.println("token is " + token);

        response = given()
                .headers("Authorization", "Bearer " + token,
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON)
                .param("size", 2000)
                .when()
                .get(ConfigurationReader.getProperty(endpoint))
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        // response.prettyPrint();

    }

    @And("Validate the customer")
    public void validateTheCustomer() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        customer = obj.readValue(response.asString(), CustomerObject[].class);

        File file = new File(filePath);
        if (file != null) {
            file.delete();
        }
        WriteToTxt.saveAllCustomerData(filePath, customer);

        List<String> actualSsnList = ReadTxt.returnCustomerSNNList(filePath);

        String lastSSN = actualSsnList.get(actualSsnList.size() - 1);
        System.out.println("Last ssn is: " + lastSSN);

        List<String> expectedSsnList = new ArrayList<>();
        expectedSsnList.add(ConfigurationReader.getProperty("demo_ssn"));

        if (lastSSN.equals(ConfigurationReader.getProperty("demo_ssn"))) {
            System.out.println("Create is successful");
        }
        if (actualSsnList.containsAll(expectedSsnList)) {
            System.out.println("Ssn number is matching");
        } else {
            System.out.println("Ssn number is not matching");
        }

        Assert.assertTrue("Ssn number is not mach!", actualSsnList.containsAll(expectedSsnList));

    }

    @And("Validate the customer of applicants endpoint")
    public void validateTheCustomerOfApplicantsEndpoint() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        applicants = obj.readValue(response.asString(), Applicants[].class);

        File file = new File(filePath41);
        if (file != null) {
            file.delete();
        }
        WriteToTxt.saveDataInFileWithSSN(filePath41, applicants);

        List<String> actualSsnList = ReadTxt.returnApplicantsSSN(filePath41);

        Assert.assertTrue("Ssn number is not mach!", actualSsnList.contains(expectedSsn));
        System.out.println("Validation Successful");
        Driver.wait(5);

    }
}
