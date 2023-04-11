package com.example.src;

import com.example.src.Card.Rank;
import com.example.src.Card.Suit;

public class Deck {
    private Card[] c = new Card[52];

    public Deck() {
        refill();
    }
    public final void refill() {
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                c[i++] = new Card(suit, rank);
            }
        }
    }
    public Card draw() {
        Card card = null;
        while(card == null) {
            int index = (int)(Math.random() * c.length);
            card = c[index];
            c[index] = null;
        }
        return card;
    }
}
