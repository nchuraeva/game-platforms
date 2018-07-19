package ru.springboot.project.game.objects;

import ru.springboot.project.game.interfaces.Player;

import java.util.List;

public  class Hand {

    private List<Card> cards;


    private Player player;

    private boolean isBust = false;

    public Hand() {

    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void clear() {
        cards.clear();
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getRate() {
        if(cards.isEmpty()) {
            return 0;
        }
       // если первая карта имеет значение 0 , то она лежит стороной вверх
        if (cards.get(0).isFaceUp() == true) {
            return 0;
        }
        int cardNum;
        int handSum=0;
        int handAces = 0;
        for (int i=0; i < cards.size();i++)
        {
           // получить значение карты
            cardNum = cards.get(i).getRank().getValue();
            if (cardNum == 1)
            {
                handAces = handAces+1 ; // количество тузов
                handSum = handSum + 11;
            }
            else if (cardNum > 10) { handSum = handSum + 10; }
            else {handSum = handSum + cardNum; }
        }

        while (handSum > 21 && handAces > 0 )
        {
            handSum = handSum - 10;
            handAces = handAces - 1;
        }
        return handSum;

    }

    public void turnOver() {

    }

    public boolean bust() {
        return isBust;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
