package ru.praktikum.UserData;

import org.apache.commons.lang3.RandomStringUtils;


public class RandomUserData {
    private static String name;
    private String email;
    private static String password;

    public RandomUserData(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }



    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static RandomUserData newRandomUser() {
        return new  RandomUserData("Diplom" + RandomStringUtils.randomAlphabetic(3), "Diplom@ya." + RandomStringUtils.randomAlphabetic(3), "123456");
    }

    public static RandomUserData newRandomUserPasswordSevenCharacters() {
        return new  RandomUserData("Diplom" + RandomStringUtils.randomAlphabetic(3), "Diplom@ya." + RandomStringUtils.randomAlphabetic(3), "1234567");
    }

    public static RandomUserData newRandomUserInvalidPasswordFiveCharacters() {
        return new  RandomUserData("Diplom" + RandomStringUtils.randomAlphabetic(3), "Diplom@ya." + RandomStringUtils.randomAlphabetic(3), "12345");
    }

    }
