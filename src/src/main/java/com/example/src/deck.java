package com.example.src;

import com.example.src.Card.Rank;
import com.example.src.Card.Suit;

public class deck {
    private Card[] cards = new Card[52];

    public deck() {
        refill();
    }
    public final void refill() {
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards [i++] = new Card(suit,rank);
            }
        }
    }
    public Card drawCard() {
        Card card = null;
        while(card == null) {
            int index = (int)(Math.random() * cards.length);
            card = cards[index];
            cards[index] = null;
        }
        return card;
    }
}