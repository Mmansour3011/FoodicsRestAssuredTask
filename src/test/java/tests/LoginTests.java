package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginSuccess() {
        String email = "merchant@foodics.com";
        String password = "123456";

        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}")
                .when()
                .post("/cp_internal/login")
                .then()
                .statusCode(200)
                .extract()
                .response();

        String token = response.jsonPath().getString("token");
        assertEquals(token.length(), 32, "Token length mismatch!");
    }

    @Test
    public void testWhoamiWithValidToken() {
        String token = "Lyz22cfYKMetFhKQybx5HAmVimF1i0xO";

        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/cp_internal/whoami")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void testLoginFailureWithInvalidCredentials() {
        String email = "Test";
        String password = "Test";

        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}")
                .when()
                .post("/cp_internal/login")
                .then()
                .statusCode(401)
                .extract()
                .response();

        String errorMessage = response.jsonPath().getString("message");
        assertEquals(errorMessage, "Invalid credentials", "Error message mismatch!");
    }
}

