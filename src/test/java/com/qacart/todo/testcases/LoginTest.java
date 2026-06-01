package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Feature("Auth Feature")
public class LoginTest extends BaseTest {
    @Story("login with email and password")
    @Description("it will login by filling email and password")
    @Test(description = "Should able to login correctly")
    public void ShouldBeAbleToLoginWithEmailAndPassword()  {
        LoginPage loginPage = new LoginPage(getDriver());
        boolean isWelcomeMessageDisplayed =
                loginPage.load()
                         .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                         .isWelcomeDisplayed();
        Assert.assertTrue(isWelcomeMessageDisplayed);


    }

}
