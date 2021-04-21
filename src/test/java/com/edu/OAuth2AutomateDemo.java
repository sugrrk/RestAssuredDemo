package com.edu;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OAuth2AutomateDemo {
    @Test
    public void testDemo(){
        Response resp = RestAssured.given()
                .formParam("client_id","SessionDemo")
                .formParam("client_secret","ba8eaa5aae1714ddb6cff7f6306545bf")
                .formParam("grant_type","client_credentials").when()
                .post("http://coop.apps.symfonycasts.com/token");
        System.out.println(resp.jsonPath().prettify());  //until this if we execute we will get the access_token.
        String token = resp.jsonPath().get("access_token");

        Response resp1 = RestAssured.given()
                .auth()
                .oauth2(token)
                .post("http://coop.apps.symfonycasts.com/api/1824/chickens-feed");
        Assert.assertEquals(resp1.getStatusCode(),200);
        System.out.println("The status code is : " + resp1.getStatusCode());




    }
}
