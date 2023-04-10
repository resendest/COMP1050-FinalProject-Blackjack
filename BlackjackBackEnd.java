import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;
public class BlackjackBackEnd {

	private static final int dealer_threshold = 17;
	private static final int max_hand_size = 12;
	private static final int blackjack = 21;
	
	private List <String> deck, playerhand, dealerhand;
	private double playerbet, playerfunds;
	private boolean pbj, dbj, pbust, end, dd_allowed, ins_allowed, pinsured;
	public void Blackjack() {
		deck = new ArrayList<>();
		playerhand = new ArrayList<>();
		dealerhand = new ArrayList<>();
		playerfunds = 10000;	
	}
//Shuffles deck
    public void shuffleDeck() {
        deck.clear();
        String[] suits = new String[] {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (int i = 2; i <= 10; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(Integer.toString(i) + " of " + suits[j]);
            }
        }
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add("Ace of " + suits[j]);
           }
        }
        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add("10 of " + suits[j]);
            }
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

    public double getPlayerBet() {
        return playerbet;
    }

    public void setPlayerBet(double playerbet) {
        this.playerbet = playerbet;
    }

    public double getPlayerFunds() {
        return playerfunds;
    }

    public void setplayerFunds(double playerFunds) {
        this.playerfunds = playerFunds;
    }

    public boolean isBlackJack(int handValue) {
        return handValue == blackjack;
    }

    public boolean isBust(int handValue) {
        return handValue > blackjack;
    }

    public boolean isDealerWin() {
        if (getPlayerHandValue() < getDealerHandValue()) {
            return true;
        }
        return false;
    }
    public boolean isPlayerWin() {
        if (getPlayerHandValue() > getDealerHandValue()) {
            return true;
        }
        return false;
    }

    public boolean isPush() {
        if (getPlayerHandValue() == getDealerHandValue()) {
            return true;
        }
        return false;
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

    public void betHandling() {
        if (isBlackJack(getDealerHandValue())) {
            playerfunds -= playerbet;
        } else if (isBlackJack(getPlayerHandValue())) {
            playerfunds = playerfunds + (playerbet * 1.5);
        } else if (isBust(getPlayerHandValue())) {
            playerfunds -= playerbet;
        } else if (isBust(getDealerHandValue())) {
            playerfunds += playerbet;
        }  else if (isPush()) {

        } else if (isDealerWin()) {
            playerfunds -= playerbet;
        } else if (isPlayerWin()) {
            playerfunds += playerbet;
        }
    }


}