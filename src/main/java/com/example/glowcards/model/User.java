package com.example.glowcards.model;
import java.util.ArrayList;

public class User {
    private ArrayList<Set> collectionArrayList = new ArrayList<>();
    private String name;
    private String username;
    private String password;
    private String image;

    public User(String name, String username, String password, String image) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.image = image;
    }

    public void addSet(Set newSet){
        collectionArrayList.add(newSet);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Set> getCollectionArrayList(){
        return collectionArrayList;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getImage() {
        return image;
    }
}
