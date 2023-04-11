import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Card extends Parent {
    enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    };

    enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);

        final int value;
        private Rank (int value) {
            this.value = value;
        }
    };

    public final Suit s;
    public final Rank r;
    public final int v;

    public Card(Suit suit, Rank rank) {
        this.s = suit;
        this.r = rank;
        this.v = rank.value;

        Rectangle card = new Rectangle(60, 100);
        card.setArcWidth(20);
        card.setArcHeight(20);
        card.setFill(Color.WHITE);

        Text t = new Text(toString());
        t.setWrappingWidth(50);

        getChildren().add(new StackPane(card, t));
    }

    @Override
    public String toString() {
        return r.toString() + " of " + s.toString();
    }

}
