package ExamenNivelInicial;

import Simulacro_Examen.DataGenerator;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class prueba_mailchimp {

    String URL = "https://login.mailchimp.com/";
    WebDriver driver;

    @BeforeTest
    public void setBaseUrl(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void aceptarCookies() throws InterruptedException {
        Thread.sleep(2000);
        WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookies.click();
        Thread.sleep(2000);
    }

    @Test (priority = 0)
    public void validarTituloTest() throws InterruptedException{
        aceptarCookies();

        String actualTittle = driver.getTitle();
        String expectedTitlle = "Login | Mailchimp";
        Assert.assertEquals(actualTittle,expectedTitlle);
    }

    @Test (priority = 1)
    public void iniciarSesionPageTest() throws InterruptedException{
        aceptarCookies();

        WebElement existText = driver.findElement(By.xpath("//span[contains(text(),'Need a Mailchimp account?')]"));
        Assert.assertEquals(existText.getText(),"Need a Mailchimp account?");

    }

    @Test (priority = 2)
    public void loginErrorTest() throws InterruptedException{
        aceptarCookies();

        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("XXXXX@gmail.com");

        WebElement loginButton = driver.findElement(By.xpath("//*[@value='log in']"));
        loginButton.click();

        WebElement errorMsgLogin = driver.findElement(By.xpath("//*[contains(text(),'forgot your password')]"));
        String expectedError = "Looks like you forgot your password there, XXXXX@gmail.com.";

        Assert.assertEquals(errorMsgLogin.getText(),expectedError);

        WebElement checkbox = driver.findElement(By.id("stay-signed-in"));
        Assert.assertFalse(checkbox.isSelected());

    }

    @Test (priority = 3)
    public void fakeEmailTest() throws InterruptedException{
        aceptarCookies();
        driver.navigate().to("https://login.mailchimp.com/signup/");

        Faker faker = new Faker();

        WebElement emailRegister = driver.findElement(By.id("email"));
        emailRegister.sendKeys(faker.internet().emailAddress());
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"));

    }

    @Test (dataProvider = "emails", dataProviderClass = DataGenerator.class, priority = 4)
    public void dataProviderEmailTest(String anEmail, String aPass) throws InterruptedException {
        aceptarCookies();

        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys(anEmail);
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys(aPass);
        WebElement loginButton = driver.findElement(By.xpath("//*[@value='log in']"));
        loginButton.click();

        WebElement errorMsgLogin = driver.findElement(By.xpath("//*[contains(text(),'we couldn't find an account')]"));
        String expectedError = "\n" +
                "                    Sorry, we couldn't find an account with that username. Can we help you recover your ";
        Assert.assertEquals(errorMsgLogin.getText(),expectedError);

    }

    @AfterTest
    public void closeDriver(){
        System.out.println("Test finalizado");
        driver.close();
    }

}
