package com.ticketsystem.utils;

public final class Constantes {

    private Constantes() {
    }

    public static final String PROP_BASE_URL = "base.url";
    public static final String PROP_HEADLESS = "headless";
    public static final String PROP_TIMEOUT_SECONDS = "timeout.seconds";
    public static final String DEFAULT_BASE_URL = "http://localhost:3000";
    public static final String DEFAULT_HEADLESS = "false";
    public static final String DEFAULT_TIMEOUT_SECONDS = "15";

    public static final String LOGIN = "/login";
    public static final String REGISTER = "/register";
    public static final String TICKETS = "/tickets";

    public static final String NAVBAR = ".navbar";
    public static final String NAVBAR_USERNAME = ".navbar__username";
    public static final String NAVBAR_LOGOUT = ".navbar__link--logout";
    public static final String NAVBAR_LOGOUT_XPATH = "//button[contains(normalize-space(),'Cerrar Sesion') or contains(normalize-space(),'Cerrar Sesión')]";
    public static final String AUTH_TITLE = ".auth-title";
    public static final String AUTH_ERROR = ".auth-error";
    public static final String SPINNER = ".spinner";
    public static final String BTN_SECONDARY = ".btn-secondary";
    public static final String SUBMIT_BUTTON = "button[type='submit']";
    public static final String INPUT_USERNAME = "username";
    public static final String INPUT_EMAIL = "email";
    public static final String INPUT_PASSWORD = "password";
    public static final String INPUT_CONFIRM_PASSWORD = "confirmPassword";

    public static final String FEATURES_PATH = "src/test/resources/features/autenticacion";
    public static final String GLUE = "com.ticketsystem.stepdefinitions";
    public static final String PLUGIN_PRETTY = "pretty";

    public static final String PROP_QA_LOGIN_EMAIL = "qa.login.email";
    public static final String PROP_QA_LOGIN_PASSWORD = "qa.login.password";
    public static final String PROP_QA_LOGIN_USERNAME = "qa.login.username";
    public static final String DEFAULT_QA_LOGIN_EMAIL = "user@test.com";
    public static final String DEFAULT_QA_LOGIN_PASSWORD = "UserPass1!";
    public static final String DEFAULT_QA_LOGIN_USERNAME = "user";
    public static final String NEW_USER_PREFIX = "testuser_";
    public static final String NEW_USER_EMAIL_DOMAIN = "@test.com";
    public static final String NEW_USER_PASSWORD = "NewUser1!";

    public static final String ARG_HEADLESS_NEW = "--headless=new";
}
