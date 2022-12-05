package starter.Mentutor.loginAdmin;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class AdminAPI {

    public static final String URL = "https://ecommerce-alta.online";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR + "/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";

    public static final String BEARER_ADMIN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZENsYXNzIjowLCJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2NzAxODY0NjMsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MTAwMH0.4853aDnmArgDdGcfBR5LhAUBysz090Pc0xvwreLrkBo";
    public static final String BEARER_MENTOR= "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZENsYXNzIjozOCwiYXV0aG9yaXplZCI6dHJ1ZSwiZXhwIjoxNjcwMTgxMDQzLCJyb2xlIjoibWVudG9yIiwidXNlcklkIjoxMDMzfQ.6ldLlflbj7cjKA6QkNetRtyH3-hIC-LdGKn4zAFsw7s";
    public static String LOGIN = URL + "/login";

    public static String GET_ALL_USER = URL +"/admin/users";
    public static String GET_ALL_USER_INVALID = URL+"/admin/usersz";
    public static String ADMIN_MANAGE_CLASSES_INVALID = URL+"/admin/classeszz";
    public static String ADMIN_MANAGE_USERS = URL+"/admin/users/{id_user}";
    public static String ADMIN_MANAGE_USERS_INVALID = URL+"/admin/userssz/{id_user}";
    public static String ADMIN_MANAGE_CLASSES = URL+"/admin/classes";
    public static String ADMIN_MANAGE_USERS_PROFILE = URL+"/admin/users/{id_user}";
    public static String ADMIN_DELETE_CLASS = URL+"/admin/classes/{id_class}";
    public static String ADMIN_DELETE_CLASS_WITHOUTID = URL+"/admin/classes/";
    public static String ADMIN_DELETE_CLASS_INVALID = URL+"/admin/classesqa/{id_class}";
    public static String ADMIN_UPDATE_CLASS = URL+"/admin/classes/{id_class}";

    public static String ADMIN_REGISTER_NEW_USER =URL+"/admin/users";
    public static String ADMIN_DELETE_USER =URL+"/admin/users/{id_user}";
    public static String DELETE_USER_INVALID_PARAM =URL+"/admin/usersdew/{id_user}";
//    public static String MENTOR_UPDATE_USER = URL + "/users";
//    public static String MANAGE_TASK=URL+"/mentors/task";
//    public static String MANAGE_SPECIFIC_TASK_ID = URL+"/mentors/task/{id_task}";
//    public static String MENTOR_MANAGE_TASK_SCORE = URL+"/mentors/submission/{id_submission}";
//    public static String MENTOR_ADD_COMMENT=URL+"/forum/{id_status}";
//
//    public static String MENTEE_UPDATE_PROFILE = URL+"/users";
//    public static String MENTEE_GET_ALL_TASK = URL+"/mentees/tasks";
//    public static String MENTEE_POST_SUBMIT_TASK = URL+"/mentees/submission/{id_task}";
//    public static String MENTEE_POST_COMMENT_FORUM = URL+"/forum/{id_status}";
//
//    public static String MANAGE_FORUM = URL+"/forum";
    public static String ATTACHMENT = DIR+"/src/test/resources/Attachment";


    @Step("Post Login User")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get all users with authorization")
    public void getAllUserWithAuthorization(){
        SerenityRest.given().headers("Authorization",BEARER_ADMIN);
    }
    @Step("Get all user without authorization")
    public void getAllUserWithoutAuthorazation(){
        SerenityRest.given().log().all();
    }
    @Step("Get all class with authorization")
    public void getAllClassWithAuthorization(){
        SerenityRest.given().headers("Authorization",BEARER_ADMIN);
    }
    @Step("Get all class without authorization")
    public void getAllClassWithoutAuthorization(){
        SerenityRest.given().log().all();
    }

    @Step("Get user profile with id")
    public void getUserProfileWithId(int id_user){
        SerenityRest.given().log().all()
                .headers("Authorization",BEARER_ADMIN)
                .pathParam("id_user",id_user);
    }
    @Step("Get single user without id")
    public void getUserProfileWithoutId() {
        SerenityRest.given().log().all()
                .headers("Authorization", BEARER_ADMIN);
    }
        @Step("Delete user with valid id")
        public void deleteUserWithId ( int id_user){
            SerenityRest.given().headers("Authorization", BEARER_ADMIN)
                    .pathParam("id_user", id_user);
        }
         @Step("Delete user without id")
         public void deleteUserWithoutId () {
            SerenityRest.given().headers("Authorization", BEARER_ADMIN);
        }
        @Step("Delete class with valid id")
        public void deleteClassWithId ( int id_class) {
            SerenityRest.given().headers("Authorization", BEARER_ADMIN)
                    .pathParam("id_class", id_class);
        }
         @Step("Delete class with without id")
         public void deleteClassWithoutId ( ) {
            SerenityRest.given().headers("Authorization", BEARER_ADMIN);
        }
        @Step("Post register new user with authorization")
        public void setAdminRegisterNewUser (File json){
            SerenityRest.given().headers("Authorization", BEARER_ADMIN)
                    .contentType(ContentType.JSON)
                    .body(json);
        }
        @Step("Put update user")
        public void putUpdateUser ( int id_user){
            SerenityRest.given().multiPart("name", "Bismillah bener aminnn")
                    .multiPart("email", "setmentee@gmail.com")
                    .multiPart("role", "mentee")
                    .multiPart("id_user", "2")
                    .multiPart("class_name", "Base Testing")
                    .multiPart("images", new File(ATTACHMENT + "/download.png"))
                    .pathParam("id_user", id_user)
                    .headers("Authorization", BEARER_ADMIN);
//                    .contentType(ContentType.JSON)
//                    .body(json);
        }
        @Step("Put update user without body")
        public void putUpdateUserWithoutBody(int id_user){
            SerenityRest.given().log().all().pathParam("id_user",id_user)
                    .headers("Authorization",BEARER_ADMIN);
        }

    @Step("Put update class")
    public void putUpdateClass ( int id_class){
        SerenityRest.given().multiPart("id_class", "14")
                .multiPart("class_name", "bahasa alien")
                .multiPart("status", "active")
                .multiPart("total_student", "1")
                .pathParam("id_class", id_class)
                .headers("Authorization", BEARER_ADMIN);
    }
    @Step("Update class without data")
    public void putUpdateClassWithOutData (int id_class){
        SerenityRest.given().headers("Authorization",BEARER_ADMIN)
                .pathParam("id_class",id_class);
    }
    }
