package tests;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class SchemaValidation {

    @Test(priority = 0)
    public void schema_validation() {
/*
Validate our json response against a json schema.
Step 1: Create Json Schema
Step 2: Add Json schema in classpath (target/classes/userSchema.json)
 */

        RestAssured.baseURI = "https://reqres.in/api";
        RestAssured.given()
                .when()
                .get("/users/2")
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/userSchema.json"));


    }
}
