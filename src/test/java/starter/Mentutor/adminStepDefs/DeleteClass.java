package starter.Mentutor.adminStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentutor.loginAdmin.AdminAPI;

public class DeleteClass {
    @Steps
    AdminAPI adminAPI;
    //Positif 1
    @Given("Delete class with id_class {int}")
    public void deleteclassWithId (int id_class){
        adminAPI.deleteClassWithId(id_class);
    }
    @When("Send delete class request")
    public void sendDeleteClassRequest() {
        SerenityRest.when().delete(AdminAPI.ADMIN_DELETE_CLASS);
    }
    @Then("Status delete class code should be {int} OK")
    public void statusDeleteClassCodeShouldBeOK(int created) {
        SerenityRest.then().statusCode(created);
    }
    //Negatif 1
    @Given("Delete class without id")
    public void deleteClassWithoutId() {
        adminAPI.deleteClassWithoutId();
    }
    @When("Send delete class without id request")
    public void sendDeleteClassWithoutIdRequest() {
        SerenityRest.when().delete(AdminAPI.ADMIN_DELETE_CLASS_WITHOUTID);
    }
    @Then("Status delete class code should be {int} Method Not Allowed")
    public void statusDeleteClassCodeShouldBeBadRequst(int notAllowed) {
        SerenityRest.then().statusCode(notAllowed);
    }
    //Negatif 2
    @When("Send delete class with invalid param request")
    public void sendDeleteClassWithInvalidParamRequest() {
        SerenityRest.when().delete(AdminAPI.ADMIN_DELETE_CLASS_INVALID);
    }
    @Then("Status delete class code should be {int} Not Found")
    public void statusDeleteClassCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }


}
