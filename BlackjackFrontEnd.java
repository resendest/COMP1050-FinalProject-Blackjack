import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BlackjackFrontEnd extends Application {

    private BlackjackBackEnd play;
    private Label player, dealer, message, status, funds, bet;
    private TextField betTF;
    private Button deal, hit, stand, insurance, split, dd, new_game;
    private Image cardBack;
    private Image cA, sA, dA, hA;
    private Image c2, s2, d2, h2;
    private Image c3, s3, d3, h3;
    private Image c4, s4, d4, h4;
    private Image c5, s5, d5, h5;
    private Image c6, s6, d6, h6;
    private Image c7, s7, d7, h7;
    private Image c8, s8, d8, h8;
    private Image c9, s9, d9, h9;
    private Image c10, s10, d10, h10;
    private Image cJ, sJ, dJ, hJ;
    private Image cQ, sQ, dQ, hQ;
    private Image cK, sK, dK, hK;
    private ImageView cardBackView;
    private ImageView cAV, sAV, dAV, hAV;
    private ImageView c2V, s2V, d2V, h2V;
    private ImageView c3V, s3V, d3V, h3V;
    private ImageView c4V, s4V, d4V, h4V;
    private ImageView c5V, s5V, d5V, h5V;
    private ImageView c6V, s6V, d6V, h6V;
    private ImageView c7V, s7V, d7V, h7V;
    private ImageView c8V, s8V, d8V, h8V;
    private ImageView c9V, s9V, d9V, h9V;
    private ImageView c10V, s10V, d10V, h10V;
    private ImageView cJV, sJV, dJV, hJV;
    private ImageView cQV, sQV, dQV, hQV;
    private ImageView cKV, sKV, dKV, hKV;
    private boolean canDD, canSplit, canInsure;





    public void start(Stage primStage) {
        play = new BlackjackBackEnd();

        player = new Label("Your Hand: " + play.getPlayerHandValue());
        dealer = new Label("Dealer Hand: " + play.getDealerHandValue());
        betTF = new TextField();
        bet.setText("Enter bet amount");
        deal = new Button("Deal");
        hit = new Button("Hit");
        stand = new Button("Stand");

        play.shuffleDeck();
        cardBack = new Image ("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Card_back_01.svg/640px-Card_back_01.svg.png"); 
        cardBackView = new ImageView(cardBack);
        cA = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Ace_of_clubs.svg/640px-Ace_of_clubs.svg.png");
        cAV = new ImageView(cA);
        sA = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Ace_of_spades.svg/418px-Ace_of_spades.svg.png?20150115015447");
        sAV = new ImageView(sA);
        dA = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Ace_of_diamonds.svg/640px-Ace_of_diamonds.svg.png");
        dAV = new ImageView(dA);
        hA = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/Ace_of_hearts.svg/640px-Ace_of_hearts.svg.png");
        hAV = new ImageView(hA);
        c2 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/2_of_clubs.svg/640px-2_of_clubs.svg.png");
        c2V = new ImageView(c2);
        s2 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/2_of_spades.svg/640px-2_of_spades.svg.png");
        s2V = new ImageView(s2);
        d2 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/2_of_diamonds.svg/640px-2_of_diamonds.svg.png");
        d2V = new ImageView(d2);
        h2 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/2_of_hearts.svg/418px-2_of_hearts.svg.png?20150115014437");
        h2V = new ImageView(h2);
        c3 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/3_of_clubs.svg/640px-3_of_clubs.svg.png");
        c3V = new ImageView(c3);
        s3 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/3_of_spades.svg/640px-3_of_spades.svg.png");
        s3V = new ImageView(s3);
        h3 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/3_of_hearts.svg/640px-3_of_hearts.svg.png");
        h3V = new ImageView(h3);
        d3 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/3_of_diamonds.svg/640px-3_of_diamonds.svg.png");
        d3V = new ImageView(d3);
        c4 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/4_of_clubs.svg/640px-4_of_clubs.svg.png");
        c4V = new ImageView(c4);
        s4 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/4_of_spades.svg/640px-4_of_spades.svg.png");
        s4V = new ImageView(s4);
        d4 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/4_of_diamonds.svg/640px-4_of_diamonds.svg.png");
        d4V = new ImageView(d4);
        h4 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/4_of_hearts.svg/640px-4_of_hearts.svg.png");
        h4V = new ImageView(h4);
        c5 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/7/72/5_of_clubs.svg/640px-5_of_clubs.svg.png");
        c5V = new ImageView(c5);
        s5 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/5_of_spades.svg/640px-5_of_spades.svg.png");
        s5V = new ImageView(s5);
        d5 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/5_of_diamonds.svg/640px-5_of_diamonds.svg.png");
        d5V = new ImageView(d5);
        h5 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/5_of_hearts.svg/640px-5_of_hearts.svg.png");
        h5V = new ImageView(h5);
        c6 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/6_of_clubs.svg/640px-6_of_clubs.svg.png");
        c6V = new ImageView(c6);
        h6 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/6_of_hearts.svg/640px-6_of_hearts.svg.png");
        h6V = new ImageView(h6);
        s6 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/6_of_spades.svg/640px-6_of_spades.svg.png");
        s6V = new ImageView(s6);
        d6 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/6_of_diamonds.svg/640px-6_of_diamonds.svg.png");
        d6V = new ImageView(d6);
        c7 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Poker-sm-248-7c.png/640px-Poker-sm-248-7c.png");
        c7V = new ImageView(c7);
        s7 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Poker-sm-218-7s.png/640px-Poker-sm-218-7s.png");
        s7V = new ImageView(s7);
        d7 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/Poker-sm-238-7d.png/640px-Poker-sm-238-7d.png");
        d7V = new ImageView(d7);
        h7 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Poker-sm-228-7h.png/640px-Poker-sm-228-7h.png");
        h7V = new ImageView(h7);
        c8 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Poker-sm-247-8c.png/640px-Poker-sm-247-8c.png");
        c8V = new ImageView(c8);
        s8 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Poker-sm-217-8s.png/640px-Poker-sm-217-8s.png");
        s8V = new ImageView(s8);
        d8 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c6/Poker-sm-237-8d.png/640px-Poker-sm-237-8d.png");
        d8V = new ImageView(d8);
        h8 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Poker-sm-227-8h.png/640px-Poker-sm-227-8h.png");
        h8V = new ImageView(h8);
        c9 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Poker-sm-246-9c.png/640px-Poker-sm-246-9c.png");
        c9V = new ImageView(c9);
        s9 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Poker-sm-216-9s.png/640px-Poker-sm-216-9s.png");
        s9V = new ImageView(s9);
        d9 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c0/Poker-sm-236-9d.png/640px-Poker-sm-236-9d.png");
        d9V = new ImageView(d9);
        h9 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d6/Poker-sm-226-9h.png/640px-Poker-sm-226-9h.png");
        h9V = new ImageView(h9);
        c10 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Poker-sm-245-Tc.png/640px-Poker-sm-245-Tc.png");
        c10V = new ImageView(c10);
        s10 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Poker-sm-215-Ts.png/640px-Poker-sm-215-Ts.png");
        s10V = new ImageView(s10);
        d10 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/6/6d/Poker-sm-235-Td.png/640px-Poker-sm-235-Td.png");
        d10V = new ImageView(d10);
        h10 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Poker-sm-225-Th.png/640px-Poker-sm-225-Th.png");
        h10V = new ImageView(h10);
        cJ = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7b/Jack_of_clubs2.svg/640px-Jack_of_clubs2.svg.png");
        cJV = new ImageView(cJ);
        sJ = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Jack_of_spades2.svg/640px-Jack_of_spades2.svg.png");
        sJV = new ImageView(sJ);
        dJ = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Jack_of_spades2.svg/640px-Jack_of_spades2.svg.png");
        dJV = new ImageView(dJ);
        hJ = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Jack_of_hearts2.svg/640px-Jack_of_hearts2.svg.png");
        hJV = new ImageView(hJ);
        cQ = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Queen_of_clubs2.svg/640px-Queen_of_clubs2.svg.png");
        cQV = new ImageView(cQ);
        sQ = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Queen_of_spades2.svg/640px-Queen_of_spades2.svg.png");
        sQV = new ImageView(sQ);
        dQ = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Queen_of_diamonds2.svg/640px-Queen_of_diamonds2.svg.png");
        dQV = new ImageView(dQ);
        hQ = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Queen_of_hearts2.svg/640px-Queen_of_hearts2.svg.png");
        hQV = new ImageView(hQ);
        cK = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/King_of_clubs2.svg/640px-King_of_clubs2.svg.png");
        cKV = new ImageView(cK);
        sK = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/2/22/King_of_spades2.svg/640px-King_of_spades2.svg.png");
        sKV = new ImageView(sK);
        dK = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c6/King_of_diamonds2.svg/640px-King_of_diamonds2.svg.png");
        dKV = new ImageView(dK);
        hK = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/King_of_hearts2.svg/640px-King_of_hearts2.svg.png");
        hKV = new ImageView(hK);
        player = new Label("Your hand:");
        dealer = new Label("Dealer hand:");
        status = new Label("Place your bet, then click the New Game button to begin!");
        funds = new Label ("Funds: $" + play.getPlayerFunds());
        bet = new Label("Bet:");
        betTF = new TextField();
        hit = new Button("Hit");
        stand = new Button("Stand");
        dd = new Button("Double Down");
        split = new Button("Split");
        insurance = new Button("Insurance");
        new_game = new Button("New Game");
        canDD = true;
        canSplit = true;
        canInsure = true;





        deal.setOnAction(e -> {
            int bet_amount = Integer.parseInt(bet.getText());
            play.getPlayerBet();
            play.dealCards();
            updateLabels();
            toggleButtons(true, true, false, false);
        });
    }

    public void placeBet(TextField bet) {

    }



    public void updateLabels() {
    }
    public void toggleButtons(boolean hit, boolean stand, boolean deal, boolean reset) {
    }
    public void shuffleDeck() {
    }
}

