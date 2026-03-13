package com.ticketsystem.pages;

import com.ticketsystem.config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(TestConfig.timeoutSeconds()));
        PageFactory.initElements(driver, this);
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }

    protected void waitForUrlToContain(String partialUrl) {
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForClickability(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected boolean isVisible(WebElement element) {
        try {
            waitForVisibility(element);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected boolean currentUrlContains(String partialUrl) {
        return getCurrentUrl().contains(partialUrl);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
