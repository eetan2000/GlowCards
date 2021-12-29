package com.example.glowcards.control;

import java.util.ArrayList;

public class User {
    private ArrayList<CueCardController> sets = new ArrayList<>();
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
