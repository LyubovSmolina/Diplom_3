package ru.praktikum.Pages;

import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static io.restassured.RestAssured.given;
import static ru.praktikum.CONST.*;

public class LogInPage {

    //Кнопка "Войти" на странице авторизации
    By logInButton  = By.className("button_button__33qZ0");

    //Поля ввода почты и пароля пользователя
    By fieldEmail = By.xpath(".//input[@type='text']");
    By fieldPassword = By.xpath(".//input[@type='password']");


    //Кнопка выхода из аккаунта, расположена в личном кабинете пользователя
    By logOutButton = By.className("Account_button__14Yp3");

    public static String tokenForDel;




    @Step("Авторизация и получение токена пользователя")
    public void getTokenFromLocalStorage(WebDriver driver, String email, String password) {

        driver.get("https://stellarburgers.nomoreparties.site/login");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(logInButton));


        driver.findElement(By.cssSelector("input[name='name']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name='Пароль']")).sendKeys(password);
        driver.findElement(logInButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(
                        By.cssSelector("a[class^='BurgerIngredient']"), 2));

        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        String accessToken = localStorage.getItem("accessToken");
        tokenForDel = StringUtils.substringAfter(accessToken, " ");

    }

    @Step("Удаление учетной записи пользователя")
    public void deleteUser() {
        given().log().all()
                .header("Content-type", "application/json")
                .auth().oauth2(tokenForDel)
                .baseUri(BASE_URL)
                .when()
                .delete(DELETE_ACCOUNT)
                .then().log().all().assertThat()
                .statusCode(ACCEPT_202);
        System.out.println("Учетная запись клиента успешно удалена");
    }

}
