package Prueba_Selenium_Intermedio.Steps;

import Prueba_Selenium_Intermedio.PageObject.AgreementPage;
import Prueba_Selenium_Intermedio.PageObject.SpotifyPage;
import Prueba_Selenium_Intermedio.PageObject.PremiumPage;
import Prueba_Selenium_Intermedio.PageObject.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class SpotifySteps {

    WebDriver driver;
    protected SpotifyPage spotifyPage;
    protected PremiumPage premiumPage;
    protected RegisterPage registerPage;
    protected AgreementPage agreementPage;

    @Given("estoy en la pagina de Spotify")
    public void estoyEnLaPaginaDeSpotify() {
        spotifyPage = new SpotifyPage(driver);
        spotifyPage.goToSpotify();
    }

    @When("me encuentro en la seccion Premium")
    public void meEncuentroEnLaSeccionPremium() {
        premiumPage = spotifyPage.goToPremiumPage();
    }

    @Then("valido que se encuentre el plan individual")
    public void valido_que_se_encuentre_el_plan_individual(String nombrePlan) {
        premiumPage.validarPlanes(nombrePlan);
    }

    @Then("valido que se encuentre el plan premium")
    public void valido_que_se_encuentre_el_plan_premium(String nombrePlan) {
        premiumPage.validarPlanes(nombrePlan);
    }

    @Then("valido que se encuentre el plan familiar")
    public void valido_que_se_encuentre_el_plan_familiar(String nombrePlan) {
        premiumPage.validarPlanes(nombrePlan);
    }

    @When("accedo a la pagina de registro")
    public void accedo_a_la_pagina_de_registro() {
        registerPage = spotifyPage.goToRegisterPage();
    }

    @When("completo el campo mail con vecio")
    public void completo_el_campo_mail_con_vecio(String mail) {
        registerPage.CompleteEmailField(mail);
    }

    @Then("se muestra el mensaje Es necesario que introduzcas tu correo electrónico.")
    public void se_muestra_el_mensaje_es_necesario_que_introduzcas_tu_correo_electrónico(String msgEsperado) {
        registerPage.ValidateMsgError(msgEsperado);
    }

    @When("completo el campo mail con ffff")
    public void completo_el_campo_mail_con_ffff(String mail) {
        registerPage.CompleteEmailField(mail);
    }

    @Then("se muestra el mensaje Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com")
    public void se_muestra_el_mensaje_este_correo_electrónico_no_es_válido_asegúrate_de_que_tenga_un_formato_como_este_ejemplo_email_com(String msgEsperado) {
        registerPage.ValidateMsgError(msgEsperado);
    }

    @When("completo el campo mail con test@test.com")
    public void completo_el_campo_mail_con_test_test_com(String mail) {
        registerPage.CompleteEmailField(mail);
    }

    @Then("se muestra el mensaje Este correo electrónico ya está conectado a una cuenta. Inicia sesión.")
    public void se_muestra_el_mensaje_este_correo_electrónico_ya_está_conectado_a_una_cuenta_inicia_sesión(String msgEsperado) {
        registerPage.ValidateMsgError(msgEsperado);
    }

    @Given("ingreso a terminos y condiciones")
    public void ingresoATerminosYCondiciones() {
        agreementPage = spotifyPage.goToAgreementPage();
    }

    @Then("valido que se encuentre el link Disfrutando Spotify")
    public void valido_que_se_encuentre_el_link_disfrutando_spotify(String linkEsperado) {
        agreementPage.ValidoLink(linkEsperado);
    }

    @Then("valido que se encuentre el link Pagos, cancelaciones y periodo de reflexión")
    public void valido_que_se_encuentre_el_link_pagos_cancelaciones_y_periodo_de_reflexión(String linkEsperado) {
        agreementPage.ValidoLink(linkEsperado);
    }

    @Then("valido que se encuentre el link Uso de nuestro servicio")
    public void valido_que_se_encuentre_el_link_uso_de_nuestro_servicio(String linkEsperado) {
        agreementPage.ValidoLink(linkEsperado);
    }
}
