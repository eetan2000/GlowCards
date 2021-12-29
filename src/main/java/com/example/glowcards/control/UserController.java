package com.example.glowcards.control;

import java.util.ArrayList;

public class UserController {
    private ArrayList<User> userArrayList = new ArrayList<>();

    private static UserController INSTANCE;

    private UserController(){}

    public static UserController getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new UserController();
        }
        return INSTANCE;
    }

    public void addUser(User user){
        userArrayList.add(user);
        System.out.println("**Added new user**");
    }
}
