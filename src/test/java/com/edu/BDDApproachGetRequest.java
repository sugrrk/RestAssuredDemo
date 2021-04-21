package com.edu;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class  BDDApproachGetRequest {
    @Test
    public void getRequest(){
       given()
               .when()
               .get("https://reqres.in/api/users/2")
               .then()
               .statusCode(200)
               .assertThat()
               .header("Content-Type","application/json; charset=utf-8")
               .log().all();
    }



    }




