package com.edu;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OAuthBarnDemo {

    @Test
    public void test2(){
        Response resp = RestAssured.given()
                .formParam("client_id" , "MyOwnTry")
                .formParam("client_secret","75748b6d99b8a07835f80bd69e962a0e")
                .formParam("grant_type","client_credentials").when()
                .post("http://coop.apps.symfonycasts.com/token");
        System.out.println(resp.jsonPath().prettify());
       String token = resp.jsonPath().get("access_token");
        Response resp1 = RestAssured.given()
                .auth()
                .oauth2(token)
                .when()
                .post("http://coop.apps.symfonycasts.com/api/1824/barn-unlock");
        System.out.println(resp1.getStatusCode());
        Assert.assertEquals(resp1.getStatusCode(),200);

    }
}
