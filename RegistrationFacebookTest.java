import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationFacebookTest {

    @Test
    public void fullRegistrationTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com");
        driver.findElement(By.id("u_0_2")).click();
        Thread.sleep(3000);

        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("reg_email__")).sendKeys("5555555");
        driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");

        WebElement dias = driver.findElement(By.id("day"));
        Select comboboxDias = new Select(dias);
        comboboxDias.selectByValue("26");

        WebElement mes = driver.findElement(By.id("month"));
        Select comboboxMeses = new Select(mes);
        comboboxMeses.selectByVisibleText("jun");

        WebElement año = driver.findElement(By.id("year"));
        Select comboboxAño = new Select(año);
        comboboxAño.selectByValue("1980");

        driver.findElement(By.id("u_1_2")).click();
    }

    public WebDriver getDriver(String unaUrl){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(unaUrl);
        return driver;
    }
}
