package service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import request.*;
import response.*;

import static io.restassured.RestAssured.given;

public class CrudService extends BaseService {

    public static String getToken(SignInRequest Body) {
        return RestAssured.given()
                .baseUri("http://192.168.68.233:3000/api/v1")
                .contentType(ContentType.JSON)
                .log().all()
                .body(Body)
                .when()
                .post("/sign-in")
                .then()
                .log().all()
                .extract().as(SignInResponse.class).access_token;
    }

    public static SignUpResponse registration(SignUpRequest requestBody) {
        return new BaseService()
                .setEndPoint("sign-up")
                .postRequest(requestBody)
                .as(SignUpResponse.class);
    }

    public static SignInResponse login(SignInRequest requestBody) {
        return new BaseService()
                .setEndPoint("/sign-in")
                .postRequest(requestBody)
                .as(SignInResponse.class);
    }

    public static ChangePasswordResponse changePassword(PasswordUpdateRequest requestBody) {
        return new BaseService()
                .setEndPoint("user/password")
                .putRequestPassword(requestBody)
                .as(ChangePasswordResponse.class);
    }

    private static final String END_POINT_STUDENT = "/student";

    public static CreateStudentResponse createStudent(CreateStudentRequest requestBody) {
        return new BaseService()
                .auth()
                .setEndPoint(END_POINT_STUDENT)
                .postRequest(requestBody)
                .as(CreateStudentResponse.class);
    }

    public static UpdateStudentResponse updateStudent(UpdateStudentRequest requestBody, String studentId) {
        return new BaseService()
                .auth()
                .setEndPoint(END_POINT_STUDENT)
                .putRequestStudent(requestBody, studentId)
                .as(UpdateStudentResponse.class);
    }

    public static DeleteStudentResponse deleteStudent(DeleteStudentRequest requestBody) {
        return new BaseService()
                .auth()
                .setEndPoint("/student")
                .deleteRequest(requestBody)
                .as(DeleteStudentResponse.class);
    }
}
