package com.ticketsystem.pages;

import com.ticketsystem.utils.Constantes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = Constantes.AUTH_TITLE)
    private WebElement pageTitle;

    @FindBy(id = Constantes.INPUT_EMAIL)
    private WebElement emailInput;

    @FindBy(id = Constantes.INPUT_PASSWORD)
    private WebElement passwordInput;

    @FindBy(css = Constantes.SUBMIT_BUTTON)
    private WebElement submitButton;

    @FindBy(css = Constantes.AUTH_ERROR)
    private WebElement errorMessage;

    @FindBy(css = Constantes.SPINNER)
    private WebElement spinner;

    @FindBy(css = Constantes.BTN_SECONDARY)
    private WebElement registerLink;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLoginPage(String baseUrl) {
        navigateTo(baseUrl + Constantes.LOGIN);
    }

    public void waitUntilLoaded() {
        waitForUrlToContain(Constantes.LOGIN);
        waitForVisibility(pageTitle);
    }

    public String getPageTitle() {
        waitForVisibility(pageTitle);
        return pageTitle.getText();
    }

    public void fillForm(String email, String password) {
        waitForVisibility(emailInput);
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void submit() {
        waitForClickability(submitButton);
        submitButton.click();
    }

    public void loginAs(String email, String password) {
        fillForm(email, password);
        submit();
    }

    public void waitForSpinnerToDisappear() {
        waitForInvisibility(spinner);
    }

    public void waitForRedirectToTickets() {
        waitForUrlToContain(Constantes.TICKETS);
    }

    public String getErrorText() {
        waitForVisibility(errorMessage);
        return errorMessage.getText();
    }

    public boolean isErrorVisible() {
        return isVisible(errorMessage);
    }

    public boolean isSubmitButtonEnabled() {
        waitForVisibility(submitButton);
        return submitButton.isEnabled();
    }

    public void clickRegisterLink() {
        waitForClickability(registerLink);
        registerLink.click();
    }

    public boolean isAtLoginPage() {
        return currentUrlContains(Constantes.LOGIN);
    }

    public boolean isAtTicketsPage() {
        return currentUrlContains(Constantes.TICKETS);
    }
}
