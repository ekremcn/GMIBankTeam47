package gmibank.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import gmibank.pojos.Applicants;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.ReadTxt;
import gmibank.utilities.WriteToTxt;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class US023_ReadApplicantsStepDefinition {

    Applicants[] applicants;
    ObjectMapper object;
    Response response;
    JsonPath jsonPath;
    String filePath = ConfigurationReader.getProperty("filePath_Read_Applicants");

    @Given("Authorized user goes to api end point {string}")
    public void authorizedUserGoesToApiEndPoint(String endpoint) {
        response = RestAssured.
                given().
                accept(ContentType.JSON).
                contentType(ContentType.JSON).
                auth().
                oauth2(ConfigurationReader.getProperty("token")).
                when().
                get(endpoint).
                then().
                extract().
                response();

        response.prettyPrint();

        jsonPath = response.jsonPath();
    }

    @And("Authorized user validate data")
    public void authorizedUserValidateData() throws IOException {
        object = new ObjectMapper();
        applicants = object.readValue(response.asString(), Applicants[].class);
        File file = new File(filePath);
        if(file != null){
            file.delete();
        }
        WriteToTxt.saveDataInFileWithApplicantsId(filePath, applicants);


        List<Applicants> actual = ReadTxt.returnApplicantsId(filePath);
        for(int i=0; i<applicants.length; i++) {
            System.out.println(actual.get(i).getId());
        }
        System.out.println(actual.size());
        // int totalNumberOfId=actual.size();
        // Assert.assertEquals("Total number of Id didn't mach",3011, actual.size());
        if(!actual.isEmpty()){
            System.out.println("Read and Pass");
        }else{
            System.out.println("Read and Fall");
        }//Assert ile yapilabilir

    }

    @And("Create a new applicant using to api end point {string}")
    public void createANewApplicantUsingToApiEndPoint(String endpoint) {
        String createdApllicant="{\n" +
                "        \"ssn\": \"470-47-4748\",\n" +
                "        \"firstName\": \"first47\",\n" +
                "        \"lastName\": \"last47\",\n" +
                "        \"address\": \"US\",\n" +
                "        \"mobilePhoneNumber\": \"470-470-4748\",\n" +
                "        \"userId\": 1202,\n" +
                "        \"userName\": \"User47\",\n" +
                "        \"email\": \"User47@gmail.com\",\n" +
                "        \"createDate\": \"2021-06-24T22:47:54.927Z\"\n" +
                "    }";
        Response response = RestAssured.given()
                .headers("Authorization",
                        "Bearer "
                                + ConfigurationReader.getProperty("token"),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().body(createdApllicant)
                .post(endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
    }

    @And("Validate the Created Applicant")
    public void validateTheCreatedApplicant() throws IOException {
        object = new ObjectMapper();
        applicants = object.readValue(response.asString(), Applicants[].class);
        File file = new File(filePath);
        if(file != null){
            file.delete();
        }
        WriteToTxt.saveDataInFileWithApplicantsId(filePath, applicants);


        List<Applicants> actual = ReadTxt.returnApplicantsId(filePath);
        System.out.println(actual.size());

        Response responseLast=RestAssured.given().headers("Authorization","Bearer " + ConfigurationReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .get(ConfigurationReader.getProperty("applicantsEndPoint"))
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        //responseLast.prettyPrint();
        JsonPath json = responseLast.jsonPath();
        String id=json.getString("id");
        Assert.assertTrue("not verify",id.contains("9947"));
    }
}
