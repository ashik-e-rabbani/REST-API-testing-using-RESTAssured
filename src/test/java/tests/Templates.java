package tests;

import io.restassured.RestAssured;
/* If we import RestAssured as static import we will no longer need to use class name
RestAssured.get(); can be used as get();
 */
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.equalTo;
import static utils.UtilsPack.mapToJsonString;

public class Templates {
    @Test(priority = 0)
    public void test_GET() {

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println(response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(priority = 1)
    public void test_BDD_process() {

        RestAssured.baseURI = "https://reqres.in/api";
        RestAssured.given()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[1]", equalTo(8));

    }

    @Test(priority = 2)
    public void test_post() {
/*
Json payload sending
nested json send
payload creation using hashMap and Json library
 */
//      Prepare RequestBody
        Map<String, Object> data = new HashMap<>();
        data.put("name", "ashik");
        data.put("job", "SQA");


        RestAssured.baseURI = "https://reqres.in/api";
        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(mapToJsonString(data))
                .when()
                .post("/users")
                .then()
                .statusCode(201);


    }

    @Test(priority = 3)
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
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("userSchema.json"));


    }

    @Test(priority = 4)
    public void timeout_handle() {
/*
It's important to note that setting a global timeout with
RestAssured.config().httpClient() will affect all subsequent
REST Assured requests within the same execution.
 */
        int timeoutInSeconds = 10;
        // Set the global timeout for REST Assured
        RestAssured.config().httpClient(
                RestAssured.config().getHttpClientConfig().setParam(
                        "http.connection.timeout", timeoutInSeconds * 1000
                )
        );

        RestAssured.baseURI = "https://reqres.in/api";
        RestAssured.given()
                .when()
                .get("/users/2")
                .then()
                .assertThat()
                .statusCode(200);


    }

}
