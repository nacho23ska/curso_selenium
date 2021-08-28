package Simulacro_Examen_Nivel_Intermedio.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ShowStaysPage extends BasePage{

    public ShowStaysPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void validarDestino(String place){
        Assert.assertTrue(driver.getCurrentUrl().contains(place));
    }

    public void validoHuespedes(){
        List<WebElement> cantidadHuespedesMsgList = driver.findElements(By.xpath("//*[contains(text(),'2 huéspedes')]"));
        Assert.assertNotEquals(cantidadHuespedesMsgList.size(), 0);
        Assert.assertNotNull(cantidadHuespedesMsgList);
    }

    public void validoBuscarExperiencias(){
        Assert.assertTrue(driver.getCurrentUrl().contains("Roma"));
        List<WebElement> cantidadHuespedesMsgList = driver.findElements(By.xpath("//*[contains(text(),'3 sep.')]"));
        Assert.assertNotEquals(cantidadHuespedesMsgList.size(), 0);
        Assert.assertNotNull(cantidadHuespedesMsgList);
    }

}
