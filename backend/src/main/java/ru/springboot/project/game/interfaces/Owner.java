package ru.springboot.project.game.interfaces;

import ru.springboot.project.game.objects.Money;

public interface Owner {
    String getName();
    void takeMoney(Money money);
}
