package gmibank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.pojos.Customer;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.ReadText;
import gmibank.utilities.WriteToText;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiStepDefinition {

    Response response;
    String filePath="src/test/resources/testdata/AllCustomersDatas.txt";
    Customer[] customer;

    @Given("User provides the api end point to set the response using {string} {string}")
    public void userProvidesTheApiEndPointToSetTheResponseUsing(String endpoint, String bearerToken) {

        /*
        Map<String,Object> mapForToken = new HashMap<>();
        mapForToken.put("username", "team47admin");
        mapForToken.put("password", "Team47admin.");
        mapForToken.put("rememberMe", false);

        response=given().headers(
                "Content-Type", ContentType.JSON,"Accept", ContentType.JSON)
                .when().body(mapForToken)
                .post("https://gmibank-qa-environment.com/api/authenticate")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        response.prettyPrint();
        */


        response = given().headers(
                "Authorization", "Bearer " + ConfigurationReader.getProperty(bearerToken),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON)
                //.param("size", 1500).auth().oauth2(ConfigurationReader.getProperty(bearerToken))
                // buraya auth methodu yazarakta authorization yapabiliyoruz.
                .param("size", 1500)
                .when()
                .get(ConfigurationReader.getProperty(endpoint))
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        //   response.prettyPrint();

    }

    @And("All customer info will be set to customers with deserialization")
    public void allCustomerInfoWillBeSetToCustomersWithDeserialization() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        customer = obj.readValue(response.asString(), Customer[].class);
//        System.out.println(customer[0].getFirstName() + "\n" + customer[0].getLastName());
//        System.out.println(customer[1].getFirstName() + "\n" + customer[1].getLastName());
//
//        for (int i = 0; i < customer.length; i++) {
//
////    System.out.println(customer[i].getFirstName());
//
//            if (customer[i].getCountry() != null)
//                System.out.println(customer[i].getCountry().getName());
//
//        }

    }


    @And("All customer info will be saved to txt files")
    public void allCustomerInfoWillBeSavedToTxtFiles() {

        WriteToText.saveAllCustomerData(filePath, customer);

    }

    @And("All customer info has been validated")
    public void allCustomerInfoHasBeenValidated() {
        List<String > actualSsnList = ReadText.returnCustomerSNNList(filePath);
        List<String> expectedList = new ArrayList<>();
        expectedList.add("348-27-5269");
        expectedList.add("716-17-4100");
        expectedList.add("890-40-8248");

        Assert.assertTrue("Ssn´ler eslesmiyor!", actualSsnList.containsAll(expectedList));


    }
}
