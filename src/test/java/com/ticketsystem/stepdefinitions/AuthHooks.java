package com.ticketsystem.stepdefinitions;

import com.ticketsystem.config.TestConfig;
import com.ticketsystem.stepdefinitions.support.AuthScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.WebDriver;

public class AuthHooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        if (TestConfig.headless()) {
            System.setProperty("headless.mode", "true");
        }
        driver = ThucydidesWebDriverSupport.getDriver();
        driver.manage().window().maximize();

        AuthScenarioContext.initialize(driver);
    }

    @After
    public void tearDown() {
        AuthScenarioContext.clear();
    }
}
