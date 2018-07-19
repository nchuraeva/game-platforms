package ru.springboot.project.game.objects;

public enum Suit {

    SPADES("♠"),
    CLUBS("♣"),
    HEARTS("♥"),
    DIAMONDS("♦");

    private String stringValue;

    Suit(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

}
