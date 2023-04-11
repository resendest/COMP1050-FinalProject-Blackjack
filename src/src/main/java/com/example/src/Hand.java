package com.example.src;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;

import com.example.src.Card.Rank;

public class Hand {
    private ObservableList<Node> c;
    private SimpleIntegerProperty value = new SimpleIntegerProperty(0);

    private int a = 0;

    public Hand(ObservableList<Node>c) {
        this.c = c;
    }

    public void takeCard(Card card) {
        c.add(card);

        if (card.r == Rank.Ace) {
            a++;
        }

        if (value.get() + card.v > 21 && a > 0) {
            value.set(value.get() + card.v - 10);
            a--;
        } else {
            value.set(value.get() + card.v);
        }
    }

    public void reset() {
        c.clear();
        value.set(0);
        a = 0;
    }

    public SimpleIntegerProperty totalValue() {
        return value;
    }
}