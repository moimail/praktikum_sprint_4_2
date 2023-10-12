package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Questions  {

     static WebDriver driver;
    //Список вопросов о важном

    //Сколько стоит
    //private static By howMatch = By.xpath(".//div[@id = 'accordion__heading-0']");
   // private static By howMatchText = By.xpath(".//div/p[contains(text(),\"Сутки\")]");

    private  String pathQuest;
    private  String queText;

    // Несколько самокатов

    public Questions(WebDriver driver) {
        this.driver = driver;


    }

    public static void pressQue(String pathQuest) {

        WebElement element = driver.findElement(By.xpath(".//div[@id = 'accordion__heading-"+ pathQuest+"']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public static String getTextQue(String queText) {

        WebElement element = driver.findElement(By.xpath(".//div/p[contains(text(),'"+queText+"')]"));
        element.isDisplayed();
        String text = element.getText();
        return text;
    }


}
