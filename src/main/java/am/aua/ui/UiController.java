package am.aua.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UiController {
    @FXML
    private Label welcomeText;


    @FXML
    protected void on2PlayerButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void on3PlayerButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void on4PlayerButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}