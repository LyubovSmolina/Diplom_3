import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.praktikum.Pages.LogInPage;
import ru.praktikum.UserData.RandomUserData;
import ru.praktikum.UserData.RandomUserDataApi;


import static io.restassured.RestAssured.baseURI;
import static ru.praktikum.UserData.RandomUserDataApi.checkCreatedUser;


public class LoginAndLogOutTest extends LogInPage {
    @Rule
    public DriverRule driverRule = new DriverRule();


    @Before
    public void setUp() {
      baseURI = "https://stellarburgers.nomoreparties.site/";

    }

    //При успешном создании пользователя аккаунт удаляется через API
    @After
    @DisplayName("Удаление учетной записи пользователя")
    public void deleteAccount() {
        if (tokenForDel != null) {
            deleteUser();
        }
    }

    @Test
    @DisplayName("Проверка авторизации пользователя по кнопке \"Войти в аккаунт\" на главной странице продукта")
    public void successLoginFromHomePage() {

        RandomUserData randomUser = RandomUserData.newRandomUser();
        Response response = RandomUserDataApi.apiCreateNewUser(RandomUserDataApi.from(randomUser));
        checkCreatedUser(response);
        String email = randomUser.getEmail();
        String password = randomUser.getPassword();

        WebDriver driver = driverRule.getDriver();

        logInAccountButtonOnMainPage(driver, email, password);
    }

    @Test
    @DisplayName("Проверка авторизации пользователя по ссылке на \"Личный кабинет\" из хедера страницы")
    public void successLoginFromLinkInHeader() {

        RandomUserData randomUser = RandomUserData.newRandomUser();
        Response response = RandomUserDataApi.apiCreateNewUser(RandomUserDataApi.from(randomUser));
        checkCreatedUser(response);
        String email = randomUser.getEmail();
        String password = randomUser.getPassword();

        WebDriver driver = driverRule.getDriver();

        logInFromHeaderLink(driver, email, password);
    }

    @Test
    @DisplayName("Проверка авторизации пользователя по ссылке восстановления пароля")
    public void successLoginFromRefreshPasswordPage() {

        RandomUserData randomUser = RandomUserData.newRandomUser();
        Response response = RandomUserDataApi.apiCreateNewUser(RandomUserDataApi.from(randomUser));
        checkCreatedUser(response);
        String email = randomUser.getEmail();
        String password = randomUser.getPassword();

        WebDriver driver = driverRule.getDriver();

        logInFromRefreshPasswordPage(driver, email, password);
    }

    @Test
    @DisplayName("Проверка выхода из аккаунта")
    public void successLogOut () {

        RandomUserData randomUser = RandomUserData.newRandomUser();
        Response response = RandomUserDataApi.apiCreateNewUser(RandomUserDataApi.from(randomUser));
        checkCreatedUser(response);
        String email = randomUser.getEmail();
        String password = randomUser.getPassword();

        WebDriver driver = driverRule.getDriver();

        driver.get("https://stellarburgers.nomoreparties.site/login");

        authByLinkAndGetTokenFromLocalStorage(driver, email, password);
        clickLogoutButtonAndCheckIt(driver);
    }
}
