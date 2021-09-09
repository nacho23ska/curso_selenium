package Prueba_Selenium_Intermedio.PageObject;

import Simulacro_Examen_Nivel_Intermedio.PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SpotifyPage extends BasePage {

    public SpotifyPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void goToSpotify(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public PremiumPage goToPremiumPage(){
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/premium/']")).click();
        PremiumPage nextPage = new PremiumPage(driver);
        return nextPage;
    }

    public RegisterPage goToRegisterPage(){
        String actualTittle = driver.getTitle();
        System.out.println(actualTittle);
        if(actualTittle.equals("Spotify – Reproductor web")) {
            driver.findElement(By.xpath("//*[@type='button']")).click();
        }
        else if(actualTittle.equals("Escuchar es todo - Spotify")){
            driver.findElement(By.xpath("//*[@href='https://www.spotify.com/uy/signup/']")).click();
        }
        RegisterPage nextPage = new RegisterPage(driver);
        return nextPage;
    }

    public AgreementPage goToAgreementPage(){
        driver.navigate().to("https://www.spotify.com/uy/legal/end-user-agreement/");
        AgreementPage nextPage = new AgreementPage(driver);
        return nextPage;
    }

}
