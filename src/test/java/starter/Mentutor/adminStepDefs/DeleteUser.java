package starter.Mentutor.adminStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentutor.loginAdmin.AdminAPI;

public class DeleteUser {
    @Steps
    AdminAPI adminAPI;

    @Given("Delete user with id_user {int}")
    public void deleteUserWithId(int id_user){
        adminAPI.deleteUserWithId(id_user);
    }
    @When("Send delete users request")
    public void sendDeleteUsersRequest() {
        SerenityRest.when().delete(AdminAPI.ADMIN_DELETE_USER);
    }
    @Then("Status delete user code should be {int} OK")
    public void statusDeleteUserCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }
    //Negatif
    @Given("Delete user without id")
    public void deleteUserWithoutId_user() {
        adminAPI.deleteUserWithoutId();
    }
    @Then("Status delete user code should be {int} Method Not Allowed")
    public void statusDeleteUserCodeShouldBeBadRequst(int notAllowed) {
        SerenityRest.then().statusCode(notAllowed);
    }

    //Negatif 3
    @When("Send delete users with invalid param request")
    public void sendDeleteUsersWithInvalidParamRequest() {
        SerenityRest.when().delete(AdminAPI.DELETE_USER_INVALID_PARAM);
    }
    @Then("Status delete user code should be {int} Not Found")
    public void statusDeleteUserCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @When("Send delete users without id request")
    public void sendDeleteUsersWithoutIdRequest() {
        SerenityRest.when().delete(AdminAPI.ADMIN_DELETE_CLASS_WITHOUTID);
    }
}
