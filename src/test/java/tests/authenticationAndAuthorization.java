package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class authenticationAndAuthorization {
    @Test
    public void basicAuthentication(){
        RestAssured.given()
                .auth().basic("username", "password")
                .get("https://api.example.com/endpoint")
                .then()
                .statusCode(200);
    }

    @Test
    public void tokenBaseAuthentication(){
        RestAssured.given()
                .header("Authorization", "Bearer <token>")
                .get("https://api.example.com/endpoint")
                .then()
                .statusCode(200);
    }
}
