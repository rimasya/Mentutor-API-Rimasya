package starter.Mentutor.adminStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentutor.loginAdmin.MentutorResponses;
import starter.Mentutor.loginAdmin.AdminAPI;

import static org.hamcrest.CoreMatchers.equalTo;

public class UpdateUser {
    @Steps
    AdminAPI adminAPI;

    @Given("Update user with valid id_user {int}")
    public void updateUserWithValidData(int id_user){
        adminAPI.putUpdateUser(id_user);
    }
    @When("Send update user request")
    public void sendUpdateUserRequest() {
        SerenityRest.when().put(AdminAPI.ADMIN_MANAGE_USERS);
    }
    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @Given("Update user with invalid id_user {int}")
    public void updateUserWithInvalidId_user(int id_user) {
        adminAPI.putUpdateUser(id_user);
    }

    @Then("Status code update user should be {int} Not Found")
    public void statusCodeUpdateUserShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @Given("Update user with invalid id_user {int} without body")
    public void updateUserWithInvalidId_userWithoutBody(int id_user) {
        adminAPI.putUpdateUserWithoutBody(id_user);
    }

    @And("Status code update user without body should be {int} Bad Request")
    public void statusCodeUpdateUserWithoutBodyShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }


    @Then("Response body page should contain id_user {int} ,{string}, email {string}, role {string} and class_name {string}")
    public void responseBodyPageShouldContainId_userEmailRoleAndClass_name(int id_user, String name, String email, String role, String class_name) {
        SerenityRest.then().body(MentutorResponses.ID_USER,equalTo(id_user))
                .body(MentutorResponses.NAME,equalTo(name))
                .body(MentutorResponses.EMAIL,equalTo(email))
                .body(MentutorResponses.ROLE,equalTo(role))
                .body(MentutorResponses.CLASS,equalTo(class_name));

    }

}
