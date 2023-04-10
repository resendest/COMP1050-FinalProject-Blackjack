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


