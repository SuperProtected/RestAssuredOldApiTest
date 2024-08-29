package SimpleApiTests;

import basses.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SignIn2 extends BaseTest {
    @Test
    public void cheekSignInPositiveAndGetToken() {
        given()
                .baseUri("http://192.168.68.233:3000/api/v1")
                .contentType(ContentType.JSON)
                .log().all()
                .body("{\n" +
                        "  \"username\": \"WWWWWWWW\",\n" +
                        "  \"password\": \"80808080\"\n" +
                        "}")
                .when()
                .post("sign-in")
                .then()
                .log().all()
                .statusCode(200);
    }
}
