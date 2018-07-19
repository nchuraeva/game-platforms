package ru.springboot.project.game.objects;


import ru.springboot.project.game.interfaces.Dealer;
import ru.springboot.project.game.interfaces.Observable;
import ru.springboot.project.game.interfaces.Player;

import java.util.ArrayList;
import java.util.List;

public class BlackJackDealer extends Player implements Dealer, Observable {

    private Hand hand;
    private String name;
    private List<Player> players;
    private DeckPile deckPile;

    public BlackJackDealer(String name) {
        super(name);
        this.hand = new Hand();
        players = new ArrayList<>();
    }


    @Override
    public void hit(Player player) {
        player.addCard(this.deckPile.dealUp());
    }

    @Override
    public void passTurn() {
        this.notifyAllPlayers();
    }

    @Override
    protected boolean hit() {
       return hand.getRate() < 17;
    }

    @Override
    public void stopPlay() {

    }

    @Override
    public void addCard(Card card) {
        this.hand.addCard(card);
    }


    @Override
    public void notifyAllPlayers() {


        //!!!!!!
        // Уведомляет о том что другой
        // игрок всупает в игру
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public void deletePlayer(Player player) {
        if(players.contains(player)) {
            players.remove(player);
        }

    }

    public Hand getHand() {
        return hand;
    }


    public void  startNewGame() {
        for(int i=1; i <= 2; i++) {
            players.forEach(item -> {
                if (!deckPile.getDecksOfCards().isEmpty()) {
                    item.addCard(deckPile.dealUp());
                }
            });
            if (!deckPile.getDecksOfCards().isEmpty()) {
                this.addCard(deckPile.dealUp());
            }
        }
        this.flipFirstCard();
    }

    public void flipFirstCard() {
        if(!hand.getCards().isEmpty()) {
            hand.getCards().get(0).flip();
        }
    }

    public void setDeckPile(DeckPile deckPile) {
        this.deckPile = deckPile;
    }
}
