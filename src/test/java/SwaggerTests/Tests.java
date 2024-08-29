package SwaggerTests;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import request.*;
import response.*;
import service.CrudService;

import static io.restassured.RestAssured.given;


public class Tests {

    @Test
    public void signUpPositive() {
//        SignUpRequest signUpRequest = new SignUpRequest();

        SignUpResponse signUpResponse = CrudService.registration(new SignUpRequest());

        Assert.assertEquals(signUpResponse.message.get(0), "User registration successfully");
    }

    @Test
    public void signInPositive() {
        SignInResponse signInResponse = CrudService.login(new SignInRequest());

        Assert.assertEquals(signInResponse.access_token, "access_token");
    } //eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjYyLCJpYXQiOjE2OTkyODI5MTV9.q4DggVbeoGarMu4Q54RDHoL431uF-5N_x_eOldX5lNA

    @Test
    public void changePasswordPositive() {

        ChangePasswordResponse changePasswordResponse = CrudService.changePassword(new PasswordUpdateRequest());

        Assert.assertEquals(changePasswordResponse.message, "Password update");
    }

    @Test
    public void createStudentPositive() {
        CreateStudentResponse createStudentResponse = CrudService.createStudent(new CreateStudentRequest());

        Assert.assertEquals(createStudentResponse.email, new CreateStudentRequest().email);
    }

    @Test
    public void updateStudentPositive() {
        UpdateStudentResponse updateStudentResponse = CrudService.updateStudent(new UpdateStudentRequest(), "30");

        Assert.assertEquals(updateStudentResponse.email, new UpdateStudentRequest().email);
    }

    @Test
    public void deleteStudentPositive() {
//        CreateStudentResponse createStudentResponse = CrudService.createStudent(new CreateStudentRequest());

//        Assert.assertEquals(createStudentResponse.email, new CreateStudentRequest().email);

        DeleteStudentResponse deleteStudentResponse = CrudService.deleteStudent(new DeleteStudentRequest());

        Assert.assertTrue(deleteStudentResponse.raw.isEmpty());
    }

    @Test
    public void getStudents() {
        given()
                .baseUri("http://192.168.68.233:3000/api/v1")
                .header("Authorization", "Bearer " + SignInResponse.access_token)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get("students")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getACCESS_TOKEN() {
        CrudService.getToken(new SignInRequest());
    }
    //allure + log4j + ITestListener
}
