package SimpleApiTests;

import basses.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import request.SignInRequest;

public class GetToken {

    @Test
    public static String getToken() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(new SignInRequest())
                .when()
                .post("/sign-in")
                .then()
                .log().all()
                .extract().as(BaseTest.class).accessToken;
    }
}
