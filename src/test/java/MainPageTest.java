import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.praktikum.MainPage;
import static ru.praktikum.MainPage.*;


public class MainPageTest {


    @Rule
    public DriverRule driverRule = new DriverRule();


    @Test
    @DisplayName("Проверка перехода к разделу \"Соусы\" в конструкторе бургера на главной странице продукта")
    public void switchSauceTabs() {
        WebDriver driver = driverRule.getDriver();
        MainPage.openURL(driver);

        clickSauceTab(driver);
        checkSauceTabIsEnable(driver);
    }

    @Test
    @DisplayName("Проверка перехода к разделу \"Начинки\" в конструкторе бургера на главной странице продукта")
    public void switchFillingTabs() {
        WebDriver driver = driverRule.getDriver();
        MainPage.openURL(driver);

        clickFillingTab(driver);
        checkFillingTabIsEnable(driver);
    }

    //Для составления теста на проверку перехода к разделу "Булки" необходимо кликнуть на другой раздел,
    //потом перейти в проверяемый раздел. Т.к. раздел "Булки" активен в стартовом состоянии страницы
    @Test
    @DisplayName("Проверка перехода к разделу \"Булки\" в конструкторе бургера на главной странице продукта")
    public void switchBunTabs() {
        WebDriver driver = driverRule.getDriver();
        MainPage.openURL(driver);

        clickFillingTab(driver);
        checkFillingTabIsEnable(driver);

        clickBunTab(driver);
        checkBunTabIsEnable(driver);
    }



}