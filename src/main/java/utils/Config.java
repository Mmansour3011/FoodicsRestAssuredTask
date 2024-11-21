package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Config {
    public static String loginAndGetToken(String email, String password) {
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}")
                .when()
                .post("/cp_internal/login")
                .then()
                .statusCode(200)
                .extract()
                .response();

        return response.jsonPath().getString("token");
    }
}
