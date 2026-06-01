package com.qacart.todo.api;

import com.qacart.todo.config.EndPoints;
import com.qacart.todo.objects.Task;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TasksApi {
    public void addTask(String token){
        Task task = new Task(false , "Chest Day Workout");
       Response response = given()
                .baseUri("https://todo.qacart.com")
                .header("Content-Type" , "application/json")
                .body(task)
                .auth().oauth2(token)
                .when()
                .post(EndPoints.API_ADD_TASK_ENDPOINT)
                .then()
                .log().all().extract().response();
       if(response.statusCode() != 201){
           throw new RuntimeException("something went wrong in adding todo");
       }

    }
}
