package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.objects.User;

public  class UserUtils {
    static String firstName = new Faker().name().firstName();
    static String lastName = new Faker().name().lastName();
    static String email = new Faker().name().firstName() + System.currentTimeMillis() + "@example.com";;
    static String password = "Test12345!";
    // داخل كلاس UserUtils
    public static User generateRandomUtils() {
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        // إضافة الوقت الحالي بالملي ثانية لضمان الفرادة
        String email = firstName + System.currentTimeMillis() + "@example.com";
        String password = "Test12345!";
        return new User(firstName, lastName, email, password);
    }}
