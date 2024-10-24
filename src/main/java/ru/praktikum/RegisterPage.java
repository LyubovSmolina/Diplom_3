package ru.praktikum;

import org.openqa.selenium.By;

public class RegisterPage {

    //Ссылка на форму регистрации нового аккаунта, расположена на странице авторизации
    By registerANewAccountButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");

    //Поля регистрации аккаунта
    By fieldRegisterName = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/label");
    By fieldRegisterEmail = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    By fieldRegisterPassword = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/label");

    //Кнопка "Зарегистрироваться"
    By buttonRegisterAnAccount = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
}
