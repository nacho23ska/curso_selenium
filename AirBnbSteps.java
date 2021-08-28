package Simulacro_Examen_Nivel_Intermedio;

import Simulacro_Examen_Nivel_Intermedio.PageObject.FindPlacePage;
import Simulacro_Examen_Nivel_Intermedio.PageObject.ShowStaysPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AirBnbSteps {

    WebDriver driver;
    protected FindPlacePage findPlacePage;
    protected ShowStaysPage showStaysPage;

    @Given("accedo a la pagina de AirBnb")
    public void accedoALaPaginaDeAirBnb() {
        findPlacePage = new FindPlacePage(driver);
        findPlacePage.goToAirbnb();
    }

    @When("completo el Bariloche de destino")
    public void completo_el_bariloche_de_destino() {
        findPlacePage.buscarEn("Bariloche");
    }

    @When("completo el Cataratas de destino")
    public void completo_el_cataratas_de_destino() {
        findPlacePage.buscarEn("Cataratas");
    }

    @When("completo el Mendoza de destino")
    public void completo_el_mendoza_de_destino() {
        findPlacePage.buscarEn("Mendoza");
    }

    @When("elijo la fecha y selecciono la cantidad de adultos")
    public void elijo_la_fecha_y_selecciono_la_cantidad_de_adultos() {
        findPlacePage.completoCalendario();
        findPlacePage.seleccionoHuespedes();
        showStaysPage = findPlacePage.clickBuscarBtn();
    }

    @Then("valido el Bariloche")
    public void valido_el_bariloche() {
        showStaysPage.validarDestino("Bariloche");
    }

    @Then("valido el Cataratas")
    public void valido_el_cataratas() {
        showStaysPage.validarDestino("Cataratas");
    }

    @Then("valido el Mendoza")
    public void valido_el_mendoza() {
        showStaysPage.validarDestino("Mendoza");
    }

    @Then("la cantidad de huespedes")
    public void la_cantidad_de_huespedes() {
        showStaysPage.validoHuespedes();
        showStaysPage.closeDriver();
    }

    @When("selecciono la opcion Experiencias")
    public void seleccionoLaOpcionExperiencias() {
        findPlacePage.experienceClick();
    }

    @When("elijo destino y fecha y valido los datos")
    public void elijo_destino_y_fecha_y_valido_los_datos() {
        findPlacePage.buscarEn("Roma");
        findPlacePage.completoCalendarioSimple();
    }

    @Then("hago la busqueda y valido los datos")
    public void hago_la_busqueda_y_valido_los_datos() {
        showStaysPage = findPlacePage.clickBuscarBtn();
        showStaysPage.validoBuscarExperiencias();
        showStaysPage.closeDriver();
    }

    @Then("muestro la lista de lugares cercanos")
    public void muestroLaListaDeLugaresCercanos() {
        findPlacePage.nearbyPlaces();
        findPlacePage.closeDriver();
    }
}
