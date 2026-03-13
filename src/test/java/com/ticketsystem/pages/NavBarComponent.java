package com.ticketsystem.pages;

import com.ticketsystem.utils.Constantes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class NavBarComponent extends BasePage {

    @FindBy(css = Constantes.NAVBAR)
    private WebElement navBar;

    @FindBy(css = Constantes.NAVBAR_USERNAME)
    private WebElement usernameDisplay;

    @FindAll({
            @FindBy(css = Constantes.NAVBAR_LOGOUT),
            @FindBy(xpath = Constantes.NAVBAR_LOGOUT_XPATH)
    })
    private WebElement logoutButton;

    public NavBarComponent(WebDriver driver) {
        super(driver);
    }

    public boolean isVisible() {
        return isVisible(navBar);
    }

    public String getUsernameText() {
        waitForVisibility(usernameDisplay);
        return usernameDisplay.getText();
    }

    public boolean hasUsername(String expectedUsername) {
        return getUsernameText().contains(expectedUsername);
    }

    public void logout() {
        waitForClickability(logoutButton);
        logoutButton.click();
    }
}
