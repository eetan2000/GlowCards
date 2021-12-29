package com.example.glowcards.control;

public class UserFactory {
    private static UserFactory INSTANCE;

    private UserFactory(){}

    public static UserFactory getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new UserFactory();
        }
        return INSTANCE;
    }

    public User createUser(String username, String password){
        return new User(username,password);
    }
}
