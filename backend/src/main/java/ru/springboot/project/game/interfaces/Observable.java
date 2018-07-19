package ru.springboot.project.game.interfaces;

public interface Observable {

    void notifyAllPlayers();

    void addPlayer(Player player);

    void deletePlayer(Player player);
}
