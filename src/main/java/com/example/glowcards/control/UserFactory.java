package com.example.glowcards.control;

import com.example.glowcards.model.User;

public class UserFactory {
    private static UserFactory INSTANCE;

    private UserFactory() {
    }

    public static UserFactory getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new UserFactory();
        }
        return INSTANCE;
    }

    public User createUser(String name, String username, String password, String image) {
        return new User(name, username, password, image);
    }
}
