package SimpleApiTests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ChangePassword3 {
    @Test
    public void cheekChangePassWordPositive(){
        given()
                .baseUri("http://192.168.68.233:3000/api/v1")
                .body("{\n" +
                        "  \"username\": \"WWWWWWWW\",\n" +
                        "  \"password\": \"79797979\",\n" +
                        "  \"new_password\": \"80808080\",\n" +
                        "  \"confirm_new_password\": \"80808080\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when().put("user/password")
                .then()
                .log().all()
                .statusCode(200);
    }
}
