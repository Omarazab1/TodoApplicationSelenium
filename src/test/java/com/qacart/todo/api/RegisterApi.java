package com.qacart.todo.api;

import com.qacart.todo.config.EndPoints;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.opentelemetry.api.trace.StatusCode;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {
    private String accessToken;
    private List<Cookie> cookies;
    private  String userID;
    private  String firstName;
    public String getAccessToken(){
        return  this.accessToken;
    }
    public List<Cookie> getCookie(){
        return  this.cookies;
    }
    public String getUserId(){
        return  this.userID;
    }
    public String getFirstName(){
        return  this.firstName;
    }


    public void register(){
        User user =  UserUtils.generateRandomUtils();

        Response response = given()
                .baseUri("https://todo.qacart.com")
                .header("Content-Type" , "application/json")
                .body(user)
                .when().post(EndPoints.API_REGISTER_ENDPOINT)
                .then()
                .log().all().extract().response();
        System.out.println(response.prettyPrint());
        // بدلاً من السطر 45 في RegisterApi.java
        if (response.statusCode() != 201) {
            // اطبع نص الخطأ لتعرف السبب الحقيقي
            System.out.println("Registration Failed! Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.asString());
            throw new RuntimeException("Registration Failed");
        }

        cookies = response.detailedCookies().asList();
        accessToken =response.path("access_token");
        userID=response.path("userID");
        firstName= response.path("firstName");
    }
}
