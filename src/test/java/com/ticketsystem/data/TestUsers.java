package com.ticketsystem.data;

import com.ticketsystem.utils.Constantes;

public final class TestUsers {

    private TestUsers() {
    }

    public static final Credentials VALID_LOGIN = new Credentials(
            System.getProperty(Constantes.PROP_QA_LOGIN_EMAIL, Constantes.DEFAULT_QA_LOGIN_EMAIL),
            System.getProperty(Constantes.PROP_QA_LOGIN_PASSWORD, Constantes.DEFAULT_QA_LOGIN_PASSWORD),
            System.getProperty(Constantes.PROP_QA_LOGIN_USERNAME, Constantes.DEFAULT_QA_LOGIN_USERNAME)
    );

    public static NewUser generateNewUser() {
        long now = System.currentTimeMillis();
        return new NewUser(
                Constantes.NEW_USER_PREFIX + now,
                Constantes.NEW_USER_PREFIX + now + Constantes.NEW_USER_EMAIL_DOMAIN,
                Constantes.NEW_USER_PASSWORD,
                Constantes.NEW_USER_PASSWORD
        );
    }

    public static final class Credentials {
        public final String email;
        public final String password;
        public final String username;

        public Credentials(String email, String password, String username) {
            this.email = email;
            this.password = password;
            this.username = username;
        }
    }

    public static final class NewUser {
        public final String username;
        public final String email;
        public final String password;
        public final String confirmPassword;

        public NewUser(String username, String email, String password, String confirmPassword) {
            this.username = username;
            this.email = email;
            this.password = password;
            this.confirmPassword = confirmPassword;
        }
    }
}
