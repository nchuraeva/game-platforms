package ru.springboot.project.game.objects;

import ru.springboot.project.game.interfaces.Player;
import ru.springboot.project.game.session.GameSession;

import java.util.List;
import java.util.Map;

public class Game {

    private List<GameSession> gameSessions;
    private  Map<String, Player> players;
    private int currentCountPlayers = 0;
    public static int gameCountPlayers;
    private GameSession currentSession;


    public Game() {
    }

    public void addPlayers(String name)  {
        Player player = null;
        if(currentCountPlayers < gameCountPlayers) {
            player = new HumanPlayer(name);
            currentCountPlayers++;
            players.put(Integer.toString(currentCountPlayers),player);
        }
        else if (currentCountPlayers == gameCountPlayers) {
            this.start();
        }
    }

    public String start() {
        currentSession = new GameSession(this);
        gameSessions.add(currentSession);
       return  currentSession.startNewGame();
    }

    public String stop() {
        return currentSession.playerToStop();
    }


    public String hitMe() {
        return currentSession.hitMe();
    }


    public Map<String, Player> getPlayers() {
        return players;
    }
    public void setGameCountPlayers(int gameCountPlayers) {
        this.gameCountPlayers = gameCountPlayers;
    }
}
