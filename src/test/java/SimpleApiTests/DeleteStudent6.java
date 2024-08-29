package SimpleApiTests;

import basses.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteStudent6 extends BaseTest {
    @Test
    public void deleteStudent(){
        given()
                .baseUri(baseUri)
                .header("Authorization","Bearer " + accessToken)
                .body("{\n" +
                        "  \"email\": \"dmk.makuhin1698832570244@gmail.com\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when().delete("student")
                .then()
                .log().all()
                .statusCode(200);
    }
}