import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;
public class BlackjackBackEnd {

	private static final int dealer_threshold = 17;
	private static final int max_hand_size = 12;
	private static final int blackjack = 21;
	
	private List <String> deck, playerhand, dealerhand;
	private int playerbet, playerfunds;
	private boolean pbj, dbj, pbust, dbust, end, dd_allowed, split_allowed, ins_allowed, pinsured;
	private int splitHandIdx;
	public void Blackjack() {
		deck = new ArrayList<>();
		playerhand = new ArrayList<>();
		dealerhand = new ArrayList<>();
		playerfunds = 10000;	
	}
//Shuffles deck
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
        dd_allowed = true;
        split_allowed = isSplitAllowed();
    }
    //How to play in the split scenario, if legal.
    public boolean split() {
        if (!split_allowed || playerhand.size() != 2) {
            return false;
        }
        String firstCard = playerhand.get(0);
        String secondCard = playerhand.get(1);
        if (!firstCard.equals(secondCard)) {
            return false;
        }
        splitHandIdx = 1;
        playerhand.remove(1);
        playerhand.add(getNextCard());
        dealerhand.add(getNextCard());
        dd_allowed = true;
        pbust = isBust(getPlayerHandValue());
        return true;
    }
    
    public void doubleDown() {
        if (!dd_allowed || playerhand.size() != 2) {
            return;
        }
        playerfunds -= playerbet;
        playerbet *= 2;
        playerhand.add(getNextCard());
        pbust = isBust(getPlayerHandValue());
        end = true;
    }
    
    public boolean insurance() {
        if (!ins_allowed || dealerhand.get(0).equals("A")) {
            return false;
        }
        pinsured = true;
        playerfunds -= playerbet / 2;
        return true;
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
    
    public boolean isSplitAllowed() {
        if (playerhand.size() != 2) {
            return false;
        }
        String card1 = playerhand.get(0);
        String card2 = playerhand.get(1);
        return card1.equals(card2);
    }
    
    public boolean isDoubleDownAllowed() {
        if (playerhand.size() != 2) {
            return false;
        }
        int playerHandValue = getPlayerHandValue();
        return (playerfunds >= playerbet) && (playerHandValue >= 9 && playerHandValue <= 11);
    }
    
    public boolean isInsuranceAllowed() {
        if (dealerhand.size() != 2) {
            return false;
        }
        String dealerUpCard = dealerhand.get(1);
        return dealerUpCard.equals("A");
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