package com.ticketsystem.config;

import com.ticketsystem.utils.Constantes;

public final class TestConfig {

    private TestConfig() {
    }

    public static String baseUrl() {
        return System.getProperty(Constantes.PROP_BASE_URL, Constantes.DEFAULT_BASE_URL);
    }

    public static boolean headless() {
        return Boolean.parseBoolean(System.getProperty(Constantes.PROP_HEADLESS, Constantes.DEFAULT_HEADLESS));
    }

    public static int timeoutSeconds() {
        return Integer.parseInt(System.getProperty(Constantes.PROP_TIMEOUT_SECONDS, Constantes.DEFAULT_TIMEOUT_SECONDS));
    }
}
