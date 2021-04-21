package com.edu;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BasicAuthBDDApproach {
    @Test
    public void BasicAuthDemo1(){
        given().auth().preemptive().basic("postman","password")
                .when().get("https://postman-echo.com/basic-auth")
                .then().log().body();
    }
}
