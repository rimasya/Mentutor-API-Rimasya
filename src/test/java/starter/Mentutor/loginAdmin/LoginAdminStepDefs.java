package starter.Mentutor.loginAdmin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class LoginAdminStepDefs {

    @Steps
    AdminAPI adminAPI;

    @Given("Post login with all valid value as admin")
    public void postLoginWithAllValidValueAsAdmin(){
        File json = new File(AdminAPI.JSON_REQ_BODY+"/PostLoginAdmin.json");
        adminAPI.postLoginUser(json);
    }

    @When("Send request post login")
    public void sendRequestPostLogin() {
        SerenityRest.when().post(AdminAPI.LOGIN);
    }

    @Then("Should return {int} OK")
    public void shouldReturnOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @Given("Post login with invalid value as admin")
    public void postLoginWithInvalidValueAsAdmin() {
        File json = new File(AdminAPI.JSON_REQ_BODY+"/PostLoginAdminInvalidEmail.json");
        adminAPI.postLoginUser(json);
    }

    @Then("Should return {int} Not Found")
    public void shouldReturnNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
}
