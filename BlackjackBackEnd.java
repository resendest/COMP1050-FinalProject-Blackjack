
public class BlackjackBackEnd {

	private static final int dealer_threshold = 17;
	private static final int max_hand_size = 12;
	private static final int blackjack = 21;
	
	private list <String> deck, playerhand, dealerhand;
	private int playerbet, playerfunds;
	
	public Blackjack() {
		deck = new ArrayList<>();
		playerhand = new ArrayList<>();
		dealerhand = new ArrayList<>();
		playerfunds = 10000;	
	}
	
	public void shuffleDeck() {
		deck.clear();
        for (int i = 2; i <= 10; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(Integer.toString(i));
            }
        }
        for (int i = 0; i < 16; i++) {
            deck.add("A");
        }
        for (int i = 0; i < 64; i++) {
            deck.add("10");
        }
        Collections.shuffle(deck);
	}
	
	public void dealCards() {
        playerHand.clear();
        dealerHand.clear();
        playerHand.add(getNextCard());
        dealerHand.add(getNextCard());
        playerHand.add(getNextCard());
        dealerHand.add(getNextCard());
    }

}
public int getPlayerFunds() {
    return playerFunds;
}

public void setplayerFunds(int playerFunds) {
    this.playerFunds = playerFunds;
}

public boolean isBlackJack (int handValue) {
    return handValue == BLACKJACK;
}

public boolean isBust (int handValue) {
    return handValue > BLACKJACK;
}
public boolean isDealerDone() {
    return getDealerHandValue() >= DEALER_THRESHOLD;
}

public int getValue(String card) {
    if (card.equals("A")) {
        return 11;
    } else if (card.equals("10") || card.equals("J") || card.equals("Q") || card.equals("K")) {
        return 10;
    } else {
        return Integer.parseInt(card);
    }
}

public String reshuffleDeck() {
    if (deck.isEmpty()) {
        shuffleDeck();
    }
    return;
}