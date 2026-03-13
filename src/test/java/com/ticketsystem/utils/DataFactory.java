package com.ticketsystem.utils;

import com.ticketsystem.data.TestUsers;

public final class DataFactory {

    private static volatile TestUsers.Credentials registeredUserCredentials;

    private DataFactory() {
    }

    public static TestUsers.NewUser newUser() {
        return TestUsers.generateNewUser();
    }

    public static synchronized void rememberRegisteredUser(TestUsers.NewUser newUser) {
        registeredUserCredentials = new TestUsers.Credentials(
                newUser.email,
                newUser.password,
                newUser.username
        );
    }

    public static TestUsers.Credentials validLogin() {
        if (registeredUserCredentials != null) {
            return registeredUserCredentials;
        }
        return TestUsers.VALID_LOGIN;
    }
}
