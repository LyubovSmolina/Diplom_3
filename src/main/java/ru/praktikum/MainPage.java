package ru.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class MainPage {

    //Ссылка на личный кабинет в хедере страницы
    By personalAccountButtonOnHeader = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");

    //Внопка входа в аккаунт на главной странице
    By loginButtonOnTheMainPage = By.className("button_button__33qZ0 ");

    //Локатор страницы авторизации(необходим для проверки перехода на страницу по нажатию на кнопки "Личный кабинет" и "Войти в аккаунт")
    By LoginPage = By.xpath("//*[@id=\"root\"]/div/main/div/h2");

    //Конструктор и лого в хедере страницы
    By constructor = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");
    By logoInHeader = By.xpath("//*[@id=\"root\"]/div/header/nav/div/a");

    //Разделы: булки, соусы, начинки, на главной странице
    static By bunTab = By.cssSelector(".tab_tab__1SPyG:nth-child(1)");
    static By sauceTab = By.cssSelector(".tab_tab__1SPyG:nth-child(2)");
    static By fillingTab = By.cssSelector(".tab_tab__1SPyG:nth-child(3)");


    @Step("Загрузка главной страницы продукта")
    public static void openURL(WebDriver driver) {
        driver.get(CONST.BASE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(CONST.TIME_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(sauceTab));
    }



    @Step("Переход к разделу \"Соусы\"")
    public static void clickSauceTab(WebDriver driver) {
        driver.findElement(sauceTab).click();
        new WebDriverWait(driver, Duration.ofSeconds(CONST.TIME_WAIT))
                .until(ExpectedConditions.attributeContains(sauceTab, "class", "current"));
    }

    @Step("Проверка активности раздела \"Соусы\"")
    public static void checkSauceTabIsEnable(WebDriver driver) {
        WebElement elementSauceTab = driver.findElement(sauceTab);
        String sauceTabClass = elementSauceTab.getAttribute("class");
        assertTrue(sauceTabClass.contains("current"));
    }


    @Step("Переход к разделу \"Начинки\"")
    public static void clickFillingTab(WebDriver driver) {
        driver.findElement(fillingTab).click();
        new WebDriverWait(driver, Duration.ofSeconds(CONST.TIME_WAIT))
                .until(ExpectedConditions.attributeContains(fillingTab, "class", "current"));
    }

    @Step("Проверка активности раздела \"Начинки\"")
    public static void checkFillingTabIsEnable(WebDriver driver) {
        WebElement elementFillingTab = driver.findElement(fillingTab);
        String fillingTabClass = elementFillingTab.getAttribute("class");
        assertTrue(fillingTabClass.contains("current"));
    }

    @Step("Переход к разделу \"Булки\"")
    public static void clickBunTab(WebDriver driver) {
        driver.findElement(bunTab).click();
        new WebDriverWait(driver, Duration.ofSeconds(CONST.TIME_WAIT))
                .until(ExpectedConditions.attributeContains(bunTab, "class", "current"));
    }

    @Step("Проверка активности раздела \"Булки\"")
    public static void checkBunTabIsEnable(WebDriver driver) {
        WebElement elementFillingTab = driver.findElement(bunTab);
        String bunTabClass = elementFillingTab.getAttribute("class");
        assertTrue(bunTabClass.contains("current"));
    }

}