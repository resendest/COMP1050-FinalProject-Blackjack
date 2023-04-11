package com.example.src;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;

import com.example.src.Card.Rank;

public class Hand {
    private ObservableList<Node>  cards;
    private SimpleIntegerProperty value = new SimpleIntegerProperty(0);

    private int a = 0;

    public Hand(ObservableList<Node>cards) {
        this.cards = cards;
    }

    public void takeCard(Card card) {
        cards.add(card);

        if (card.r == Rank.ACE) {
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
        cards.clear();
        value.set(0);
        a = 0;
    }

    public SimpleIntegerProperty valueProperty() {
        return value;
    }
}