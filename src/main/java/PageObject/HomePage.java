package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    protected WebDriver driver;

    //Верхняя кнопка заказа
    private By topButtonOrder = By.xpath(".//button[@class = 'Button_Button__ra12g']");
    // кнопка статуса заказа
    private By statusOrder = By.xpath(".//button[@class = 'Header_Link__1TAG7']");

    // нижняя кнопка заказ
    private By botomButtonOrder = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");




    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public void pressTopButtonOrder() {

        driver.findElement(topButtonOrder).click();
    }

    public void pressStatusOrder() {

        driver.findElement(statusOrder).click();

    }

    public void pressBottomButtonOrder() {

        WebElement element = driver.findElement(botomButtonOrder);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }


}
