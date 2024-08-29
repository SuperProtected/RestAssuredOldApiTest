package SimpleApiTests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SignUp1 {

    @Test
    public void cheekSignUpPositive() {
        given()
                .baseUri("http://192.168.68.233:3000/api/v1")
                .body("{\n" +
                        "  \"username\": \"WWWWWWWW\",\n" +
                        "  \"password\": \"79797979\",\n" +
                        "  \"confirm_password\": \"79797979\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when().post("sign-up")
                .then()
                .log().all()
                .extract().statusCode();
//              .statusCode(201);

        //System.out.println(rs);
    }
}