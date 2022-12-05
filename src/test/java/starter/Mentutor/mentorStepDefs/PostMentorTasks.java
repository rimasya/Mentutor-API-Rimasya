package starter.Mentutor.mentorStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentutor.loginMentor.MentorAPI;

public class PostMentorTasks {

    @Steps
    MentorAPI mentorAPI;
    //positive 1
    @Given("Post mentor tasks with valid data")
    public void postMentorTasksWithImages() {
        mentorAPI.setMentorTasksWithValidData();
    }
    @When("Send post section request")
    public void sendPostSectionRequest() {
        SerenityRest.when().post(MentorAPI.MANAGE_TASK);
    }
    @Then("Status code should be {int} CREATED")
    public void statusCodeShouldBeCREATED(int creator) {
        SerenityRest.then().statusCode(creator);
    }
    //negative 1
    @Given("Post mentor tasks without authorazation")
    public void postMentorTasksWithoutAuthorazation() {
        mentorAPI.postMentorWithoutAuthorization();

    }
}
