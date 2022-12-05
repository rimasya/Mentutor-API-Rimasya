package starter.Mentutor.adminStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentutor.loginAdmin.AdminAPI;

public class GetAllClasses {

    @Steps
    AdminAPI adminAPI;

    //Positif 1
    @Given("Get all class with authorization")
    public void getAllClassWithAuthorization(){
        adminAPI.getAllClassWithAuthorization();
    }
    @When("Send get class users request")
    public void sendGetClassUsersRequest() {
        SerenityRest.when().get(AdminAPI.ADMIN_MANAGE_CLASSES);
    }
    @Then("Status get class code should be {int} OK")
    public void statusGetClassCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }
    //Negatif 1
    @Given("Get all class without authorization")
    public void getAllClassWithoutAuthorization() {
        adminAPI.getAllClassWithoutAuthorization();
    }
    @When("Send get all class request")
    public void sendGetAllClassRequest() {
        SerenityRest.when().get(AdminAPI.ADMIN_MANAGE_CLASSES);
    }
    @Then("Status code get all class should be {int} Bad Request")
    public void statusCodeGetAllClassShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }
    //Negativ 2
    @Given("Get all class with invalid parameter")
    public void getAllClassWithInvalidParameter() {
        adminAPI.getAllClassWithAuthorization();
    }
    @When("Send get all class invalid request")
    public void sendGetAllClassInvalidRequest() {
        SerenityRest.when().get(AdminAPI.ADMIN_MANAGE_CLASSES_INVALID);
    }
    @Then("Status code get all class should be {int} Not Found")
    public void statusCodeGetAllClassShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
}
