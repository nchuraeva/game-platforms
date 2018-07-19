package ru.springboot.project.game.objects;

public class Card {

    private Rank rank;
    private Suit suit;
    private boolean IsFaceUp;


    public Card(Rank rank, Suit suit, boolean isFaceUp) {
        this.rank = rank;
        this.suit = suit;
        this.IsFaceUp = isFaceUp;
    }


    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public boolean isFaceUp() {
        return IsFaceUp;
    }

    public void flip() {
        this.IsFaceUp = !(IsFaceUp);
    }


    @Override
    public String toString() {
        return "card { " +
                rank.getValue() +
                ", " +
                suit.getStringValue() + '}';
    }
}
