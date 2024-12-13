package Game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApp extends Application {
    private int width = 350;
    private int height = 200;
    private Stage primaryStage;
    private Scene registrationScene;
    private Scene optionsScene;
    private Scene mainScene;
    private String username;
    private String level;
    private Label welcomeLabel = new Label();
    private Label levelLabel = new Label();

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        registrationScene = createRegistrationScene();
        optionsScene = createOptionsScene();
        mainScene = createMainScene();
        stage.setTitle("GameApp");
        stage.setScene(registrationScene);
        stage.show();
    }

    private Scene createMainScene() {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        levelLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        pane.getChildren().addAll(welcomeLabel, levelLabel);

        return new Scene(pane, width, height);
    }

    private Scene createOptionsScene() {
        VBox pane = new VBox(10);
        pane.setPadding(new Insets(25, 25, 25, 35));
        Button easyButton = new Button("Easy");
        Button mediumButton = new Button("Medium");
        Button hardButton = new Button("Hard");
        Label label = new Label("Choose a level:");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        pane.getChildren().addAll(label, easyButton, mediumButton, hardButton);

        easyButton.setOnAction(e -> updateLevel("Easy"));
        mediumButton.setOnAction(e -> updateLevel("Medium"));
        hardButton.setOnAction(e -> updateLevel("Hard"));

        return new Scene(pane, width, height);
    }

    private Scene createRegistrationScene() {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.add(new Label("Username"), 0, 0);
        TextField usernameTextField = new TextField();
        pane.add(usernameTextField, 1, 0);
        pane.add(new Label("Password:"), 0, 1);
        pane.add(new PasswordField(), 1, 1);

        Button okButton = new Button("OK");
        Button cancelButton = new Button("Cancel");
        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.BOTTOM_RIGHT);
        buttons.getChildren().addAll(okButton, cancelButton);

        okButton.setOnAction(e -> {
            username = usernameTextField.getText();
            welcomeLabel.setText(String.format("Welcome to JavaFX, %s!", username));
            primaryStage.setScene(optionsScene);
        });
        cancelButton.setOnAction(e -> primaryStage.close());

        pane.add(buttons, 1, 2);

        return new Scene(pane, width, height);
    }

    private void updateLevel(String selectedLevel) {
        level = selectedLevel;
        levelLabel.setText(String.format("Your chosen level is %s.", level));
        primaryStage.setScene(mainScene);
    }
}