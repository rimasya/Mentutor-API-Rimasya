package starter.Mentutor.adminStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentutor.loginAdmin.AdminAPI;

public class GetSingleUser {

    @Steps
    AdminAPI adminAPI;


    @Given("Get user Get user profile with invalid id_user {int}")
    public void getUserGetUserProfileWithInvalidId(int id_user) {
        adminAPI.getUserProfileWithId(id_user);
    }

    @Then("Status get user profile code should be {int} Bad Request")
    public void statusGetUserProfileCodeShouldBeBadRequest(int bedRequest) {
        SerenityRest.then().statusCode(bedRequest);
    }

    @Given("Get user profile with valid id_user {int}")
    public void getUserProfileWithValidId_user(int id_user) {
        adminAPI.getUserProfileWithId(id_user);
    }
    @When("Send get user profile request")
    public void sendGetUserProfileRequest() {
        SerenityRest.when().get(AdminAPI.ADMIN_MANAGE_USERS_PROFILE);
    }
    @Then("Status get user profile code should be {int} OK")
    public void statusGetUserProfileCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @Then("Status code update user should be {int} Bad Request")
    public void statusCodeUpdateUserShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    //Negatif 2
    @Given("Get user profile without id")
    public void getUserProfileWithoutId() {
        adminAPI.getUserProfileWithoutId();
    }

    //Negatif 3
    @Given("Get user Get user profile invalid param with id_user {int}")
    public void getUserGetUserProfileInvalidParam( int id_user) {
            adminAPI.getUserProfileWithId(id_user);
    }
    @When("Send get user profile invalid param request")
    public void sendGetUserProfileInvalidParamRequest() {
        SerenityRest.when().get(AdminAPI.ADMIN_MANAGE_USERS_INVALID);
    }

    @Then("Status get user profile code should be {int} Not Found")
    public void statusGetUserProfileCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
}