package com.edu;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class BDDApproachPostRequest {
    @Test
    public void validPostAPITest(){
        RestAssured.baseURI="https://reqres.in/api/users";

        RestAssured.given().body("{\n" +
                "    \"name\": \"Suganya\",\n" +
                "    \"job\": \"QA\"\n" +
                "}").when().post().then().log().all()
                .assertThat().statusCode(201);
    }

    @Test
    public void APIPostDemo(){
        RestAssured.baseURI="https://reqres.in/api/users";
        String json = "{\n" + "    \"name\": \"Shreya\",\n" + "    \"job\": \"Test-Lead\"\n" + "}";
        RestAssured.given().body(json).post().then().log().all().assertThat().statusCode(201);

    }

}
