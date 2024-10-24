package ru.praktikum;

import org.openqa.selenium.By;

public class LogInPage {

    //Кнопка "Войти" на странице авторизации
    By logInButton  = By.className("button_button__33qZ0");

    //Поля ввода почты и пароля пользователя
    By fieldEmail = By.xpath(".//input[@type='text']");
    By fieldPassword = By.xpath(".//input[@type='password']");


    //Кнопка выхода из аккаунта, расположена в личном кабинете пользователя
    By logOutButton = By.className("Account_button__14Yp3");

}
