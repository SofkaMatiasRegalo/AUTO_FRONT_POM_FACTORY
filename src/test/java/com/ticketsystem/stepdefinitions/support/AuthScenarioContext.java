package com.ticketsystem.stepdefinitions.support;

import com.ticketsystem.factory.PageObjectFactory;
import com.ticketsystem.pages.LoginPage;
import com.ticketsystem.pages.NavBarComponent;
import com.ticketsystem.pages.RegisterPage;
import com.ticketsystem.pages.TicketListPage;
import org.openqa.selenium.WebDriver;

public final class AuthScenarioContext {

    private static final ThreadLocal<AuthScenarioContext> CURRENT = new ThreadLocal<>();

    private LoginPage loginPage;
    private RegisterPage registerPage;
    private NavBarComponent navBar;
    private TicketListPage ticketListPage;
    private String expectedUsername;

    private AuthScenarioContext() {
    }

    public static void initialize(WebDriver driver) {
        AuthScenarioContext context = new AuthScenarioContext();

        PageObjectFactory pageFactory = new PageObjectFactory(driver);
        context.loginPage = pageFactory.getLoginPage();
        context.registerPage = pageFactory.getRegisterPage();
        context.navBar = pageFactory.getNavBar();
        context.ticketListPage = pageFactory.getTicketListPage();

        CURRENT.set(context);
    }

    public static AuthScenarioContext get() {
        AuthScenarioContext context = CURRENT.get();
        if (context == null) {
            throw new IllegalStateException("AuthScenarioContext no inicializado. Verifica hooks @Before.");
        }
        return context;
    }

    public static void clear() {
        CURRENT.remove();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public RegisterPage getRegisterPage() {
        return registerPage;
    }

    public NavBarComponent getNavBar() {
        return navBar;
    }

    public TicketListPage getTicketListPage() {
        return ticketListPage;
    }

    public String getExpectedUsername() {
        return expectedUsername;
    }

    public void setExpectedUsername(String expectedUsername) {
        this.expectedUsername = expectedUsername;
    }
}
