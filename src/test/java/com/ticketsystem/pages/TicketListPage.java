package com.ticketsystem.pages;

import com.ticketsystem.utils.Constantes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TicketListPage extends BasePage {

    @FindBy(css = Constantes.NAVBAR)
    private WebElement navBar;

    public TicketListPage(WebDriver driver) {
        super(driver);
    }

    public void waitUntilLoaded() {
        waitForUrlToContain(Constantes.TICKETS);
        waitForVisibility(navBar);
    }

    public boolean isAtTicketsPage() {
        return currentUrlContains(Constantes.TICKETS);
    }
}
