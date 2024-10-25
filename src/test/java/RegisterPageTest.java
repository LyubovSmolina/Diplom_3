import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.praktikum.Pages.LogInPage;
import ru.praktikum.UserData.RandomUserData;
import ru.praktikum.Pages.RegisterPage;
import static ru.praktikum.Pages.RegisterPage.*;

public class RegisterPageTest extends LogInPage {

    @Rule
    public DriverRule driverRule = new DriverRule();


    //При успешном создании пользователя аккаунт удаляется через API
    @After
    @DisplayName("Удаление учетной записи пользователя")
    public void deleteAccount() {
        if (tokenForDel != null) {
            deleteUser();
        }
    }

    @Test
    @DisplayName("Проверка успешной регистрации пользователя, пароль: 6 символов")
    public void successRegistrationPasswordGetSixCharacters() {
        WebDriver driver = driverRule.getDriver();
        RegisterPage.openPage(driver);

        //Создание рандомного пользователя с валидным паролем равным 6 символам.
        //В переменные email и password записаны данные для авторизации.
        RandomUserData randomUserData = RandomUserData.newRandomUser();
        String email = randomUserData.getEmail();
        String password = randomUserData.getPassword();

        //Заполнение формы авторизации
        completionUserData(driver, randomUserData);
        clickButtonRegistration(driver);
        checkSuccessfulRegistration(driver);

        //Авторизация пользователя, получение токена
        getTokenFromLocalStorage(driver, email, password);
    }

    @Test
    @DisplayName("Проверка успешной регистрации пользователя, пароль: 7 символов")
    public void successRegistrationPasswordGetSevenCharacters() {
        WebDriver driver = driverRule.getDriver();
        RegisterPage.openPage(driver);

        RandomUserData randomUserData = RandomUserData.newRandomUserPasswordSevenCharacters();
        String email = randomUserData.getEmail();
        String password = randomUserData.getPassword();

        completionUserData(driver, randomUserData);
        clickButtonRegistration(driver);
        checkSuccessfulRegistration(driver);
        System.out.println(password);

        getTokenFromLocalStorage(driver, email, password);
    }

    @Test
    @DisplayName("Проверка получения ошибки при попытке регистрации аккаунта с 5 символами в поле Password")
    public void errorRegistrationPasswordGetFiveCharacters() {
        WebDriver driver = driverRule.getDriver();
        RegisterPage.openPage(driver);

        RandomUserData randomUserData = RandomUserData.newRandomUserInvalidPasswordFiveCharacters();

        completionUserData(driver, randomUserData);
        checkErrorRegistrationInvalidPassword(driver);

    }
}