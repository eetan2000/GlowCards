package com.example.glowcards.model;

import java.time.LocalDate;

public class CueCard {
    private LocalDate date;
    private String term;
    private String definition;
    private int score;

    public CueCard(String term, String definition){
        this.term = term;
        this.definition = definition;
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Term: " + getTerm() + "\nDefinition: " + getDefinition();
    }
}
