package com.example.src;

import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Card extends Parent {
    enum Suit {
        Hearts, Diamonds, Clubs, Spades
    };
    enum Rank {
        Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(10), Queen(10), King(10), Ace(11);
        final int value;
        private Rank (int value) {
            this.value = value;
        }
    };

    public final Suit s;
    public final Rank r;
    public final int v;

    public Card(Suit suit, Rank rank) {
        this.s = suit;
        this.r = rank;
        this.v = rank.value;

        Rectangle card = new Rectangle(60, 100);
        card.setArcWidth(20);
        card.setArcHeight(20);
        card.setFill(Color.WHITE);

        Text t = new Text(toString());
        t.setWrappingWidth(50);
        getChildren().add(new StackPane(card, t));
    }

    @Override
    public String toString() {
        return r.toString() + " of " + s.toString();
    }
}
