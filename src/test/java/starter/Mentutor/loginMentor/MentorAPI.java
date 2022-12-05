package starter.Mentutor.loginMentor;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class MentorAPI {

    public static final String URL = "https://ecommerce-alta.online";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR + "/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR + "/src/test/resources/JSON/JsonSchema";
    public static final String BEARER_MENTOR = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZENsYXNzIjozOCwiYXV0aG9yaXplZCI6dHJ1ZSwiZXhwIjoxNjcwMTg4NTEyLCJyb2xlIjoibWVudG9yIiwidXNlcklkIjoxMDMzfQ.heeFjZ_jRkF_8JOByS_s7S_2hmjBedWefPsAhPK9OGE";
    public static String LOGIN = URL + "/login";
    public static String MENTOR_UPDATE_USER = URL + "/users";
    public static String MENTOR_UPDATE_USER_INVALID = URL + "/userssq";
    public static String MANAGE_TASK = URL + "/mentors/tasks";
    public static String MANAGE_TASK_INVALID = URL + "/mentors/taskssz";
    public static String MANAGE_SPECIFIC_TASK_ID = URL + "/mentors/task/{id_task}";
    public static String MENTOR_MANAGE_TASK_SCORE = URL + "/mentors/submission/{id_submission}";
    public static String MENTOR_ADD_COMMENT = URL + "/forum/{id_status}";
    public static String ATTACHMENT = DIR + "/src/test/resources/Attachment";

    @Step("Get mentor tasks authorization")
    public void getMentorTasksWithAuthorization() {
        SerenityRest.given().headers("Authorization", BEARER_MENTOR);
    }
    @Step("Get mentor tasks without authorization")
    public void getMentorTasksWithoutAuthorization(){
        SerenityRest.given().log().all();
    }
    @Step("Put update user mentor")
    public void putUpdateUserMentor() {
        SerenityRest.given()
                .multiPart("id_tasks", "102")
                .multiPart("title", "test")
                .multiPart("description", "test11")
                .headers("Authorization", BEARER_MENTOR);
    }
    @Step("Put update user mentor without data")
    public void putUpdateUserMentorWithoutData() {
        SerenityRest.given().headers("Authorization", BEARER_MENTOR);
    }
    @Step("Post mentor tasks with valid data")
    public void setMentorTasksWithValidData() {
        SerenityRest.given().multiPart("title", "testing title")
                .multiPart("description", "isi apa ajalah")
                .multiPart("images", new File(ATTACHMENT + "/download.png"))
                .multiPart("due_date", "2022-12-09")
                .multiPart("file", new File(ATTACHMENT + "/testfile.pdf"))
                .headers("Authorization", BEARER_MENTOR);
    }
    @Step("Post mentor tasks without authorization")
    public void postMentorWithoutAuthorization(){
        SerenityRest.given().log().all();
    }

}
