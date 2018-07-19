package ru.springboot.project.game.interfaces;

public interface Dealer {
    // раздача карт
    void hit(Player player);

    void passTurn();
}
