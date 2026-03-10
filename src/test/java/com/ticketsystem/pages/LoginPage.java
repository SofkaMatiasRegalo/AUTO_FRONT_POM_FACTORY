package com.ticketsystem.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private static final String PAGE_PATH = "/login";

    @CacheLookup
    @FindBy(css = ".auth-title")
    private WebElement pageTitle;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".auth-error")
    private WebElement errorMessage;

    @FindBy(css = ".spinner")
    private WebElement spinner;

    @FindBy(css = ".btn-secondary")
    private WebElement registerLink;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLoginPage(String baseUrl) {
        navigateTo(baseUrl + PAGE_PATH);
    }

    public String getPageTitle() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }

    public void fillForm(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public void waitForRedirectToTickets() {
        waitForUrlToContain("/tickets");
    }

    public String getErrorText() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public boolean isErrorVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isSubmitButtonEnabled() {
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        return submitButton.isEnabled();
    }

    public void clickRegisterLink() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }
}
