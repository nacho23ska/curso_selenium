package Prueba_Selenium_Intermedio.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AgreementPage extends BasePage {

    public AgreementPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void ValidoLink(String linkEsperado){
        List<WebElement> linkList = driver.findElements(By.tagName("a"));

        boolean linkText = false;
        for(WebElement link : linkList){
            if(link.getText().equals(linkEsperado)){
                linkText = true;
            }
            Assert.assertTrue(linkText);
        }
    }

}
