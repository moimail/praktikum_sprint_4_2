import PageObject.HomePage;
import PageObject.OrderPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest {

    private final String name;
    private final String lastName;
    private final String city;
    private final String metro;
    private final String phone;
    protected WebDriver driver;

    public OrderTest(String name, String lastName, String city, String metro, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        this.metro = metro;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Object[][] getQue() {
        //Сгенерируй тестовые данные (нам нужно название городов и результат поиска)
        return new Object[][]{
                {"Василий", "Петров","Москва","Черкизовская","+79515553344"},
                {"Иван", "Петров","Москва","Сокольники","+79517775544"}


        };
    }

    @Test
    public void checkOrderTopButton() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //Открытие главной страницы и открытие формы заказа
        HomePage HomePage = new HomePage(driver);

        HomePage.pressTopButtonOrder();

        OrderPage OrderPage = new OrderPage(driver);

        //Согласится с куки
        OrderPage.clickCookie();
        //Заполнение имени
        OrderPage.inputName(name);
        OrderPage.inputLastName(lastName);
        OrderPage.inputAdress(city);
        OrderPage.inputMetro(metro);
        OrderPage.inputPhone(phone);
        OrderPage.clickNext();
        OrderPage.waitSecondPageOrder();
        OrderPage.inputDate("01.11.2023");
        OrderPage.inputRenatalPeriod("четверо суток");
        OrderPage.clickChoiceColor();
        OrderPage.inputComment("_Тест");
        OrderPage.clickOrderButton();
        OrderPage.waitConfirmOrderForm();
        //Кнопка с ошибкой хром
        //OrderPage.clickYesButton();
        OrderPage.clickNoButton();

        driver.quit();
        //Оформление через верхнюю кнопку



    }

    @Test
    public void checkOrderBottomButton() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //Открытие главной страницы и открытие формы заказа
        HomePage HomePage = new HomePage(driver);
        OrderPage OrderPage = new OrderPage(driver);
        //Согласится с куки
        OrderPage.clickCookie();
        HomePage.pressBottomButtonOrder();



        //Заполнение имени
        OrderPage.inputName(name);
        OrderPage.inputLastName(lastName);
        OrderPage.inputAdress(city);
        OrderPage.inputMetro(metro);
        OrderPage.inputPhone(phone);
        OrderPage.clickNext();
        OrderPage.waitSecondPageOrder();
        OrderPage.inputDate("01.11.2023");
        OrderPage.inputRenatalPeriod("четверо суток");
        OrderPage.clickChoiceColor();
        OrderPage.inputComment("_Тест");
        OrderPage.clickOrderButton();
        OrderPage.waitConfirmOrderForm();

        OrderPage.clickYesButton();
        OrderPage.waitOrderComleteForm();
        OrderPage.clickSeeStatusButton();
        OrderPage.waitStatusOrderPage();

        driver.quit();


    }

}
