package ru.springboot.project.game.session;

import ru.springboot.project.game.interfaces.Player;
import ru.springboot.project.game.objects.BlackJackDealer;
import ru.springboot.project.game.objects.Deck;
import ru.springboot.project.game.objects.DeckPile;
import ru.springboot.project.game.objects.Game;

import java.util.Map;

public class GameSession {

    private BlackJackDealer dealer;

    private Game game;
    // сделать volitale
    public static int currentPlayerNumber = 1;
    public Player currentPlayer;


    public GameSession(Game game) {
        this.game = game;
    }

    // Сначала передаем строку
    // далее json object
    public String startNewGame() {
        Deck deck = new Deck();
        DeckPile deckPile = new DeckPile();
        deck.buildCards();
        deck.addToStack(deckPile);

        dealer = new BlackJackDealer("Dealer");
        dealer.setDeckPile(deckPile);

        for(Map.Entry entry: game.getPlayers().entrySet()) {
            dealer.addPlayer((Player) entry);
        }

        currentPlayer = game.getPlayers().get(Integer.toString(currentPlayerNumber));

        dealer.startNewGame();


        // дописать ответ
        String result =  "New game is started!";
        return result;
    }

    public String playerToStop() {
        currentPlayer.stopPlay();
        String result = "";
        return result;

    }


    public String hitMe() {
        currentPlayer.play(dealer);

        String result = "";
        return result;

    }

}
