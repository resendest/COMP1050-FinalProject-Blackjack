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

public class BlackjackFrontEnd extends Application {
	
	private BlackjackBackEnd play;
    private Label player;
    private Label dealer;
    private TextField bet;
    private Button deal;
    private Button hit;
    private Button stand;
    private Button reset;

	

	
	public void start(Stage primStage) {
		play = new BlackjackBackEnd();
		
		player = new Label("Your Hand: " + play.getPlayerHandValue());
		dealer = new Label("Dealer Hand: " + play.getDealerHandValue());
        bet = new TextField();
        bet.setPromptText("Enter bet amount");
        deal = new Button("Deal");
        hit = new Button("Hit");
        stand = new Button("Stand");
        reset = new Button("Reset");
		
        deal.setOnAction(e -> {
            int bet_amount = Integer.parseInt(bet.getText());
            play.placeBet(bet);
            play.deal();
            updateLabels();
            toggleButtons(true, true, false, false);
        });
	}


}
