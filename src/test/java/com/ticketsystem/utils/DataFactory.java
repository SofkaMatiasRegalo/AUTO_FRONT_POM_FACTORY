package com.ticketsystem.utils;

import com.ticketsystem.data.TestUsers;

public final class DataFactory {

    private DataFactory() {
    }

    public static TestUsers.NewUser newUser() {
        return TestUsers.generateNewUser();
    }

    public static TestUsers.Credentials validLogin() {
        return TestUsers.VALID_LOGIN;
    }
}
