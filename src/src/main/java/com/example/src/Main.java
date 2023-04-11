package com.example.src;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    //References to call
    private Deck d = new Deck();
    private Hand dealer, player;
    private Text m = new Text();

    private SimpleBooleanProperty play = new SimpleBooleanProperty(false);

    private HBox dC = new HBox(20);
    private HBox pC = new HBox(20);

    private Parent create() {
        dealer = new Hand(dC.getChildren());
        player = new Hand(pC.getChildren());

        Pane root = new Pane();
        root.setPrefSize(1000, 1000);

        Region background = new Region();
        background.setPrefSize(1000, 1000);
        background.setStyle("-fx-background-color:black;");

        //Creates basic layout
        HBox rootLayout = new HBox(5);
        rootLayout.setPadding(new Insets(5, 5, 5, 5));
        Rectangle cards = new Rectangle(550, 560);
        cards.setFill(Color.BLACK);
        Rectangle buttons = new Rectangle(230, 560);
        buttons.setFill(Color.WHITE);

        //Creates layout for the cards side of things
        StackPane cS = new StackPane();

        VBox cB = new VBox(50);
        cB.setAlignment(Pos.TOP_CENTER);

        Text dS = new Text("Dealer: ");
        Text pS = new Text("Player");

        //Adds the text and cards to picture
        cB.getChildren().addAll(dS, pS, dC, pC, m);
        cS.getChildren().addAll(cards, cB);

        //Create button side to picture
        StackPane bS = new StackPane();

        VBox bB = new VBox(20);
        bB.setAlignment(Pos.CENTER);

        final TextField b = new TextField("Bet");
        b.setDisable(true);
        b.setMaxWidth(50);

        Text m = new Text("Cash");
        Button bStand = new Button("Stand");
        Button bPlay = new Button("Play");
        Button bHit = new Button("Hit");

        HBox bHB = new HBox(15);
        bHB.setAlignment(Pos.CENTER);
        bHB.setDisable(true);
        bS.setDisable(true);

        //Add all to picture
        bHB.getChildren().addAll(bHit, bStand);
        bB.getChildren().addAll(m, bHB, b, bPlay);
        bS.getChildren().addAll(buttons, bB);

        //Adds them to the root layout
        rootLayout.getChildren().addAll(cS, bS);

        //Adds all
        root.getChildren().addAll(rootLayout, background);


        bPlay.disableProperty().bind(play);
        bHit.disableProperty().bind(play.not());
        bStand.disableProperty().bind(play.not());

        pS.textProperty().bind(new SimpleStringProperty("Player: ").concat(player.totalValue().asString()));
        dS.textProperty().bind(new SimpleStringProperty("Dealer: ").concat(dealer.totalValue().asString()));

        player.totalValue().addListener((obs, old, newValue) ->  {
            if (newValue.intValue() >= 21) {
                endGame();
            }
        });
        dealer.totalValue().addListener((obs, old, newValue) -> {
            if (newValue.intValue() >= 21) {
                endGame();
            }
        });

        bPlay.setOnAction(event -> {
            startGame();
        });
        bHit.setOnAction(event -> {
            player.takeCard(d.draw());
        });
        bStand.setOnAction(event -> {
            while (dealer.totalValue().get() < 17) {
                dealer.takeCard(d.draw());
            }
            endGame();
        });

        return root;
    }

    private void startGame() {
        play.set(true);
        m.setText("");
        d.refill();
        player.reset();
        dealer.reset();
        dealer.takeCard(d.draw());
        dealer.takeCard(d.draw());
        player.takeCard(d.draw());
        player.takeCard(d.draw());
    }

    private void endGame() {
        play.set(false);

        int pV = player.totalValue().get();
        int dV = dealer.totalValue().get();
        String win = "Exceptional case: d: " + dV + " p: " + pV;

        if (dV == 21 || pV > 21 || (dV < 21 && dV > pV)) {
            win = "Dealer";
        } else if (pV == 21 || dV > 21 || pV > dV) {
            win = "Player";
        } else if (pV == dV) {
            win = "No one";
        }

        m.setText(win + " wins");
    }

    //Creates the stage
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(create()));
        primaryStage.setWidth(1000);
        primaryStage.setHeight(1000);
        primaryStage.setTitle("Blackjack");
        primaryStage.show();
    }

    //Launches program
    public static void main(String[] args) {
        launch(args);
    }
}
