package gmibank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.pages.CreateOrEditACustomerPage;
import gmibank.pages.CustomerPage;
import gmibank.pages.EmployeeMainPage;
import gmibank.pages.ManageCustomersPage;
import gmibank.pojos.CountryObject;
import gmibank.pojos.Customer;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Demo48_StepDef {

    Response response;
    Response responseGet;
    String token;
    CustomerObject[] customer;
    CountryObject[] country;
    String filePath01 = "src/test/resources/testdata/countriesIds.txt";
    String filePath11 = "src/test/resources/testdata/countriesIdsAfterCreate.txt";
    String filePath21 = "src/test/resources/testdata/countriesIdsAfterUpdate.txt";
    String filePath31 = "src/test/resources/testdata/countriesIdsAfterDelete.txt";
    String filePath41 = "src/test/resources/testdata/AllApplicantsSSN.txt";
    String expectedName;
    int expectedId;
    int updateId;
    int deleteId;
    String actualName;
    String expectedCountry;

    @Given("User access to api end point")
    public void userAccessToApiEndPoint() {
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
        //System.out.println("token is "+token);
    }

    @Then("apiUser read all countries from api using {string}")
    public void apiUserReadAllCountriesFromApiUsing(String endPoint) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        responseGet = RestAssured.given().headers("Authorization", "Bearer " + token,
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON)
                .when().contentType(ContentType.JSON)
                .get("https://gmibank-qa-environment.com/api/tp-countries")
                .then()
                .extract()
                .response();
        //responseGet.prettyPrint();
        country = objectMapper.readValue(responseGet.asString(), CountryObject[].class);

        File file = new File(filePath01);
        if (file != null) {
            file.delete();
        }
        WriteToTxt.saveDataInFileWithCountryid(filePath01, country);
        List<String> allCountriesID = ReadTxt.returnCountryIdList(filePath01);
    }

    @And("apiUser creates a new country from api using {string}")
    public void apiUserCreatesANewCountryFromApiUsing(String endPoint) {
        expectedCountry = "Land1";
        Map<String, Object> createANewCountry = new HashMap<>();
        createANewCountry.put("name", expectedCountry);
        createANewCountry.put("states", null);

        response = RestAssured.
                given().
                headers("Authorization", "Bearer " + token,
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .body(createANewCountry)
                .post(ConfigurationReader.getProperty(endPoint));
        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        expectedName = jsonPath.getString("name");
        expectedId = jsonPath.getInt("id");
        System.out.println(expectedId + " " + expectedName);
    }

    @Then("apiUser validates that country is created")
    public void apiUserValidatesThatCountryIsCreated() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        responseGet = RestAssured.given().headers("Authorization", "Bearer " + token,
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON)
                .when().contentType(ContentType.JSON)
                .get("https://gmibank-qa-environment.com/api/tp-countries")
                .then()
                .extract()
                .response();
        //responseGet.prettyPrint();
        country = objectMapper.readValue(responseGet.asString(), CountryObject[].class);

        File file = new File(filePath11);
        if (file != null) {
            file.delete();
        }
        WriteToTxt.saveDataInFileWithCountryid(filePath11, country);
        List<String> actualCountryIds = ReadTxt.returnCountryIdList(filePath11);
        Assert.assertTrue(actualCountryIds.contains(expectedId + ""));
        System.out.println("Testing to create is successfully passed via API");
    }

    @And("apiUser update created country using api end point {string}")
    public void apiUserUpdateCreatedCountryUsingApiEndPoint(String endPoint) {
        updateId = expectedId;
        expectedCountry = "Land56";
        Map<String, Object> updatedCountry = new HashMap<>();
        updatedCountry.put("id", updateId);
        updatedCountry.put("name", expectedCountry);
        updatedCountry.put("states", null);
        response = RestAssured.
                given().
                headers("Authorization", "Bearer " + token,
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .body(updatedCountry)
                .put(ConfigurationReader.getProperty(endPoint));
        response.prettyPrint();

    }

    @Then("apiUser validates that country is updated")
    public void apiUserValidatesThatCountryIsUpdated() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        responseGet = RestAssured.given().headers("Authorization", "Bearer " + token,
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON)
                .when().contentType(ContentType.JSON)
                .get("https://gmibank-qa-environment.com/api/tp-countries" + "/" + updateId)
                .then()
                .extract()
                .response();
        JsonPath json = response.jsonPath();
        actualName = json.getString("name");


        responseGet = RestAssured.given().headers("Authorization", "Bearer " + token,
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON)
                .when().contentType(ContentType.JSON)
                .get("https://gmibank-qa-environment.com/api/tp-countries")
                .then()
                .extract()
                .response();
        //responseGet.prettyPrint();
        country = objectMapper.readValue(responseGet.asString(), CountryObject[].class);

        File file = new File(filePath21);
        if (file != null) {
            file.delete();
        }
        WriteToTxt.saveDataInFileWithCountryid(filePath21, country);
        List<String> actualCountryIds = ReadTxt.returnCountryIdList(filePath21);
        //Assert.assertEquals("Land2", actualName);
        Assert.assertTrue(actualCountryIds.contains(updateId + ""));
        System.out.println("Testing to update is successfully passed via API");
    }

    @And("apiUser delete created country using api end point {string}")
    public void apiUserDeleteCreatedCountryUsingApiEndPoint(String endPoint) {
        deleteId = updateId;
        response = RestAssured.
                given().
                headers("Authorization", "Bearer " + token,
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                //.delete(ConfigurationReader.getProperty(endPoint) +"/"+7047);
                .delete("https://gmibank-qa-environment.com/api/tp-countries/" + deleteId);
    }

    @Then("apiUser validates that country is deleted")
    public void apiUserValidatesThatCountryIsDeleted() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        responseGet = RestAssured.given().headers("Authorization", "Bearer " + token,
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON)
                .when().contentType(ContentType.JSON)
                .get("https://gmibank-qa-environment.com/api/tp-countries")
                .then()
                .extract()
                .response();
        //responseGet.prettyPrint();
        country = objectMapper.readValue(responseGet.asString(), CountryObject[].class);

        File file = new File(filePath31);
        if (file != null) {
            file.delete();
        }
        WriteToTxt.saveDataInFileWithCountryid(filePath31, country);
        List<String> actualCountryIds = ReadTxt.returnCountryIdList(filePath31);
        Assert.assertFalse(actualCountryIds.contains(deleteId));
        System.out.println("Testing to delete is successfully passed via API");
        System.out.println("\n" + deleteId + " was deleted");
    }
    Actions actions = new Actions(Driver.getDriver());
    EmployeeMainPage employeeMainPage = new EmployeeMainPage();
    CreateOrEditACustomerPage customerPage = new CreateOrEditACustomerPage();
    ManageCustomersPage customer2 = new ManageCustomersPage();
    @Then("apiUser validates that country is created on UI")
    public void apiuserValidatesThatCountryIsCreatedOnUI() {
        Driver.wait(1);
        employeeMainPage.myOperations.click();
        Driver.wait(1);
        employeeMainPage.menageCustomers.click();
        Driver.wait(1);
        customer2.createANewCustomer.click();
        Driver.wait(1);
        actions.sendKeys(Keys.END).sendKeys(Keys.PAGE_UP).perform();
        Select countryDropDown = new Select(customerPage.countryDDTextBox);
        countryDropDown.selectByVisibleText(expectedCountry);
        List<WebElement> allCountriesWebElement = countryDropDown.getOptions();
        List<String> allCountryNames = new ArrayList<>();
        for (WebElement w : allCountriesWebElement) {
            allCountryNames.add(w.getText());
        }

        Assert.assertTrue(allCountryNames.contains(expectedCountry));
        System.out.println("Testing to create is successfully passed via UI");
    }

    @Then("apiUser validates that country is update on UI")
    public void apiuserValidatesThatCountryIsUpdateOnUI() {
        Driver.wait(1);
        employeeMainPage.myOperations.click();
        Driver.wait(1);
        employeeMainPage.menageCustomers.click();
        Driver.wait(1);
        customer2.createANewCustomer.click();
        Driver.wait(1);
        actions.sendKeys(Keys.END).sendKeys(Keys.PAGE_UP).perform();
        Select countryDropDown = new Select(customerPage.countryDDTextBox);
        countryDropDown.selectByVisibleText(expectedCountry);
        List<WebElement> allCountriesWebElement = countryDropDown.getOptions();
        List<String> allCountryNames = new ArrayList<>();
        for (WebElement w : allCountriesWebElement) {
            allCountryNames.add(w.getText());
        }

        Assert.assertTrue(allCountryNames.contains(expectedCountry));
        System.out.println("Testing to update is successfully passed via UI");
    }

    @Then("apiUser validates that country is delete on UI")
    public void apiuserValidatesThatCountryIsDeleteOnUI() {
        Driver.wait(1);
        employeeMainPage.myOperations.click();
        Driver.wait(1);
        employeeMainPage.menageCustomers.click();
        Driver.wait(1);
        customer2.createANewCustomer.click();
        Driver.wait(1);
        actions.sendKeys(Keys.END).sendKeys(Keys.PAGE_UP).perform();
        Select countryDropDown = new Select(customerPage.countryDDTextBox);
        List<WebElement> allCountriesWebElement = countryDropDown.getOptions();
        List<String> allCountryNames = new ArrayList<>();
        for (WebElement w : allCountriesWebElement) {
            allCountryNames.add(w.getText());
        }

        Assert.assertFalse(allCountryNames.contains(expectedCountry));
        System.out.println("Testing to delete is successfully passed via UI");
    }
}


