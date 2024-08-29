package SimpleApiTests;

import basses.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateStudent5 extends BaseTest {

    @Test
    public void updateStudentPositive() {
        given()
                .baseUri(baseUri)
                .header("Authorization","Bearer " + accessToken)
                .param("id", "24")
                .body("{\n" +
                        "  \"name\": \"Jo\",\n" +
                        "  \"email\": \"WWWWWWWfff@gmail.com\",\n" +
                        "  \"office\": \"eeeeeeeeeeeeeeeeeeeeeeee\",\n" +
                        "  \"mentor\": \"----------------------------------\",\n" +
                        "  \"signed_up\": \"2023-10-25T13:09:19.692Z\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .put("/student")
                .then()
                .log().all()
                .statusCode(200);
    }
}
