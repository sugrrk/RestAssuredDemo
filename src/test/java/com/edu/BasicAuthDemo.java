package com.edu;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthDemo {
    @Test
    public void AuthorizationTest(){
        RestAssured.baseURI="https://postman-echo.com/basic-auth";//base url

        //Basic Authentication
        //Before sending request we should authorize
        //PreemptiveBasicAuthScheme is pre defined class in restAssured and create a object called authScheme
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("postman");//using object authScheme we pass method called setUserName.
        authScheme.setPassword("password");//method called SetPassword.
        RestAssured.authentication=authScheme;//we are specifying what type of authentication.ie authScheme


        RequestSpecification httpReq = RestAssured.given();//what specification we are giving to the server
        Response res = httpReq.request(Method.GET,"/");//response will be stored in res object
        //to get status code
        int statusCode = res.getStatusCode();
        System.out.println("the status code is:" + statusCode);//Printing the status code
        Assert.assertEquals(statusCode,200);// we are asserting here.

        //response payload or body
        String jsonPayload = res.asString();// we are using asString method and printing payload
        System.out.println("the response payload is:" + jsonPayload);

        //response headers
        System.out.println("the response header is " + res.getHeaders());
    }

    }



