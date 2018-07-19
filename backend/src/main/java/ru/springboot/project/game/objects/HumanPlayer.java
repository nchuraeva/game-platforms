package ru.springboot.project.game.objects;

import ru.springboot.project.game.interfaces.Dealer;
import ru.springboot.project.game.interfaces.Player;

public class HumanPlayer extends Player  {

    private Hand hand;

    private Dealer dealer;

    public HumanPlayer(String name) {
        super(name);
        hand = new Hand();
    }


    @Override
    protected boolean hit() {
        return this.hand.getRate() < 21;
    }

    @Override
    public void stopPlay() {
        dealer.passTurn();
    }

    @Override
    public void addCard(Card card) {
        hand.addCard(card);
    }

    public Hand getHand() {
        return hand;
    }


    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }
}
