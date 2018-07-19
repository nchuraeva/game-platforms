package ru.springboot.project.game.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckPile {


    private List<Card> decksOfCards;
    private int numCards;

    public DeckPile() {
        decksOfCards = new ArrayList<>();
        numCards = 0;
    }

    public void addCards(List<Card> cards) {
        for(Card card : cards) {
            decksOfCards.add(card);
            numCards++;
        }
    }


    public void shuffle() {
        Collections.shuffle(decksOfCards);
    }

    public Card dealUp() {
        Card top = this.decksOfCards.get(numCards - 1);
        this.decksOfCards.remove(numCards - 1);
        numCards --;
        return top;
    }

    public Card dealDown() {

        Card down = this.decksOfCards.get(0);



        return down;
    }

    public void reset() {
        this.decksOfCards.clear();
    }

    public List<Card> getDecksOfCards() {
        return decksOfCards;
    }
}
