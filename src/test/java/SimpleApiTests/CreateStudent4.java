package SimpleApiTests;

import basses.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateStudent4 extends BaseTest {
    @Test
    public void createStudentPositive() {
        given()
                .baseUri("http://192.168.68.233:3000/api/v1")
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .log().all()
                .body("{\n" +
                        "  \"name\": \"-----\",\n" +
                        "  \"email\": \"rtfgfg@gmail.com\",\n" +
                        "  \"office\": \"-------\",\n" +
                        "  \"mentor\": \"-----\",\n" +
                        "  \"signed_up\": \"2023-11-02T07:39:49.961Z\"\n" +
                        "}")
                .when()
                .post("/student")
                .then()
                .log().all()
                .statusCode(201);
    }
}
