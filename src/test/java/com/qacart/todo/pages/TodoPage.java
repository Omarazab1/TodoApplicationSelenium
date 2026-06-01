package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoints;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {
    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcome;


    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement addButton;

    @FindBy(css = "[data-testid=\"todo-item\"]")
    private WebElement todoItem;

    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement newTodo;

    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement submitNewTask;

    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement deleteTodo;

    @FindBy(css = "[data-testid=\" no-todos\"]")
    private WebElement noTodo;



    @Step
    public boolean checkNoTodos(){
        return noTodo.isDisplayed();
    }
    @Step
    public TodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoints.TODO_PAGE_ENDPOINT);
        return this;
    }
    @Step
    public boolean isWelcomeDisplayed(){

        return welcome.isDisplayed();
    }
    @Step
    public NewTodoPage clickOnAddButton(){
        addButton.click();
        return new NewTodoPage(driver);

    }
    @Step
    public  String getTodoItem(){

        return todoItem.getText();
    }
    @Step
    public TodoPage clickOnDeleteButton(){
        deleteTodo.click();
        return this;
    }


}
