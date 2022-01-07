package com.example.glowcards.control;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.example.glowcards.model.Set;
import com.example.glowcards.model.User;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class UserController {
    private ArrayList<User> userArrayList = new ArrayList<>();

    private static UserController INSTANCE;

    private UserController() {
    }

    public static UserController getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new UserController();
        }
        return INSTANCE;
    }

    public void addUser(User user) {
        userArrayList.add(user);
    }

    public void saveUser(User user) {
        JsonArray collectionJsonArray = new JsonArray();
        JsonArray setJsonArray = new JsonArray();

        //for each set in the user
        for (int i = 0; i < user.getCollectionArrayList().size() + 1; i++){
            if (i == 0){
                JsonObject userDetails = new JsonObject();
                userDetails.addProperty("name" , user.getName());
                userDetails.addProperty("username" , user.getUsername());
                userDetails.addProperty("password" , user.getPassword());

                setJsonArray.add(userDetails);
            }
            else {
                Set curSet = user.getCollectionArrayList().get(i - 1);
                //for each cue card in the set
                //the first entry contains title
                for (int j = 0; j < curSet.getSetArrayList().size() + 1; j++) {
                    JsonObject cueCardDetails = new JsonObject();
                    if (j == 0) {
                        cueCardDetails.addProperty("title", curSet.getTitle());

                    } else {
                        cueCardDetails.addProperty("term", curSet.getSetArrayList().get(j - 1).getTerm());
                        cueCardDetails.addProperty("definition", curSet.getSetArrayList().get(j - 1).getDefinition());

                    }
                    setJsonArray.add(cueCardDetails);
                }
                collectionJsonArray.add(setJsonArray);
            }
        }
        try {
            FileWriter file = new FileWriter("./Users/" + user.getUsername() + ".json");
            file.write(collectionJsonArray.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadUsers(){

    }
}
