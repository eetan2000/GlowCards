package com.example.glowcards.control;

import com.example.glowcards.model.CueCard;
import com.example.glowcards.model.Set;

public class SetFactory {
    private static SetFactory INSTANCE;

    private SetFactory() {

    }

    public static SetFactory getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new SetFactory();
        }
        return INSTANCE;
    }

    public Set createSet(String title) {
        Set newSet = new Set(title);
        return newSet;
    }
}
