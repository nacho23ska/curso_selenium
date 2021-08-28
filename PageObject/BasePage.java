package Prueba_Selenium_Intermedio.PageObject;

import org.openqa.selenium.WebDriver;

public class BasePage {

    public WebDriver driver;

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    public String getPageTittle(){
        return driver.getTitle();
    }

    public void closeDriver(){
        driver.close();
    }

}
