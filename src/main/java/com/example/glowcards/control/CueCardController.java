package com.example.glowcards.control;

import com.example.glowcards.model.CueCard;

import java.util.ArrayList;

public class CueCardController {
    private ArrayList<CueCard> cueCardArrayList = new ArrayList<>();

    public void addCard(String term, String definition){
        CueCard newCard = CueCardFactory.getINSTANCE().createCueCard(term,definition);
        cueCardArrayList.add(newCard);
    }
}
