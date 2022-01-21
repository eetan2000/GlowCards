package com.example.glowcards.control;

import java.io.*;
import java.util.ArrayList;

import com.example.glowcards.model.CueCard;
import com.example.glowcards.model.Set;
import com.example.glowcards.model.User;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
        JsonObject info = new JsonObject();
        JsonArray userInfo = new JsonArray();
        JsonArray collectionJsonArray = new JsonArray();

        //for each set in the user
        for (int i = 0; i < user.getCollectionArrayList().size() + 1; i++) {
            if (i == 0) {
                JsonObject userDetails = new JsonObject();
                userDetails.addProperty("name", user.getName());
                userDetails.addProperty("username", user.getUsername());
                userDetails.addProperty("password", user.getPassword());
                userDetails.addProperty("image", user.getImage());

                userInfo.add(userDetails);
                info.add("user info", userInfo);
            } else {
                Set curSet = user.getCollectionArrayList().get(i - 1);
                JsonArray setJsonArray = new JsonArray();
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
        info.add("collection", collectionJsonArray);
        try {
            FileWriter file = new FileWriter("./Users/" + user.getUsername() + ".json");
            file.write(info.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadUsers() {
        File folder = new File("./Users");
        File[] listOfFiles = folder.listFiles();

        String name = null;
        String username = null;
        String password = null;
        String image = null;
        String title;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try {
                    JsonElement fileElement = JsonParser.parseReader(new FileReader(listOfFiles[i]));
                    JsonObject fileObject = fileElement.getAsJsonObject();

                    if (fileObject.toString().equals("{}")) {
                        return;
                    }

                    JsonArray jsonArrayOfUserInfo = fileObject.get("user info").getAsJsonArray();
                    for (JsonElement curElement : jsonArrayOfUserInfo) {
                        JsonObject curObject = curElement.getAsJsonObject();

                        name = curObject.get("name").getAsString();
                        username = curObject.get("username").getAsString();
                        password = curObject.get("password").getAsString();
                        image = curObject.get("image").getAsString();
                    }
                    User loadedUser = UserFactory.getINSTANCE().createUser(name, username, password, image);

                    JsonArray jsonArrayOfCollection = fileObject.get("collection").getAsJsonArray();
                    Set loadedSet = null;
                    for (JsonElement curElement : jsonArrayOfCollection) {
                        JsonArray curSet = curElement.getAsJsonArray();
                        int j = 0;
                        for (JsonElement curElementInSet : curSet) {
                            JsonObject curObject = curElementInSet.getAsJsonObject();
                            if (j == 0) {
                                title = curObject.get("title").getAsString();
                                loadedSet = SetFactory.getINSTANCE().createSet(title);
                                j++;
                            } else {
                                String term = curObject.get("term").getAsString();
                                String definition = curObject.get("definition").getAsString();

                                CueCard loadedCard = CueCardFactory.getINSTANCE().createCueCard(term, definition);
                                loadedSet.addCard(loadedCard);
                            }
                        }
                        loadedUser.addSet(loadedSet);
                    }
                    addUser(loadedUser);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean uniqueUsername(String username) {
        for (User curUser : userArrayList) {
            if (curUser.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public User findUser(String username, String password) {
        for (User curUser : userArrayList) {
            if (curUser.getUsername().equals(username) && curUser.getPassword().equals(password)) {
                return curUser;
            }
        }
        return null;
    }

    public void setScore(String username, String setTitle, int score) {
        for (User curUser : userArrayList) {
            if (username.equals(curUser.getUsername())) {
                for (Set curSet : curUser.getCollectionArrayList()) {
                    if (setTitle.equals(curSet.getTitle())) {
                        curSet.setScore(score);
                    }
                }
            }
        }
    }
}
