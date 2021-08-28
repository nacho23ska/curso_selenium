package Prueba_Selenium_Intermedio.PageObject;

import Simulacro_Examen_Nivel_Intermedio.PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class PremiumPage extends BasePage {

    public PremiumPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void validarPlanes(String nombrePlan){
        List<WebElement> listaH3s = driver.findElements(By.tagName("h3"));

        boolean plan = false;
        for(WebElement h3s : listaH3s) {
            if (h3s.getText().equals(nombrePlan)) {
                plan = true;
            }
            Assert.assertTrue(plan);
        }
    }

}
