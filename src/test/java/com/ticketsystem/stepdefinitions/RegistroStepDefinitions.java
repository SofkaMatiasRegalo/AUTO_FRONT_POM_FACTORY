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

public class RegistroStepDefinitions {

    private String baseUrl() {
        return TestConfig.baseUrl();
    }

    @Given("que un usuario accede por primera vez al sistema")
    public void queUnUsuarioAccedePorPrimeraVezAlSistema() {
        AuthScenarioContext context = AuthScenarioContext.get();
        context.getRegisterPage().navigateToRegisterPage(baseUrl());
        context.getRegisterPage().waitUntilLoaded();
    }

    @When("se registra con datos de usuario validos y unicos")
    public void seRegistraConDatosDeUsuarioValidosYUnicos() {
        AuthScenarioContext context = AuthScenarioContext.get();
        TestUsers.NewUser newUser = DataFactory.newUser();
        context.setExpectedUsername(newUser.username);
        context.setLoginCredentials(new TestUsers.Credentials(
                newUser.email,
                newUser.password,
                newUser.username
        ));

        context.getRegisterPage().registerAs(newUser.username, newUser.email, newUser.password, newUser.confirmPassword);
    }

    @Then("su nombre de usuario es visible en la barra de navegacion")
    public void suNombreDeUsuarioEsVisibleEnLaBarraDeNavegacion() {
        AuthScenarioContext context = AuthScenarioContext.get();
        assertTrue(AuthStepTexts.MSG_NAVBAR_MUST_BE_VISIBLE, context.getNavBar().isVisible());
        assertTrue(AuthStepTexts.MSG_USERNAME_MISMATCH, context.getNavBar().hasUsername(context.getExpectedUsername()));
    }
}
