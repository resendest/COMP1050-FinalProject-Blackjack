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
    private ImageView cardBackView;
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
        cardBack = new Image(); //need to insert picture
        cardBackView = new ImageView(cardBackView);
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


