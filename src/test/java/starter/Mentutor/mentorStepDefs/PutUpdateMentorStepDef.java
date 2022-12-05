package starter.Mentutor.mentorStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentutor.loginMentor.MentorAPI;

public class PutUpdateMentorStepDef {

    @Steps
    MentorAPI mentorAPI;

    //Positif
    @Given("Update user mentor with authorization")
    public void updateUserMentorWithAuthorization() {
        mentorAPI.putUpdateUserMentor();
    }
    @When("Send update user mentor request")
    public void sendUpdateUserMentorRequest() {
        SerenityRest.when().put(MentorAPI.MENTOR_UPDATE_USER);
    }
    @Then("Status code update user mentor should be {int} Created")
    public void statusCodeUpdateUserMentorShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }
    //Negatif 1
    @Given("Put user mentor without data")
    public void putUserMentorWithoutData() {
        mentorAPI.putUpdateUserMentorWithoutData();
    }
//    @When("Send put user mentor request")
//    public void sendPutUserMentorRequest() {
//    }
    @Then("Status code update user mentor should be {int} Bad Request")
    public void statusCodeUpdsteUserMentorShouldBeBadRequest(int bedRequest) {
        SerenityRest.then().statusCode(bedRequest);
    }
    //Negatif 2
    @Given("Put user mentor invalid param")
    public void putUserMentorInvalidParam() {
        mentorAPI.putUpdateUserMentor();
    }
    @When("Send put user mentor invalid param request")
    public void sendPutUserMentorInvalidParamRequest() {
        SerenityRest.when().put(MentorAPI.MENTOR_UPDATE_USER_INVALID);
    }
    @Then("Status code update user mentor should be {int} Bad Not Found")
    public void statusCodeUpdateUserMentorShouldBeBadNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
}
