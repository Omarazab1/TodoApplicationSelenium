package com.qacart.todo.testcases;
import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoTest extends BaseTest {
    @Story("Add Todo")
    @Test
    public void ShouldBeAbleToAddNewTodo() {

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        newTodoPage.load();
        //driver.get(ConfigUtils.getInstance().getBaseUrl() + "/todo");
        injectCookiesToBrowser(registerApi.getCookie());

        String actualResult = newTodoPage
                .load()
                .addNewTodo("Chest Day Workout")
                .getTodoItem();
        Assert.assertEquals(actualResult, "Chest Day Workout");
    }
    @Story("Delete Todo")
    @Test()
    public  void ShouldBeAbleToDeleteTodo(){
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TasksApi tasksApi = new TasksApi();
        tasksApi.addTask(registerApi.getAccessToken());
       TodoPage todoPage = new TodoPage(getDriver());
       todoPage.load();
       injectCookiesToBrowser(registerApi.getCookie());
        boolean isNoTodoMessageDisplayed =   todoPage
                .load()
                .clickOnDeleteButton()
                .checkNoTodos();
        Assert.assertTrue(isNoTodoMessageDisplayed);


    }

}
