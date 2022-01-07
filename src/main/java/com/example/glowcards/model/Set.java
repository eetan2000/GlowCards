package com.example.glowcards.model;

import com.example.glowcards.control.CueCardFactory;
import com.example.glowcards.model.CueCard;

import java.util.ArrayList;

public class Set {
    private ArrayList<CueCard> setArrayList = new ArrayList<>();
    private String title;

    public Set(String title){
        this.title = title;
    }

    public void addCard(CueCard newCard) {
        setArrayList.add(newCard);
    }

    public ArrayList<CueCard> getSetArrayList(){
        return setArrayList;
    }

    public String getTitle() {
        return title;
    }
}
