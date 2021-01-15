import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SpotifyByPlaceHolder {

    @Test
    public void spotifyByPlaceHolder() {
        WebDriver driver = getDriver("https://www.spotify.com/uy/signup/");
        driver.findElement(By.cssSelector("[placeholder='Introduce tu correo electrónico.']")).sendKeys("prueba@test.com");
        driver.findElement(By.cssSelector("[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("prueba@test.com");
        driver.findElement(By.cssSelector("[placeholder='Crea una contraseña.']")).sendKeys("prueba1234");
        driver.findElement(By.cssSelector("[placeholder='Introduce un nombre de perfil.']")).sendKeys("prueba_test");
        driver.findElement(By.cssSelector("[placeholder='DD']")).sendKeys("30");
        WebElement mes = driver.findElement(By.cssSelector("[name='month']"));
        Select comboboxMeses = new Select(mes);
        comboboxMeses.selectByValue("12");
        driver.findElement(By.cssSelector("[placeholder='AAAA']")).sendKeys("2000");

    }

    public WebDriver getDriver(String unaUrl){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(unaUrl);
        return driver;
    }
}
