package SimpleApiTests;

import basses.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetStudents7 extends BaseTest {
    @Test
    public void getStudents(){
        given()
                .baseUri(baseUri)
                .header("Authorization","Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get("students")
                .then()
                .log().all()
                .statusCode(200);
    }
}
