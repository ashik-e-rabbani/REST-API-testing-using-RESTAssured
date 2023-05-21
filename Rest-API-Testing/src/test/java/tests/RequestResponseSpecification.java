package tests;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 These specifications allow you to define common configurations, headers, query parameters,
 and assertions that can be shared across multiple API requests.
 */
public class RequestResponseSpecification {

//    Declare Specifications here for global use
    RequestSpecification reqSpec;
    ResponseSpecification resSpec;

    @BeforeClass
    public void InitializeRequestResponse(){

        reqSpec = RestAssured.given()
                .baseUri("https://reqres.in/");
        resSpec = RestAssured.expect()
                .statusCode(200);


    }
@Test
    public void doRegister(){
        RestAssured.given()
//              Provide the initialized request here
                .spec(reqSpec)
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .post("api/users")
                .then()
//              Provide the initialized response assertion here
                .spec(resSpec);
    }
}
