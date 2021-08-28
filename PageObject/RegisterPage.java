package Prueba_Selenium_Intermedio.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void CompleteEmailField(String mail){
        driver.findElement(By.id("email")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@type='submit']")).submit();
    }

    public void ValidateMsgError(String msgEsperado){
        WebElement msgError = driver.findElement(By.className("LinkContainer-sc-1t58wcv-0 gUjKMh"));
        Assert.assertEquals(msgError.getText(),msgEsperado);
    }

}
