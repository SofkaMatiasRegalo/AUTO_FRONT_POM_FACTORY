package com.ticketsystem.pages;

import com.ticketsystem.utils.Constantes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(css = Constantes.AUTH_TITLE)
    private WebElement pageTitle;

    @FindBy(id = Constantes.INPUT_USERNAME)
    private WebElement usernameInput;

    @FindBy(id = Constantes.INPUT_EMAIL)
    private WebElement emailInput;

    @FindBy(id = Constantes.INPUT_PASSWORD)
    private WebElement passwordInput;

    @FindBy(id = Constantes.INPUT_CONFIRM_PASSWORD)
    private WebElement confirmPasswordInput;

    @FindBy(css = Constantes.SUBMIT_BUTTON)
    private WebElement submitButton;

    @FindBy(css = Constantes.SPINNER)
    private WebElement spinner;

    @FindBy(css = Constantes.AUTH_ERROR)
    private WebElement errorMessage;

    @FindBy(css = Constantes.BTN_SECONDARY)
    private WebElement loginLink;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToRegisterPage(String baseUrl) {
        navigateTo(baseUrl + Constantes.REGISTER);
    }

    public void waitUntilLoaded() {
        waitForUrlToContain(Constantes.REGISTER);
        waitForVisibility(pageTitle);
    }

    public String getPageTitle() {
        waitForVisibility(pageTitle);
        return pageTitle.getText();
    }

    public void fillForm(String username, String email, String password, String confirmPassword) {
        waitForVisibility(usernameInput);
        usernameInput.clear();
        usernameInput.sendKeys(username);
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void submit() {
        waitForClickability(submitButton);
        submitButton.click();
    }

    public void registerAs(String username, String email, String password, String confirmPassword) {
        fillForm(username, email, password, confirmPassword);
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

    public void clickLoginLink() {
        waitForClickability(loginLink);
        loginLink.click();
    }

    public boolean isAtRegisterPage() {
        return currentUrlContains(Constantes.REGISTER);
    }

    public boolean isAtTicketsPage() {
        return currentUrlContains(Constantes.TICKETS);
    }
}
