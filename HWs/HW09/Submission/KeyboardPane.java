import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.util.Map; // <K,V>
import static java.util.Map.entry;

/**
 * @author Braiden Anderson
 * @version 1.0.0
 */
public class KeyboardPane {
    // VARIABLES
        // FINAL VARIABLES
    private static final int KEYPANE_BOX_SIDE_LENGTH = 90;
    private static final Color BACKGROUND_COLOR = Color.rgb(18, 18, 19);
    private static final Color WHITE = Color.rgb(248, 248, 248);
    private static final Color GRAY = Color.rgb(58, 58, 60);
    private static final Color GREEN = Color.rgb(83, 141, 78);
    private static final Color YELLOW = Color.rgb(181, 159, 59);
    private static final KeyboardMap KEYBOARD_POSITIONS = new KeyboardMap(true); // instantiates PositionMap
    private static final String TEXT_FONT = "Arial";
    private static final FontWeight FONT_WEIGHT = FontWeight.NORMAL;
    private static final int TEXT_SIZE = 32;
    private static final Map<Color, String> COLOR_MAP = Map.ofEntries(
        entry(BACKGROUND_COLOR, "n"), entry(GRAY, "i"), entry(YELLOW, "y"), entry(GREEN, "g")
    );

        // INSTANCED VARIABLES
    private String letter;
    private Text keyboardText;
    private Color color;
    private String colorAdjacent;
    private Rectangle letterBox = null;
    private Rectangle letterBoxOutline = null;
    private int keyboardPaneColumn;
    private int keyboardPaneRow;
    private StackPane keyboardStackPane = new StackPane();


    // CONSTRUCTOR
    /**
     * @param letter the letter from the keyboard to instantiate this individual keyboardPane.
     */
    public KeyboardPane(String letter) {
        this.letter = letter;                   // letter
        this.keyboardText = createText(letter); // keyboardText
        this.color = this.BACKGROUND_COLOR;     // color
        this.colorAdjacent = "n";               // colorAdjacent
        resetKeyboardPane();                    // letterBox, letterBoxOutline
        evaluateKeyboardPaneColumnRow(letter);  // column, row
        configureStackPane();                   // keyboardStackPane
    }


    // METHODS
    private Text createText(String textLetter) {
        if (textLetter.equals("BACK_SPACE")) {
            return new Text("⌫");
        }
        if (textLetter.equals("ENTER")) {
            return new Text("↵");
        }
        return new Text(textLetter);
    }

    private Rectangle createBox(Color boxColor, boolean innerBox) {
        int boxEdge = (innerBox ? 0 : 4);
        return new Rectangle(this.KEYPANE_BOX_SIDE_LENGTH - boxEdge, this.KEYPANE_BOX_SIDE_LENGTH  - boxEdge, boxColor);
    }

    private void evaluateKeyboardPaneColumnRow(String queryLetter) {
        int position = KEYBOARD_POSITIONS.getPosition(queryLetter);
        if (position == KEYBOARD_POSITIONS.getPosition("BACK_SPACE")) { // Back space is a special occurence
            this.keyboardPaneColumn = 10;
            this.keyboardPaneRow = 0;
            return;
        }
        if (position == KEYBOARD_POSITIONS.getPosition("ENTER")) { // Enter is also a special occurence
            this.keyboardPaneColumn = 10;
            this.keyboardPaneRow = 1;
            return;
        }
        this.keyboardPaneColumn = position % 10;
        this.keyboardPaneRow = position / 10;

        if (this.keyboardPaneRow > 0) {
            this.keyboardPaneColumn += this.keyboardPaneRow;
        }
    }

    private boolean priorityColorChecking(Color colorChange) { // true -> you can change color; false -> nope;
        switch (this.colorAdjacent) {
        case "n":
            return true;
        case "i":
            if (colorChange.equals(this.YELLOW) || colorChange.equals(this.GREEN)) {
                return true;
            }
            return false;
        case "y":
            if (colorChange.equals(this.GREEN)) {
                return true;
            }
            return false;
        case "g":
            return false;
        default:
            // System.out.println(this.colorAdjacent);
            return false;
        }
    }

    private void configureStackPane() {
        this.keyboardText.setFill(this.WHITE);
        this.keyboardText.setFont(Font.font(TEXT_FONT, FONT_WEIGHT, TEXT_SIZE));
        this.keyboardStackPane.getChildren().setAll(this.letterBoxOutline, this.letterBox, this.keyboardText);
    }

    /**
     * @param newColor The color used to update the Rectangle of the individual Pane.
     */
    public void updateColor(Color newColor) {
        if (priorityColorChecking(newColor)) {
            this.colorAdjacent = COLOR_MAP.get(newColor);
            this.color = newColor;
        }
        this.letterBox = createBox(this.color, false);
        this.letterBoxOutline = createBox(this.color, true);
        configureStackPane();
    }

    /**
     * Resets the keyboard pane to its original state for the next round of Jordle.
     */
    public void resetKeyboardPane() {
        this.letterBox = createBox(this.BACKGROUND_COLOR, false);
        this.letterBoxOutline = createBox(this.GRAY, true);
        this.colorAdjacent = "n";
        this.color = this.BACKGROUND_COLOR;
        configureStackPane();
    }


    // GETTERS
    /**
     * @return returns the stackPane value.
     */
    public StackPane getPane() {
        return this.keyboardStackPane;
    }

    /**
     * @return returns the row value of where the pane needs to be positioned in the keyboard GridPane.
     */
    public int getRow() {
        return this.keyboardPaneRow;
    }

    /**
     * @return returns the column value of where the pane needs to be positioned in the keyboard GridPane.
     */
    public int getColumn() {
        return this.keyboardPaneColumn;
    }
}