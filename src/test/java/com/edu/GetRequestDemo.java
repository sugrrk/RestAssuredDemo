package com.edu;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequestDemo {
    @Test
    public void getRequest(){
        RestAssured.baseURI="https://reqres.in/";//base url
        String endURL="/api/users?page=2";//end url
        RequestSpecification httpReq = RestAssured.given();//what specification we are giving to the server
        //we will send the request
        Response res = httpReq.request(Method.GET,endURL);//response will be stored in res object
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
    @Test
    public void postRequest(){
        RestAssured.baseURI="https://reqres.in/";//base url
        String endURL="/api/users";//end url
        RequestSpecification req = RestAssured.given();//what specification we are giving to the server
        req.header("Content-Type","application/json");
        JSONObject json = new JSONObject();// library json simple
        json.put("name", "Suganya");
        json.put("job","QA");
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
@Test
    public void putRequest(){
        RestAssured.baseURI="https://reqres.in/";//base url
        String endURL="/api/users?page=2";//end url
        RequestSpecification req = RestAssured.given();//what specification we are giving to the server
        req.header("Content-Type","application/json");
        JSONObject json = new JSONObject();// library json simple
        json.put("name", "Suganya");
        json.put("job","Tester");
        String stringJsonData = json.toJSONString();
        req.body(stringJsonData);
        Response res = req.request(Method.PUT,endURL);//response will be stored in res object
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

    @Test
    public void deleteRequest(){
        RestAssured.baseURI="https://reqres.in/";//base url
        String endURL="/api/users/2";//end url
        RequestSpecification req = RestAssured.given();//what specification we are giving to the server
        req.header("Content-Type","application/json");
        JSONObject json = new JSONObject();// library json simple
        json.put("name", "Suganya");
        json.put("job","Tester");
        String stringJsonData = json.toJSONString();
        req.body(stringJsonData);
        Response res = req.request(Method.DELETE,endURL);//response will be stored in res object
        //to get status code
        int statusCode = res.getStatusCode();
        System.out.println("the status code is:" + statusCode);//Printing the status code
        Assert.assertEquals(statusCode,204);// we are asserting here.

        //response payload or body
        String jsonPayload = res.asString();// we are using asString method and printing payload
        System.out.println("the response payload is:" + jsonPayload);

        //response headers
        System.out.println("the response header is " + res.getHeaders());
    }

}
