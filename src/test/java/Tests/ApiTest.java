package com.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {
        Response response = given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .when()
                .get("/get");

        response.then().statusCode(200);
        response.then().body("url", equalTo("https://postman-echo.com/get"));
        response.prettyPrint();
    }

    @Test
    public void testGetRequestOops() {
        Response response = given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .when()
                .get("/get?foo1=bar1&foo2=bar2");

        response.then().statusCode(200);
        response.then().body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
        response.prettyPrint();
    }

    @Test
    public void testPostRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(requestBody)
                .when()
                .post("/post");

        System.out.println("Response Body:");
        response.prettyPrint();

        if (response.statusCode() != 200) {
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Headers: " + response.getHeaders());
        }

        response.then().statusCode(200);
        response.then().body("data", equalTo(requestBody));
    }

    @Test
    public void testPostFormData() {
        Response response = given()
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo", "bar")
                .when()
                .post("/post");

        System.out.println("Response Body:");
        response.prettyPrint();

        if (response.statusCode() != 200) {
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Headers: " + response.getHeaders());
        }

        response.then().statusCode(200);
        response.then().body("form.foo", equalTo("bar"));
    }

    @Test
    public void testPutRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(requestBody)
                .when()
                .put("/put");

        System.out.println("Response Body:");
        response.prettyPrint();

        if (response.statusCode() != 200) {
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Headers: " + response.getHeaders());
        }

        response.then().statusCode(200);
        response.then().body("data", equalTo(requestBody));
    }

    @Test
    public void testPatchRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(requestBody)
                .when()
                .patch("/patch");

        System.out.println("Response Body:");
        response.prettyPrint();

        if (response.statusCode() != 200) {
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Headers: " + response.getHeaders());
        }

        response.then().statusCode(200);
        response.then().body("data", equalTo(requestBody));
    }

    @Test
    public void testDeleteRequest() {
        Response response = given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .when()
                .delete("/delete");

        System.out.println("Response Body:");
        response.prettyPrint();

        if (response.statusCode() != 200) {
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Headers: " + response.getHeaders());
        }

        response.then().statusCode(200);
    }
}
