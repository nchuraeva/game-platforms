package ru.springboot.project.game.interfaces;

import ru.springboot.project.game.objects.Card;
import ru.springboot.project.game.objects.Money;

public abstract class Player implements Owner {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    protected abstract boolean hit();


    public void reset() {

    }
    public abstract void stopPlay() ;


    public  abstract void addCard(Card card);

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void takeMoney(Money money) {

    }

    public void play(Dealer dealer) {
        if(hit()) {
            dealer.hit(this);
        }
    }

}
