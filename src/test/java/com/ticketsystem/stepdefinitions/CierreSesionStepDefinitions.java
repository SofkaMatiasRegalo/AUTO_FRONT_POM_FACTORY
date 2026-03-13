package com.ticketsystem.stepdefinitions;

import com.ticketsystem.config.TestConfig;
import com.ticketsystem.data.TestUsers;
import com.ticketsystem.stepdefinitions.support.AuthScenarioContext;
import com.ticketsystem.stepdefinitions.support.AuthStepTexts;
import com.ticketsystem.utils.DataFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;

public class CierreSesionStepDefinitions {

    private String baseUrl() {
        return TestConfig.baseUrl();
    }

    @Given("que un usuario tiene una sesion activa")
    public void queUnUsuarioTieneUnaSesionActiva() {
        AuthScenarioContext context = AuthScenarioContext.get();
        TestUsers.Credentials credentials = DataFactory.validLogin();
        context.setExpectedUsername(credentials.username);

        context.getLoginPage().navigateToLoginPage(baseUrl());
        context.getLoginPage().waitUntilLoaded();
        context.getLoginPage().loginAs(credentials.email, credentials.password);

        context.getTicketListPage().waitUntilLoaded();
        assertTrue(AuthStepTexts.MSG_USER_MUST_BE_AUTHENTICATED, context.getNavBar().isVisible());
    }

    @When("cierra su sesion desde la barra de navegacion")
    public void cierraSuSesionDesdeLaBarraDeNavegacion() {
        AuthScenarioContext context = AuthScenarioContext.get();
        context.getNavBar().logout();
    }

    @Then("es redirigido a la pantalla de inicio de sesion")
    public void esRedirigidoALaPantallaDeInicioDeSesion() {
        AuthScenarioContext context = AuthScenarioContext.get();
        context.getLoginPage().waitUntilLoaded();
        assertTrue(
                AuthStepTexts.MSG_URL_MUST_CONTAIN_LOGIN,
                context.getLoginPage().isAtLoginPage()
        );
    }
}
