package Simulacro_Examen_Nivel_Intermedio.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindPlacePage extends BasePage{

    public FindPlacePage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void goToAirbnb(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.airbnb.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@data-testid='accept-btn']")).click();
    }

    public void buscarEn(String place){
        driver.findElement(By.xpath("//*[@placeholder='¿A dónde vas?']")).sendKeys(place);
    }

    public void completoCalendario(){
        WebElement calendario = driver.findElement(By.xpath("//div[@data-testid='structured-search-input-field-split-dates-0']/div/div[1]"));
        calendario.click();

        WebElement fechaInicio = driver.findElement(By.xpath("//*[@data-testid='datepicker-day-2021-09-03']"));
        fechaInicio.click();

        WebElement fechaFin = driver.findElement(By.xpath("//*[@data-testid='datepicker-day-2021-09-16']"));
        fechaFin.click();
    }

    public void seleccionoHuespedes(){
        WebElement huespedes = driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-guests-button']"));
        huespedes.click();

        WebElement aumentarAdultosBtn = driver.findElement(By.xpath("(//*[@aria-label='aumentar valor'])[1]"));
        aumentarAdultosBtn.click();
        aumentarAdultosBtn.click();
    }

    public ShowStaysPage clickBuscarBtn(){
        WebElement buscarBtn = driver.findElement(By.xpath("//*[@data-testid='structured-search-input-search-button']"));
        buscarBtn.click();
        ShowStaysPage nextPage = new ShowStaysPage(driver);
        return nextPage;
    }

    public void experienceClick(){
        driver.findElement(By.xpath("//*[contains(text(),'Experiencias')]")).click();
    }

    public void completoCalendarioSimple(){
        WebElement calendario = driver.findElement(By.xpath("//div[@data-testid='structured-search-input-field-dates-button']"));
        calendario.click();

        WebElement fechaInicio = driver.findElement(By.xpath("//*[@data-testid='datepicker-day-2021-09-03']"));
        fechaInicio.click();
    }

    public void nearbyPlaces(){
        List<WebElement> nearPlacesList = driver.findElements(By.className("_wy1hs1"));
        System.out.println("Listado de lugares cercanos:");
        for(WebElement nearPlace : nearPlacesList){
            System.out.println("--> " + nearPlace.getText());
        }
    }
}
