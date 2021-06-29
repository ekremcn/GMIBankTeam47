package gmibank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.pojos.CustomerObject;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.ReadTxt;
import gmibank.utilities.WriteToTxt;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TokenAndCustomerInfoStepsDefinition {
    Response response;
    String token;
    CustomerObject [] customer;
    String filePath ="src/test/resources/testdata/CustomersInfo.txt";

    @Given("Authorized user provides the api end point to set the response using {string} {string}")
    public void authorizedUserProvidesTheApiEndPointToSetTheResponseUsing(String endpoint, String bearerToken) {
        Map<String, Object> mapForToken = new HashMap<>();
        mapForToken.put("username", "team47admin");
        mapForToken.put("password", "Team47admin.");
        mapForToken.put("rememberMe", false);

        response= given()
                .headers("Content-Type", ContentType.JSON, "accept", ContentType.JSON)
                .when().body(mapForToken)
                .post("https://gmibank-qa-environment.com/api/authenticate")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

       // response.prettyPrint();
        /*
        son asamada gelen verileri console JSON veri tipinde yazdiriyor
         */

        token = response.prettyPrint().substring(19,response.prettyPrint().length()-3);
        System.out.println("token is "+token);

        response= given()
                .headers("Authorization", "Bearer "+ token,
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
        /*
        son asamada gelen verileri console JSON veri tipinde yazdiriyor
         */
    }

    @And("Customers info will be set to customers with deserialization")
    public void customersInfoWillBeSetToCustomersWithDeserialization() throws IOException {
        ObjectMapper obj =new ObjectMapper();
        customer =obj.readValue(response.asString(), CustomerObject[].class);
        System.out.println(customer[0].getId()+"\n"+customer[0].getFirstName()+" "+customer[0].getLastName()+"\n");
        System.out.println(customer[1].getId()+"\n"+customer[1].getFirstName()+" "+customer[1].getLastName()+"\n");

//        for(int i=0; i<customer.length; i++){
//            if(customer[i].getFirstName()!=null)
//                System.out.println(customer[i].getFirstName());
//        }

//        for(int i=0; i<customer.length; i++){
//            if(customer[i].getCountry()!=null)
//                System.out.println(customer[i].getCountry().getName());
//        }


    }

    @Then("Customers info will be saved to txt files")
    public void customersInfoWillBeSavedToTxtFiles() {
        File file=new File(filePath);
        if(file !=null){
            file.delete();
        }
        WriteToTxt.saveAllCustomerData(filePath, customer);
    }

    @Then("Customers info has been validated")
    public void customersInfoHasBeenValidated() {
        List<String> actualSsnList = ReadTxt.returnCustomerSNNList(filePath);
        System.out.println("first customer's ssn number is: "+actualSsnList.get(0)+"\n");
        List<String> expectedSsnList = new ArrayList<>();
        expectedSsnList.add("231-89-4203");
        expectedSsnList.add("570-65-6993");
        expectedSsnList.add("473-22-1798");
        expectedSsnList.add("299-65-4042");

        if( actualSsnList.containsAll(expectedSsnList)){
            System.out.println("Test Ssn numbers are matching");
        }else{
            System.out.println("Test Ssn numbers are not matching");
        }

       Assert.assertTrue("Test failed", actualSsnList.containsAll(expectedSsnList));


    }

  }
