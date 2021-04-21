package com.edu;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostDemo1 {
    @Test
    public void test1(){
        RestAssured.baseURI = "http://dummy.restapiexample.com";
        String endURL = "/api/v1/create";
        RequestSpecification req = RestAssured.given();
        req.header("Content-Type","application/json");
        JSONObject json = new JSONObject();
        json.put("name", "Shreya");
        json.put("salary", "1234");
        json.put("age", "23");
        String stringJsonData = json.toJSONString();
        req.body(stringJsonData);
        Response res = req.request(Method.POST,endURL);//response will be stored in res object
        //to get status code
        int statusCode = res.getStatusCode();
        System.out.println("the status code is:" + statusCode);//Printing the status code
        Assert.assertEquals(statusCode,201);// we are asserting here.

        //response payload or body
        String jsonPayload = res.asString();// we are using asString method and printing payload
        System.out.println("the response payload is:" + jsonPayload);

        //response headers
        System.out.println("the response header is " + res.getHeaders());
    }
}
