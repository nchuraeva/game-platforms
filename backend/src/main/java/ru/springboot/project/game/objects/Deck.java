package ru.springboot.project.game.objects;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private  int numCards = 52;

    private List<Card> deckOfCards;

    public Deck() {
        deckOfCards = new ArrayList<>();
    }

    public void buildCards() {
        deckOfCards.clear();
        for(int i=0; i < 4;i++) {
            for(int j=1; j <=13; j++) {
                this.deckOfCards.add(new Card(Rank.values()[j],Suit.values()[i],false));
            }
        }

    }
    public void addToStack(DeckPile stack) {
        stack.addCards(deckOfCards);
    }

    public int getNumCards() {
        return numCards;
    }

    public List<Card> getDeckOfCards() {
        return deckOfCards;
    }
}
