package service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import response.SignInResponse;

import static response.SignInResponse.access_token;
import static service.CrudService.getToken;

public class BaseService {

    private final RequestSpecification requestSpecification;


    public BaseService() {
        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .setBaseUri("http://192.168.68.233:3000/api/v1")
                .build();
    }

    public BaseService auth() {
        requestSpecification.header("Authorization", "Bearer " + access_token);
        return this;
    }

    public BaseService setEndPoint(String endPoint) {
        requestSpecification.basePath(endPoint);
        return this;
    }

    public Response postRequest(Object requestBody) {
        requestSpecification.body(requestBody);
        return RestAssured
                .given()
                .log().all()
                .spec(requestSpecification)
                .when()
                .post()
                .then()
                .log().all()
                .extract().response();
    }

    public Response putRequestStudent(Object requestBody, String id) {
        requestSpecification.body(requestBody);
        return RestAssured
                .given()
                .log().all()
                .spec(requestSpecification)
                .param(id)
                .when()
                .put()
                .then()
                .log().all()
                .extract().response();
    }
    public Response putRequestPassword(Object requestBody) {
        requestSpecification.body(requestBody);
        return RestAssured
                .given()
                .log().all()
                .spec(requestSpecification)
                .when()
                .put()
                .then()
                .log().all()
                .extract().response();
    }

    public Response deleteRequest(Object requestBody) {
        requestSpecification.body(requestBody);
        return RestAssured
                .given()
                .log().all()
                .spec(requestSpecification)
                .when()
                .delete()
                .then()
                .log().all()
                .extract().response();
    }

    public Response getStudents(){
        return RestAssured
                .given()
                .log().all()
                .when()
                .get()
                .then()
                .log().all()
                .extract().response();
    }
}
