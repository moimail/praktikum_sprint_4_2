package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

    static WebDriver driver;

    private By nameField = By.xpath(".//input[@placeholder = '* Имя']");
    private By lastNameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    private By adressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private By metroField = By.xpath(".//input[@placeholder = '* Станция метро']");
    private By phoneField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[text() = 'Далее']");
    private By cookieButton = By.xpath(".//button[@class = 'App_CookieButton__3cvqF']");
    private By dateField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private By rentalPeriodField = By.xpath(".//div[@class = 'Dropdown-control']");
    private By choiceColor= By.xpath(".//label[1]/input[@class = 'Checkbox_Input__14A2w']");
    private By commentField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");

    private By orderButton = By.xpath(".//button[2][text() = 'Заказать']");
    private By cofirmOrderForm = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']");
    private By yesButton = By.xpath(".//button[2][text() = 'Да']");
    private By noButton = By.xpath(".//button[1][text() = 'Нет']");
    private By orderComleteForm = By.xpath(".//div[1][text() = 'Заказ оформлен']");
    private By seeStatusButton = By.xpath(".//button[text() = 'Посмотреть статус']");
    private By statusOrderPage = By.xpath(".//div[1][text() = 'Самокат на складе']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputName(String name) {

        WebElement element = driver.findElement(nameField);
        element.sendKeys(name);
    }

    public void inputLastName(String lastName) {

        WebElement element = driver.findElement(lastNameField);
        element.sendKeys(lastName);
    }

    public void inputAdress(String adress) {

        WebElement element = driver.findElement(adressField);
        element.sendKeys(adress);
    }

    public void inputMetro(String metro) {

        WebElement element = driver.findElement(metroField);
        element.click();
        driver.findElement(By.xpath(".//*[text()='" + metro + "']")).click();

    }

    public void inputPhone(String phone) {

        WebElement element = driver.findElement(phoneField);
        element.sendKeys(phone);
    }

    public void clickNext() {

        WebElement element = driver.findElement(nextButton);
        element.click();
    }
    public void clickCookie() {

        WebElement element = driver.findElement(cookieButton);
        element.click();
    }

    public void waitSecondPageOrder() {

        WebElement element = driver.findElement(dateField);
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(dateField));
    }
    public void inputDate(String date) {

        WebElement element = driver.findElement(dateField);
        element.sendKeys(date);
        driver.findElement(By.xpath(".//div[3][@class='react-datepicker__day react-datepicker__day--001 react-datepicker__day--selected']")).click();
    }

    public void inputRenatalPeriod(String period) {

        WebElement element = driver.findElement(rentalPeriodField);
        element.click();
        driver.findElement(By.xpath(".//*[text()='" + period + "']")).click();
    }

    public void clickChoiceColor() {

        WebElement element = driver.findElement(choiceColor);
        element.click();

    }

    public void inputComment(String comment) {

        WebElement element = driver.findElement(commentField);
        element.sendKeys(comment);


    }

    public void clickOrderButton() {

        WebElement element = driver.findElement(orderButton);
        element.click();

    }

    public void waitConfirmOrderForm() {

        WebElement element = driver.findElement(cofirmOrderForm);
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(cofirmOrderForm));
    }

    public void clickYesButton() {

        WebElement element = driver.findElement(yesButton);
        element.click();
    }
    public void clickNoButton() {

        WebElement element = driver.findElement(noButton);
        element.click();
    }
    public void waitOrderComleteForm() {

        WebElement element = driver.findElement(orderComleteForm);
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(orderComleteForm));
    }

    public void clickSeeStatusButton() {

        WebElement element = driver.findElement(seeStatusButton);
        element.click();
    }
    public void waitStatusOrderPage() {

        WebElement element = driver.findElement(statusOrderPage);
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(statusOrderPage));
    }
}
