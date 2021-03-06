package com.example.glowcards.model;

import com.example.glowcards.control.CueCardFactory;
import com.example.glowcards.model.CueCard;

import java.util.ArrayList;

public class Set {
    private ArrayList<CueCard> setArrayList = new ArrayList<>();
    private String title;
    private int score;

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

    public int getSize(){
        return setArrayList.size();
    }

    public String getTerm(int index) {
        return setArrayList.get(index).getTerm();
    }

    public String getDefinition(int index) {
        return setArrayList.get(index).getDefinition();
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
