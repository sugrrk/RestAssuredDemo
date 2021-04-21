package com.edu;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetDemo1 {
    @Test
    public void getRequest(){
        RestAssured.baseURI = "http://dummy.restapiexample.com";
       String endURL="/api/v1/employees";
        RequestSpecification req = RestAssured.given();
        Response res = req.request(Method.GET,endURL);
        int statusCode = res.getStatusCode();
        System.out.println("the status code is:" + statusCode);
        Assert.assertEquals(statusCode,200);
        String jsonPayload = res.asString();
        System.out.println("the response payload is:" + jsonPayload);
        System.out.println("the response header is " + res.getHeaders());


    }
}
