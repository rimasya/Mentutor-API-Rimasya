package starter.Mentutor.adminStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentutor.loginAdmin.AdminAPI;

public class UpdateClass {

    @Steps
    AdminAPI adminAPI;

    @Given("Update class with valid id_class {int}")
    public void putUpdateClass (int id_class){
        adminAPI.putUpdateClass(id_class);
    }
    @When("Send update class request")
    public void sendUpdateClassRequest() {
        SerenityRest.when().put(AdminAPI.ADMIN_UPDATE_CLASS);
    }
    @Then("Status code should update class be {int} Created")
    public void statusCodeShouldUpdateClassBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @Given("Update class with invalid id_class {int}")
    public void updateClassWithInvalidId_user(int id_class) {
        adminAPI.putUpdateClass(id_class);
    }
    @Then("Status code update class should be {int} Bad Request")
    public void statusCodeUpdateClassShouldBeNotFound(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @Given("Update user with invalid id_class {int} without data")
    public void updateUserWithInvalidId_classWithoutBody(int id_class) {
        adminAPI.putUpdateClassWithOutData(id_class);
    }
    @Then("Status code update class without body should be {int} Bad Request")
    public void statusCodeUpdateClassWithoutBodyShouldBeBadRequest(int bedRequest) {
        SerenityRest.then().statusCode(bedRequest);
    }
}
