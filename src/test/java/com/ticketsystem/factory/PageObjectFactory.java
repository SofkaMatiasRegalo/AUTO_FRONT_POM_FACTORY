package com.ticketsystem.factory;

import com.ticketsystem.pages.LoginPage;
import com.ticketsystem.pages.NavBarComponent;
import com.ticketsystem.pages.RegisterPage;
import com.ticketsystem.pages.TicketListPage;
import org.openqa.selenium.WebDriver;

public class PageObjectFactory {

    private final LoginPage loginPage;
    private final RegisterPage registerPage;
    private final NavBarComponent navBar;
    private final TicketListPage ticketListPage;

    public PageObjectFactory(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
        this.registerPage = new RegisterPage(driver);
        this.navBar = new NavBarComponent(driver);
        this.ticketListPage = new TicketListPage(driver);
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
}
