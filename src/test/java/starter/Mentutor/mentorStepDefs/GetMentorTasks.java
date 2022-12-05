package starter.Mentutor.mentorStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentutor.loginMentor.MentorAPI;

public class GetMentorTasks {
    @Steps
    MentorAPI mentorAPI;
    //positive 1
    @Given("Get mentor tasks with authorization")
    public void getMentorTasksWithAuthorization() {
        mentorAPI.getMentorTasksWithAuthorization();
    }
    @When("Send get mentor tasks request")
    public void sendGetMentorTasksRequest() {
        SerenityRest.when().get(MentorAPI.MANAGE_TASK);
    }
    @Then("Status code get mentor tasks should be {int} OK")
    public void statusCodeGetMentorTasksShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }
    //negative 1
    @Given("Get mentor tasks without authorization")
    public void getMentorTasksWithoutAuthorization() {
        mentorAPI.getMentorTasksWithoutAuthorization();
    }
    @Then("Status code mentor tasks should be {int} Bad Request")
    public void statusCodeMentorTasksShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }
    //negative 2
    @Given("Get mentor tasks with invalid parameter")
    public void getMentorTasksWithInvalidParameter() {
        mentorAPI.getMentorTasksWithAuthorization();
    }

    @When("Send mentor tasks users invalid request")
    public void sendMentorTasksUsersInvalidRequest() {
        SerenityRest.when().get(MentorAPI.MANAGE_TASK_INVALID);
    }

    @Then("Status code mentor tasks should be {int} Not Found")
    public void statusCodeMentorTasksShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
}
