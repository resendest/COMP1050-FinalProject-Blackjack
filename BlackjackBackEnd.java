import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class BlackjackBackEnd {

	private static final int dealer_threshold = 17;
	private static final int max_hand_size = 12;
	private static final int blackjack = 21;
	
	private List <String> deck, playerhand, dealerhand;
	private int playerbet, playerfunds;
	
	public void Blackjack() {
		deck = new ArrayList<>();
		playerhand = new ArrayList<>();
		dealerhand = new ArrayList<>();
		playerfunds = 10000;	
	}
	
	public void shuffleDeck() {
		deck.clear();
    private static final int dealer_threshold = 17;
    private static final int max_hand_size = 12;
    private static final int blackjack = 21;

    private List<String> deck, playerhand, dealerhand;
    private int playerbet, playerfunds;

    public void Blackjack() {
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
        playerhand.clear();
        dealerhand.clear();
        playerhand.add(getNextCard());
        dealerhand.add(getNextCard());
        playerhand.add(getNextCard());
        dealerhand.add(getNextCard());
    }

    public int getPlayerHandValue() {
        int handValue = 0;
        int numAces = 0;
        for (String card : playerhand) {
            if (card.equals("A")) {
                numAces++;
            }
            handValue += getValue(card);
        }
        while (handValue > blackjack && numAces > 0) {
            handValue -= 10;
            numAces--;
        }
        return handValue;
    }

    public int getDealerHandValue() {
        int handValue = 0;
        int numAces = 0;
        for (String card : dealerhand) {
            if (card.equals("A")) {
                numAces++;
            }
            handValue += getValue(card);
        }
        while (handValue > blackjack && numAces > 0) {
            handValue -= 10;
            numAces--;
        }
        return handValue;
    }

    public int getPlayerBet() {
        return playerbet;
    }

    public void setPlayerBet(int playerbet) {
        this.playerbet = playerbet;
    }

    public int getPlayerFunds() {
        return playerfunds;
    }

    public void setplayerFunds(int playerFunds) {
        this.playerfunds = playerFunds;
    }

    public boolean isBlackJack(int handValue) {
        return handValue == blackjack;
    }

    public boolean isBust(int handValue) {
        return handValue > blackjack;
    }

    public boolean isDealerDone() {
        return getDealerHandValue() >= dealer_threshold;
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

    public String getNextCard() {
        if (deck.isEmpty()) {
            shuffleDeck();
        }
        return deck.remove(0);
    }
}