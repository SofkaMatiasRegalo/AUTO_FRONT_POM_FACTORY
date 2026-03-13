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

public class LoginStepDefinitions {

    private String baseUrl() {
        return TestConfig.baseUrl();
    }

    @Given("que un usuario no tiene sesion activa")
    public void queUnUsuarioNoTieneSesionActiva() {
        AuthScenarioContext context = AuthScenarioContext.get();
        context.getLoginPage().navigateToLoginPage(baseUrl());
        context.getLoginPage().waitUntilLoaded();
    }

    @When("inicia sesion con credenciales validas")
    public void iniciaSesionConCredencialesValidas() {
        AuthScenarioContext context = AuthScenarioContext.get();
        TestUsers.Credentials credentials = DataFactory.validLogin();
        context.setExpectedUsername(credentials.username);

        context.getLoginPage().loginAs(credentials.email, credentials.password);
    }

    @Then("es redirigido al listado de tickets")
    public void esRedirigidoAlListadoDeTickets() {
        AuthScenarioContext context = AuthScenarioContext.get();
        context.getTicketListPage().waitUntilLoaded();
        assertTrue(
                AuthStepTexts.MSG_URL_MUST_CONTAIN_TICKETS,
                context.getTicketListPage().isAtTicketsPage()
        );
    }

    @Then("el nombre del usuario es visible en la barra de navegacion")
    public void elNombreDelUsuarioEsVisibleEnLaBarraDeNavegacion() {
        AuthScenarioContext context = AuthScenarioContext.get();
        assertTrue(AuthStepTexts.MSG_NAVBAR_MUST_BE_VISIBLE, context.getNavBar().isVisible());
        assertTrue(AuthStepTexts.MSG_USERNAME_MISMATCH, context.getNavBar().hasUsername(context.getExpectedUsername()));
    }
}
