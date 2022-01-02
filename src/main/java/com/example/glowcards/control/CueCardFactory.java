package com.example.glowcards.control;

import com.example.glowcards.model.CueCard;

public class CueCardFactory {
    private static CueCardFactory INSTANCE;

    private CueCardFactory() {

    }

    public static CueCardFactory getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new CueCardFactory();
        }
        return INSTANCE;
    }

    public CueCard createCueCard(String term, String definition) {
        CueCard newCard = new CueCard(term, definition);
        return newCard;
    }
}
