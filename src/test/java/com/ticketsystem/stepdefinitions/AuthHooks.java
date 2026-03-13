package com.ticketsystem.stepdefinitions;

import com.ticketsystem.config.TestConfig;
import com.ticketsystem.stepdefinitions.support.AuthScenarioContext;
import com.ticketsystem.utils.Constantes;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AuthHooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        if (TestConfig.headless()) {
            options.addArguments(Constantes.ARG_HEADLESS_NEW);
        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        AuthScenarioContext.initialize(driver);
    }

    @After
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } finally {
            AuthScenarioContext.clear();
        }
    }
}
