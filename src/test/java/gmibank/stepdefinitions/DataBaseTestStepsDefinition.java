package gmibank.stepdefinitions;

import gmibank.utilities.DatabaseUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class DataBaseTestStepsDefinition {
    @Given("Uders user connect database and print all data")
    public void Uders_user_connect_database_and_print_all_data() {

        DatabaseUtility.createConnection();

        String query = "SELECT * FROM public.tp_customer";
        List<Object> list = DatabaseUtility.getColumnData(query,"email");

        for (Object w : list) {
            System.out.println(w.toString());
        }

    }

    @Given("Uders user creates a connection with db using {string} , {string} and {string}")
    public void udersUserCreatesAConnectionWithDbUsingAnd(String arg0, String arg1, String arg2) {
    }

    @And("Uders user creates a Country data using {string}")
    public void udersUserCreatesACountryDataUsing(String arg0) {
    }

    @And("Uders user reads the Country data using {string} and {string}")
    public void udersUserReadsTheCountryDataUsingAnd(String arg0, String arg1) {
    }

    @Then("Uders validate customers data")
    public void udersValidateCustomersData() {
    }
}
