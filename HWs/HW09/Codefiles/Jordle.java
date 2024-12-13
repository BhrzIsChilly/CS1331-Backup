import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent; // for anonymous inner class
import javafx.event.EventHandler; // for anonymous inner class Ctrl+F or CMD+F, "Anonymous inner class".-
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
// import javafx.scene.layout.*;  <-- Alternative
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Braiden Anderson
 * @version 1.0.0
 */
public class Jordle extends Application {
        // Variables
        // DEFAULTS
    private static final int SCREEN_WIDTH = 1920;
    private static final int SCREEN_HEIGHT = 1080;
    private static final int INSTRUCTION_SCREEN_WIDTH = 810;
    private static final int INSTRUCTION_SCREEN_HEIGHT = 360;
    private static final int GAME_GRID_BOX_SIDE_LENGTH = 100;
    private static final int GAME_GRID_ROWS = 6;
    private static final int GAME_GRID_COLUMNS = 5;
    private static final Color BACKGROUND_COLOR = Color.rgb(18, 18, 19);
    private static final Color WHITE = Color.rgb(248, 248, 248);
    private static final Color GRAY = Color.rgb(58, 58, 60);
    private static final Color GREEN = Color.rgb(83, 141, 78);
    private static final Color YELLOW = Color.rgb(181, 159, 59);
    private static final String DEFAULT_TEXT = "Try guessing a word!";
    private static final String WIN_TEXT = "Congratulations! You've guessed the word!\n\t\tRestart to play again.";
    private static final ArrayList<String> WORDS_LIST = getWords();
    private static final ArrayList<String> SPECIAL_KEYS = new ArrayList<>(Arrays.asList("ENTER", "BACK_SPACE"));
    private static final ArrayList<String> ALLOWED_KEYS = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E",
                                                                                       "F", "G", "H", "I", "J",
                                                                                       "K", "L", "M", "N", "O",
                                                                                       "P", "Q", "R", "S", "T",
                                                                                       "U", "V", "W", "X", "Y",
                                                                                       "Z", "ENTER", "BACK_SPACE"));

        // INSTANCED
    private Stage primaryStage;
    private Stage instructionStage;
    private Scene welcomeScene;
    private Scene mainScene;
    private GridPane mainGamePane = new GridPane();
    private GridPane keyboardPane = new GridPane();
    private KeyboardMap keyboardPositionMap = new KeyboardMap(true);
    private KeyboardMap keyboardPaneMap = new KeyboardMap(false);
    private Label gameStatus = new Label(DEFAULT_TEXT);
    private Backend backend = new Backend();
    private String target = backend.getTarget();
    private String guessingTarget = "";
    private int workingRow = 0;
    private int workingCol = 0;
    private boolean endOfLine = false;


    @Override
    public void start(Stage primStage) throws IOException {
        this.primaryStage = primStage;
        welcomeScene = createWelcomeScene();
        mainScene = createMainScene();
        createGamePane(); // Initialize game pane
        loadKeyboardGrid(); // Initialize keyboard pane
        welcomeScene.setOnKeyPressed(e -> closeHandling(e, primaryStage)); // lambda expression
        mainScene.setOnKeyPressed(e -> keyHandling(e));
        primaryStage.setTitle("Jordle");
        primaryStage.setScene(welcomeScene);
        primaryStage.show();
        primaryStage.setOnHidden(
            new EventHandler<WindowEvent>() { // Anonymous Inner Class
                @Override
                public void handle(WindowEvent e) {
                    if (instructionStage != null) {
                        instructionStage.close();
                    }
                }
            });
    }

    private void openInstructions() {
        if (instructionStage == null) {
            instructionStage = new Stage();
            GridPane pnInstructions = new GridPane();

            // Instruction Labels
            Label header = new Label("How To Play");
            Label subHeader = new Label("Guess the Jordle in 6 tries.");
            Label body = new Label(
                "\t• Each guess must be a valid 5-letter word.\n"
                + "\t• The color of the tiles will change to show how close your guess was to the word.\n"
                + "For example:"
                + "\t• A block will turn green a letter is in the word and in the correct spot.\n"
                + "\t• A block will turn yellow a letter is in the word and in the wrong spot.\n"
                + "\t• A block will turn gray if the letter is not in the word.\n\n\n"
                + "\t\t\t\t\t\t\t  PRESS ESC TO EXIT"
            );
            header.setTextFill(WHITE);
            header.setFont(Font.font("Nimbus Sans", FontWeight.BLACK, 32));
            subHeader.setTextFill(WHITE);
            subHeader.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            body.setTextFill(WHITE);
            body.setFont(Font.font("Arial", FontWeight.THIN, 20));


            // Instruction Labels
            pnInstructions.setBackground(new Background(new BackgroundFill(BACKGROUND_COLOR, null, null)));
            pnInstructions.add(header, 0, 1);
            pnInstructions.add(subHeader, 0, 2);
            pnInstructions.add(body, 0, 3);

            Scene instructionScene = new Scene(pnInstructions, INSTRUCTION_SCREEN_WIDTH, INSTRUCTION_SCREEN_HEIGHT);
            instructionScene.setOnKeyPressed(e -> closeHandling(e, instructionStage));

            // Configure Stage
            instructionStage.setTitle("Jordle Instructions");
            instructionStage.setScene(instructionScene);
            instructionStage.show();

        } else {
            instructionStage.close();
            instructionStage.show();
        }
    }

    private void loadKeyboardGrid() {
        KeyboardPane stack;
        int column, row;

        for (String keyString : ALLOWED_KEYS) {
            stack = keyboardPaneMap.getPane(keyString);
            column = stack.getColumn();
            row = stack.getRow();
            this.keyboardPane.add(stack.getPane(), column, row);
        }
    }

    private void accessGameGrid(int row, int column, String letter, Color outlineColor, Color boxColor) {
        Text gameGridText = new Text(letter);
        Rectangle wordBox = new Rectangle(this.GAME_GRID_BOX_SIDE_LENGTH - 4,
                            this.GAME_GRID_BOX_SIDE_LENGTH - 4, boxColor);
        Rectangle wordBoxOutline = new Rectangle(this.GAME_GRID_BOX_SIDE_LENGTH,
                                   this.GAME_GRID_BOX_SIDE_LENGTH, outlineColor);

        gameGridText.setFill(WHITE);
        gameGridText.setFont(Font.font("Arial", FontWeight.NORMAL, 48));

        StackPane stack = new StackPane();
        stack.getChildren().addAll(wordBoxOutline, wordBox, gameGridText);
        this.mainGamePane.add(stack, column, row);
    }

    private void accessGameGrid(int row, int column, String letter) {
        accessGameGrid(row, column, letter, this.GRAY, this.BACKGROUND_COLOR);
    }

    private void createGamePane() {
        this.guessingTarget = "";
        this.workingRow = 0;
        this.workingCol = 0;
        this.endOfLine = false;
        for (int row = 0; row < this.GAME_GRID_ROWS; row++) {
            for (int col = 0; col < this.GAME_GRID_COLUMNS; col++) {
                accessGameGrid(row, col, "");
            }
        }
    }

    private boolean colorGuessedWord(String checkStringVal) {
        int col = 0;
        int completeness = 0;
        KeyboardPane stack;
        for (char val : checkStringVal.toCharArray()) {
            String letterAtCol = String.valueOf(this.guessingTarget.charAt(col));
            stack = keyboardPaneMap.getPane(letterAtCol);
            switch (val) {
            case 'i':
                accessGameGrid(this.workingRow, col, letterAtCol, this.GRAY, this.GRAY);
                stack.updateColor(this.GRAY);
                break;
            case 'y':
                accessGameGrid(this.workingRow, col, letterAtCol, this.YELLOW, this.YELLOW);
                stack.updateColor(this.YELLOW);
                break;
            case 'g':
                completeness++;
                accessGameGrid(this.workingRow, col, letterAtCol, this.GREEN, this.GREEN);
                stack.updateColor(this.GREEN);
                break;
            default:
                break;
            }

            if (completeness == GAME_GRID_ROWS - 1) {
                return true;
            }
            col++;
        }
        return false;
    }

    private void alertNotFiveLetters() {
        Alert error = new Alert(Alert.AlertType.ERROR, "Your guess was not 5 letters long.");
        error.setTitle("Incorrect answer");
        error.showAndWait();
        System.out.println(target);
    }

    private void alertNotAWord() {
        Alert error = new Alert(Alert.AlertType.ERROR, "Your guess was not a valid word.");
        error.setTitle("Incorrect answer");
        error.showAndWait();
    }

    private void keyHandling(KeyEvent inputKey) { // Main logic
        String keyStringVal = inputKey.getCode().toString();
        String checkStringVal;
        boolean isAWord;

        closeHandling(inputKey, primaryStage);
        if (!ALLOWED_KEYS.contains(keyStringVal)) {
            return;
        }
        if (!endOfLine && keyStringVal.equals("ENTER")) {
            alertNotFiveLetters();
            return;
        }
        if (endOfLine && keyStringVal.equals("ENTER")) {
            try {
                isAWord = checkIfWordExists(guessingTarget);
                if (!isAWord) {
                    alertNotAWord();
                    return;
                }
                checkStringVal = backend.check(guessingTarget);
                if (this.workingRow == GAME_GRID_ROWS - 1) {
                    if (!colorGuessedWord(checkStringVal)) {
                        gameStatus.setText(String.format("Game over. The word was %s.\n\tRestart to play again.",
                                           this.target.toUpperCase()));
                        mainScene.setOnKeyPressed(e ->      // Disables from typing after win
                            closeHandling(e, primaryStage));
                        return;
                    }
                }
                if (colorGuessedWord(checkStringVal)) {
                    gameStatus.setText(WIN_TEXT);
                    mainScene.setOnKeyPressed(e -> closeHandling(e, primaryStage)); // Disables from typing after win
                    return;
                }
                this.workingRow++;
                this.workingCol = 0;
                this.endOfLine = false;
                guessingTarget = "";
            } catch (InvalidGuessException ige) {
                System.out.println(ige.getMessage());
            }
            return;
        }
        if (keyStringVal.equals("BACK_SPACE") && this.workingCol > 0) {
            accessGameGrid(this.workingRow, --this.workingCol, "");
            guessingTarget = guessingTarget.substring(0, guessingTarget.length() - 1);
        }
        if (this.workingCol < GAME_GRID_COLUMNS && !SPECIAL_KEYS.contains(keyStringVal)) { // 5 columns - 6 rows
            accessGameGrid(this.workingRow, this.workingCol++, keyStringVal);
            guessingTarget += keyStringVal;
        }
        if (this.workingCol == GAME_GRID_COLUMNS) {
            this.endOfLine = true;
        } else {
            this.endOfLine = false;
        }

    }

    private void closeHandling(KeyEvent inputKey, Stage stage) {
        if (inputKey.getCode().toString().equals("ESCAPE")) {
            stage.close();
        }
    }

    // Taken and adapted from Backend.java
    private static ArrayList<String> getWords() {
        ArrayList<String> lines = new ArrayList<>();
        File file = new File("official_allowed_guesses.txt"); // The list of allowed guesses
                                                              // of the official wordle game
                                                              // that will never become wordles
                                                              // themselves. Taken from:
    // https://github.com/Kinkelin/WordleCompetition/blob/main/data/official/official_allowed_guesses.txt
        Scanner scan = null;
        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.length() == 5) {
                    lines.add(line.toLowerCase());
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error in reading words.txt: " + fnfe.getMessage());
            lines.add("adieu");
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
        return lines;
    }

    private boolean checkIfWordExists(String guessingWord) {
        return WORDS_LIST.contains(guessingWord.toLowerCase());
    }

    private Scene createMainScene() {
        // Create main Pane
        BorderPane pnMain = new BorderPane();
        pnMain.setBackground(new Background(new BackgroundFill(BACKGROUND_COLOR, null, null)));

        // Configuring Side bar
        GridPane sideBar = new GridPane();
        sideBar.setAlignment(Pos.CENTER);
        sideBar.setHgap(10);
        sideBar.setVgap(10);
        sideBar.add(createInstructionsButton(), 0, 0);
        sideBar.add(createRestartButton(), 0, 1);

        // Configuring game pane
        mainGamePane.setAlignment(Pos.CENTER); // %pngame
        mainGamePane.setHgap(10); // %pngame
        mainGamePane.setVgap(10); // %pngame

        // Configuring keyboard pane %keyboard %important
        keyboardPane.setAlignment(Pos.CENTER);
        keyboardPane.setHgap(10);
        keyboardPane.setVgap(10);

        // Adding Panes altogether
        pnMain.setCenter(mainGamePane); // %pngame
        pnMain.setBottom(keyboardPane); // %pngame
        pnMain.setRight(sideBar);
        pnMain.setTop(createStatusPane());

        return new Scene(pnMain, this.SCREEN_WIDTH, this.SCREEN_HEIGHT);
    }

    private void clearGameGrid() {
        this.mainScene.setOnKeyPressed(e -> keyHandling(e)); // Allows user to retype on board
        this.backend.reset();
        this.gameStatus.setText(DEFAULT_TEXT);
        this.target = backend.getTarget();
        createGamePane();
        resetKeyboardPaneMap();
    }

    private void resetKeyboardPaneMap() {
        for (String keyString : ALLOWED_KEYS) {
            this.keyboardPaneMap.getPane(keyString).resetKeyboardPane();
        }
    }

    private HBox createRestartButton() {
        Button btRestart = new Button("Restart");
        btRestart.setTextFill(GREEN);
        btRestart.setFont(Font.font("Arial", FontWeight.NORMAL, 48));
        btRestart.setOnAction(e -> clearGameGrid());
        btRestart.setFocusTraversable(false);

        HBox restartButton = new HBox(10);
        restartButton.setAlignment(Pos.CENTER);
        restartButton.getChildren().add(btRestart);

        return restartButton;
    }

    private HBox createInstructionsButton() {
        Button btInstructions = new Button("     Open\nInstruction");
        btInstructions.setTextFill(GREEN);
        btInstructions.setFont(Font.font("Arial", FontWeight.NORMAL, 48));
        btInstructions.setOnAction(e -> openInstructions());
        btInstructions.setFocusTraversable(false);

        HBox instructionButton = new HBox(10);
        instructionButton.setAlignment(Pos.CENTER);
        instructionButton.getChildren().add(btInstructions);

        return instructionButton;
    }

    private HBox createStatusPane() {
        gameStatus.setTextFill(WHITE);
        gameStatus.setFont(Font.font("Arial", FontWeight.THIN, 32));
        Label buffer = new Label("~~~~~~~~~~~~~~~");
        buffer.setTextFill(BACKGROUND_COLOR);
        buffer.setFont(Font.font("Arial", FontWeight.THIN, 32));


        HBox gameStatusBox = new HBox(10);
        gameStatusBox.setAlignment(Pos.CENTER);
        gameStatusBox.getChildren().addAll(gameStatus, buffer);

        return gameStatusBox;
    }

    private Scene createWelcomeScene() {
        // Creating the GridPane
        GridPane titlePane = new GridPane();
        titlePane.setAlignment(Pos.CENTER);
        titlePane.setHgap(10);
        titlePane.setVgap(10);

        // Label Creation
        Label jordle = new Label("Jordle");
        jordle.setTextFill(Color.BLUE);
        jordle.setFont(Font.font("Arial", FontWeight.BLACK, 128));

        // Configuring play button
        Button btPlay = new Button("Play");
        btPlay.setTextFill(WHITE);
        btPlay.setFont(Font.font("Arial", FontWeight.BLACK, 32));
        btPlay.setMinWidth(480);

        // Configuring button pane
        HBox playButton = new HBox(10);
        playButton.setAlignment(Pos.CENTER);
        playButton.getChildren().add(btPlay);

        // Defining button handle
        btPlay.setOnAction(e -> setMainStage());

        // Adding to the GridPane
        titlePane.add(jordle, 0, 0);
        titlePane.add(playButton, 0, 1);
        titlePane.setBackground(setBackground("jordleImage.png")); // jordleImage.jpg explicitly does not work.

        return new Scene(titlePane, this.SCREEN_WIDTH, this.SCREEN_HEIGHT);
    }

    private void setMainStage() {
        primaryStage.setScene(mainScene);
    }

    private Background setBackground(String imageDir) {
        Image image = new Image(imageDir);

        BackgroundSize backgroundSize = new BackgroundSize(this.SCREEN_WIDTH, this.SCREEN_HEIGHT,
                                                           false, false, false, true);

        BackgroundImage backgroundimage = new BackgroundImage(image,
                                        BackgroundRepeat.NO_REPEAT,
                                        BackgroundRepeat.NO_REPEAT,
                                        BackgroundPosition.DEFAULT,
                                        backgroundSize);

        return new Background(backgroundimage);
    }


}