package com.edu;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class OAuth2NewDemoManual {

    // this code is to generate the access token manually and using it.

    @Test
    public void test1(){
      Response resp = RestAssured.given()
                .auth()
              .oauth2("53e7fc251d33c3f1d96b76cf9b210d060bc09843")
              .post("http://coop.apps.symfonycasts.com/api/1824/chickens-feed");
        System.out.println("code "+ resp.getStatusCode());
        System.out.println(("code "+ resp.getBody().asString()));
    }
}
